package Utilities;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {

	// previous code and then changes with new code

	/*
	 * public String getProperty(String propertyName, String fileName) {
	 * 
	 * String propertyValue;
	 * 
	 * try { File file = new File("");
	 * 
	 * FileReader filereader = new FileReader(file);
	 * 
	 * Properties properties = new Properties();
	 * 
	 * properties.load(filereader);
	 * 
	 * propertyValue = properties.getProperty(propertyName);
	 * 
	 * Logs.getLog().getLogger().info("Sucess reading property: "+ propertyName);
	 * 
	 * 
	 * } catch (IOException ex) {
	 * Logs.getLog().getLogger().error("Failed to get property by Name: "+
	 * propertyName);
	 * 
	 * propertyValue = null; } return propertyValue;
	 * 
	 * }
	 */

	// New code taken from AppProperties1

	public static String getProperty(String filePath, String propertyName) {
		String property = null;

		try {
			File file = new File(filePath);

			FileReader fileReader = new FileReader(file);

			Properties properties = new Properties();

			properties.load(fileReader);

			property = properties.getProperty(propertyName);
		}

		catch (IOException ex) {
			Logs.getLog().getLogger("AppProperties").error("Error-->" + ex.getMessage());
		}
		if (property != null) {
			Logs.getLog().getLogger("AppProperties").info("Info--> Success Reading Property : " + property);

		} else {
			Logs.getLog().getLogger("AppProperties").info("Info--> Failure Reading Property : " + property);
		}

		return property;

	}

}
