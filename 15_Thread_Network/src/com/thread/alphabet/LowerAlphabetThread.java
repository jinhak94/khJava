package com.thread.alphabet;

public class LowerAlphabetThread extends Thread{
	@Override
	public void run() {
		for(int i = 'a'; i<='z'; i++) {
			System.out.print((char)i);
			if(i!='z')
				System.out.print(", ");
		}
	}
}
