<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");

if(id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")) {
	response.sendRedirect("ResponseWelcome.jsp");
}
else {
	/*
	인증에 실패한 경우 메인페이지로 포워드한다.
	포워드란 페이지 이동과는 다르게 제어의 흐름을 전달하고자 할때 사용한다.
	웹브라우저의 주소줄에는 ResponseLogin.jsp가 표시되지만, 실제 출력되는 내용은
	ResponseMain.jsp가 출력된다. 
	즉, 아래 명령을 만나기 전까지의 모든 내용을 버퍼(메모리)에서 제거한 후
	아래 페이지의 내용을 웹브라우저에 출력하면서 요청정보와 응답정보를 전달한다.
	*/
	request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
		.forward(request, response);
}
%>
</body>
</html>