<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
             ArrayList<ProductBean> al = (ArrayList<ProductBean>)request.getAttribute("List");
		     if(al.size()==0)
		     {
		    	 out.println("<h1>There are NO records in Product Table<br><br></h1>");
		     }
		     else
		     {
		    	 Iterator<ProductBean> i = al.iterator();
		    	 while(i.hasNext())
		    	 {
		    		 ProductBean pb = i.next();
		    		 out.println("<h1>"+pb.getPcode()+"  "+pb.getPname()+"  "+pb.getPcompany()+"  "+pb.getPprice()+"  "+pb.getPqty()+"<br></h1>");
		    	 }
		     }
		%>
		<jsp:include page="index.html"/>
	
</body>
</html>