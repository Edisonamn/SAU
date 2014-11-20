package br.unisul.sau.bean.tenum;

public enum TipoProblema {
	//comunicação de rede
	ADSL("adsl","Adsl"),
	RADIO("radio","Radio"),
	CABLE_MODEM("cable modem","Cable modem"),
	OUTRO("outro","Outro"),
	
	//banco de dados
	MYSQL("mysql","MySql"),
	ORACLE("oracle","Oracle"),
	SQLSERVER("sqlserver","SqlServer");
	
	private String key;
	private String label;
	
	private TipoProblema(String key, String label) {
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
