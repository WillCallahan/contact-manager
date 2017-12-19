package com.callahanwilliam.contactmanager.utility.model.dynamodb;

import com.callahanwilliam.contactmanager.model.dynamodb.Address;
import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import com.callahanwilliam.contactmanager.model.dynamodb.Phone;
import com.callahanwilliam.contactmanager.model.enumeration.PhoneType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

/**
 * Provides seeding data for the {@link com.callahanwilliam.contactmanager.model.dynamodb.Person} object
 */
public class PersonSeeder {
	
	public static Person getInstance() {
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
	
	public static String getAsJson() {
		return "{\"id\":null,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"primaryEmail\":\"callahan043@connect.wcsu.edu\",\"secondaryEmail\":\"callahanwilliam@callahanwilliam.com\",\"address\":{\"street\":\"A Street\",\"city\":\"A Town Somewhere\",\"state\":\"Connecticut\",\"postalCode\":\"06812\"},\"phoneList\":[{\"phoneNumber\":\"012-345-6789\",\"phoneType\":3}]}";
	}
	
}
