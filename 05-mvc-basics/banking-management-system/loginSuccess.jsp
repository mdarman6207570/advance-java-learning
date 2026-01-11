<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
    <style>
        body {
            background: #f0f6fa;
            font-family: Arial, sans-serif;
        }
        .success-container {
            background: #fff;
            border-radius: 8px;
            padding: 32px 40px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.09);
            max-width: 380px;
            margin: 80px auto;
            text-align: center;
        }
        h1 {
            color: #205a8e;
        }
        .welcome {
            margin-top: 18px;
            color: #3091d1;
        }
        .link-btn {
            display: inline-block;
            margin-top: 24px;
            padding: 10px 28px;
            background: #3091d1;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
        }
        .link-btn:hover {
            background: #225b88;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h1>Login Successful!</h1>
        <% 
            String holderName = (String) session.getAttribute("holderName");
            if(holderName != null){
        %>
            <div class="welcome">
                Welcome, <strong><%= holderName %></strong>!
            </div>
        <% 
            } 
        %>
        <a href="application.html" class="link-btn">Go to Application</a>
    </div>
</body>
</html>
