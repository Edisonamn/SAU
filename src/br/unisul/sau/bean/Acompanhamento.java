package br.unisul.sau.bean;

import java.sql.Date;

public class Acompanhamento {
	
	private Long seq_id_acompanhamento;
	private String descricao;
	private Date date;
	private Double tempo_execucao;
	
	public Acompanhamento() {
		super();
	}

	public Long getSeq_id_acompanhamento() {
		return seq_id_acompanhamento;
	}

	public void setSeq_id_acompanhamento(Long seq_id_acompanhamento) {
		this.seq_id_acompanhamento = seq_id_acompanhamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTempo_execucao() {
		return tempo_execucao;
	}

	public void setTempo_execucao(Double tempo_execucao) {
		this.tempo_execucao = tempo_execucao;
	}

}
