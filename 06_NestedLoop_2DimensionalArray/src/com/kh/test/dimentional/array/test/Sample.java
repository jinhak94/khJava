package com.kh.test.dimentional.array.test;

public class Sample {
	public static void main(String[] args) {
		Sample s = new Sample();
		s.exercise1();
	}
	
	public void exercise1() {
		int[][] arr = new int[3][4];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length-1; j++) {
				arr[i][j] = (int)(Math.random()*100+1);
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length-1; j++) {
				arr[i][arr[0].length-1] += arr[i][j];
			}
		}

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
