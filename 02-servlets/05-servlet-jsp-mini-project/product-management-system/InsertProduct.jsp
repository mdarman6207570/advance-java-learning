f<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor:cyan>
	<center>
		<h1>
			<%
			String data = (String) request.getAttribute("msg");
			out.println(data);
			%>
                 <br>
			<a href="product.html">Add Product details...</a><br> 
			<a href="view"> View Product Details...</a>
		</h1>
</body>
</html>