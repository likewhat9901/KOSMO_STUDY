package common;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class JDBConnect {
	
	// 멤버변수 : JDBC 프로그래밍을 위한 객체
    public Connection conn = null;
    public Statement stmt;
    public PreparedStatement psmt = null;
    public ResultSet rs = null;
    
    public JDBConnect() {
    	try {
    		// 오라클 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 커넥션URL, 아이디, 비번
            String url = "jdbc:oracle:thin:@localhost:1521/xe";
            String id = "musthave";
            String pwd = "1234";
            // 연결 시도 및 Connection 객체 반환
            conn = DriverManager.getConnection(url, id, pwd);
            
            System.out.println("DB 연결 성공(기본 생성자)");
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // 자원 반납하기
    public void close() {
    	try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (conn != null) conn.close();
            
            System.out.println("JDBC 자원 해제");
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
