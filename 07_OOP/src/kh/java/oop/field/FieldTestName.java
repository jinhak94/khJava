package kh.java.oop.field;

public class FieldTestName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FieldTest f = new FieldTest();
//		f.test1();
		f.test2();
	
		FieldTest k = new FieldTest();
		f.test3(k);
		System.out.println(k.a);
	}
}
