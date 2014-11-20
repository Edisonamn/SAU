package br.unisul.sau.dao;

import br.unisul.sau.dao.impl.AcompanhamentoDAOImpl;
import br.unisul.sau.dao.impl.ChamadoDAOImpl;
import br.unisul.sau.dao.impl.EmpresaDAOImpl;
import br.unisul.sau.dao.impl.TecnicoDAOImpl;

public interface FactoryDAO {
	
	AcompanhamentoDAOImpl getAcompanhamentoDAOImpl();
	
	ChamadoDAOImpl getChamadoDAOImpl();
	
	EmpresaDAOImpl getClienteDAOImpl();
	
	TecnicoDAOImpl getTecnicoDAOImpl();
	

}
