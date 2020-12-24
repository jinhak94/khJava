package com.thread.alphabet;

public class UpperPlphabetThread extends Thread{
	@Override
	public void run() {
		for(int i = 'A'; i<='Z'; i++) {
			System.out.print((char)i);
			if(i!='Z')
				System.out.print(", ");
		}
	}
}
