package br.unisul.sau.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unisul.sau.bean.Chamado;
import br.unisul.sau.bean.tenum.Problema;
import br.unisul.sau.bean.tenum.Status;
import br.unisul.sau.bean.tenum.TipoProblema;
import br.unisul.sau.connection.Conexao;
import br.unisul.sau.dao.GenericDAO;

public class ChamadoDAOImpl implements GenericDAO<Chamado> {

	@Override
	public Chamado get(long id) {
		Chamado bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select seq_id_chamado, seq_id_empresa, seq_id_tecnico, nome_cliente, " +
						"status, problema, tipo_problema, info_problema, software, versao_software, "+
						"data_chamado, duracao from sau.en_chamado where seq_id_chamado = ?";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, id);
			ps.setMaxRows(1);
			rs = ps.executeQuery();
			while (rs.next()) {
				bean = new Chamado();
				bean.setSeq_id_chamado(rs.getLong(1));
				bean.setSeq_id_empresa(rs.getLong(2));
				bean.setSeq_id_tecnico(rs.getLong(3));
				bean.setNome_cliente(rs.getString(4));
				bean.setStatus(Status.findByValue(rs.getInt(5)));
				bean.setProblema(Problema.findByValue(rs.getInt(6)));
				bean.setTipo_problema(TipoProblema.findByValue(rs.getInt(7)));
				bean.setInfo_problema(rs.getString(8));
				bean.setSoftware(rs.getString(9));
				bean.setVersao_software(rs.getString(10));
				bean.setData(rs.getDate(11));
				bean.setDuracao(rs.getDouble(12));
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
	public long add(Chamado bean) {
		PreparedStatement ps = null;
		long retorno = -1L;
		
		try {
			String sql = "insert intp sau.en_chamado(seq_id_chamado, seq_id_empresa, seq_id_tecnico, nome_cliente, "+
					"status, problema, tipo_problema, info_problema, software, versao_software, data_chamado, duracao) " +
					"values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			ps = Conexao.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, bean.getSeq_id_empresa());
			ps.setLong(2, bean.getSeq_id_tecnico());
			ps.setString(3, bean.getNome_cliente());
			ps.setInt(4, bean.getStatus().getKey());
			ps.setInt(5, bean.getProblema().getKey());
			ps.setInt(6, bean.getTipo_problema().getKey());
			ps.setString(7, bean.getInfo_problema());
			ps.setString(8, bean.getSoftware());
			ps.setString(9, bean.getVersao_software());
			ps.setDate(10, bean.getData());
			ps.setDouble(11, bean.getDuracao());
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
	public boolean update(Chamado bean) {
		PreparedStatement ps = null;
		
		try {
			String sql = "update sau.en_chamado set seq_id_empresa = ?, seq_id_tecnico = ?, nome_cliente = ?, "+
					"status = ?, problema = ?, tipo_problema = ?, info_problema = ?, software = ?, versao_software = ?, data_chamado = ?, duracao = ? " +
					"where seq_id_chamado = ?;";
			ps = Conexao.getInstance().prepareStatement(sql);
			ps.setLong(1, bean.getSeq_id_empresa());
			ps.setLong(2, bean.getSeq_id_tecnico());
			ps.setString(3, bean.getNome_cliente());
			ps.setInt(4, bean.getStatus().getKey());
			ps.setInt(5, bean.getProblema().getKey());
			ps.setInt(6, bean.getTipo_problema().getKey());
			ps.setString(7, bean.getInfo_problema());
			ps.setString(8, bean.getSoftware());
			ps.setString(9, bean.getVersao_software());
			ps.setDate(10, bean.getData());
			ps.setDouble(11, bean.getDuracao());
			ps.setLong(12, bean.getSeq_id_chamado());
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
	
	public List<Chamado> getAllAberto() {
		Chamado bean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Chamado> list = new ArrayList<Chamado>();
		
		try {
			String sql = "select seq_id_chamado, seq_id_empresa, seq_id_tecnico, nome_cliente, " +
						"status, problema, tipo_problema, info_problema, software, versao_software, "+
						"data_chamado, duracao from sau.en_chamado where status = 1";
			ps = Conexao.getInstance().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(bean = new Chamado());
				bean.setSeq_id_chamado(rs.getLong(1));
				bean.setSeq_id_empresa(rs.getLong(2));
				bean.setSeq_id_tecnico(rs.getLong(3));
				bean.setNome_cliente(rs.getString(4));
				bean.setStatus(Status.findByValue(rs.getInt(5)));
				bean.setProblema(Problema.findByValue(rs.getInt(6)));
				bean.setTipo_problema(TipoProblema.findByValue(rs.getInt(7)));
				bean.setInfo_problema(rs.getString(8));
				bean.setSoftware(rs.getString(9));
				bean.setVersao_software(rs.getString(10));
				bean.setData(rs.getDate(11));
				bean.setDuracao(rs.getDouble(12));
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

}
