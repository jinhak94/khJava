package kh.java.collection.list.comp;

import java.util.Comparator;

import kh.java.collection.list.Student;

public class StudentNameDescending implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		return s2.getName().compareTo(s1.getName());
	}

}
