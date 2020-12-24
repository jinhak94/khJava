package kh.java.collection.list;

import java.util.Objects;

public class Student implements Comparable<Student>{
	
	private int no;
	private String name;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Student)) {
			return false;
		}
        Student s = (Student)obj;
        if(no != s.no) {
        	return false;
        }
        if(name == null) {
        	if(s.name!=null) {
        		return false;
        	}
        }else {
        	if(!name.equals(s.name)) {
        		return false;
        	}
        }
        return true;
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(no, name);
	}
	
	/**
	 * 기본 정렬 기준
	 * no 오름차순
	 */
	@Override
	public int compareTo(Student o) {
		return this.no- o.no;
	}
}
