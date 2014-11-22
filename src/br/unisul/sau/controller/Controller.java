package br.unisul.sau.controller;

import br.unisul.sau.bean.Acompanhamento;
import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.ChamadoAcompanhamento;
import br.unisul.sau.dao.impl.FactoryDAOImpl;

public class Controller {
	
	private static FactoryDAOImpl factory = new FactoryDAOImpl();
	
	public boolean addChamadoAcompanhamento(final Chamado chamado, final Acompanhamento acompanhamento) {
		
		Long idChamado = null, idAcompanhamento = null;
		if (chamado.getSeq_id_chamado() == null) {
			idChamado = factory.getChamadoDAOImpl().add(chamado);
		}
		
		if ((idChamado == null) || idChamado < 0) {
			return false;
		}
		
		if (acompanhamento.getSeq_id_acompanhamento() == null) {
			idAcompanhamento = factory.getAcompanhamentoDAOImpl().add(acompanhamento);
		}
		
		if ((idAcompanhamento == null) || idAcompanhamento < 0) {
			return false;
		}
		
		ChamadoAcompanhamento bean = new ChamadoAcompanhamento(idChamado, idAcompanhamento);
		return factory.getChamadoAcompanhamentoDAOImpl().add(bean);
	}

}
