package com.collection.map.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain {
	public static void main(String[] args) {
		Properties p = new Properties();
		try{
			p.load(new FileInputStream("resources/config.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Enumeration<?> names = p.propertyNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String value = p.getProperty(name);
			System.out.println(name + "=" + value);
		}
	}
}
