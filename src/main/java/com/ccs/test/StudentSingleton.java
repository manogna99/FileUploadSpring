package com.ccs.test;

public class StudentSingleton {

	AddressPrototype address;
	
	public AddressPrototype getAddress() {
		return address;
	}

	public void setAddress(AddressPrototype address) {
		this.address = address;
	}

	String message;
	 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
}
