package ncs4.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add((int)(Math.random()*100+1));
		}
		Collections.sort(list, new Decending());
		new ListTest().display(list);
	}
	
	public void display(List<Integer> list) {
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
