package kh.java.oop.student;

public class Run {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("김철수");
		s1.setGender('남');
		s1.setAge(20);
		s1.introduce();
		
		System.out.println();
		
		Student s2 = new Student();
		s2.setName("이영희");
		s2.setGender('여');
		s2.setAge(20);
		s2.introduce();
	}
}
