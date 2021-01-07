package member.controller;

import java.util.List;

import member.model.exception.MemberException;
import member.model.service.MemberService;
import member.model.vo.Member;
import member.view.MemberMenu;

public class MemberController {

	private MemberService memberService = new MemberService();
	
	public int insertMember(Member member) {
		int result = 0;
		try {
			result = memberService.insertMember(member);
		} catch (MemberException e) {
			//e.printStackTrace();
			new MemberMenu().displayError(e.getMessage(), e.getCause());
		}
		return result;
	}

	public Member selectOneMember(String memberId) {
		return memberService.selectOneMember(memberId);
	}

	public List<Member> selectAllMember() {
		List<Member> list = null;
		try {
			list = memberService.selectAllMember();
		} catch (MemberException e) {
			//사용자에게 오류 사실을 feedback 해주는 것.
			new MemberMenu().displayError(e.getMessage(), e.getCause());
		}
		return list;
	}

	public List<Member> selectMemberByName(String name) {
		return memberService.selectMemberByName(name);
	}

	public int deleteMember(String memberId) {
		return memberService.deleteMember(memberId);
	}

	public int updateMemberByPassword(String memberId, String memberPassword) {
		return memberService.updateMemberByPassword(memberId, memberPassword);
	}

	public int updateMemberByEmail(String memberId, String memberEmail) {
		return memberService.updateMemberByEmail(memberId,memberEmail);
	}

	public int updateMemberByPhone(String memberId, String memberPhone) {
		return memberService.updateMemberByPhone(memberId, memberPhone);
	}

	public int updateMemberByAddress(String memberId, String memberAddress) {
		return memberService.updateMemberByAddress(memberId, memberAddress);
	}

	public List<Member> selectDeleteMember() {
		List<Member> list = null;
		try {
			list = memberService.selectDeleteMember();
		} catch (MemberException e) {
			new MemberMenu().displayError(e.getMessage(), e.getCause());
		}
		return list;
	}

}
