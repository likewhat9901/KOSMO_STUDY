<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    String user = "JSP";
    String password = "1234";

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        String sql = "SELECT * FROM member";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<h1>회원 목록</h1>
<%
        while (rs.next()) {
%>
    <h2>ID: <%= rs.getString("id") %></h2>
    <p>Name: <%= rs.getString("name") %></p>
    <hr>
<%
        }
    } catch(Exception e) {
        e.printStackTrace();
        out.println("DB 연결 실패: " + e.getMessage());
    } finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
        if (conn != null) try { conn.close(); } catch(Exception e) {}
    }
%>
</body>
</html>
