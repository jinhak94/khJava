package com.thread.alphabet;

public class AlphabetTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new UpperPlphabetThread());
		Thread t2 = new Thread(new LowerAlphabetThread());
		t1.start();
		t2.start();
	}
}
