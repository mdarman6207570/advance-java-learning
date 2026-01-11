<%@page import="com.pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Your Profile</title>
</head>
<body>

	<center>
		<h1>
			<%
			UserBean ub = (UserBean) application.getAttribute("UserBean");
			String fn = (String)request.getAttribute("fName");
			out.println("This Session belongs To "+fn+" 😍 <br><br>");
			%>

            <form action="update" method="post">
              FirstName <input type="text" name="f_name" value="<%=ub.getU_fname()%>"><br>
              LastName <input type="text" name="l_name" value="<%=ub.getU_lname()%>"><br>
              MailId <input type="text" name="mail_id" value="<%=ub.getU_mail()%>"><br>
              Phone <input type="text" name="phone_no" value="<%=ub.getU_phone()%>"><br>
              <input type="submit" value="Update">
            
            </form>  
              
		</h1>
</body>
</html>