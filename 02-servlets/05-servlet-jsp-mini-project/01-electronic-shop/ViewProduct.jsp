<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>

<style>
    /* 🌈 Base Layout */
    body {
        font-family: 'Poppins', 'Segoe UI', Arial, sans-serif;
        background: linear-gradient(135deg, #e3f2fd, #bbdefb);
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background-color: #fff;
        border-radius: 15px;
        box-shadow: 0 4px 20px rgba(0,0,0,0.2);
        padding: 40px;
        width: 90%;
        max-width: 900px;
        margin-top: 50px;
        text-align: center;
    }

    h1 {
        color: #1565c0;
        font-size: 28px;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        font-size: 16px;
    }

    th {
        background-color: #1565c0;
        color: white;
        padding: 12px 8px;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    td {
        padding: 10px 8px;
        border-bottom: 1px solid #ddd;
        color: #333;
    }

    tr:nth-child(even) {
        background-color: #f4f8ff;
    }

    tr:hover {
        background-color: #e3f2fd;
        transition: 0.3s;
    }

    .actions a {
        text-decoration: none;
        color: white;
        padding: 6px 12px;
        border-radius: 6px;
        font-size: 14px;
        margin: 0 3px;
        transition: 0.3s;
    }

    .edit-btn {
        background-color: #43a047;
    }

    .edit-btn:hover {
        background-color: #2e7d32;
    }

    .delete-btn {
        background-color: #e53935;
    }

    .delete-btn:hover {
        background-color: #b71c1c;
    }

    .add-btn {
        display: inline-block;
        background-color: #1976d2;
        color: white;
        padding: 10px 20px;
        border-radius: 8px;
        font-weight: 500;
        text-decoration: none;
        margin-top: 25px;
        transition: 0.3s;
    }

    .add-btn:hover {
        background-color: #0d47a1;
        transform: translateY(-2px);
    }

    .empty {
        color: red;
        font-size: 18px;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
            ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");

            if (abean == null) {
                response.sendRedirect("AdminLogin.html");
                return;
            }
        %>

        <h1>Welcome, <%= abean.getA_fname() %> 👋</h1>

        <%
            if (al == null || al.isEmpty()) {
        %>
            <p class="empty">Product inventory is empty!</p>
            <a href="AddProduct.html" class="add-btn">Add Product</a>
        <%
            } else {
        %>
            <table>
                <tr>
                    <th>Product Code</th>
                    <th>Name</th>
                    <th>Company</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
                <%
                    for (ProductBean pb : al) {
                %>
                <tr>
                    <td><%= pb.getPcode() %></td>
                    <td><%= pb.getPname() %></td>
                    <td><%= pb.getPcompany() %></td>
                    <td>₹<%= pb.getPprice() %></td>
                    <td><%= pb.getPqty() %></td>
                    <td class="actions">
                        <a href="edit?pcode=<%= pb.getPcode() %>" class="edit-btn">Edit</a>
                        <a href="delete?pcode=<%= pb.getPcode() %>" class="delete-btn">Delete</a>
                    </td>
                </tr>
                <% } %>
            </table>
            
        <%
            }
        %>
    </div>
</body>
</html>
