package br.unisul.sau.bean.tenum;

public enum Status {
	INICIADO(1, "Iniciado"),
	EM_ATENDIMENTO(2,"Em atendimento"),
	AGUARDANDO_RESPOSTA(3,"Aguardando resposta"),
	ENCERRADO(4,"Encerrado"),
	SEM_SOLUCAO(5,"Sem solução"),
	NAO_INFORMADO(6, "Não Informado");
	
	private Integer key;
	private String label;
	
	private Status(Integer key, String label) {
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
	
	public static Status findByValue(int key) {
		switch(key) {
		case 1: return INICIADO;
		case 2: return EM_ATENDIMENTO;
		case 3: return AGUARDANDO_RESPOSTA;
		case 4: return ENCERRADO;
		case 5: return SEM_SOLUCAO;
		case 6: return NAO_INFORMADO;
		default: return null;
		}
	}

}
