package br.unisul.sau.dao.impl.util;

import java.io.FileInputStream;
import java.util.Properties;

public class BDProperties {

	private static BDProperties bdProperties = null;
	private static Properties props = null;

	public BDProperties() {
		props = new Properties();
		try {
//			InputStream is = getClass().getResourceAsStream("./WebContent/properties/banco.properties");
			FileInputStream is = new FileInputStream("./WebContent/properties/banco.properties");
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized static BDProperties getInstance() {
		if (bdProperties == null) {
			bdProperties = new BDProperties();
		}
		return bdProperties;
	}

	public String getPropertieAsString(String propertie) {
		return props.getProperty(propertie);
	}

	public String getPropertieAsString(String propertie, String defaultValue) {
		return props.getProperty(propertie, defaultValue);
	}

}
