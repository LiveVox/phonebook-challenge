package com.phonebook.services;

import com.phonebook.data.domains.Contact;
import com.phonebook.services.models.ContactModel;

public class ContactConverterUtil {
	public static ContactModel to(Contact domain) {
		ContactModel result = new ContactModel();
		result.setFirstName(domain.getFirstName());
		result.setLastName(domain.getLastName());
		result.setPhoneNumber(domain.getPhoneNumber());
		return result;
	}
	
	public static Contact to(ContactModel model) {
		Contact result = new Contact();
		result.setFirstName(model.getFirstName());
		result.setLastName(model.getLastName());
		result.setPhoneNumber(model.getPhoneNumber());
		return result;
	}
}
