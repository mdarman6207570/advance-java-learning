<%@page import="java.util.ArrayList"%>
<%@page import="com.task.bean.ProductBean"%>
<%@page import="com.task.bean.AdminBean"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Product</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="relative min-h-screen bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900 text-white font-[Poppins] overflow-x-hidden">

	<!-- Glowing background effects -->
	<div class="absolute w-[400px] h-[400px] bg-blue-600/20 rounded-full blur-3xl top-10 left-10 animate-pulse"></div>
	<div class="absolute w-[350px] h-[350px] bg-purple-600/20 rounded-full blur-3xl bottom-10 right-10 animate-pulse delay-1000"></div>

	<%
		AdminBean ab = (AdminBean) session.getAttribute("AdminBean");
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");
	%>

	<!-- Header -->
	<header class="relative z-10 bg-gray-800/70 backdrop-blur-lg border-b border-gray-700 text-white p-5 flex justify-between items-center shadow-lg">
		<h1 class="text-2xl font-bold">
			👋 Welcome, <span class="text-blue-400"><%= ab != null ? ab.getUname() : "Admin" %></span>
		</h1>
		<a href="Logout"
		   class="bg-gradient-to-r from-red-600 to-red-500 hover:from-red-500 hover:to-red-400 px-5 py-2 rounded-lg text-lg font-semibold shadow-lg hover:shadow-red-400/40 transition-all duration-300 transform hover:scale-[1.05]">
		   🚪 Logout
		</a>
	</header>

	<!-- Main Container -->
	<div class="relative z-10 p-10">

		<h2 class="text-4xl font-extrabold text-center mb-10 bg-gradient-to-r from-blue-400 to-purple-400 bg-clip-text text-transparent drop-shadow-lg">
			📦 Product Inventory
		</h2>

		<%
			if (al == null || al.isEmpty()) {
		%>
			<p class="text-center text-gray-400 text-lg">No products available in inventory 🛒</p>
		<%
			} else {
		%>

		<!-- Product Table -->
		<div class="overflow-x-auto">
			<table class="min-w-full bg-gray-800/70 backdrop-blur-lg border border-gray-700 rounded-2xl shadow-2xl text-white">
				<thead>
					<tr class="bg-gradient-to-r from-blue-600 to-purple-600 text-left text-lg font-semibold">
						<th class="py-4 px-6 rounded-tl-2xl">Product Code</th>
						<th class="py-4 px-6">Product Name</th>
						<th class="py-4 px-6">Company</th>
						<th class="py-4 px-6">Price</th>
						<th class="py-4 px-6">Quantity</th>
						<th class="py-4 px-6 text-center rounded-tr-2xl">Actions</th>
					</tr>
				</thead>
				<tbody class="divide-y divide-gray-700">
					<%
						Iterator<ProductBean> i = al.iterator();
						while (i.hasNext()) {
							ProductBean pb = i.next();
					%>
					<tr class="hover:bg-gray-700/60 transition duration-300">
						<td class="py-3 px-6"><%= pb.getpCode() %></td>
						<td class="py-3 px-6"><%= pb.getpName() %></td>
						<td class="py-3 px-6"><%= pb.getpCompany() %></td>
						<td class="py-3 px-6">₹<%= String.valueOf(pb.getpPrice()) %></td>
						<td class="py-3 px-6"><%= String.valueOf(pb.getpQty()) %></td>
						<td class="py-3 px-6 text-center">
							<a href="EditProduct?pcode=<%= pb.getpCode() %>"
							   class="bg-gradient-to-r from-yellow-400 to-yellow-500 hover:from-yellow-300 hover:to-yellow-400 text-white px-4 py-2 rounded-lg font-semibold shadow-md hover:shadow-yellow-400/40 transition-all duration-300 mr-2 transform hover:scale-[1.05]">
							   ✏️ Edit
							</a>
							<a href="DeleteProduct?pcode=<%= pb.getpCode() %>"
							   class="bg-gradient-to-r from-red-600 to-red-500 hover:from-red-500 hover:to-red-400 text-white px-4 py-2 rounded-lg font-semibold shadow-md hover:shadow-red-400/40 transition-all duration-300 transform hover:scale-[1.05]">
							   🗑️ Delete
							</a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

		<%
			}
		%>

		<!-- Add Product Button -->
		<div class="text-center mt-12">
			<a href="AddProduct.html"
			   class="inline-block bg-gradient-to-r from-green-600 to-green-500 hover:from-green-500 hover:to-green-400 text-white px-8 py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-green-400/40 transition-all duration-300 transform hover:scale-[1.05]">
			   ➕ Add New Product
			</a>
		</div>
	</div>

	<!-- Footer -->
	<footer class="relative z-10 text-center text-gray-400 text-sm py-6 border-t border-gray-700 mt-10">
		© 2025 Admin Panel | Designed by Devil_King
	</footer>

</body>
</html>
