package kh.java.api.format;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {
	public static void main(String[] args) {
		FormatTest t = new FormatTest();
		t.test1();
		t.test2();
	}
	
	/**
	 * Decimal Format
	 * 
	 * - # : 해당자리수의 숫자가 없다면 비워둠.
	 * - 0 : 해당자리수의 숫자가 없다면 0으로 채움.
	 */
	public void test2() {
		double num = 1234567890.123;
		//반올림 처리됨.
		DecimalFormat df = new DecimalFormat("#,###.####");
		System.out.println(df.format(num));
		
		df.applyLocalizedPattern("0,000.00000");
		System.out.println(df.format(num));
		
	}
	
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd (E) HH:mm:ss");
		Date now = new Date();
		System.out.println(sdf.format(now));

		System.out.println(new SimpleDateFormat("HH시 mm분 ss초").format(now));
		System.out.println(new SimpleDateFormat("M L").format(now));
	}
}
