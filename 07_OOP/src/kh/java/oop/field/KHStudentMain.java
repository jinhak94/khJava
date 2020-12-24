package kh.java.oop.field;

public class KHStudentMain {
	public static void main(String[] args) {
		KHStudent kh1 = new KHStudent();
		kh1.setStudentName("김진하");
		kh1.setStudentPhoneNum("01056785678");
		kh1.setClassRoom("201호");
		
		KHStudent kh2 = new KHStudent();
		kh2.setStudentName("홍길동");
		kh2.setStudentPhoneNum("01043214321");
		kh2.setClassRoom("202호");
		
		System.out.printf("교육원명 : [%s], 교육원전화번호 : [%s],%n"
				+ "학생명 : [%s], 강의장명 : [%s], 전화번호 : [%s]%n",
				KHStudent.KH_NAME, KHStudent.KH_PHONE_NUM,
				kh1.getStudentName(), kh1.getClassRoom(),
				kh1.getStudentPhoneNum());

		System.out.printf("교육원명 : [%s], 교육원전화번호 : [%s],%n"
				+ "학생명 : [%s], 강의장명 : [%s], 전화번호 : [%s]%n",
				KHStudent.KH_NAME, KHStudent.KH_PHONE_NUM,
				kh2.getStudentName(), kh2.getClassRoom(),
				kh2.getStudentPhoneNum());
		
	}
}
