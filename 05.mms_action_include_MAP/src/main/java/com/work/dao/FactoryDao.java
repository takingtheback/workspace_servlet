package com.work.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 모든 DAO 클래스에서 사용하기 위한 Factory DAO 클래스
 * -- Connection 반환, 
 * -- close() 자원해제를 담당하는 기능으로만 분리설계
 * 
 * -- 모든 DAO 클래스에서 getConnection(), close(conn, stmt, rs) : 호출사용  
 * 
 * -- Singleton pattern 구현
 * 1. private 생성자
 * 2. private static 클래스이름 instance = new 클래스이름();
 * 3. public static 클래스이름 getInstance() { return instance; }
 */
public class FactoryDao {
	/** jdbc resource property 
	 * -- 파일로 분리 설계 : java.io.* => 개발자가 직접 구현 마음데로 가능
	 * -- java.util.ResourceBundle API
	 * 		=> 규칙 
	 * 		1. 파일명확장자 : 파일명.properties
	 * 		2. 파일위치 : classpath 상대경로
	 * 		3. propert-name=property-value
	 * -- xml 파일
	 * 		=> 규칙
	 * 		<tag 속성명="속성값" 속성명='속성값'>contents</tag>
	 * 		<tag 속성명="속성값" 속성명='속성값' />
	 * 		=> xml 형식 구조 표준화 기술 : DTD, Schema
	 * 		=> xml = well-formed(xml 작성규칙 준수한 문서) + valid(dtd, schema 규칙 준수한 문서)
	 * */
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private String user = "scott";
//	private String password = "tiger";
	
	private static FactoryDao instance = new FactoryDao();
	
	private FactoryDao() {
//		try {
//			Class.forName(driver);
//			System.out.println("[성공] 드라이버 로딩");
//		} catch (ClassNotFoundException e) {
//			System.out.println("[오류] 드라이버 로딩 오류");
//			e.printStackTrace();
//		}
	}
	
	
	public static FactoryDao getInstance() { 
		return instance; 
	}
	
	/**
	 * DB 연결 Connection 반환 메서드 
	 * @return Connection
	 */
	public static Connection getConnection() {
	    Connection conn = null;
	    try {
	        Context initContext = new InitialContext();
	        DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/Oracle11g");
	        conn = ds.getConnection();
	     } catch (Exception e) {
	        System.out.println("[JdbcTemplate.getConnection] : " + e.getMessage());
	        e.printStackTrace();
	    }
	    return conn;
	 }
	
//	public Connection getConnection() {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		};
//		
//		System.out.println("getConnection() : " + conn);
//		return conn;
//	}
	
	/**
	 * 자원해제 : SELECT 수행에 대한 자원
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 자원해제 : CUD 수행에 대한 자원
	 * @param conn
	 * @param stmt
	 */
	public void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
}









