package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar cal;
		
		int year, month, day;
		SimpleDateFormat sf = 
				new SimpleDateFormat("yyyy년 M월 dd일 E요일");
		System.out.println("날짜를 입력하시오.");
		
		System.out.print("년 : ");
		year = sc.nextInt();

		System.out.print("월 : ");
		month = sc.nextInt();
		
		System.out.print("일 : ");
		day = sc.nextInt();
		
		cal = new GregorianCalendar(year, month-1, day);

		
		System.out.println("\n입력된 날짜에 대한 정보는 아래와 같습니다.");
		System.out.println(sf.format(cal.getTime()));
		
		if((cal.getWeekYear()%4)==0) {			
			System.out.println(cal.getWeekYear() + "년은 윤년이다.");
		}
		
	}
}
