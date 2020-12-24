package ncs4.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

public class PropTest {
	public static void main(String[] args) {
		PropTest pt = new PropTest();
		Properties p = new Properties();
		p.setProperty("1", "apple,1200,3");
		p.setProperty("2", "banana,2500,2");
		p.setProperty("3", "grape,4500,5");
		p.setProperty("4", "orange,800,10");
		p.setProperty("5", "melon,5000,2");
		pt.fileSave(p);
		pt.fileOpen(p);
	}
	
	public void fileSave(Properties p) {
		try{
			p.storeToXML(new FileOutputStream("data.xml"), "data.xml");		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen(Properties p) {
		try{
			p.loadFromXML(new FileInputStream("data.xml"));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<?> names = p.propertyNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String value = p.getProperty(name);
			StringTokenizer t = new StringTokenizer(value, ",");
			String fruit = t.nextToken();
			String price = t.nextToken();
			String num = t.nextToken();
			System.out.println(name + "=" + 
			fruit + ", " + price + "원, " + num + "개");
		}
		
	}
	
}
