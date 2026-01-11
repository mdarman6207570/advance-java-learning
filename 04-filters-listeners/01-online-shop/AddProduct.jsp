<%@page import="com.task.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="relative min-h-screen flex items-center justify-center bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900 text-white font-[Poppins] overflow-hidden">

    <!-- Animated Glow Circles -->
    <div class="absolute w-96 h-96 bg-blue-600/20 rounded-full blur-3xl top-10 left-10 animate-pulse"></div>
    <div class="absolute w-80 h-80 bg-purple-600/20 rounded-full blur-3xl bottom-10 right-10 animate-pulse delay-1000"></div>

    <%
        AdminBean bean = (AdminBean) session.getAttribute("AdminBean");
        String data = (String) request.getAttribute("msg");
        if (bean == null) {
            response.sendRedirect("AdminLogin.html");
            return;
        }
    %>

    <!-- Dashboard Card -->
    <div class="relative z-10 bg-gray-800/70 backdrop-blur-lg border border-gray-700 p-10 rounded-2xl shadow-2xl w-[400px] text-center hover:shadow-blue-500/30 transition-all duration-500">
        
        <!-- Success or Info Message -->
        <%
            if (data != null) {
        %>
            <div class="mb-4 px-4 py-2 bg-green-600/30 border border-green-500 rounded-lg text-green-300 font-semibold animate-fade-in">
                <%= data %>
            </div>
        <%
            }
        %>

        <!-- Title -->
        <h1 class="text-4xl font-bold mb-2 bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent drop-shadow-lg">
            Admin Dashboard
        </h1>
        <p class="text-lg mb-6 text-gray-300">Welcome, <span class="text-blue-400 font-semibold"><%= bean.getFname() %></span> 👋</p>

        <!-- Buttons -->
        <div class="flex flex-col space-y-4">
            <a href="AddProduct.html"
               class="bg-gradient-to-r from-blue-600 to-blue-500 hover:from-blue-500 hover:to-blue-400 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-blue-400/40 transition-all duration-300 transform hover:scale-[1.03]">
               ➕ Add Product
            </a>

            <a href="ViewProduct"
               class="bg-gradient-to-r from-green-600 to-green-500 hover:from-green-500 hover:to-green-400 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-green-400/40 transition-all duration-300 transform hover:scale-[1.03]">
               📦 View Products
            </a>

            <a href="Logout"
               class="bg-gradient-to-r from-red-600 to-red-500 hover:from-red-500 hover:to-red-400 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-red-400/40 transition-all duration-300 transform hover:scale-[1.03]">
               🚪 Logout
            </a>
        </div>

        <!-- Footer -->
        <footer class="mt-8 text-gray-400 text-sm opacity-80">
            © 2025 Admin Panel | Designed with 💙 by Devil__King
        </footer>
    </div>

</body>
</html>
