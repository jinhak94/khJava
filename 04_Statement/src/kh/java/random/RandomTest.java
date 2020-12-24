package kh.java.random;

import java.util.Random;
import java.util.Scanner;

/**
 * 난수 생성
 * 	- 1. Math.random()
 * 	- 2. java.util.Random 클래스의 메소드
 *
 */

public class RandomTest {
	public static void main(String[] args) {
		RandomTest r = new RandomTest();
		//r.test1();
		//r.test2();
		r.test3();
	}

	/**
	 * 동전 앞뒤 맞추기 게임
	 */
	public void test3() {
		//1. 사용자 입력값
		Scanner sc = new Scanner(System.in);
		System.out.print("동전 앞뒤 입력(1.앞  2. 뒤) : ");
		int userInput = sc.nextInt();
		
		//2. 동전(난수) 던지기
		int coin = (int)(Math.random()*2+1);
//		Random rnd = new Random();
//		int coin = rnd.nextInt(2) + 1;
		
		//3. 값비교
		System.out.println("----------------------------");
		System.out.println("결과 : " + (coin == 1 ? "앞" : "뒤"));
		System.out.println(userInput == coin ? "맞췄습니다." : "틀렸습니다.");
		
	}
	
	public void test2() {
		// 0.0(inclusive)과 1.0(exclusive) 사이의 난수 발생
		
		double rndNum = Math.random();
		System.out.println(rndNum);
		
		// 1 ~ 10 사이의 난수
		rndNum = Math.random() * 10 + 1;	// 1.0 이상 11.0 미만
		int result = (int)rndNum;
		System.out.println(result);
	}
	
	/**
	 * Random
	 * 	- 경우의 수
	 * 	- 시작값(최소값)
	 */
	
	public void test1() {
		Random random = new Random();
		// 정수 난수 가져오기
		int rndNum = random.nextInt(10);	// 0 ~ 9까지 10개의 수 중에 랜덤 출력
		rndNum = random.nextInt(10) + 1;	// 1 ~ 10까지 10개의 수 중에 랜덤 출력
		
		// 1 ~ 100 사이 난수 출력
		rndNum = random.nextInt(100) + 1;
		// 50 ~ 100 사이 난수 출력
		rndNum = random.nextInt(51) + 50;
		System.out.println(rndNum);
		
		//가위0바위1보2
		int rsp = random.nextInt(3);
		System.out.println(rsp);
		String rspStr = rsp == 0?"가위" : (rsp==1 ? "바위" : "보");
		System.out.println(rspStr);
		
		//타입별 난수 지원
		System.out.println(random.nextBoolean());
		System.out.println(random.nextDouble()); // 0.0 이상 1.0 미만의 난수 반환
	}
}
