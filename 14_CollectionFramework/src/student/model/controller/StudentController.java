package student.model.controller;

import java.util.ArrayList;
import java.util.Iterator;

import student.model.vo.Student;


public class StudentController {
	private ArrayList<Student> list = new ArrayList<>();
	
	public ArrayList<Student> selectAll(){
		return list;
	}
	
	public Student selectOne(int classNumber) {
		Iterator<Student> iter = list.iterator();
		int no = 0;
		while(iter.hasNext()) {
			Student s = iter.next();
			if(s.getNo() == classNumber) 
				break;
			no++;
		}

		try{
			Student s = list.get(no);
			System.out.println("학번이 "+classNumber+" 인 학생의 정보를 출력합니다.");
			return s;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 학번입니다!\n");
			return null;
		}
	}
	
	public void insertStudent(Student s) {
		list.add(s);
		System.out.println(list.size());
	}
	
	public void updateStudent(Student oldStudent, Student newStudent) {
		Iterator<Student> iter = list.iterator();
		int no = 0;
		while(iter.hasNext()) {
			Student s = iter.next();
			if(s.getNo() == oldStudent.getNo()) 
				break;
			no++;
		}
		list.set(no , newStudent);
	}
	
	public void deleteStudent(int classNumber) {
		Iterator<Student> iter = list.iterator();
		int no = 0;
		while(iter.hasNext()) {
			Student s = iter.next();
			if(s.getNo() == classNumber) 
				break;
			no++;
		}
		
		try{
			list.remove(no);
			System.out.println("학번이 "+classNumber+"인 학생의 학생 정보를 삭제하였습니다!\n");
		}catch(IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 학번입니다!");
		}
	}
}
