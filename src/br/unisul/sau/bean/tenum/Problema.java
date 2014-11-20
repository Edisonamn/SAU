package br.unisul.sau.bean.tenum;

public enum Problema {
	COMUNICACAO_REDE("comunicacao de rede","Comunicação de rede"),
	BANCO_DADOS("banco dados","Banco e dados"),
	DESEMPENHO("","");
	
	private String key;
	private String lagel;
	
	private Problema(String key, String lagel) {
		this.key = key;
		this.lagel = lagel;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLagel() {
		return lagel;
	}
	public void setLagel(String lagel) {
		this.lagel = lagel;
	}

}
