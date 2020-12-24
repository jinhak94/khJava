package kh.java.oop.field;

/**
 * k학생정보를 관리
 * 필드 :
 *  - 교육원명
 *  - 학생명
 *  - 강의장명
 *  - 학생 전화번호
 *  - 교육원 전화번호
 * 
 *
 */

public class KHStudent {

	public static final String KH_NAME = "kh정보교육원";
	public static final String KH_PHONE_NUM = "01012341234";

	private String studentName = "김진하";
	private String studentPhoneNum = "01043214321";
	private String classRoom = "203호";

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentPhoneNum(String studentPhoneNum) {
		this.studentPhoneNum = studentPhoneNum;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentPhoneNum() {
		return studentPhoneNum;
	}
	public String getClassRoom() {
		return classRoom;
	}
}
