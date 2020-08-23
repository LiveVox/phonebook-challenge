package com.phonebook.services;

import com.phonebook.services.models.ContactModel;

public interface ContactsService {
	void add(ContactModel contact);
	Iterable<ContactModel> getItems(Integer page, Integer rowsPerPage, String keyword);
}
