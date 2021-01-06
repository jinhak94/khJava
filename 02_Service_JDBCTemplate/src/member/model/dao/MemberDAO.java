package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

/**
 * 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
 * 4. 쿼리전송(실행) - 결과값
 * 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
 * 5. 자원반납(PreparedStatement, ResultSet)
*/	

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
		 // 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
		 try{
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1,  member.getMemberId());
			 pstmt.setString(2,  member.getPassword());
			 pstmt.setString(3,  member.getMemberName());
			 pstmt.setString(4,  member.getGender());
			 pstmt.setInt(5,  member.getAge());
			 pstmt.setString(6,  member.getEmail());
			 pstmt.setString(7,  member.getPhone());
			 pstmt.setString(8,  member.getAddress());
			 pstmt.setString(9,  member.getHobby());
			 
			 // 4. 쿼리전송(실행) - 결과값
			 result = pstmt.executeUpdate(); //DML인 경우 executeUpdate

		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 // 5. 자원반납(PreparedStatement, ResultSet)
		     close(pstmt);
		 }
		
		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id = ?";
		Member member = null;
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			//2. 실행 및 ResultSet값 -> member객체
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(memberId);
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		System.out.println("member@dao = " + member);
		return member;
	}

	public List<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member";
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			
			//2. 실행 및 ResultSet값 -> member객체
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getNString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<Member> selectMemberByName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_name = ?";
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			//2. 실행 및 ResultSet값 -> member객체
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setPassword(rset.getString("password"));
				member.setMemberName(name);
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		String sql = "delete from member where member_id = ?";
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberByPassword(Connection conn, String memberId, String memberPassword) {
		PreparedStatement pstmt = null;
		String sql = "update member set password = ? where member_id = ?";
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPassword);
			pstmt.setString(2, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberByEmail(Connection conn, String memberId, String memberEmail) {
		PreparedStatement pstmt = null;
		String sql = "update member set email = ? where member_id = ?";
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			pstmt.setString(2, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberByPhone(Connection conn, String memberId, String memberPhone) {
		PreparedStatement pstmt = null;
		String sql = "update member set phone = ? where member_id = ?";
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPhone);
			pstmt.setString(2, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberByAddress(Connection conn, String memberId, String memberAddress) {
		PreparedStatement pstmt = null;
		String sql = "update member set address = ? where member_id = ?";
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberAddress);
			pstmt.setString(2, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}
}
