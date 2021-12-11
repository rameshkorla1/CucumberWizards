package com.wizards.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigReader {
	
	public Properties prop;
	
	public Properties PropertyReader()
	{
		prop = new Properties();	
		File file = new File("./src/test/resources/config/config.properties");	
		InputStream is = null;		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		try {
			prop.load(is);
		} catch (IOException e) {
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
