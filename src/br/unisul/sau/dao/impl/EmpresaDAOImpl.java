package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.unisul.sau.bean.Empresa;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.EmpresaDAO;
import br.unisul.sau.dao.GenericDAO;

public class EmpresaDAOImpl implements GenericDAO<Empresa>, EmpresaDAO {

	@Override
	public Empresa get(long id) {
		Empresa bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_empresa, nome, numero_contrato from sau.en_empresa where seq_id_empresa = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			ps.setMaxRows(1);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getInt(3));
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
	public long add(Empresa bean) {
		PreparedStatement ps = null;
		long retorno = -1L;
		
		try {
			String sql = "insert into sau.en_empresa(seq_id_empresa, nome, numero_contrato)values(DEFAULT, ?, ?)";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, bean.getNome());
			ps.setInt(2, bean.getContrato());
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
	public boolean update(Empresa bean) {
		PreparedStatement ps = null;
		
		try {
			String sql = "update sau.en_tecnico set nome = ?, numero_contrato = ? where seq_id_tecnico = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, bean.getNome());
			ps.setInt(2, bean.getContrato());
			ps.setLong(3, bean.getSeq_id_empresa());
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
		boolean inserido = false;
		PreparedStatement ps = null;
		
		try {
			String sql = "update sai.en_cliente set excluido = 0 where seq_id_cliente = ?";
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
	public Empresa get(int contrato) {
		Empresa bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_empresa, nome, numero_contrato from sau.en_empresa where numero_contrato = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, contrato);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getInt(3));
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
	public Empresa get(String nome) {
		Empresa bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_empresa, nome, numero_contrato from sau.en_empresa where nome like ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getInt(3));
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
