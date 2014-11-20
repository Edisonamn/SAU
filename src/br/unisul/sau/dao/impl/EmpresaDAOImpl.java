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
			String sql = "select * from sau.en_empresa where seq_id_empresa = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getLong(3));
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
	public boolean add(Empresa object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Empresa object) {
		// TODO Auto-generated method stub
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
			String sql = "select * from sau.en_empresa where contrato = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, contrato);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getLong(3));
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
			String sql = "select * from sau.en_empresa where nome = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Empresa();
				bean.setSeq_id_empresa(rs.getLong(1));
				bean.setNome(rs.getString(2));
				bean.setContrato(rs.getLong(3));
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
