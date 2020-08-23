package com.phonebook.data;

public interface Repository<T, Tkey> extends RepositoryReader<T, Tkey>, RepositoryEditor<T, Tkey> {

}
