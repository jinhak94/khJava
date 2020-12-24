package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayListTest a = new ArrayListTest();
		//a.test0();
		//a.test1();
		//a.test2();
		a.test3();
		//a.test4();
		//a.test5();
	}
	
	private void test5() {
		Student[] arr = new Student[3];
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"홍길동"));
		list.add(new Student(2,"신사임당"));
		list.add(new Student(3,"장영실"));

		//학생 2명 추가
		list.add(new Student(4,"김진하"));
		list.add(new Student(5,"이진하"));
		
		int index = list.indexOf(new Student(2,"신사임당"));
		System.out.println(index);
		
		//학생1명 삭제
		list.remove(2);
		
		//학생 1명 삽입
		list.add(3, new Student(3, "박진하"));
		
		//확인
		Iterator<Student> iter = list.iterator();
		while(iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s);
		}
		
	}
	
	/**
	 * iterator
	 * 모든 요소를 열람하는 방법
	 */
	private void test4() {
		//두 번재 제네릭 타입은 생략 가능
		List<String> list = new ArrayList<>();
		list.add("honggd");
		list.add("sinsa");
		list.add("sejong");
		
		//iterator
		Iterator<String> iter = list.iterator();
		
		//모든 요소를 접근하게 되면, 재사용 불가능함. 1회성임.
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		iter = list.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
		
		
		
	}
	
	/**
	 * ArrayList 사용법
	 */
	private void test3() {
		//List는 인터페이스여서 객체화 할 수 없고,
		//ArrayList를 객체화 해야 함.
		List<Integer> list = new ArrayList<Integer>();
		
		//저장된 순서를 유지
		list.add(3);
		list.add(2);
		list.add(1);
		//중복을 허용
		list.add(2);
		list.add(3);
		System.out.println(list);
		//삭제 : 다음번지수를 하나씩 앞당겨 재배치
		list.remove(0);
		System.out.println(list);
		
		list.remove(new Integer(2));
		System.out.println(list);
		//수정 : 특정인덱스의 요소를 변경
		list.set(0, 300);
		System.out.println(list);
		
		list.add(1, 200);
		System.out.println(list);
		
		//다른 리스트의 요소를 통째로 추가
		List<Integer> another = new ArrayList<Integer>();
		another.add(999);
		another.add(99);
		another.add(9);
		
		list.addAll(another);
		System.out.println(list);
		list.add(500);
		list.add(1,500);
		System.out.println(list);
		
		//특정요소 포함여부 boolean
		boolean bool = list.contains(99);
		System.out.println(bool);
		//특정요소 포함여부 index(int)
		int idx = list.indexOf(99);
		System.out.println(idx);
		idx = list.indexOf(9999999);
		System.out.println(idx);
		list.add(5, 200);
		System.out.println(list);
		idx = list.indexOf(200);
		System.out.println(idx);
		idx = list.lastIndexOf(200);
		
		System.out.println(idx);
		
		//요소전체삭제
		//list.clear();
		
		//리스트에 요소가 없는가?
		bool = list.isEmpty();
		System.out.println(bool);
		
		System.out.println(list);
	}
	
	/**
	 * Generic 타입변수
	 * 기본형을 사용할 수 없다.
	 * 
	 */
	private void test2() {
		List<String> list = new ArrayList<>();
		//요소 추가 시에 타입 체크가 가능하다.
		//런타임도 아니고 컴파일 타임에 체크가 가능한 좋은 방법.
		list.add("안녕");
		list.add(new String("hello"));
//		list.add(new Date());
		
		//요소를 가져올 때 형변환 할 필요가 없다.
		String s = list.get(0);
		//int -> Integer, char -> Character
		//double -> Doubelc, boolean -> Boolean 
		
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);	// 1 -> new Integer(1); auto-boxing
		numList.add(2);	// 2 -> new Integer(2); auto-boxing
		
		System.out.println(numList.get(0) + numList.get(1));
		//Integer + Integer -> 1 + 2  auto-unboxing		
		System.out.println(numList.get(0).getClass());
		System.out.println(numList.get(0).getClass().getName());
	}
	
	
	// 인터페이스간의 상속은 extends 사용
	private void test1() {
		ArrayList list1 = new ArrayList();
		//List를 가장 선호함.
		List list2 = new ArrayList();
	//	List<Object> list2 = new ArrayList<Object>();
		Collection list3 = new ArrayList();
		
		//제네릭 쓰지 않으면 String 사용하기 위해
		//원래는 아래와 같이 해줘야했다.
		//Object o = list1.get(0);
		//String s = (String)list1.get(0);

		list1.add("apple");
		list1.add(123);
		list1.add(123);
		list1.add(new Date());
		list1.add(new Student());
		
		System.out.println(list1);
		
		//특정요소 : 인덱스로 접근
		System.out.println(list1.get(0));
		System.out.println(list1.get(3));

		System.out.println(list1.size());
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
//		for(Object o:list1) {
//			System.out.println(o);
//		}
	}
	
	/**
	 * 배열의 한계
	 * 
	 */
	private void test0() {
		Student[] arr = new Student[3];
		
		arr[0] = new Student(1, "홍길동");
		arr[1] = new Student(2, "신사임당");
		
		
		//학생 2명 추가
		Student[] arr1 = new Student[10];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		arr1[3] = new Student(4, "세종대왕");
		arr1[4] = new Student(5, "윤봉준");
		
		//학생1명 삭제
		//arr1[1]=null;
		arr1[1] = arr1[2];
		arr1[2] = arr1[3];
		arr1[3] = arr1[4];
		arr1[4] = null;
		
		arr1[4] = arr1[3];
		arr1[3] = arr1[2];
		arr1[2] = arr1[1];
		
		//확인
		for(Student s:arr1) {
			System.out.println(s);
		}
	}
}
