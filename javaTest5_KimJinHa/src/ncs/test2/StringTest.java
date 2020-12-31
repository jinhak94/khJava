package ncs.test2;

public class StringTest {
	public static void main(String[] args) {
		String str = "A, b, c, D, a, B, C, d, f, F";

		
		String[] st = str.split(", ")/* str에서 `, `으로 데이터를 분리한다. */;
		char[] data = new char[st.length];

		int i = 0;
		for(String s:st) {
			data[i] = (s.toCharArray())[0];
			i++;
		}
		i = 0;
		//char[]에서 대문자만 골라서 출력한다. continue문 사용할 것
		while(i < data.length) {//while loop문 사용한다.
			if(!((data[i] >= 'A') && (data[i] <= 'Z'))) {
				i++;
				continue;
			}
			System.out.printf("data[%d] : %c\n",i,data[i]);
			i++;
		}
	}
}
