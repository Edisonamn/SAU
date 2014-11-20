package br.unisul.sau.bean.tenum;

public enum Status {
	INICIADO("iniciado", "Iniciado"),
	EM_ATENDIMENTO("em atendimento","Em atendimento"),
	AGUARDANDO_RESPOSTA("aguardando resposta","Aguardando resposta"),
	ENCERRADO("encerrado","Encerrado"),
	SEM_SOLUCAO("sem solucao","Sem solução");
	
	private String key;
	private String label;
	
	private Status(String key, String label) {
		this.key = key;
		this.label = label;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}	

}
