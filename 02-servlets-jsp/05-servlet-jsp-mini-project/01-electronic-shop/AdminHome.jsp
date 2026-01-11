<%@ page import="com.pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f8;
    text-align: center;
    padding-top: 60px;
  }
  .container {
    background: white;
    display: inline-block;
    padding: 40px 60px;
    border-radius: 12px;
    box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
  }
  h2 {
    color: #333;
  }
  a {
    display: block;
    margin: 15px;
    padding: 12px 25px;
    background-color: #007BFF;
    color: white;
    text-decoration: none;
    border-radius: 8px;
    transition: 0.3s;
  }
  a:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<%
AdminBean ab = (AdminBean) session.getAttribute("AdminBean");
if (ab == null) {
    response.sendRedirect("AdminLogin.html");
    return;
}
%>

<div class="container">
  <h2>Welcome, Mr. <%= ab.getA_fname() %> 👋</h2>
  <p>Select an option below:</p>

  <a href="AddProduct.html">Add Product</a>
  <a href="view1">View Product</a>
  <a href="logout">Logout</a>
</div>

</body>
</html>
