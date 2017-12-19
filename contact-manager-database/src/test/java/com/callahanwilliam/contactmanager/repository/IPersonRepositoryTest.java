package com.callahanwilliam.contactmanager.repository;

import com.callahanwilliam.contactmanager.configuration.DatabaseConfigurationTest;
import com.callahanwilliam.contactmanager.configuration.DynamoDbConfiguration;
import com.callahanwilliam.contactmanager.model.dynamodb.Address;
import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import com.callahanwilliam.contactmanager.model.dynamodb.Phone;
import com.callahanwilliam.contactmanager.model.enumeration.PhoneType;
import com.callahanwilliam.contactmanager.repository.dynamodb.IPersonRepository;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * Tests the {@link IPersonRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfigurationTest.class, DynamoDbConfiguration.class})
public class IPersonRepositoryTest {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IPersonRepository iPersonRepository;
	
	@Test
	public void findAllTest() {
		log.info("Finding all objects");
		log.info("All Person objects: " + iPersonRepository.findAll());
	}
	
	@Test
	public void saveTest() {
		log.info("Saving a new Person");
		iPersonRepository.save(getPersonInstance());
		log.info("Looking up saved person");
		Iterable<Person> personIterable = iPersonRepository.findAll();
		Assert.notEmpty(IterableUtils.toList(personIterable));
		log.info(String.format("Found %d people", IterableUtils.toList(personIterable).size()));
		log.info("Saving complete");
	}
	
	@Test
	public void updateTest() {
		log.info("Updating an existing object");
		Person person = iPersonRepository.save(getPersonInstance());
		person.setFirstName("Jane");
		person.setLastName("Doe");
		Person personUpdated = iPersonRepository.save(person);
		Assert.notNull(personUpdated);
		Assert.isTrue(personUpdated.getFirstName().equals(person.getFirstName()));
		Assert.isTrue(personUpdated.getLastName().equals(person.getLastName()));
		log.info("Updated a person!");
	}
	
	@Test
	public void deleteTest() {
		log.info("Deleting an existing record");
		Person person = iPersonRepository.save(getPersonInstance());
		long startCount = iPersonRepository.count();
		Assert.notNull(person);
		iPersonRepository.delete(person.getId());
		long endCount = iPersonRepository.count();
		Assert.isTrue(startCount == endCount + 1);
		log.info("Deleted a person!");
	}
	
	public static Person getPersonInstance() {
		Person person = new Person();
		person.setFirstName("william");
		person.setLastName("callahan");
		person.setPrimaryEmail("callahan043@connect.wcsu.edu");
		person.setSecondaryEmail("callahanwilliam@callahanwilliam.com");
		Address address = new Address();
		address.setStreet("A Street");
		address.setCity("A Town Somewhere");
		address.setState("Connecticut");
		address.setPostalCode("06812");
		person.setAddress(address);
		Phone phone = new Phone();
		phone.setPhoneNumber("012-345-6789");
		phone.setPhoneType(PhoneType.ANDROID);
		person.setPhoneList(new ArrayList<>());
		person.getPhoneList().add(phone);
		return person;
	}
	
}