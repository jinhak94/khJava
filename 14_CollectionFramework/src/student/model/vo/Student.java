package student.model.vo;

public class Student {
	private int no;
	private String name;
	private int age;
	private String address;
	private double grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(int no, String name, int age, String address, double grade) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.address = address;
		this.grade = grade;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", age=" + age + ", address=" + address + ", grade=" + grade
				+ "]";
	}
	
	
}
