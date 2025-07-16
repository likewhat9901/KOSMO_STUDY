<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloServlet.jsp</title>
</head>
<body>
	<h2>web.xml에서 매핑 후 JSP에서 출력하기</h2>
	<p>
		<!-- 리퀘스트 영역에 저장된 속성값을 출력 -->
		<strong><%= request.getAttribute("message") %></strong>
		<br/>
		<a href="./HelloServlet.do">바로가기</a>
	</p>
</body>
</html>