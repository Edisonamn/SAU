package br.unisul.sau.dao;

public interface GenericDAO<T> {

	T get(long id);
	
	boolean add(T object);
	
	boolean update(T object);
	
	boolean remove(long id);
	
}
