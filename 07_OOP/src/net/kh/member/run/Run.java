package net.kh.member.run;

import java.util.Scanner;

import net.kh.member.Member;

public class Run {
	public static void main(String[] args) {
		
		//사용자 입력값으로 member객체 대입하기
		Scanner sc = new Scanner(System.in);
		
		Member m = new Member();

		System.out.print("아이디 : ");
		String memberId = sc.next();
		m.setMemberId(memberId);
		
		System.out.print("Pwd : ");
		String memberPwd = sc.next();
		m.setMemberPwd(memberPwd);
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		m.setMemberName(memberName);
	
		System.out.print("나이 : ");
		int age = sc.nextInt();
		m.setAge(27);
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		m.setGender(gender);

		System.out.print("전화번호 : ");
		String phone = sc.next();
		m.setPhone(phone);
		
		System.out.print("이메일 : ");
		String email = sc.next();
		m.setEmail(email);
		
		System.out.printf("ID : [%s], pwd : [%s],%n 이름 : [%s]"
				+ " 나이 : [%d], 성별 : [%c],%n 핸드폰번호 : [%s], 이메일 : [%s]",
				m.getMemberId(), m.getMemberPwd(), m.getMemberName()
				,m.getAge(), m.getGender(), m.getPhone(),m.getEmail());
	}
}
