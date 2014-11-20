package br.unisul.sau.dao;

import br.unisul.sau.bean.Empresa;

public interface EmpresaDAO {
	
	Empresa get(int contrato);
	
	Empresa get(String nome);

}
