package com.phonebook.data.repositories;

import com.phonebook.data.Repository;
import com.phonebook.data.domains.*;

public interface ContactsRepository extends Repository<Contact, Integer> {

	Iterable<Contact> getItems(Integer page, Integer rowsPerPage, String searchCriteria);

}
