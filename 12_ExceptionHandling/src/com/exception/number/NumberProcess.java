package com.exception.number;

public class NumberProcess {
	public NumberProcess() {
		
	}
	public boolean checkDouble(int a, int b) throws NumberRangeException{
		if(!((a>=1 && a<=100)&&(b>=1 && b<=100))) {
			throw new NumberRangeException();
		}
		if(a%b==0) {
			return true;
		}else {
			return false;
		}
	}
}
