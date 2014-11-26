package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unisul.sau.bean.ChamadoAcompanhamento;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.RelacioamentoDAO;

public class ChamadoAcompanhamentoDAOImpl implements RelacioamentoDAO<ChamadoAcompanhamento>{

	@Override
	public List<ChamadoAcompanhamento> getAll(long id) {
		List<ChamadoAcompanhamento> list = new ArrayList<ChamadoAcompanhamento>();
		
		ChamadoAcompanhamento bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_chamado, seq_id_acompanhamento from sau.re_acompanhamento_chamado where seq_id_chamado = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(bean = new ChamadoAcompanhamento());
				bean.setSeq_id_acompanhamento(rs.getLong(1));
				bean.setSeq_id_chamado(rs.getLong(2));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return list;
	}

	@Override
	public boolean add(ChamadoAcompanhamento bean) {
		PreparedStatement ps = null;
		
		try {
			String sql = "insert into sau.re_chamado_acompanhamento (seq_id_chamado, seq_id_acompanhamento) values (?, ?)";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, bean.getSeq_id_chamado());
			ps.setLong(2, bean.getSeq_id_acompanhamento());
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1) {
				return true;
			}
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

		return false;
	}
	
}
