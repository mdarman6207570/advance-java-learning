<%@page import="com.task.bean.ProductBean"%>
<%@page import="com.task.bean.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="relative bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900 text-white flex items-center justify-center min-h-screen font-[Poppins] overflow-hidden">

	<!-- Background glowing circles -->
	<div class="absolute w-[400px] h-[400px] bg-blue-600/20 rounded-full blur-3xl top-10 left-10 animate-pulse"></div>
	<div class="absolute w-[350px] h-[350px] bg-purple-600/20 rounded-full blur-3xl bottom-10 right-10 animate-pulse delay-1000"></div>

	<%
	    int item=(int) request.getAttribute("item");
	    CustomerBean cb = (CustomerBean) session.getAttribute("CustomerBean");
		String data = (String) session.getAttribute("msg");
		ProductBean pb = (ProductBean) request.getAttribute("ProductBean");
	%>

	<!-- Glass Dashboard Card -->
	<div class="relative z-10 bg-gray-800/70 backdrop-blur-lg border border-gray-700 p-10 rounded-2xl shadow-2xl w-[400px] text-center hover:shadow-blue-500/30 transition-all duration-500">

		<!-- Header -->
		<h1 class="text-4xl font-extrabold mb-6 bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent drop-shadow-lg">
			👋 Hello, <%= cb.getFirstName() %><br><br> 
			You have charged  <%= (pb.getpPrice()*item)%>
			You order is placed successfully!!!
			
		</h1>

		<!-- Navigation Buttons -->
		<div class="flex flex-col space-y-4 mt-4">
			<a href="ViewCustomerProduct"
			   class="bg-gradient-to-r from-green-600 to-green-500 hover:from-green-500 hover:to-green-400 py-3 rounded-lg text-xl font-semibold shadow-lg hover:shadow-green-400/40 transition-all duration-300 transform hover:scale-[1.05]">
			   📦 View Products
			</a>

			<a href="Logout"
			   class="bg-gradient-to-r from-red-600 to-red-500 hover:from-red-500 hover:to-red-400 py-3 rounded-lg text-xl font-semibold shadow-lg hover:shadow-red-400/40 transition-all duration-300 transform hover:scale-[1.05]">
			   🚪 Logout
			</a>
		</div>

		<!-- Footer -->
		<footer class="mt-8 text-sm text-gray-400 opacity-80">
			© 2025 Customer Panel | Powered by Devil__King
		</footer>
	</div>

</body>
</html>
