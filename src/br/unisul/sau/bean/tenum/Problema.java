package br.unisul.sau.bean.tenum;

public enum Problema {
	COMUNICACAO_REDE(1, "Comunicação de rede"), BANCO_DADOS(2, "Banco e dados"), DESEMPENHO(3, "");

	private Integer key;
	private String label;

	private Problema(Integer key, String label) {
		this.key = key;
		this.label = label;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static Problema findByValue(int key) {
		switch (key) {
		case 1:
			return COMUNICACAO_REDE;
		case 2:
			return BANCO_DADOS;
		case 3:
			return DESEMPENHO;
		default:
			return null;
		}

	}

}
