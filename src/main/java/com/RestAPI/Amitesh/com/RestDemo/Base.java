package com.RestAPI.Amitesh.com.RestDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	
	public String gethost(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("/Users/568650/Documents/Selenium/com.RestDemo/src/main/java/resource/config.properties"));
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String url=prop.getProperty(key);
		
		return url;
	}

}
