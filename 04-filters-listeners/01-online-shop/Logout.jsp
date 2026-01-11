<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Logout</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>

<body class="relative flex items-center justify-center min-h-screen bg-gradient-to-br from-gray-900 via-gray-800 to-gray-900 text-white font-[Poppins] overflow-hidden">

    <!-- Background glowing effects -->
    <div class="absolute w-[400px] h-[400px] bg-green-500/20 rounded-full blur-3xl top-20 left-10 animate-pulse"></div>
    <div class="absolute w-[350px] h-[350px] bg-blue-500/20 rounded-full blur-3xl bottom-20 right-10 animate-pulse delay-1000"></div>

    <%
        session.invalidate();
    %>

    <!-- Logout Card -->
    <div class="relative z-10 bg-gray-800/70 backdrop-blur-lg border border-gray-700 p-10 rounded-2xl shadow-2xl w-[400px] text-center hover:shadow-green-500/30 transition-all duration-500">

        <div class="flex flex-col items-center space-y-4">
            <div class="text-6xl animate-bounce">✅</div>
            <h1 class="text-3xl font-bold text-green-400">Logout Successful</h1>
            <p class="text-gray-300 text-lg">You have been logged out successfully.</p>
        </div>

        <div class="mt-8">
            <a href="index.html" 
               class="inline-block w-full bg-gradient-to-r from-green-600 to-green-500 hover:from-green-500 hover:to-green-400 text-white py-3 rounded-lg text-lg font-semibold shadow-lg hover:shadow-green-400/40 transition-all duration-300 transform hover:scale-[1.05]">
               🔑 Login Again
            </a>
        </div>

        <footer class="mt-8 text-sm text-gray-400 opacity-80">
            © 2025 Admin Panel | Powered by Devil__King
        </footer>
    </div>

</body>
</html>
