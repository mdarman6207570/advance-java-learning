<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
             session.invalidate();
		     out.println("<h1>user loggout successfully!!!</h1><br>");
		%>>
		<%@include file="index.html" %>
</body>
</html>