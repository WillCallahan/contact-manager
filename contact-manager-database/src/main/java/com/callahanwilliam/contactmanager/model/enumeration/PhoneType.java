package com.callahanwilliam.contactmanager.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Used to provide the type of phone that a {@link com.callahanwilliam.contactmanager.model.dynamodb.Phone} represents.
 */
public enum PhoneType {
	
	MOBILE(0, "Mobile"), LANDING(1, "Landing"), FAX(2, "FAX"), ANDROID(3, "Android"), IPHONE(4, "iPhone");
	
	private int type;
	
	private String name;
	
	private PhoneType(int type, String name) {
		this.type = type;
		this.name = name;
	}
	
	@JsonValue
	public int getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	@JsonCreator
	public static PhoneType getPhoneType(int type) {
		for (int i = 0; i < PhoneType.values().length; i++) {
			if (PhoneType.values()[i].getType() == type)
				return PhoneType.values()[i];
		}
		throw new IllegalArgumentException("Phone Type " + type + " does not exist!");
	}
	
}
