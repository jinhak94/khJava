package com.api.token;

import java.util.StringTokenizer;

public class TokenTest {
		public static void main(String[] args) {
			String str = "J a v a P r o g r a m";
			StringTokenizer st = new StringTokenizer(str, " ");
			int idx = 0;
			
			System.out.println("토큰 처리 전 : " + str);
			System.out.println("전 글자 갯수 : " + str.length());			
			System.out.println("토큰 처리 후 글자 갯수 : " + st.countTokens());

			char[] arr = new char[str.length()];
			while(st.hasMoreTokens()) {
				arr[idx] = st.nextToken().charAt(0);
				idx++;
			}
			
			for(int i = 0; i < idx; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			System.out.println(String.valueOf(arr).toUpperCase());
			
		}
}
