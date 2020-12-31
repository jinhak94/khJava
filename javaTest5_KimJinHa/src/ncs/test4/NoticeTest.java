package ncs.test4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;


public class NoticeTest {
	
	public static void main(String[] args) {
		NoticeTest t = new NoticeTest();
		Object[] obArray = new Object[3];
		Scanner sc = new Scanner(System.in);
		ArrayList<Notice> list;
		
		int no;
		String title;
		Date date;
		String writer;
		String content;
		Calendar cal;
		int year = 2016;
		int month[] = {03, 04, 05};
		int day[] = {15, 23, 12};
		
		for(int i = 0; i < obArray.length; i++) {
			System.out.println("등록할 공지사항을 입력하시오.");
			System.out.print("제목 : ");
			title = sc.nextLine();
			System.out.print("작성자 : ");
			writer = sc.nextLine();
			System.out.print("내용 : ");
			content = sc.nextLine();
			cal = new GregorianCalendar(year, month[i]-1, day[i]);
			no = i + 1;
			date = new Date(cal.getTimeInMillis());
			
			obArray[i] = new Notice(no, title, date, writer, content);
		}

		t.fileSave(obArray);
		
		list = t.fileRead();
	}
	
	public void fileSave(Object[] array) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream("notice.dat"));
			oos.writeObject(array[0]);
			oos.writeObject(array[1]);
			oos.writeObject(array[2]);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Notice> fileRead(){
		ArrayList<Notice> list = new ArrayList<Notice>();
		File f = new File("notice.dat");
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(f));){
			list.add((Notice)ois.readObject());
			list.add((Notice)ois.readObject());
			list.add((Notice)ois.readObject());
			
			Iterator<Notice> iter = list.iterator();
			while(iter.hasNext()) {
				Notice notice = iter.next();
				System.out.println(notice);
			}
		}catch(EOFException e) {
			System.out.println("모든 정보를 읽었습니다.");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
