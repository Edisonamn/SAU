package br.unisul.sau.bean.tenum;

public enum TipoProblema {
	//comunicação de rede
	ADSL(1,"Adsl"),
	RADIO(2,"Radio"),
	CABLE_MODEM(3,"Cable modem"),
	OUTRO(4,"Outro"),
	
	//banco de dados
	MYSQL(5,"MySql"),
	ORACLE(6,"Oracle"),
	SQLSERVER(7,"SqlServer"),
	
	NAO_INFORMADO(8, "Não Informado");
	
	private Integer key;
	private String label;
	
	private TipoProblema(Integer key, String label) {
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
	
	public static TipoProblema findByValue(int key) {
		switch (key) {
		case 1:
			return ADSL;
		case 2:
			return RADIO;
		case 3:
			return CABLE_MODEM;
		case 4:
			return OUTRO;
		case 5:
			return MYSQL;
		case 6:
			return ORACLE;
		case 7:
			return SQLSERVER;
		case 8:
			return NAO_INFORMADO;
		default:
			return null;
		}
	}

}
