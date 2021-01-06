package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static common.JDBCTemplate.*;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

/**
 * 
 * Service
 * 업무로직 담당클래스 (connection 생성, 트랜잭션 처리, dao 업무 요청)
 * 
 * 1. jdbc driver 클래스 등록(dbms별로 제공) : 최초 1회
 * 2. db connection객체 생성 : dbserver url, user, password
 * -> DAO담당
 * 6. 트랜잭션처리(commit, rollback)
 * 7. 자원반납(Connection) 
 *
 */
public class MemberService {
   
   private MemberDAO memberDAO = new MemberDAO();

   public int insertMember(Member member) {
	   //1. Connection 생성
	   Connection conn = getConnection();
	   
	   //2. dao 요청
	   int result = memberDAO.insertMember(conn,  member);
	   
	   //3. 트랜잭션 처리
       if(result  > 0) commit(conn);
       else rollback(conn);
	   
	   //4. 자원반납
	   close(conn);
	   return result;
   }
   
   
   //이전버전
   public int insertMember_(Member member) {
      String driverClass = "oracle.jdbc.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "student";
      String password = "student";
      Connection conn = null;
      int result = 0;
      
      try {
         //1. jdbc driver 클래스 등록(dbms별로 제공) : 최초 1회
         Class.forName(driverClass);
         //2. db connection객체 생성 : dbserver url, user, password
         conn = DriverManager.getConnection(url, user, password);
         conn.setAutoCommit(false);
         //dao요청
         result = memberDAO.insertMember(conn, member);
         //6. 트랜잭션처리(commit, rollback)
         if(result  > 0) conn.commit();
         else conn.rollback();
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         //7. 자원반납(Connection) 
         try {
            conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      return result;
   }


	public Member selectOneMember(String memberId) {
		//1. Connection 생성
		Connection conn = getConnection();
		
		//2. dao 요청
		Member member = memberDAO.selectOneMember(conn, memberId);
		
		//3. 자원반납
		close(conn);
		
		return member;
	}


	public List<Member> selectAllMember() {
		Connection conn = getConnection();
		List<Member> list = memberDAO.selectAllMember(conn);
		close(conn);
		return list;
	}


	public List<Member> selectMemberByName(String name) {
		Connection conn = getConnection();
		List<Member> list = memberDAO.selectMemberByName(conn, name);
		close(conn);
		return list;
	}


	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = memberDAO.deleteMember(conn, memberId);
		close(conn);
		return result;
	}


	public int updateMemberByPassword(String memberId, String memberPassword) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberByPassword(conn, memberId, memberPassword);
		close(conn);
		return result;
	}


	public int updateMemberByEmail(String memberId, String memberEmail) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberByEmail(conn, memberId, memberEmail);
		close(conn);
		return result;
	}


	public int updateMemberByPhone(String memberId, String memberPhone) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberByPhone(conn, memberId, memberPhone);
		close(conn);
		return result;
	}


	public int updateMemberByAddress(String memberId, String memberAddress) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberByAddress(conn, memberId, memberAddress);
		close(conn);
		return result;
	}

}