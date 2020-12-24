package kh.java.collection.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kh.java.collection.list.Student;

public class HashSetTest {
	public static void main(String[] args) {
		HashSetTest h = new HashSetTest();
		//h.test1();
		//h.test2();
		//h.test3();
		//h.test4();
		h.test5();
	}
	
	/**
	 * LinkedHashSet : 저장된 순서 유지, 중복 제거
	 * TreeSet : 오름차순 정렬, 중복 제거
	 */
	private void test5() {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("c");
		set1.add("b");
		set1.add("a");
		set1.add("b");
		set1.add("a");
		System.out.println(set1);
		
		TreeSet<Integer> set2 = new TreeSet<>();
		set2.add(2);
		System.out.println(set2);
		set2.add(5);
		System.out.println(set2);
		set2.add(4);
		System.out.println(set2);
		set2.add(3);
		System.out.println(set2);
		set2.add(1);
		System.out.println(set2);
		
	}
	
	/**
	 * 커스텀클래스의 중복제거
	 */
	private void test4() {
		Set<Student> set = new HashSet<>();
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신사임당"));
		set.add(new Student(1, "홍길동"));
		System.out.println(set);
		
		
	}
	
	/**
	 * List와 Set을 동시에 사용하는 예
	 * 1. list -> set : 중복제거
	 * 2. set -> list : 순서, 개별접근
	 */
	private void test3() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(3);
		System.out.println(list);
	
		//list -> set
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
		
		//set -> list
		List<Integer> list2 = new ArrayList<>(set);
		System.out.println(list2);
		System.out.println(list2.get(0));
		list2.sort(Collections.reverseOrder());
		System.out.println(list2);
	}
	
	/**
	 * 전체요소 열람
	 */
	private void test2() {
		Set<String> set = new HashSet<>();
		set.add("abc");
		set.add("가나다");
		set.add("kkk");
		
		System.out.println(set);

		//set을 전체열럼하는 첫 번째 방법
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
		//set을 전체열람하는 두 번째 방법
		for(String s:set) {
			System.out.println(s);
		}
		
		//요소 포함여부
		System.out.println(set.contains("abc"));
		System.out.println(set.contains("123"));
	}
	
	private void test1() {
		HashSet set1 = new HashSet();
		Set set2 = new HashSet();
		Collection set3 = new HashSet();
		set1.add(123);
		set1.add("hello");
		set1.add(new Student(1, "홍길동"));
		set1.add(new Student(1, "홍길동"));
		//중복을 허용하지 않음. Date() 메소드는 equals와 hashCode 오버라이딩 해놨음.
		set1.add(new Date());
		set1.add(new Date());
		set1.add(123);
		set1.add("hello");
		
		//삭제
		set1.remove(123);
		
		//전체요소삭제
		set1.clear();
		
		//요소가 존재하지 않는가?
		System.out.println(set1.isEmpty());
		
		System.out.println(set1.size());
		System.out.println(set1);
		
	}
}
