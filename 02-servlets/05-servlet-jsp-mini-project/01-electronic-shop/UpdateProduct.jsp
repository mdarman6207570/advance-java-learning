<%@page import="com.pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>

<style>
    body {
        font-family: 'Segoe UI', Arial, sans-serif;
        background: linear-gradient(135deg, #e3f2fd, #bbdefb);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: white;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        padding: 40px 60px;
        text-align: center;
        width: 400px;
    }

    h1 {
        color: #1565c0;
        font-size: 26px;
        margin-bottom: 20px;
    }

    p {
        color: #444;
        font-size: 18px;
        margin-bottom: 30px;
    }

    .links {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        gap: 15px;
    }

    a {
        text-decoration: none;
        background-color: #1976d2;
        color: white;
        padding: 10px 20px;
        border-radius: 8px;
        font-weight: 500;
        transition: 0.3s ease;
    }

    a:hover {
        background-color: #0d47a1;
        transform: translateY(-2px);
    }

</style>
</head>
<body>

<div class="container">
    <%
        AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
        String data = (String)request.getAttribute("msg");
    %>

    <h1>Hello <%= abean != null ? abean.getA_fname() : "Admin" %> 👋</h1>
    <p><%= data != null ? data : "" %></p>

    <div class="links">
        <a href="AddProduct.html">Add Product</a>
        <a href="view1">View Product</a>
        <a href="logout">Logout</a>
    </div>
</div>

</body>
</html>
