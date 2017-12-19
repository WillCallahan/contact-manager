package com.callahanwilliam.contactmanager.model.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.callahanwilliam.contactmanager.model.enumeration.PhoneType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Contains information about a phone
 *
 * @see PhoneType
 */
@DynamoDBDocument
public class Phone {
	
	private String phoneNumber;
	
	private PhoneType phoneType;
	
	public Phone() {
	
	}
	
	@DynamoDBAttribute(attributeName = "phone")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@DynamoDBIgnore
	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	//Getters and setters specific for use by AWS
	
	@JsonIgnore
	@DynamoDBAttribute(attributeName = "type")
	public int getPhoneTypeInt() {
		return this.phoneType.getType();
	}

	public void setPhoneTypeInt(int phoneType) {
		this.phoneType = PhoneType.getPhoneType(phoneType);
	}

}
