package student.model.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import student.model.controller.StudentController;
import student.model.vo.Student;

public class StudentView {
	private StudentController sct = new StudentController();
	private ArrayList<Student> list;
	private Scanner sc = new Scanner(System.in);
	private int no; //학번
	private String name; //이름
	private int age; //나이
	private String address; //주소
	private double grade; //학점

	public void mainMenu() {
		while(true) {
			System.out.println("1. 학생 전체 정보 출력");
			System.out.println("2. 학생 정보 조회(학번)");
			System.out.println("3. 학생 정보 입력");
			System.out.println("4. 학생 정보 변경");
			System.out.println("5. 학생 삭제 ");
			System.out.println("0. 프로그램 종료");
				
			int input = sc.nextInt();
			switch(input) {
			case 1:
				selectAll();
				break;
			case 2:
				selectOne();
				break;
			case 3:
				insertStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				return;
			}
		}
	}
	
	public void selectAll() {
		list = sct.selectAll();
		if(list.isEmpty()) {
			System.out.println("학생 정보가 존재하지 않습니다.\n");
		}else {
			System.out.println("전체 학생의 정보를 출력합니다.\n");
		}
		
		Iterator<Student> iter = list.iterator();
		while(iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s);
		}
	}
	
	public void selectOne() {
		System.out.print("조회할 학생의 학번을 입력하세요 : ");
		no = sc.nextInt();
		Student s = sct.selectOne(no);
		if(s == null) {
			return;
		}else {			
			System.out.println(s);
		}
	}
	
	public void insertStudent() {
		
		System.out.print("학번을 입력하세요 : ");
		no = sc.nextInt();
		System.out.print("이름을 입력하세요 : ");
		name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();
		address = sc.nextLine();
		System.out.print("학점을 입력하세요 : ");
		grade = sc.nextDouble();
		sct.insertStudent(new Student(no,name,age,address,grade));
		System.out.println("학번이 " + no + "인 학생의 학생 정보를 입력하였습니다.\n");
	}
	
	public void updateStudent() {
		System.out.print("수정할 학생의 학번을 입력하세요 : ");
		list = sct.selectAll();
		boolean bool = false;
		no = sc.nextInt();
		Student st = null;
		Iterator<Student> iter = list.iterator();
		while(iter.hasNext()) {
			st = iter.next();
			if(st.getNo() == no) {
				bool = true;
				break;	
			}
		}
		if(bool == false) {
			System.out.println("학생 정보가 존재하지 않습니다.\n");
			return;
		}
		
		System.out.println("------- 수정 내역 입력 --------");
		System.out.print("학번을 입력하세요 : ");
		no = sc.nextInt();
		System.out.print("이름을 입력하세요 : ");
		name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();
		address = sc.nextLine();
		System.out.print("학점을 입력하세요 : ");
		grade = sc.nextDouble();
		
		sct.updateStudent(st, new Student(no, name, age, address, grade));
	}
	
	public void deleteStudent() {
		System.out.print("학생 정보를 삭제할 학생의 학번을 입력하세요 : ");
		no = sc.nextInt();
		sct.deleteStudent(no);
	}
	
	
}
