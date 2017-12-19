package com.callahanwilliam.contactmanager.model.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * Represents a physical address
 */
@DynamoDBDocument
public class Address {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	public Address() {
	
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
