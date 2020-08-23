package com.phonebook.services.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContactModel {
	@NotNull
	@Size(min=1,message="You forgot to enter the firstname") 
	private String firstName;
	@NotNull
	@Size(min=1,message="You forgot to enter the lastname") 
	private String lastName;
	@NotNull
	@Size(min=7,message="You forgot to enter the phone number")
	@Pattern(regexp = "^\\d{7,10}$", message = "The format is invalid")
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
