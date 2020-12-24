package ncs4.test3;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Inventory> map = new HashMap<String, Inventory>();
		map.put("삼성 갤럭시", new Inventory("삼성 갤럭시", 
				new Date(new GregorianCalendar(2016,3,15).getTimeInMillis()), 30));
		map.put("LG G5", new Inventory("삼성 갤럭시", 
				new Date(new GregorianCalendar(2016,2,25).getTimeInMillis()), 20));
		map.put("애플 아이패드", new Inventory("삼성 갤럭시", 
				new Date(new GregorianCalendar(2016,1,23).getTimeInMillis()), 15));
		List<Inventory> list = new ArrayList<>();
		Set<Map.Entry<String, Inventory>> setEntry = map.entrySet();
		Iterator<Map.Entry<String,Inventory>> iter = setEntry.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Inventory> entry = iter.next();
			list.add(entry.getValue());
			System.out.println(entry);
		}
		
		Inventory[] inven = list.toArray(new Inventory[list.size()]);
		for(int i = 0; i < inven.length; i++) {
			inven[i].setGetDate(new Date());
			try{
				inven[i].setGetAmount(10);
			}catch(AmountNotEnough e) {
				System.out.println("현재 " + inven[i].getGetAmount() + "개를 출고하기에는"
						+ inven[i].getProductName() + "의 재고가 부족합니다. 재고수량 확인하시기 바랍니다.");
			}
			
		}
		
		System.out.println();
		
		iter = setEntry.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Inventory> entry = iter.next();
			list.add(entry.getValue());
			System.out.println(entry);				
		}
	}
}
