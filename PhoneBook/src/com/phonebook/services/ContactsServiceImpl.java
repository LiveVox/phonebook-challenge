package com.phonebook.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.data.domains.Contact;
import com.phonebook.data.repositories.ContactsRepository;
import com.phonebook.services.models.ContactModel;

@Service
public class ContactsServiceImpl implements ContactsService {
	
	@Autowired 
	private ContactsRepository repository;
	
	@Transactional(readOnly = true)
	public Iterable<ContactModel> getItems(Integer page, Integer rowsPerPage, String keyword) {
		Iterable<Contact> contacts = this.repository.getItems(page, rowsPerPage, keyword);
		ArrayList<ContactModel> result = new ArrayList<ContactModel>();
		for(Contact contact: contacts) {
			ContactModel model = ContactConverterUtil.to(contact);
			result.add(model);
		}
		return result;
	}
	
	@Transactional
	public void add(ContactModel contact) {
		Contact domain = ContactConverterUtil.to(contact);
		this.repository.add(domain);
	}

}
