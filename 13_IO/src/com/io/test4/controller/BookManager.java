package com.io.test4.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.io.test4.model.vo.Book;

public class BookManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Scanner sc = new Scanner(System.in);
	
	public BookManager() {
		
	}
	
	public void fileSave() {
		Book[] book = new Book[] {
				new Book("일인칭 단수","무라카미 하루키",13000, new GregorianCalendar(2020,11,26),0.06), 
				new Book("여덟 단어", "박웅현", 13500, new GregorianCalendar(2013,05,20),0.1),
				new Book("나미야 잡화점의 기적","히가시노 게이고",13200, new GregorianCalendar(2012,12,19),0.1),
				new Book("참을 수 없는 존재의 가벼움","밀란 쿤데라", 13500, new GregorianCalendar(2018,06,20),0.1),
				new Book("정혜영의 식탁", "정혜영", 24100, new GregorianCalendar(2019,10,25),0.05)
		};
		try(ObjectOutputStream oos = new 
				ObjectOutputStream(new FileOutputStream("books.dat"));){
			oos.writeObject(book);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		Book[] book = new Book[10];
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("books.dat"));) {
			book = (Book[])ois.readObject();
			for(int i = 0; i < book.length; i++) {
				System.out.println(book[i]);
			}
		}catch(EOFException | ClassNotFoundException e) {
			System.out.println("books.dat 읽기 완료!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
