package com.oop.book.controller;

import com.oop.book.model.Book;

public class TestBook {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("뇌를 자극하는 JAVA", 20000, 0.2, "김윤영");
		
		b1.bookInformation();
		b2.bookInformation();
		
		System.out.println();
		
		System.out.println("수정된 결과확인");
		b1.setTitle("자바의 정석");
		b1.setPrice(35000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("윤상섭");
		
		b1.bookInformation();
		
		System.out.println();
		
		System.out.println("<출력결과>");
		System.out.println("도서명 : " + b1.getTitle());
		System.out.println("할인된 가격 : " + (int)(b1.getPrice() - (b1.getPrice() * b1.getDiscountRate()))+"원");
		System.out.println("도서명 : " + b2.getTitle());
		System.out.println("할인된 가격 : " + (int)(b2.getPrice() - (b2.getPrice() * b2.getDiscountRate()))+"원");
	}
}
