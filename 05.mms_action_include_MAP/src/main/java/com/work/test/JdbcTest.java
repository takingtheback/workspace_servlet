package com.work.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.work.dao.FactoryDao;

public class JdbcTest {

	public static void main(String[] args) {
		FactoryDao factory = FactoryDao.getInstance();
		System.out.println(factory);
		
		Connection conn = factory.getConnection();
		System.out.println(conn);
	}
	
	public static void main1(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "tiger";

		Class.forName(driver);
		System.out.println("1. driver loading");
		
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결: " + conn);
		
		PreparedStatement stmt = conn.prepareStatement("select * from member");
		System.out.println("3. 통로개설: " + stmt);
		
		ResultSet rs = stmt.executeQuery();
		System.out.println("4. sql 수행: ");
		while(rs.next()) {
			System.out.println(rs.getString(1) + ", " + rs.getString(2));
		}
		
		System.out.println("5. 자원해제");
		rs.close();
		stmt.close();
		conn.close();
	}

}
