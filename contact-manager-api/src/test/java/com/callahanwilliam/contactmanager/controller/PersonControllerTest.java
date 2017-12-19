package com.callahanwilliam.contactmanager.controller;

import com.callahanwilliam.contactmanager.configuration.SpringConfiguration;
import com.callahanwilliam.contactmanager.repository.dynamodb.IPersonRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests the {@link PersonController}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
@TestPropertySource(properties = {"spring.data.rest.basePath=/api"})
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
		mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		Assert.notNull(iPersonRepository.findAll());
	}
	
}
