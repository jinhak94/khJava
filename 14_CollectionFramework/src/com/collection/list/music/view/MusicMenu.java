package com.collection.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.collection.list.music.controller.MusicManager;
import com.collection.list.music.model.vo.Music;

public class MusicMenu {
	private Scanner sc = new Scanner(System.in);
	private MusicManager manager = new MusicManager();

	public void mainMenu() {
		int choice;
		List<Music> list = null;
		while(true) {
			System.out.println("========== Music Playlist Menu ==========");
			System.out.println("1. 목록보기");
			System.out.println("2. 마지막에 음악 추가");
			System.out.println("3. 맨처음에 음악 추가");
			System.out.println("4. 곡 삭제");
			System.out.println("5. 곡 변경");
			System.out.println("6. 곡명 검색");
			System.out.println("7. 가수 검색");
			System.out.println("8. 목록정렬(곡명오름차순)");
			System.out.println("0. 종료");
			System.out.println("=========================================");
			System.out.print(">> 메뉴 선택 : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 0:
				//종료
				System.out.println("프로그램이 종료되었습니다.");
				return;
			case 1:
				//목록보기
				printList(manager.selectList());
				break;
			case 2:
				//마지막에 음악 추가
				manager.addList(inputMusic());
				break;
			case 3:
				//맨처음에 음악 추가
				manager.addAtZero(inputMusic());
				break;
			case 4:
				//곡 삭제
				String title = inputTitle();
				boolean yn = manager.removeMusic(title);
				//boolean yn = manager.removeMusic(inputTitle());
				if(yn) {
					System.out.println(title + "이 삭제되었습니다.");
				}else {
					System.out.println(title + "을 삭제하지 못했습니다.");
				}
				break;
			case 5:
				//곡 변경
				System.out.println("바뀔 음악을 입력하세요!");
				Music oldMusic = inputMusic();
				System.out.println("바꿀 음악을 입력하세요!");
				System.out.print("곡명을 입력하세요 : ");
				String tt = sc.nextLine();
				System.out.print("가수를 입력하세요 : ");
				String sg = sc.nextLine();
				Music newMusic = new Music(tt, sg);
				if(manager.replaceMusic(oldMusic, newMusic)) {
					System.out.println(oldMusic.getTitle()+"을"+ 
							newMusic.getTitle()+"로 성공적으로 바꿨습니다.");
				}else {
					System.out.println(oldMusic.getTitle()+"을"+ 
							newMusic.getTitle()+"로 바꾸지 못했습니다.");
				}
				break;
			case 6:
				//곡명 검색
				list = 				
				manager.searchMusicByTitle(inputTitle());
				if(list == null) {
					System.out.println("검색결과가 없습니다.");
				}else {
					System.out.println(list);
				}
				break;
			case 7:
				//가수 검색
				list = 				
				manager.searchMusicBySinger(inputSinger());
				if(list == null) {
					System.out.println("검색결과가 없습니다.");
				}else {
					System.out.println(list);
				}
				break;
			case 8:
				//목록정렬(곡명 오름차순)
				OUTER:
				while(true) {
					System.out.println("=================== 정렬 메뉴 ===================");
					System.out.println("1. 가수명 오름차순");
					System.out.println("2. 가수명 내림차순");
					System.out.println("3. 곡명 오름차순");
					System.out.println("4. 곡명 내림차순");
					System.out.println("5. 메인메뉴 돌아가기");
					int input2;
					System.out.print(">>메뉴 선택 : ");
					input2 = sc.nextInt();
					switch(input2) {
					// 메인메뉴 돌아가기
					case 5:
						break OUTER;
					// 가수명 오름차순
					case 1:
						list = manager.orderBy(new MusicSingerAscending());
						System.out.println(list);
						break;
					// 가수명 내림차순
					case 2:
						list = manager.orderBy(new MusicSingerDescending());
						System.out.println(list);
						break;
					// 곡명 오름차순
					case 3:
						list = manager.orderBy(new MusicTitleAscending());
						System.out.println(list);
						break;
					// 곡명 내림차순
					case 4:
						list = manager.orderBy(new MusicTitleDescending());
						System.out.println(list);
						break;
					}
				}
				break;
			}
		}
	}
	// 리스트 출력 메소드
	public void printList(List<Music> l) {
		System.out.println(l);
	}
	// 곡명 입력 메소드
	public String inputTitle() {
		String title;
		sc.nextLine();
		System.out.print("곡명을 입력하세요 : ");
		title = sc.nextLine();
		return title;
	}
	// 가수 입력 메소드
	public String inputSinger() {
		String singer;
		sc.nextLine();
		System.out.print("가수를 입력하세요 : ");
		singer = sc.nextLine();
		return singer;
	}
	// 음악 입력 메소드(곡명, 가수 모두 입력)
	public Music inputMusic() {
		String title;
		String singer;
		sc.nextLine();
		System.out.print("곡명을 입력하세요 : ");
		title = sc.nextLine();
		System.out.print("가수를 입력하세요 : ");
		singer = sc.nextLine();
		return new Music(title, singer);
	}
}
