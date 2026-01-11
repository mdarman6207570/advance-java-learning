<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

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
        width: 400px;
        text-align: center;
    }

    h1 {
        color: #1565c0;
        font-size: 26px;
        margin-bottom: 25px;
    }

    form {
        text-align: left;
    }

    label {
        font-weight: 600;
        color: #333;
        display: block;
        margin-bottom: 6px;
        margin-top: 12px;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 16px;
        box-sizing: border-box;
        transition: 0.3s;
    }

    input[type="text"]:focus {
        border-color: #1565c0;
        box-shadow: 0 0 5px rgba(21, 101, 192, 0.5);
        outline: none;
    }

    input[type="submit"] {
        background-color: #1976d2;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 20px;
        width: 100%;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #0d47a1;
        transform: translateY(-2px);
    }
</style>
</head>
<body>
    <div class="container">
        <%
            AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
            ProductBean pb = (ProductBean)request.getAttribute("pbitem");
        %>
        <h1>Hello <%= abean != null ? abean.getA_fname() : "Admin" %>, please edit</h1>

        <form action="update" method="post">
            <label>Product Price</label>
            <input type="text" name="pprice" value="<%=pb.getPprice()%>">

            <label>Product Quantity</label>
            <input type="text" name="pqty" value="<%=pb.getPqty()%>">

            <input type="hidden" name="pcode" value="<%=pb.getPcode()%>">

            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
