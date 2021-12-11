package com.wizards.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigReader {
	
	public Properties prop;
	
	public Properties init_prop() throws IOException
	{
		prop = new Properties();	
			
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");	
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return prop;

	}	
	public String getProperty(String key)
	{		
		return prop.getProperty(key);
	}	
	//For testing
	public static void main(String[] args) {
		ConfigReader pr = new ConfigReader();
		System.out.println(pr.getProperty("browser"));		
	}	
}
