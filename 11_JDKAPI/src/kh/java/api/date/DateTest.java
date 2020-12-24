package kh.java.api.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
	
	public static void main(String[] args) {
		DateTest d = new DateTest();
		//d.test1();
		//d.test2();
		d.test3();
		//d.test4();
	}
	
	/**
	 * Date 국제화 문제로 인해 기본생성자, 밀리초 생성자를 제외하고는
	 * deprecated 되어서 사용해서는 안됩니다..
	 */
	public void test4() {
		//Calendar	-> Date
		Calendar calNewYear = new GregorianCalendar(2021, 0, 1);
		Date dateNewYear = new Date(calNewYear.getTimeInMillis());
		System.out.println(dateNewYear);
		
		//Date -> Calendar
		Calendar another = Calendar.getInstance();
		another.setTime(dateNewYear);
		printCalendar(another);
	}
	
	public void test2() {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 11, 25, 0, 0, 0);
		printCalendar(cal);
	}
	
	/**
	 * 날짜간 차이 구하기
	 * milisecond 단위로 변환해서 연산 후에, 다시 날짜 단위로 변환
	 */
	public void test3() {
		Calendar xmas = new GregorianCalendar(2020, 10, 24);
		Calendar now = new GregorianCalendar();
		
		//미래 - 과거
		long future = xmas.getTimeInMillis();
		long past = now.getTimeInMillis();
		double diff = (future - past) / 1000.0 / 60 / 60 / 24;
		System.out.println(diff);
		
		if(diff > 0) {
			System.out.println("d - " + ((int)diff + 1) + "일 남았습니다.");			
		}else if(diff > -1){
			System.out.println("d - day입니다.");
		}
	}
	/**
	 * 2020/12/25 00:00:00
	 */
	public void printCalendar(Calendar cal) {
		System.out.printf("%d/%02d/%02d %02d:%02d:%02d%n", 
						  cal.get(Calendar.YEAR),
						  cal.get(Calendar.MONTH) + 1,
						  cal.get(Calendar.DATE),
						  cal.get(Calendar.HOUR_OF_DAY),
						  cal.get(Calendar.MINUTE),
						  cal.get(Calendar.SECOND)						  
				);
	}
	
	/**
	 * Calendar
	 */
	public void test1() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = new GregorianCalendar();
		
		//unix초 : 1970/1/1 00:00:00.000 이후의 크기 반환
		//milisecond
		System.out.println(cal1);
		System.out.println(cal2);
		
		//년도
		System.out.println(cal1.get(Calendar.YEAR));
		//System.out.println(cal1.get(1));
	
		//월
		System.out.println(cal1.get(Calendar.MONTH)+1);
	
		//일
		System.out.println(cal1.get(Calendar.DATE));
		
		//요일(1:일요일....7:토요일)
		//화요일
		String[] weekDay = {"일요일", "월요일", "화요일", "수요일","목요일",
				"금요일","토요일"};
		
		int num = cal1.get(Calendar.DAY_OF_WEEK)-1;
		String today = weekDay[num];
		System.out.println(num);
		System.out.println("오늘은" + today);
		
		//시:분:초
		int hh = cal1.get(Calendar.HOUR_OF_DAY);
		int mm = cal1.get(Calendar.MINUTE);
		int ss = cal1.get(Calendar.SECOND);
		System.out.println(hh + ":" + mm + ":" + ss);
		// 패딩 문자 삽입
		System.out.printf("%02d:%02d:%02d%n", hh, mm, ss);
		System.out.println(get2digit(hh)+":"+get2digit(mm)
						+":"+get2digit(ss));
//		switch(cal1.get(Calendar.DAY_OF_WEEK)) {
//		case 1:
//			System.out.println("일요일");
//			break;
//		case 2:
//			System.out.println("월요일");
//			break;
//		case 3:
//			System.out.println("화요일");
//			break;
//		case 4:
//			System.out.println("수요일");
//			break;
//		case 5:
//			System.out.println("목요일");
//			break;
//		case 6:
//			System.out.println("금요일");
//			break;
//		}		
	}
	
	public String get2digit(int n) {
		return n < 10 ? "0" + n : "" + n;
	}
}
