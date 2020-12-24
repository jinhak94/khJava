package kh.java.char_.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 파일의 내용이 text, 문자 기반이면 문자 기반으로 처리하는게 유리하고
// (FileReader, FileWriter
// 보통은 이진 파일로 되어 있으므로
// InputStream, OutputStream..

public class FileRWTest {
	public static void main(String[] args) {
		FileRWTest f = new FileRWTest();
		f.test1();
	}
	
	
	public void test1() {
		//파일객체 : 실제 파일을 가리키고 있는 자바 객체
		File f = new File("file/myfile.txt");
		File copy = new File("file/realNewCopy.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(f));			
			bw = new BufferedWriter(new FileWriter(copy));
			//기본 스트림만 사용한 경우
//			int data = 0;
//			while((data = br.read())!=-1) {
//				System.out.print((char)data);
//			}
			
			String line = "";
			StringBuilder sb = new StringBuilder();
			// readLine()은 line 단위의 입력을 받는다.
			// int일 때는 -1이 아닐 때까지, String은 null이 아닐 때까지
			// 문자 기반으로 읽어와도 정수 기반으로 처리함
			while((line = br.readLine())!=null) {
				System.out.println("> " + line);
			// 파일의 내용을 읽어와서 StringBuilder를 통해 자바 객체로 만들 수 있다.
			// StringBuilder의 경우는, 개행을 빼고 받아오므로,
			// \n을 넣어서 입력하면 제대로 된 값이 나오는 것을 확인할 수 있다.
				sb.append(line + "\n");
				
				//복붙
//				bw.write(line);
//				bw.write("\n");
			}
			sb.append("추가적으로 작업한 내용\n");
			System.out.println(sb);
			//스트링 빌더가 아닌 String 타입으로 전달해야 해서
			//toString() 메소드를 호출하였음.
			bw.write(sb.toString());
		// 멀티catch절. Runtime 혹은 IO Exception 처리 가능
		// 단 상속 관계가 있을 때에는 사용할 수 없다.
		}catch(RuntimeException|IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();				
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
