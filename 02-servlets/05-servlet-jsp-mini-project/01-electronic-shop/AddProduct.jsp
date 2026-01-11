<%@page import="com.pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #dfe9f3 0%, #ffffff 100%);
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    }

    h1 {
        color: #333;
        margin-bottom: 10px;
        font-size: 26px;
    }

    h2 {
        color: #444;
        margin-bottom: 20px;
    }

    form {
        background-color: #fff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
        display: inline-block;
        width: 350px;
        text-align: left;
    }

    label {
        font-weight: 600;
        color: #555;
        display: block;
        margin-bottom: 5px;
        margin-top: 10px;
    }

    input[type="text"], input[type="number"] {
        padding: 10px;
        width: 100%;
        border-radius: 6px;
        border: 1px solid #ccc;
        box-sizing: border-box;
        font-size: 14px;
        margin-bottom: 12px;
        transition: border-color 0.2s ease;
    }

    input[type="text"]:focus, input[type="number"]:focus {
        border-color: #007bff;
        outline: none;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        margin-top: 10px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .msg {
        color: green;
        font-weight: bold;
        background: #e8f5e9;
        padding: 10px;
        border-radius: 6px;
        margin-bottom: 15px;
        width: 350px;
        text-align: center;
    }

    .nav-links {
        margin-top: 20px;
        text-align: center;
    }

    a {
        text-decoration: none;
        color: #007bff;
        font-weight: 500;
        margin: 0 10px;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #0056b3;
        text-decoration: underline;
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
    
    String msg = (String) request.getAttribute("msg");
%>

<h1>Welcome, <%= ab.getA_fname() %></h1>

<% if (msg != null) { %>
    <div class="msg"><%= msg %></div>
<% } %>

<form action="aps" method="post">
    <h2>Add New Product</h2>

    <label for="pcode">Product Code:</label>
    <input type="text" name="pcode" id="pcode" required>

    <label for="pname">Product Name:</label>
    <input type="text" name="pname" id="pname" required>

    <label for="pcom">Product Company:</label>
    <input type="text" name="pcom" id="pcom" required>

    <label for="pprice">Product Price:</label>
    <input type="text" name="pprice" id="pprice" required>

    <label for="pqty">Product Quantity:</label>
    <input type="text" name="pqty" id="pqty" required>

    <input type="submit" value="Add Product">
</form>

<div class="nav-links">
    <a href="view1">View Products</a> | 
    <a href="logout">Logout</a>
</div>

</body>
</html>
