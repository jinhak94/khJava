package com.api.member.run;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.api.member.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		String str = "1,김연아,165,47,19900905|"
				+ "2,양세형,167,60,19850818|3,김래원,182,80,19810319";
		
		StringTokenizer st = new StringTokenizer(str, "|");
		Member[] m = new Member[st.countTokens()];
		Run r = new Run();
		int idx = 0;
		while(st.hasMoreTokens()) {
			m[idx] = r.subTokenizer(st.nextToken(), m[idx]);
			idx++;
		}
		for(int i = 0; i < idx; i++) {
			System.out.println(m[i].information());
		}
	}
	
	public Member subTokenizer(String str, Member m) {
		StringTokenizer st = new StringTokenizer(str, ",");
		int memberNo;
		String memberName;
		int height;
		int weight;
		String strBirth;
		Calendar birth;
		int year, month, day;
		
		
		memberNo = Integer.parseInt(st.nextToken());
		memberName = st.nextToken();
		height = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());
		strBirth = st.nextToken();

		year = Integer.parseInt(strBirth.substring(0, 4));
		month = Integer.parseInt(strBirth.substring(4,6));
		day = Integer.parseInt(strBirth.substring(6));
		
		birth = new GregorianCalendar(year, month, day);
		
		return new Member(memberNo, memberName, height, weight, birth);
	}
	
}
