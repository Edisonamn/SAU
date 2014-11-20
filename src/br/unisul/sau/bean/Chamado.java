package br.unisul.sau.bean;

import java.sql.Date;

import br.unisul.sau.bean.tenum.Problema;
import br.unisul.sau.bean.tenum.Status;
import br.unisul.sau.bean.tenum.TipoProblema;

public class Chamado {
	
	private Long seq_id_chamado;
	
	private Long seq_id_empresa;
	private Long seq_id_tecnico;
	
	private String nome_cliente;
	
	private Status status;
	private Problema problema;
	private TipoProblema tipo_problema;
	private String info_problema;
	
	private String software;
	private String versao_software;
	
	private Date data;
	private Double duracao;
	
	public Chamado() {
		// TODO Auto-generated constructor stub
	}

	public Long getSeq_id_chamado() {
		return seq_id_chamado;
	}

	public void setSeq_id_chamado(Long seq_id_chamado) {
		this.seq_id_chamado = seq_id_chamado;
	}

	public Long getSeq_id_empresa() {
		return seq_id_empresa;
	}

	public void setSeq_id_empresa(Long seq_id_empresa) {
		this.seq_id_empresa = seq_id_empresa;
	}

	public Long getSeq_id_tecnico() {
		return seq_id_tecnico;
	}

	public void setSeq_id_tecnico(Long seq_id_tecnico) {
		this.seq_id_tecnico = seq_id_tecnico;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public TipoProblema getTipo_problema() {
		return tipo_problema;
	}

	public void setTipo_problema(TipoProblema tipo_problema) {
		this.tipo_problema = tipo_problema;
	}

	public String getInfo_problema() {
		return info_problema;
	}

	public void setInfo_problema(String info_problema) {
		this.info_problema = info_problema;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getVersao_software() {
		return versao_software;
	}

	public void setVersao_software(String versao_software) {
		this.versao_software = versao_software;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}
	
}
