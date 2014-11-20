package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.unisul.sau.bean.Tecnico;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.GenericDAO;
import br.unisul.sau.dao.LoginDAO;

public class TecnicoDAOImpl implements GenericDAO<Tecnico>, LoginDAO {

	@Override
	public Tecnico get(long id) {
		Tecnico bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from sau.en_tecnico where seq_id_tecnico = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Tecnico();
				bean.setSeq_id_tecnico(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setUser(rs.getString(2));
				bean.setPwd(rs.getString(2));
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
	public boolean add(Tecnico object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tecnico object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(long object) {
		boolean inserido = false;
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_tecnico set excluido = 0 where seq_id_tecnico = ?";
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

	@Override
	public Tecnico getUser(String user) {
		Tecnico bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from sau.en_tecnico where login = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Tecnico();
				bean.setSeq_id_tecnico(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setUser(rs.getString(2));
				bean.setPwd(rs.getString(2));
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

}
