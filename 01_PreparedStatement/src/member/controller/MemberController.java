package member.controller;

import java.util.List;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberController {
	
	private MemberDAO memberDAO = new MemberDAO();

	public int insertMember(Member member) {
		return memberDAO.insertMember(member);
	}

	public List<Member> selectAll(){
		return memberDAO.selectAll();
	}

	public Member selectOne(String id) {
		return memberDAO.selectOne(id);
	}

	public List<Member> selectName(String name) {
		return memberDAO.selectName(name);
	}

	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		if(memberDAO.selectOne(id)!=null)
			return true;
		else 
			return false;
	}

	public int updateMember(Member member) {
		return memberDAO.updateMember(member);
	}

	public boolean deleteMember(String id) {
		return memberDAO.deleteMember(id);
	}
}
