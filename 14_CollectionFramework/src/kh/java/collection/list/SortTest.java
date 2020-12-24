 package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kh.java.collection.list.comp.StudentNameAscending;
import kh.java.collection.list.comp.StudentNameDescending;
import kh.java.collection.list.comp.StudentNoDescending;

/**
 * 
 * collection의 정렬
 * - Comparable : 기본정렬(딱 한 가지)
 * - Comparator : 여러 정렬 기준을 만들 수 있음(클래스 당 하나)
 *
 */
 
public class SortTest {
	public static void main(String[] args) {
		SortTest s = new SortTest();
		s.test1();
		s.test2();
	}
	
	private void test2() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(2, "신사임당"));
		list.add(new Student(4, "유관순"));
		list.add(new Student(1, "홍길동"));
		list.add(new Student(5, "윤봉길"));
		list.add(new Student(3, "세종대왕"));
		System.out.println(list);
		
		//번호 오름차순
		System.out.println("번호 오름차순");
		Collections.sort(list);
		System.out.println(list);
		
		//번호 내림차순
		System.out.println("번호 내림차순");
		Comparator<Student> comp = new StudentNoDescending();
		Collections.sort(list, comp);
		System.out.println(list);

		//이름 오름차순
		System.out.println("이름 오름차순");
		comp = new StudentNameAscending();
		Collections.sort(list, comp);
		System.out.println(list);
		
		//이름 내림차순
		System.out.println("이름 내림차순");
		comp = new StudentNameDescending();
		Collections.sort(list, comp);
		System.out.println(list);
	}
	
	private void test1() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(1);
		System.out.println(list);
		
		//정렬 Integer 기본정렬 Comparable 구현
		//Collections.sort(list);
		list.sort(null);
		System.out.println(list);
		
		//기본정렬 외에 정렬 기준을 제시하고 싶다면, Comparator 객체를 이용하면 된다.
		Comparator<Integer> comp = Collections.reverseOrder();
		//Collections.sort(list, comp);
		list.sort(comp);
		System.out.println(list);
		
		List<String> strList = new ArrayList<>();
		strList.add("ghi");
		strList.add("jkl");
		strList.add("mon");
		strList.add("abc");
		strList.add("def");
		System.out.println(strList);
		//Collections.sort(strList);
		strList.sort(null);
		System.out.println(strList);
		
		Comparator<String> strComp = Collections.reverseOrder();
		Collections.sort(strList, strComp);
		strList.sort(strComp);
		System.out.println(strList);
		
	}
}









