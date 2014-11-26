package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.unisul.sau.bean.Acompanhamento;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.GenericDAO;

public class AcompanhamentoDAOImpl implements GenericDAO<Acompanhamento> {

	@Override
	public Acompanhamento get(long id) {
		Acompanhamento bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_acompanhamento, descricao, data, tempo_execucao from sau.en_acompanhamento where seq_id_acompanhamento = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			ps.setMaxRows(1);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Acompanhamento();
				bean.setSeq_id_acompanhamento(rs.getLong(1));
				bean.setDescricao(rs.getString(2));
				bean.setDate(rs.getDate(3));
				bean.setTempo_execucao(rs.getDouble(4));
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

		return bean;
	}

	@Override
	public long add(Acompanhamento bean) {
		PreparedStatement ps = null;
		long retorno = -1L;
		
		try {
			String sql = "insert into sau.en_acompanhamento(seq_id_acompanhamento, descricao, data, tempo_execucao)values(DEFAULT, ?, ?, ?)";
			ps = Conexao.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bean.getDescricao());
			try {
				java.sql.Date a = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(2, a);
			} catch (Exception e) {
				ps.setDate(2, new java.sql.Date(1L));
			}
			
			ps.setDouble(3, bean.getTempo_execucao() == null ? 0 : bean.getTempo_execucao());
			int inserido = ps.executeUpdate();
			if (inserido == 1) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
				while(generatedKeys.next()) {
					retorno = generatedKeys.getLong(1);
				}
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
		
		return retorno;
	}

	@Override
	public boolean update(Acompanhamento object) {
		boolean inserido = false;
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_acompanhamento set descricao = ?, data = ?, tempo_execucao = ? where seq_id_acompanhamento = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, object.getDescricao());
			ps.setDate(2, object.getDate());
			ps.setDouble(3, object.getTempo_execucao());
			ps.setLong(4, object.getSeq_id_acompanhamento());
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

	@Override
	public boolean remove(long object) {
		boolean inserido = false;
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_acompanhamento set excluido = 0 where seq_id_acompanhamento = ?";
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
