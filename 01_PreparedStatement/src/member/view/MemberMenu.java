package member.view;

import java.util.List;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

//메뉴에서 DAO에 직접 접근하는 일은 없어야 한다.
public class MemberMenu {

	/**
	 * 2. 회원아이디 조회 : 사용자로부터 아이디를 입력받고 일치하는 회원 1명 조회
	 * 3. 회원이름 검색 : 사용자로부터 이름을 입력받고, 일부라도 일치하는 회원 n명 조회
	 * 5. 회원정보 수정 : 변경할 정보(아이디를 제외한 정보)를 입력 받고 db에 반영(아이디, 등록일은 변경 불가)
	 * 6. 회원탈퇴 : 사용자로부터 아이디를 입력받고 일치하는 회원 1명 삭제
	 */
	
	private Scanner sc = new Scanner(System.in);
	private MemberController controller = new MemberController();
	
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
	
		//1. 4. 0번 함
		//2번, 3번, 5번, 6번 하기
		
		while(true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			Member member = null;
			int result = 0;
			List<Member> list = null;
			String id = null;
			String name = null;
			boolean isDelete = false;
			
			switch(choice) {
			case 1: 
				//1. controller 요청
				list = controller.selectAll();
				//2.
				displayMemberList(list);
				
				break;
			case 2: 
				System.out.print("검색할 id를 입력하세요 : ");
				id = sc.next();
				//1. controller 요청
				member = controller.selectOne(id);
				displayMember(member);			
				break;
			case 3: 
				System.out.print("검색하실 이름을 입력하세요 : ");
				name = sc.next();
				list = controller.selectName(name);
				displayMemberList(list);
				break;
			case 4: 
				//1. 사용자 입력값 -> member 객체 생성
				member = inputMember();
				if(member == null)
					break;
				//2. Controller에 insert 요청
				result = controller.insertMember(member);
				displayMsg(result == 1 ? "회원 가입 성공!" : "회원 가입 실패");
//				System.out.println(result);
				break;
			case 5: 
				//1. 사용자 입력값 -> member 객체 생성
				//2. Controller에 update 요청
				member = updateMember();
				if(member == null)
					break;
				result = controller.updateMember(member);
				displayMsg(result == 1 ? "회원 정보 수정 성공!" : "회원 정보 수정 실패");
				
				break;
				
			
			
			case 6: 
				System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
				id = sc.next();

				if(!deleteMember(id))
					break;
				
				isDelete = controller.deleteMember(id);
				if(isDelete) {
					System.out.println("성공적으로 탈퇴되었습니다.");
				}else {
					System.out.println("탈퇴에 실패하였습니다.");
				}
				break;
			case 0: 
				System.out.println("정말로 끝내시겠습니까?(y/n)");
				if(sc.next().charAt(0)=='y')
					return;
				break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private boolean deleteMember(String id) {

		if(!checkId(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
			return false;
		}

		return true;
	}

	private boolean checkId(String id) {
		return controller.checkId(id);
	}
	
	private Member updateMember() {
		System.out.print("변경할 멤버의 id를 입력해주세요 : ");
		String id = sc.next();
		
		if(!checkId(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
			return null;
		}
		
		System.out.println("새로운 회원정보를 입력하세요.");
		System.out.println("---------------------------------------------------");
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
		
		return new Member(id, password, memberName, gender, age, email, phone, address, hobby, null);
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

	/**
	 * 회원가입 메소드
	 * 사용자 입력처리
	 */

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
	
	private void displayMemberList(List<Member> list) {
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
	
	
	/**
	 * DML 처리 후에 사용자에게 피드백을 주는 메소드
	 */
	private void displayMsg(String msg) {
		System.out.println(msg);
	}
}
