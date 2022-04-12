<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main3.do</h1>

	<!-- 자바 표현식 -->
	<%=request.getAttribute("userNo") %>
	<br />

	<!-- 스크립트 -->
	<div>${userid}</div>
</body>
</html>