<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- build.gradle에 JSP 사용을 위한 4개의 의존성을 통해 JSTL을 사용할 수 있다.
taglib 지시어를 통해 설정한다. -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot</title>
</head>
<body>
	<h2>사용자정의 properties파일에서 가져오기</h2>
	<ul>
		<li>myId : ${ myId }</li>
		<li>myPass : ${ myPass }</li>
		<li>myAddress : ${ myAddress }</li>
		<li>myAge : ${ myAge }</li>
	</ul>
</body>
</html>