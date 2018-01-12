package com.callahanwilliam.contactmanager.controller;

import com.callahanwilliam.contactmanager.configuration.SpringConfiguration;
import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import com.callahanwilliam.contactmanager.repository.dynamodb.IPersonRepository;
import com.callahanwilliam.contactmanager.utility.model.dynamodb.PersonSeeder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLEncoder;

/**
 * Tests the {@link PersonController}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
@TestPropertySource(properties = {"spring.data.rest.basePath=/api"})
@SuppressWarnings("deprecation")
public class PersonControllerTest {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private MockMvc mockMvc;
	
	@Autowired
	private IPersonRepository iPersonRepository;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void findAllTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/persons")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
		Assert.notNull(iPersonRepository.findAll());
	}
	
	@Test
	public void findOneTest() throws Exception {
		Person person = iPersonRepository.save(PersonSeeder.getInstance());
		Assert.notNull(person);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/persons/" + URLEncoder.encode(person.getId()))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		Assert.isTrue(mvcResult.getResponse().getContentAsString().contains(person.getId()));
	}
	
	@Test
	public void countTest() throws Exception {
		Person person = iPersonRepository.save(PersonSeeder.getInstance());
		Assert.notNull(person);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/persons/count")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		Assert.isTrue(mvcResult.getResponse().getContentAsString().matches("\\{\"content\":\\d+,\"links\":\\[.*?]}"));
	}
	
	@Test
	public void createTest() throws Exception {
		long startingCount = iPersonRepository.count();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/persons")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(PersonSeeder.getAsJson()))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
		long endingCount = iPersonRepository.count();
		Assert.isTrue(startingCount == endingCount - 1);
	}
	
	@Test
	public void updateTest() throws Exception {
		Person person = iPersonRepository.save(PersonSeeder.getInstance());
		Assert.notNull(person);
		person.setFirstName("Something");
		person.setLastName("Else");
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.put("/persons/" + URLEncoder.encode(person.getId()))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(PersonSeeder.getAsJson()))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		Assert.isTrue(!mvcResult.getResponse().getContentAsString().contains(person.getFirstName()));
		Assert.isTrue(!mvcResult.getResponse().getContentAsString().contains(person.getLastName()));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Person person = iPersonRepository.save(PersonSeeder.getInstance());
		Assert.notNull(person);
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/persons/" + URLEncoder.encode(person.getId()))
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(PersonSeeder.getAsJson()))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNoContent());
		Assert.isNull(iPersonRepository.findOne(person.getId()));
	}
	
}
