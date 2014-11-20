package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.GenericDAO;

public class ChamadoDAOImpl implements GenericDAO<Chamado> {

	@Override
	public Chamado get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Chamado object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Chamado object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(long object) {
		boolean inserido = false;
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_chamado set excluido = 0 where seq_id_chamado = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, object);
			inserido = ps.execute();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return inserido;
	}

}
