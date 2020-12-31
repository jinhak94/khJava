package ncs.test5;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PhoneMapTest {
	public static final int PHONE_NUM = 3;
	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		Phone[] phoneArr = new Phone[PHONE_NUM];
		Properties prop = new Properties();

		phoneArr[0] = new Phone("galaxy S7", 563500, "삼성", 7);
		phoneArr[1] = new Phone("iphone 6s", 840000, "애플", 3);
		phoneArr[2] = new Phone("G5", 563500, "LG", 5);
		
		for(int i = 0; i < phoneArr.length; i++) {
			map.put(phoneArr[i].getModel(),phoneArr[i]);
		}

		Set<Map.Entry<String, Phone>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Phone>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Phone> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
			prop.setProperty(entry.getKey(), ((Phone)entry.getValue()).toString());
		}
		
		//파일기록
		try{
			prop.storeToXML(new FileOutputStream("phone.xml"), "phone.xml");
			System.out.println("phone.xml 파일에 성공적으로 저장되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
