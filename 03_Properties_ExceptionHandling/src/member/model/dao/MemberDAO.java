package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.exception.DuplicateMemberIdException;
import member.model.exception.MemberException;
import member.model.vo.Member;

/**
 * 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
 * 4. 쿼리전송(실행) - 결과값
 * 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
 * 5. 자원반납(PreparedStatement, ResultSet)
*/	

public class MemberDAO {

	private Properties prop = new Properties();
	
	public MemberDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection conn, Member member) throws MemberException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertMember");
		 // 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
		 try{
			//Member(memberId, password, memberName, gender, age, email, phone, address, hobby, null, null, delFlag);
			 //insertMember = insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, default, null, default);
			 pstmt = conn.prepareStatement(query);
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

		 }catch(SQLIntegrityConstraintViolationException e) {
			 if(e.getMessage().contains("unique constraint")) {
				 throw new DuplicateMemberIdException("중복된 아이디 : " + member.getMemberId());
			 }
		 }catch(Exception e) {
			 //e.printStackTrace();
			 throw new MemberException("회원가입 오류! 관리자에게 문의하세요.", e);
		 }finally {
			 // 5. 자원반납(PreparedStatement, ResultSet)
		     close(pstmt);
		 }
		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneMember");
		Member member = null;
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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
				member.setDelDate(rset.getString("del_date"));
				member.setDelFlag(rset.getString("del_flag"));
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

	public List<Member> selectAllMember(Connection conn) throws MemberException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAllMember");
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		//System.out.println("query@dao = " + query);
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
			
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
				member.setDelDate(rset.getString("del_date"));
				member.setDelFlag(rset.getString("del_flag"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
			//throw e; //1번 방법. 해당 예외를 다시 던지기
			//2번 방법. 구체적인 커스텀예외 클래스를 생성해서 던지기
			throw new MemberException("회원 조회 오류! 관리자에게 문의하세요.", e); 
			// 여기서 e는 cause에 해당
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
		String query = prop.getProperty("selectMemberByName");
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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
				member.setDelDate(rset.getString("del_date"));
				member.setDelFlag(rset.getString("del_flag"));
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
		String query = prop.getProperty("deleteMember");
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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
		String query = prop.getProperty("updateMemberByPassword");
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberPassword);
			pstmt.setString(2, memberId);
			
			//2. 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}finally {
			//3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int updateMemberByEmail(Connection conn, String memberId, String memberEmail) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateMemberByEmail");;
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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
		String query = prop.getProperty("updateMemberByPhone");;
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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
		String query = prop.getProperty("updateMemberByAddress");;
		int result = 0;
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
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

	public List<Member> selectDeleteMember(Connection conn) throws MemberException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectDeleteMember");
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		System.out.println("query@dao = " + query);
		
		try {
			//1. PrepareStatement 생성, 미완성 쿼리 값 대입
			pstmt = conn.prepareStatement(query);
			
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
				member.setDelDate(rset.getString("del_date"));
				member.setDelFlag(rset.getString("del_flag"));
				list.add(member);
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
			//throw e; //1번 방법. 해당 예외를 다시 던지기
			//2번 방법. 구체적인 커스텀예외 클래스를 생성해서 던지기
			throw new MemberException("회원 조회 오류! 관리자에게 문의하세요.", e); 
			// 여기서 e는 cause에 해당
		}finally {
			//3. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
}
