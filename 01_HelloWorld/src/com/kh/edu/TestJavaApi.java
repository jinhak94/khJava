package com.kh.edu;

import java.util.Calendar;

public class TestJavaApi {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)
				+"/"+(cal.get(Calendar.MONTH)+1)
				+"/"+cal.get(Calendar.DATE));
		
	}
}
