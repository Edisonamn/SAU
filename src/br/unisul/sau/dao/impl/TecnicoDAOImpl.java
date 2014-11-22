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
			String sql = "select seq_id_tecnico, nome, login, pwd from sau.en_tecnico where seq_id_tecnico = ?";
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
	public long add(Tecnico bean) {
		PreparedStatement ps = null;
		long retorno = -1L;
		
		try {
			String sql = "insert into sau.en_tecnico(seq_id_tecnico, nome, login, pwd) values (DEFAULT, ?, ?, ?);";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, bean.getNome());
			ps.setString(2, bean.getUser());
			ps.setString(3, bean.getPwd());
			boolean inserido = ps.execute();
			if (inserido) {
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
	public boolean update(Tecnico bean) {
		PreparedStatement ps = null;
		
		try {
			String sql = "update sau.en_tecnico set nome = ?, login = ?, pwd = ? where seq_id_tecnico = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, bean.getNome());
			ps.setString(2, bean.getUser());
			ps.setString(3, bean.getPwd());
			ps.setLong(4, bean.getSeq_id_tecnico());
			return ps.execute();
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

	@Override
	public boolean remove(long object) {
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_tecnico set excluido = 0 where seq_id_tecnico = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, object);
			return ps.execute();
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

	@Override
	public Tecnico getUser(String user) {
		Tecnico bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_tecnico, nome, login, pwd from sau.en_tecnico where login like ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, user);
			ps.setMaxRows(1);
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
