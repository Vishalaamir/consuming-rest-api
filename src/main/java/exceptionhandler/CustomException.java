package exceptionhandler;

import java.util.Properties;

public class CustomException extends RuntimeException {
	
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
		System.out.println("properties:"+properties);
	}
	

}
