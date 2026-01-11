<%@page import="com.pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile</title>
</head>
<body>

<center>

<h1>
  <%
    UserBean ub = (UserBean)application.getAttribute("UserBean");
    String fn = (String)request.getAttribute("fName");
    out.println("This session belongs to "+fn+"<br><br>");
    
    String pass = ub.getU_password();
    String confidpass = pass.substring(0,1)+"******"+pass.substring(pass.length()-1);
    
    out.println(ub.getU_name()+"  "+confidpass+"  "+ub.getU_fname()+"  "+ub.getU_lname()+"  "+ub.getU_mail()+"  "+ub.getU_phone()+" <br>");
    
    %>
</h1>

<a href="edit">EditProfile</a><br><br>
<a href="logout">LogOut</a><br><br>


</body>
</html>