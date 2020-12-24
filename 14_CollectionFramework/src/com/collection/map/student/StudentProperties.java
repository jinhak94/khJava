package com.collection.map.student;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class StudentProperties {
	public static void main(String[] args) {
		StudentProperties sp = new StudentProperties();
		List<Student> list = sp.readFile();
		sp.printConsole(list);
		sp.saveXMLFile(list);
	}
	
	public List<Student> readFile(){
		Properties pr = new Properties();
		List<Student> list = new ArrayList<>();
		StringTokenizer token = null;
		int sno;
		String sname;
		int kor, eng, math;
		try{
			pr.load(new FileReader("score.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Enumeration<?> names = pr.propertyNames();
		while(names.hasMoreElements()) {
			String no = (String)names.nextElement();
			String value = pr.getProperty(no);
			token = new StringTokenizer(value, ",");
			while(token.hasMoreTokens()) {
				sno = Integer.parseInt(token.nextToken());
				sname = token.nextToken();
				kor = Integer.parseInt(token.nextToken());
				eng = Integer.parseInt(token.nextToken());
				math = Integer.parseInt(token.nextToken());
				list.add(new Student(sno,sname,kor,eng,math));
			}
		}
		return list;
	}
	
	public void printConsole(List <Student> stdtList) {
		Iterator<Student> iter = stdtList.iterator();
		int ksum = 0, esum = 0, msum = 0;
		while(iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s);
			ksum += s.getKor();
			esum += s.getEng();
			msum += s.getMath();
		}
		System.out.printf("국어의 평균 점수는 %.2f, 수학의 평균 점수는 %.2f, 영어의 평균 점수는 %.2f입니다.",
				(double)ksum/stdtList.size(), (double)msum/stdtList.size(), (double)esum/stdtList.size());
	}
	
	public void saveXMLFile(List<Student> stdtList) {
		Properties pr = new Properties();
		Iterator<Student> iter = stdtList.iterator();
		while(iter.hasNext()) {
			Student s = iter.next();
			String str = "sno = " + s.getSno() + ", sname = " + s.getSname() + ", kor = " + s.getKor() +
					", eng = " + s.getEng() + ", math = " + s.getMath() + ", sum = " + s.getSum()
					+ ", avg = " + s.getAvg();
			pr.setProperty(String.valueOf(s.getSno()), str);
		}
		try{
			pr.storeToXML(new FileOutputStream("student.xml"), "user.xml");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
