package br.unisul.sau.dao;

import java.util.List;

public interface RelacioamentoDAO<T> {
	
	List<T> getAll(long id);
	
	boolean add(T bean);

}
