package kh.java.oop.access.modifier.field;

public class AccessModifierFieldTest {
	
	public int publicNum = 1;
	protected int protectedNum = 2;
	int defaultNum = 3;
	private int privateNum = 4;
	
	public void test() {
		System.out.println(publicNum);
		System.out.println(protectedNum);
		System.out.println(defaultNum);
		System.out.println(privateNum);
	}
}
