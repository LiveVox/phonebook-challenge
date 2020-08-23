package com.phonebook.data;

public interface RepositoryEditor<T, Tkey>  {
	void add(T item);
	void remove(T item);
	void removeById(Tkey id);
}
