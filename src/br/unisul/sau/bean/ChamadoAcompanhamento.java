package br.unisul.sau.bean;

public class ChamadoAcompanhamento {

	private Long seq_id_chamado;
	private Long seq_id_acompanhamento;

	public ChamadoAcompanhamento() {
		// TODO Auto-generated constructor stub
	}
	
	public ChamadoAcompanhamento(Long seq_id_chamado, Long seq_id_acompanhamento) {
		super();
		this.seq_id_chamado = seq_id_chamado;
		this.seq_id_acompanhamento = seq_id_acompanhamento;
	}

	public Long getSeq_id_chamado() {
		return seq_id_chamado;
	}

	public void setSeq_id_chamado(Long seq_id_chamado) {
		this.seq_id_chamado = seq_id_chamado;
	}

	public Long getSeq_id_acompanhamento() {
		return seq_id_acompanhamento;
	}

	public void setSeq_id_acompanhamento(Long seq_id_acompanhamento) {
		this.seq_id_acompanhamento = seq_id_acompanhamento;
	}

}
