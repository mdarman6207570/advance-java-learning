<%@page import="com.task.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
    /* ===== Global Styles ===== */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: "Poppins", sans-serif;
        background: radial-gradient(circle at top left, #0f2027, #203a43, #2c5364);
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        overflow: hidden;
        color: #fff;
    }

    /* ===== Animated Background Particles ===== */
    body::before, body::after {
        content: "";
        position: absolute;
        width: 400px;
        height: 400px;
        background: radial-gradient(circle, #00b4d8, transparent 70%);
        border-radius: 50%;
        animation: float 10s ease-in-out infinite alternate;
        opacity: 0.3;
    }

    body::after {
        background: radial-gradient(circle, #ff006e, transparent 70%);
        top: 40%;
        left: 60%;
        animation-delay: 5s;
    }

    @keyframes float {
        from { transform: translateY(0px); }
        to { transform: translateY(-40px); }
    }

    /* ===== Dashboard Card ===== */
    .dashboard {
        position: relative;
        background: rgba(255, 255, 255, 0.08);
        backdrop-filter: blur(15px);
        border: 1px solid rgba(255, 255, 255, 0.2);
        border-radius: 20px;
        padding: 50px 40px;
        width: 400px;
        text-align: center;
        box-shadow: 0 0 30px rgba(0, 180, 216, 0.2);
        transition: transform 0.4s ease, box-shadow 0.4s ease;
        z-index: 2;
    }

    .dashboard:hover {
        transform: scale(1.02);
        box-shadow: 0 0 40px rgba(0, 180, 216, 0.4);
    }

    /* ===== Header ===== */
    .dashboard h1 {
        font-size: 2.2em;
        color: #00b4d8;
        margin-bottom: 10px;
        letter-spacing: 1px;
        text-shadow: 0 0 10px rgba(0,180,216,0.6);
    }

    .dashboard h2 {
        color: #ddd;
        margin-bottom: 30px;
        font-weight: 400;
    }

    /* ===== Buttons ===== */
    a.button {
        display: block;
        padding: 14px;
        margin: 12px 0;
        border-radius: 10px;
        font-size: 18px;
        font-weight: 600;
        text-decoration: none;
        color: white;
        background: linear-gradient(90deg, #0077b6, #00b4d8);
        box-shadow: 0 0 15px rgba(0,180,216,0.4);
        transition: all 0.3s ease-in-out;
        position: relative;
        overflow: hidden;
    }

    a.button:hover {
        background: linear-gradient(90deg, #00b4d8, #90e0ef);
        box-shadow: 0 0 25px rgba(0,180,216,0.7);
        transform: translateY(-3px);
    }

    a.logout {
        background: linear-gradient(90deg, #ef233c, #ff6b6b);
        box-shadow: 0 0 15px rgba(239, 35, 60, 0.4);
    }

    a.logout:hover {
        background: linear-gradient(90deg, #ff6b6b, #ffd6a5);
        box-shadow: 0 0 25px rgba(255, 107, 107, 0.6);
    }

    /* ===== Footer ===== */
    footer {
        margin-top: 30px;
        font-size: 14px;
        color: #ccc;
        opacity: 0.8;
    }

    @media (max-width: 480px) {
        .dashboard {
            width: 90%;
            padding: 30px;
        }
        .dashboard h1 {
            font-size: 1.8em;
        }
        a.button {
            font-size: 16px;
        }
    }
</style>
</head>

<body>
    <%
        AdminBean bean = (AdminBean) session.getAttribute("AdminBean");
        if (bean == null) {
            response.sendRedirect("AdminLogin.html");
            return;
        }
    %>

    <div class="dashboard">
        <h1>Admin Dashboard</h1>
        <h2>Welcome, <%= bean.getUname() %> 👋</h2>

        <a href="AddProduct.html" class="button">➕ Add Product</a>
        <a href="ViewProduct" class="button">📦 View Products</a>
        <a href="Logout" class="button logout">🚪 Logout</a>

        <footer>© 2025 Admin Panel | Designed with 💙 by Devil_King</footer>
    </div>
</body>
</html>
