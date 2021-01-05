package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

/**
 * DAO
 * Data Access Object
 * 
 * 1. jdbc driver 클래스 등록(dbms별로 제공) : 최초 1회
 * 2. db connection 객체 생성 : dbserver url, user, password
 * 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
 * 4. 쿼리전송(실행) - 결과값
 * 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
 * 5. 트랜잭션처리(commit, rollback)
 * 6. 자원반납
 */


/**
 * 
      Statement 클래스
      - SQL 구문을 실행하는 역할
      - 스스로는 SQL 구문 이해 못함(구문해석 X) -> 전달역할
      - SQL 관리 O + 연결 정보 X
      
      PreparedStatement 클래스
      - Statement 클래스의 기능 향상
      - 인자와 관련된 작업이 특화(매개변수)
      - 코드 안정성 높음. 가독성 높음.
      - 코드량이 증가 -> 매개변수를 set해줘야하기 때문에..
      - 텍스트 SQL 호출
 *
 */

public class MemberDAO {
	
	private String driverClass = "oracle.jdbc.OracleDriver";
	//사용드라이버@ip주소:port:sid(접속db명)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "student";
	private String password = "student";
	/**
	 * 1. jdbc driver 클래스 등록(dbms별로 제공) : 최초 1회
	 */
	public MemberDAO() {
		try {
			Class.forName(driverClass);
		}catch(ClassNotFoundException e) {
			System.out.println("ojdbc6.jar를 확인하세요.");
			//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
			e.printStackTrace();
		}
	}
	
	/**
	 * 2. db connection 객체 생성 : dbserver url, user, password
	 * 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
	 * 4. 쿼리전송(실행) - 결과값
	 * 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
	 * 5. 트랜잭션처리(commit, rollback)
	 * 6. 자원반납
	*/	
	
