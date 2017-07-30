package config;

import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	private String getAnyProperty(String property) {
		Properties prop = new Properties();
		InputStream io = null;

		try {
			String filename = "context.properties";
			io = getClass().getClassLoader().getResourceAsStream(filename);
			if (io != null) {
				prop.load(io);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (io != null) {
				try {
					io.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		if (io == null)
			return "";
		return prop.getProperty(property);
	}

	public String getUsernameDb() {
		return getAnyProperty("property.user");
	}

	public String getPasswordDb() {
		return getAnyProperty("property.password");
	}

	public String getUrlDb() {
		return getAnyProperty("property.url");
	}

	public String getUrlRedis() {
		return getAnyProperty("property.redis");
	}
}
