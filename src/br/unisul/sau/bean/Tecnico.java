package br.unisul.sau.bean;

public class Tecnico {
	
	private Long seq_id_tecnico;
	private String nome;
	private String login;
	private String pwd;
	
	public Tecnico() {
		super();
	}

	public Long getSeq_id_tecnico() {
		return seq_id_tecnico;
	}

	public void setSeq_id_tecnico(Long seq_id_tecnico) {
		this.seq_id_tecnico = seq_id_tecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return login;
	}

	public void setUser(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
