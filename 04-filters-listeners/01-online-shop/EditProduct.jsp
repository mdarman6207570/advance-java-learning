<%@page import="com.task.bean.ProductBean"%>
<%@page import="com.task.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="relative min-h-screen flex items-center justify-center bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900 text-white font-[Poppins] overflow-hidden">

	<!-- Glowing background circles -->
	<div class="absolute w-[400px] h-[400px] bg-blue-600/20 rounded-full blur-3xl top-10 left-10 animate-pulse"></div>
	<div class="absolute w-[350px] h-[350px] bg-purple-600/20 rounded-full blur-3xl bottom-10 right-10 animate-pulse delay-1000"></div>

	<%
		AdminBean ab = (AdminBean) session.getAttribute("AdminBean");
		ProductBean pb = (ProductBean) request.getAttribute("pbitem");

		if (ab == null || pb == null) {
			response.sendRedirect("admin.html");
			return;
		}
	%>

	<!-- Glass Card -->
	<div class="relative z-10 bg-gray-800/70 backdrop-blur-lg border border-gray-700 p-10 rounded-2xl shadow-2xl w-[400px] hover:shadow-blue-500/30 transition-all duration-500">

		<!-- Header -->
		<h1 class="text-4xl font-extrabold text-center mb-4 bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent drop-shadow-lg">
			✏️ Edit Product
		</h1>
		<p class="text-center text-gray-400 mb-8">
			Hello <span class="text-blue-400 font-semibold"><%= ab.getFname() %></span>, update product details below.
		</p>

		<!-- Form -->
		<form action="UpdateProduct" method="post" class="space-y-5">

			<div>
				<input type="hidden" name="pcode" value="<%= pb.getpCode() %>" 
					   class="w-full px-4 py-2 rounded-lg bg-gray-700/70 text-gray-400 border border-gray-600 cursor-not-allowed">
			</div>

			<div>
				<label class="block text-sm font-semibold mb-1 text-gray-300">Product Price</label>
				<input type="number" name="pprice" value="<%=String.valueOf(pb.getpPrice()) %>" required
					   class="w-full px-4 py-2 rounded-lg bg-gray-700/70 text-white border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition">
			</div>

			<div>
				<label class="block text-sm font-semibold mb-1 text-gray-300">Product Quantity</label>
				<input type="number" name="pqty" value="<%= String.valueOf(pb.getpQty()) %>" required
					   class="w-full px-4 py-2 rounded-lg bg-gray-700/70 text-white border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition">
			</div>

			<!-- Update Button -->
			<button type="submit" value="Update"
					class="w-full bg-gradient-to-r from-blue-600 to-blue-500 hover:from-blue-500 hover:to-blue-400 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-blue-400/40 transition-all duration-300 transform hover:scale-[1.05]">
				💾 Update Product
			</button>

			<!-- Back Button -->
			<a href="ViewProduct"
			   class="block text-center bg-gradient-to-r from-gray-700 to-gray-600 hover:from-gray-600 hover:to-gray-500 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-gray-400/30 transition-all duration-300 transform hover:scale-[1.05]">
				⬅️ Back to Products
			</a>

		</form>

		<!-- Footer -->
		<footer class="mt-8 text-center text-gray-400 text-sm opacity-80">
			© 2025 Admin Panel | Powered by Devil__King
		</footer>
	</div>

</body>
</html>
