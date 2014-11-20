package br.unisul.sau.bean;

public class Empresa {
	
	private Long seq_id_empresa;
	private Long contrato;
	private String nome;
	
	public Empresa() {
		super();
	}

	public Long getSeq_id_empresa() {
		return seq_id_empresa;
	}

	public void setSeq_id_empresa(Long seq_id_cliente) {
		this.seq_id_empresa = seq_id_cliente;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
