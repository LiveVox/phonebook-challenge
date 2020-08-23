package com.phonebook.data;

public interface RepositoryReader<T, Tkey> {
	T getItemById(Tkey id);
	Iterable<T> getItems(Integer page, Integer rowsPerPage);
}
