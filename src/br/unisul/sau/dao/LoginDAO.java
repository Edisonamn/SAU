package br.unisul.sau.dao;

import br.unisul.sau.bean.Tecnico;

public interface LoginDAO {
	
	Tecnico getUser(String user);

}
