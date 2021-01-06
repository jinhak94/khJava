package member.controller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;

public class MemberController {

	private MemberService memberService = new MemberService();
	
	public int insertMember(Member member) {
		return memberService.insertMember(member);
	}

	public Member selectOneMember(String memberId) {
		return memberService.selectOneMember(memberId);
	}

	public List<Member> selectAllMember() {
		return memberService.selectAllMember();
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

}
