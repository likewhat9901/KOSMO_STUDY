<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot</title>
</head>
<body>
	<h2>퀴즈] 로그인폼에서 전송된 값</h2>
	<ul>
		<li>아이디 : ${ memberDTO.id }</li>
		<li>비밀번호 : ${ memberDTO.passwd }</li>
	</ul>
</body>
</html>