	public int insertMember(Member member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 실제 데이터의 값은 ?로 대체. 값 9개이므로 ? 9개
		// sql 작성할 때 주의점 : ;(세미콜론)을 찍지 않는다.
		// 공백 주의(2개 3개는 괜찮지만 없는게 문제)
		String sql = "insert into member "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		int result = 0;
		
		
		// 2. db connection 객체 생성 : dbserver url, user, password
		try {
			conn = DriverManager.getConnection(url, user, password);
			//자동커밋 사용안함(트랜잭션 처리는 java앱에서 주도적으로 처리하겠음.)
			conn.setAutoCommit(false);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql); //미완성 쿼리 전달
			// Statemenet 객체 생성 후 ?에 값 대입해서 쿼리 완성
			pstmt.setString(1,  member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3,  member.getMemberName());
			pstmt.setString(4,  member.getGender());
			pstmt.setInt(5,  member.getAge());
			pstmt.setString(6,  member.getEmail());
			pstmt.setString(7,  member.getPhone());
			pstmt.setString(8,  member.getAddress());
			pstmt.setString(9,  member.getHobby());
			
			
			// 4. 쿼리전송(실행) - 결과값
			// DML인 경우는 int값(처리된 행의 수)이 리턴됨
			result = pstmt.executeUpdate(); //dml인 경우 executeUpdate
			 
			// 5. 트랜잭션처리(commit, rollback)
			if(result > 0) conn.commit();
			else conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 6. 자원반납
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Member> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member order by enroll_date desc";
		ResultSet rset = null;
		List<Member> list = null;
		
		try {
			// 2. db connection 객체 생성 : dbserver url, user, password
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql);
			// 채워야 할 ?가 있다면, 값 대입을 해줘야 함.
			
			// 4. 쿼리전송(실행) - 결과값
			//DQL select문인 경우에는 executeQuery() 호출
			// 				-> ResultSet 객체를 받는다.
			rset = pstmt.executeQuery();
			
			// 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
			list = new ArrayList<Member>();
			while(rset.next()) {
				//한 행의 컬럼 정보에 접근할 수 있다.
				//한 행 -> member vo 객체
				Member member = new Member();
				member.setMemberId(rset.getString("member_id")); 
				// --> db컬럼명을 대 소문자 구분 없이 적기
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				
				//list에 추가
				list.add(member);
			}
			
			// 5. 트랜잭션처리(commit, rollback)
			//select문은 트랜잭션처리가 불필요하다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. 자원반납
		try {
			pstmt.close();
			rset.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("list@dai = " + list);
		return list;
		
	}

	public Member selectOne(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where member_id = ?";
		ResultSet rset = null;
		Member member = null;
		
		try {
			// 2. db connection 객체 생성 : dbserver url, user, password
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql);
			// 채워야 할 ?가 있다면, 값 대입을 해줘야 함.
			pstmt.setString(1,id);
			
			// 4. 쿼리전송(실행) - 결과값
			//DQL select문인 경우에는 executeQuery() 호출
			// 				-> ResultSet 객체를 받는다.
			rset = pstmt.executeQuery();
			
			// 4.1 select문인 경우, member 객체 생성
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id")); 
				// --> db컬럼명을 대 소문자 구분 없이 적기
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
			
			// 5. 트랜잭션처리(commit, rollback)
			//select문은 트랜잭션처리가 불필요하다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. 자원반납
		try {
			pstmt.close();
			rset.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("member@dai = " + member);
		return member;
	}

	public List<Member> selectName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where member_name like '%"
				+ name + "%' order by enroll_date desc";
		ResultSet rset = null;
		List<Member> list = null;
		
		try {
			// 2. db connection 객체 생성 : dbserver url, user, password
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql);
			// 채워야 할 ?가 있다면, 값 대입을 해줘야 함.
			
			// 4. 쿼리전송(실행) - 결과값
			//DQL select문인 경우에는 executeQuery() 호출
			// 				-> ResultSet 객체를 받는다.
			rset = pstmt.executeQuery();
			
			// 4.1 select문인 경우, 결과집합을 자바객체(list)에 옮겨담기
			list = new ArrayList<Member>();
			while(rset.next()) {
				//한 행의 컬럼 정보에 접근할 수 있다.
				//한 행 -> member vo 객체
				Member member = new Member();
				member.setMemberId(rset.getString("member_id")); 
				// --> db컬럼명을 대 소문자 구분 없이 적기
				member.setPassword(rset.getString("password"));
				member.setMemberName(rset.getString("member_name"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				
				//list에 추가
				list.add(member);
			}
			
			// 5. 트랜잭션처리(commit, rollback)
			//select문은 트랜잭션처리가 불필요하다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. 자원반납
		try {
			pstmt.close();
			rset.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("list@dai = " + list);
		return list;
	}

	public int updateMember(Member member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 실제 데이터의 값은 ?로 대체. 값 9개이므로 ? 9개
		// sql 작성할 때 주의점 : ;(세미콜론)을 찍지 않는다.
		// 공백 주의(2개 3개는 괜찮지만 없는게 문제)
		String sql = "update member set "
				+ "password = ?, "
				+ "member_name = ?, "
				+ "gender = ?, "
				+ "age = ?, "
				+ "email = ?, "
				+ "phone = ?, "
				+ "address = ?, "
				+ "hobby = ? "
				+ "where member_id = ?";
		int result = 0;
		
		
		// 2. db connection 객체 생성 : dbserver url, user, password
		try {
			conn = DriverManager.getConnection(url, user, password);
			//자동커밋 사용안함(트랜잭션 처리는 java앱에서 주도적으로 처리하겠음.)
			conn.setAutoCommit(false);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql); //미완성 쿼리 전달
			// Statemenet 객체 생성 후 ?에 값 대입해서 쿼리 완성
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2,  member.getMemberName());
			pstmt.setString(3,  member.getGender());
			pstmt.setInt(4,  member.getAge());
			pstmt.setString(5,  member.getEmail());
			pstmt.setString(6,  member.getPhone());
			pstmt.setString(7,  member.getAddress());
			pstmt.setString(8,  member.getHobby());
			pstmt.setString(9, member.getMemberId());
			
			// 4. 쿼리전송(실행) - 결과값
			// DML인 경우는 int값(처리된 행의 수)이 리턴됨
			result = pstmt.executeUpdate(); //dml인 경우 executeUpdate
			 
			// 5. 트랜잭션처리(commit, rollback)
			if(result > 0) conn.commit();
			else conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 6. 자원반납
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where member_id = ?";
		int result = 0;
		boolean flag = false;
		try {
			// 2. db connection 객체 생성 : dbserver url, user, password
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. 쿼리문 생성 및 Statement 객체(PreparedStatement) 생성
			pstmt = conn.prepareStatement(sql);
			// 채워야 할 ?가 있다면, 값 대입을 해줘야 함.
			pstmt.setString(1,id);
			
			// 4. 쿼리전송(실행) - 결과값
			//DQL select문인 경우에는 executeQuery() 호출
			// 				-> ResultSet 객체를 받는다.
			result = pstmt.executeUpdate();
			
			// 5. 트랜잭션처리(commit, rollback)
			if(result > 0) {
				conn.commit();
				flag = true;
			}
			else conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. 자원반납
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
