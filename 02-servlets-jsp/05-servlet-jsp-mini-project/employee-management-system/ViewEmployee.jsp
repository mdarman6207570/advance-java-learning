<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.EmployeeBean"%>
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
             ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)request.getAttribute("List");
		     if(al.size()==0)
		     {
		    	 out.println("<h1>There are NO records in Employee Table<br><br></h1>");
		     }
		     else
		     {
		    	 Iterator<EmployeeBean> i = al.iterator();
		    	 while(i.hasNext())
		    	 {
		    		 EmployeeBean eb = i.next();
		    		 out.println("<h1>"+eb.getId()+"  "+eb.getfName()+"  "+eb.getlName()+"  "+eb.getSalary()+"  "+eb.getAddress()+"<br></h1>");
		    	 }
		     }
		%>
		<jsp:include page="index.html"/>
	
</body>
</html>