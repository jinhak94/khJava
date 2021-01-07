package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB Connection 객체 생성
 * 트랜잭션 처리
 * 자원반납
 * 
 * 관련한 공통 코드를 작성한다(예외처리 포함)
 * 
 * static 메소드로 작성해서 객체생성 없이 바로 호출
 */

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;

		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
	    String password = "student";
	      
	    try {
	       //1. jdbc driver 클래스 등록(dbms별로 제공) : 최초 1회
	       Class.forName(driverClass);
	       //2. db connection객체 생성 : dbserver url, user, password
	       conn = DriverManager.getConnection(url, user, password);
	       conn.setAutoCommit(false);
	    } catch (Exception e) {
	       e.printStackTrace();
	    } 
		return conn;
	}

	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null && !pstmt.isClosed())
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
