package com.io.test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.fileSave();
		t1.fileRead();
	}
	
	public void fileRead() {
		BufferedReader br = null;
		String fileName;
		FileReader fr = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("파일명을 입력하세요! : ");
			fileName = br.readLine();
			int data = 0;
			fr = new FileReader(fileName);
			while((data = fr.read())!=-1) {
				sb.append((char)data);
			}
			
			System.out.println(sb.toString());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileSave() {
		BufferedReader br = null;
		String fileName;
		FileWriter fw = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("파일명을 입력하세요! : ");
			fileName = br.readLine();
			fw = new FileWriter(fileName);
			String input;
			
			while(true) {
				System.out.print("파일에 저장할 내용을 입력하시오. : ");
				input = br.readLine();
				if(input.equals("exit")) {
					System.out.println("파일에 성공적으로 저장되었습니다.");
					break;
				}
				fw.write(input + "\n");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
