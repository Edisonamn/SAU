package br.unisul.sau.dao.impl;

import br.unisul.sau.dao.FactoryDAO;

public class FactoryDAOImpl implements FactoryDAO {

	public AcompanhamentoDAOImpl getAcompanhamentoDAOImpl() {
		return new AcompanhamentoDAOImpl();
	}

	public ChamadoDAOImpl getChamadoDAOImpl() {
		return new ChamadoDAOImpl();
	}

	public EmpresaDAOImpl getClienteDAOImpl() {
		return new EmpresaDAOImpl();
	}

	public TecnicoDAOImpl getTecnicoDAOImpl() {
		return new TecnicoDAOImpl();
	}

}
