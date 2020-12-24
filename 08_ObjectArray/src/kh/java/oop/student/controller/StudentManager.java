package kh.java.oop.student.controller;

import java.util.Scanner;

import kh.java.oop.student.model.vo.Student;

/**
 * StudentManager -----------> Student
 * 연관관계 : 멤버변수로 Student를 참조한다.
 * 
 * has a 포함관계 (=연관관계)
 * - A has a B가 성립하면 포함관계
 * - StudentManager has a Student (true) -> 객체 가지고 있음
 * 
 * is a 상속관계
 * 
 */

public class StudentManager {
	
	public static final int MAX_STUDENT = 100;
	
	private Student[] arr = new Student[MAX_STUDENT];
	private Scanner sc = new Scanner(System.in);
	private int idx = 0;
	
	public void manageStudent() {
		System.out.println("---- 학생 관리 시작 ----");
		
		//1. 사용자 입력값으로 학생 객체 생성
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = inputStudent();
//		}
		while(true) {
			arr[idx] = inputStudent();
			idx++;
			
			System.out.print("추가 입력하시겠습니까? (y/n) ");
			char yn = sc.next().charAt(0);
			
			if(yn=='n')
				break;
		}
		//2. 학생 객체 출력
		printStudent();
		//3. 
	}
	
	/**
	 * 2. 배열 인덱스변수 idx
	 */
	
	public void printStudent() {
		for(int i = 0; i < idx; i++) {
			System.out.println(arr[i].print());
		}
	}
	
	/**
	 * 1. null여부 검사후 print 메소드 출력
	 */
	public void printStudent_() {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]!=null)
			//System.out.println(i + " : " + arr[i]);
				System.out.println(arr[i].print()); // NPE   .이 문제가 됨.
			else
				break;
		}
	}

	public Student inputStudent() {
		System.out.print("학생명 : ");
		String name = sc.next();
		System.out.print("점수 : ");
		int point = sc.nextInt();

		return new Student(name, point);
	}
}
