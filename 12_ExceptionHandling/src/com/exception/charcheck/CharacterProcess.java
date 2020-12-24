package com.exception.charcheck;

public class CharacterProcess {
	public CharacterProcess() {
		
	}
	public int countAlpha(String s) throws CharCheckException{
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ')
				throw new CharCheckException();
		}
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(arr[i]>='a'&&arr[i]<='z' || arr[i]>='A'&&arr[i]<='Z') {
				count++;
			}
		}
		return count;
	}
}
