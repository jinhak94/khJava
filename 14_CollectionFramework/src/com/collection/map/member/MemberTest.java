package com.collection.map.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MemberTest {
	Map<String, Member> map = new HashMap<>();
	
	public MemberTest() {
		map.put("1", new Member("honggd","1234","홍길동",35,"01012341234"));
		map.put("2", new Member("sinsa","1234","신사임당",50,"01012341234"));
		map.put("3", new Member("leess","1234","이순신",43,"01012341234"));
		map.put("4", new Member("yooon","1234","윤봉길",37,"01012341234"));
		map.put("5", new Member("jangbg","1234","장보고",29,"01012341234"));		
	}
	
	public static void main(String[] args) {
		MemberTest mt = new MemberTest();
		mt.test2();
		mt.test3();
		mt.test4();
	}

	public boolean isUserExist(String userId) {
		Set<Map.Entry<String, Member>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Member>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Member> et = iter.next();
			if(userId.equals(et.getValue().getUserId())) {
				return true;
			}
		}
		return false;
	}
	
	public void test2() {
		String str1 = "jangbg";
		String str2 = "sejong";
		if(isUserExist(str1)) {
			System.out.println(str1 + "는 존재합니다.");
		}else {
			System.out.println(str1 + "는 존재하지 않습니다.");
		}
		
		if(isUserExist(str2)) {
			System.out.println(str2 + "는 존재합니다.");
		}else {
			System.out.println(str2 + "는 존재하지 않습니다.");
		}
		
	}
	
	public void test3() {
		Set<Map.Entry<String, Member>> setEntry = map.entrySet();
		Iterator<Map.Entry<String, Member>> iter = setEntry.iterator();
		String id = "yooon";
		while(iter.hasNext()) {
			Map.Entry<String, Member> m = iter.next();
			if(id.equals(m.getValue().getUserId())) {
				m.getValue().setUserPwd("5678");
				m.getValue().setUserName("윤동주");;
				m.getValue().setAge(27);
				m.getValue().setPhoneNumber("01034563456");
				System.out.println(id + " 멤버 정보를 수정하였습니다.");
			}
		}
	}
	
	public void test4() {
		Set<Map.Entry<String, Member>> setEntry = map.entrySet();
		Iterator<Map.Entry<String, Member>> iter = setEntry.iterator();
		String key = null;
		String id = "sinsa";
		//iterator를 돌면서 뭔가 내부에서 삭제 연산을 진행할 수 없음.
		//동시성 문제에 빠져서 ConcurrentModificationException을 발생시킴.
		while(iter.hasNext()) {
			Map.Entry<String, Member> m = iter.next();
			if(m.getValue().getUserId().equals(id)) {
				key = m.getKey();
			}
		}
		if(key!=null) {
			map.remove(key);
			System.out.println(id + " 멤버 정보를 삭제하였습니다.");
		}
		
	}
	
}
