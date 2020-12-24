package kh.java.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kh.java.collection.list.Student;

/**
 * 
 * 
 *
 */

public class HashMapTest {
	public static void main(String[] args) {
		HashMapTest h = new HashMapTest();
		//h.test1();
		//h.test2();
		h.test3();
	}
	
	/**
	 * VO객체 맵으로 관리하기
	 *  - key : vo객체의 고유필드
	 *  - value : vo객체
	 */
	private void test3() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "홍길동"));
		map.put(2, new Student(2, "신사임당"));
		map.put(3, new Student(3, "세종"));
		System.out.println(map);
		
		//학생검색
		//containsKey
		boolean bool = map.containsKey(1);
		System.out.println(bool);
		
		//containsValue : equals&hashCode override 필수
		// new Student는 equals와 hashCode를 오버라이딩 해놨기 때문에
		// 동일한 객체로 인식한다.
		bool = map.containsValue(new Student(3, "세종"));
		System.out.println(bool);
		
		
		
	}
	
	/**
	 * 전체요소 열람
	 * 1. keySet() : key로만 set을 구성
	 * 2. entrySet() : key, value로 set을 구성
	 * 
	 */
	private void test2() {
		Map<String, Integer> map = new HashMap<>();
		// put하면 Node 객체로 관리된다.
		map.put("홍길동", 90);
		map.put("신사임당", 97);
		map.put("세종", 88);
		map.put("장영실", 79);
		map.put("유관순", 99);
		
		//List나 Set에 대해서 접근을 할 수 있고,
		//Map은 전체 접근 불가하므로, 
		//우회적으로 접근함
		//1. keySet
//		Set<String> keySet = map.keySet();
//		for(String key : keySet) {
//			System.out.println(key + " = "
//					+ map.get(key));
//		}
		//1-2 iterator
//		Iterator<String> iter = keySet.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println(key + " = " 
//			+ map.get(key));	
//		}
		//2. entrySet
		//내부클래스(Map 밑의 Entry 인터페이스)
		Set<Map.Entry<String, Integer>> entrySet = 
				map.entrySet();
		// Set에서 객체를 하나 꺼내면 Map.Entry 객체가 나오는 것
		// Node가 Map.Entry를 구현하므로, Map.Entry로 관리할 수 있다.
		//2-1. forEach
		for(Map.Entry<String, Integer> entry : entrySet) {
			//System.out.println(entry);
			String key = entry.getKey();
			Integer value = entry.getValue();
//			System.out.println(key + " = " + value);
		}
		//2-2. Iterator
		Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			System.out.println(entry);
		}
	
	}
	
	private void test1() {
		HashMap<Object, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		
		// 요소 추가
		// 중복된 요소가 없다면 null 리턴
		map2.put("honggd", "홍길동");
		map2.put("today", "new Date()");
		map2.put("점수", "99.9");
		map2.put("123", "456");
		map2.put("gd","홍길동");
		// 중복 저장되지 않는다.
		// 동일한 key값을 사용해서 저장하면 덮어씌워짐.
		//중복된 value값이 있다면, 삭제된 요소를 리턴한다.
		Object removed = map2.put("123",789); 
		System.out.println(removed);
		
		//toString
		System.out.println(map2);
		
		//get(String key) : Object
		System.out.println(map2.get("today"));
		
		//size()
		System.out.println(map2.size());
		
		//remove(key)
		System.out.println(map2.remove("today"));
	}
}
