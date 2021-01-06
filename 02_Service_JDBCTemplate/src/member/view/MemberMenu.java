package member.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	
	public void mainMenu() {
		String menu = "-------- 회원 관리 프로그램 --------\n"
				 + "1. 회원 전체 조회\n"
				 + "2. 회원 아이디 조회\n"
				 + "3. 회원 이름 검색\n"
				 + "4. 회원 가입\n"
				 + "5. 회원 정보 수정\n"
				 + "6. 회원 탈퇴\n"
				 + "0. 프로그램 끝내기\n"
				 + "---------------------------------\n"
				 + "선택 : ";
		
		String subMenu = "======================= 회원 정보 변경 메뉴 =======================\n"
						+ "1. 암호 변경\n"
						+ "2. 이메일 변경\n"
						+ "3. 전화번호 변경\n"
						+ "4. 주소 변경\n"
						+ "9. 메인메뉴 돌아가기\n"
						+ "=============================================================\n"
						+ "선택 : ";
		
		while(true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			int result = 0; // DML 처리
			Member member = null;
			List<Member> list = new ArrayList<Member>();
			int subChoice;
			String id = null;
			
		
			switch(choice) {
			case 1: 
				
				//회원 전체 조회
				list = memberController.selectAllMember();
				displayMember(list);
				break;
				
			case 2: 
				
				//회원 아이디 조회
				//1. 사용자입력값(memberId) - 컨트롤러 조회 요청
				//2. member객체 혹은 null 화면 출력
				member = memberController.selectOneMember(inputMemberId());
				displayMember(member);
				break;
				
			case 3: 
				
				//회원 이름 검색
				list = memberController.selectMemberByName(inputMemberName());
				displayMember(list);
				break;
			case 4:
				
				//1. 사용자 입력값 회원객체
				//2. 컨트롤러에 insertMember 요청
				//3. 사용자피드백
				result = memberController.insertMember(inputMember());
				displayMsg(result>0 ? "회원가입 성공!" : "회원가입 실패!");
				break;
				
			case 5: 
				
				/**
				 * ****** 회원 정보 변경 메뉴******
					1. 암호변경
					2. 이메일변경
					3. 전화번호변경
					4. 주소 변경
					9. 메인메뉴 돌아가기
					요구사항
					* 메인메뉴에서 회원정보변경 메뉴 선택시, 수정할 회원아이디를 입력받고, 해당 회원정보(회원아이디조회)를 우선 보여준 후 서브메뉴출력
					* 회원정보 수정은 선택된 필드를 각각 처리할 것.
					* 회원정보변경 수정완료 시 수정된 회원정보를 출력후, 서브메뉴를 다시 출력.
					* 수정할 회원아이디를 조회해서 해당하는 회원이 없다면, 메인메뉴를 다시 출력할 것.
				 */
				
				//수정할 아이디 입력받음
				id = updateMemberId();
				
				//해당 회원정보를 먼저 보여줌
				member = memberController.selectOneMember(id);
				if(member == null) {
					System.out.println("회원 정보가 존재하지 않습니다.");
					break;
				}else {
					displayMember(member);
				}
				//서브메뉴 출력
				
				Outer:
				while(true) {
					System.out.print(subMenu);
					subChoice = sc.nextInt();

					//회원정보 수정
					switch(subChoice) {
					case 1:
						//1. 암호 변경
						result = memberController.updateMemberByPassword(id, updateMemberPassword());
						if(result > 0) {
							updateSuccess(id);
						}else {
							updateFailed();
						}
						break;
					case 2:
						//2. 이메일 변경
						result = memberController.updateMemberByEmail(id, updateMemberEmail());
						if(result > 0) {
							updateSuccess(id);
						}else {
							updateFailed();
						}
						break;
					case 3:
						//3. 전화번호 변경
						result = memberController.updateMemberByPhone(id, updateMemberPhone());
						if(result > 0) {
							updateSuccess(id);
						}else {
							updateFailed();
						}
						break;
						
					case 4:
						//4. 주소 변경
						result = memberController.updateMemberByAddress(id, updateMemberAddress());
						if(result > 0) {
							updateSuccess(id);
						}else {
							updateFailed();
						}
						break;
						
					case 9:
						//5. 메인메뉴 돌아가기
						System.out.print("메인 메뉴로 돌아가시겠습니까?(y/n) :");
						if(sc.next().charAt(0) == 'y')
						break Outer;
						else
							break;
					
					default : System.out.println("잘못 입력하셨습니다.");
						break;
					}
				}
				break;
				
			case 6: 
				
				//회원 탈퇴
				result = memberController.deleteMember(inputMemberId());
				displayMsg(result>0 ? "회원탈퇴 성공!" : "회원탈퇴 실패!");
				break;
				
			case 0:
				System.out.print("정말 끝내시겠습니까?(y/n) :");
				if(sc.next().charAt(0) == 'y')
					return;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private void updateSuccess(String id) {
		System.out.println("회원 정보가 변경되었습니다.");
		Member member = memberController.selectOneMember(id);
		displayMember(member);		
	}

	private void updateFailed() {
		System.out.println("회원 정보 변경에 실패하였습니다.");
	}
	
	private void displayMember(List<Member> list) {
		System.out.println("=======================================");
		//조회된 회원정보가 있을 때
		if(list != null && !list.isEmpty()) {
			System.out.println("memberId\tMemberName\tGender\tAge\tEmail\tPhone\tAddress\tHobby\tEnrollDate");
			System.out.println("--------------------------------------------------------------------------------");
			for(Member member : list)
				System.out.println(member);
		
		}
		//조회된 회원정보가 없을 때
		else {
			System.out.println("조회된 회원이 없습니다.");
		}
		System.out.println("=======================================");
	}

	private void displayMember(Member member) {
		System.out.println("=======================================");
		//조회된 회원정보가 있을 때
		if(member != null) {
			System.out.println("memberId\tMemberName\tGender\tAge\tEmail\tPhone\tAddress\tHobby\tEnrollDate");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(member);
		}
		//조회된 회원정보가 없을 때
		else {
			System.out.println("조회된 회원이 없습니다.");
		}
		System.out.println("=======================================");
	}
	
	private String updateMemberPassword() {
		System.out.print("수정할 비밀번호 입력 : ");
		return sc.next();
	}
	
	private String updateMemberEmail() {
		System.out.print("수정할 이메일 입력 : ");
		return sc.next();
	}
	
	private String updateMemberPhone() {
		System.out.print("수정할 전화번호 입력 : ");
		return sc.next();
	}
	
	private String updateMemberAddress() {
		sc.nextLine(); //개행 날리기용
		System.out.print("수정할 주소 입력 : ");
		return sc.nextLine();
	}
	
	private String inputMemberName() {
		System.out.print("조회할 이름 입력 : ");
		return sc.next();
	}
	
	private String updateMemberId() {
		System.out.print("수정할 아이디 입력 : ");
		return sc.next();
	}
	
	private String inputMemberId() {
		System.out.print("조회할 아이디 입력 : ");
		return sc.next();
	}

	private Member inputMember() {
		System.out.println("새로운 회원정보를 입력하세요.");
		System.out.println("---------------------------------------------------");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별(M/F) : ");
		String gender = sc.next().toUpperCase();
		System.out.print("이메일  : ");
		String email = sc.next();
		System.out.print("전화번호(-빼고 입력) : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		sc.nextLine(); // 개행문자 날리기용
		System.out.print("취미(,으로 나열) : ");
		String hobby = sc.nextLine();
		
		return new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, null);
	}
	
	/**
	 * DML 처리 후에 사용자에게 피드백을 주는 메소드
	 */
	private void displayMsg(String msg) {
		System.out.println(msg);
	}
}
