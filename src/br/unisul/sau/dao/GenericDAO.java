package br.unisul.sau.dao;

public interface GenericDAO<T> {

	T get(long id);
	
	boolean add(T bean);
	
	boolean update(T bean);
	
	boolean remove(long id);
	
}
