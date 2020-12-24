package com.api.member.model.vo;

import java.util.Calendar;

public class Member {
	
	private int memberNo;
	private String memberName;
	private int height;
	private int weight;
	private Calendar birth;
	
	public Member(int memberNo, String memberName, int height, int weight, Calendar birth) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.height = height;
		this.weight = weight;
		this.birth = birth;
	}

	public String information() {
		String year, month, day;
		String birthday;
		year = String.valueOf(birth.get(Calendar.YEAR));
		month = String.valueOf(birth.get(Calendar.MONTH));
		day = String.valueOf(birth.get(Calendar.DATE));
		if(Integer.parseInt(month)<10) {
			month = "0" + month;
		}
		if(Integer.parseInt(day)<10) {
			day = "0" + day;
		}
		birthday = year + month + day;
		
		return "회원번호 : " + memberNo + ", 회원명 : " + memberName + 
				", 키 : " + height + ", 몸무게 : " + weight + 
				", 생일 : " + birthday;
	}
}
