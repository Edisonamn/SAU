package br.unisul.sau.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import br.unisul.sau.dao.impl.util.BDProperties;

public class Conexao {
	
	private static Conexao conexao = null;
	private static Connection connection = null;
	
	public Conexao() {
		createConexao();
	}
	
	public static Connection getInstance() {
		if (conexao == null) {
			conexao = new Conexao();
		}
		return connection;
	}

	private void createConexao() {
		try {
			Class.forName(BDProperties.getInstance().getPropertieAsString("driver"));
			Properties prop = new Properties();
			prop.setProperty("user", BDProperties.getInstance().getPropertieAsString("user"));
			prop.setProperty("password", BDProperties.getInstance().getPropertieAsString("password"));
			
			connection = DriverManager.getConnection(BDProperties.getInstance().getPropertieAsString("url"), prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
