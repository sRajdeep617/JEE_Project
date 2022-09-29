<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMenu App</title>
</head>
<body>
<button style="color: white;" onclick="window.location.href='/'" class="btn btn-primary">Home Page</button>
<h1 style="text-align: center;">Welcome to Zwigato Order Menu</h1>
<br>
<div style="text-align: center;">
<button onclick="window.location.href='/order-section'" class="btn btn-primary">Search Order By User</button>
<button onclick="window.location.href='/order-by-id'" class="btn btn-primary">Search Order By Id</button>
<button onclick="window.location.href='/add-order'" class="btn btn-primary">Add Order</button>
<button onclick="window.location.href='/update-order'" class="btn btn-primary">Update Order</button>
</div>
</body>
</html>