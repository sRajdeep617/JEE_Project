<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderID</title>
<style type="text/css">
	table,tr,th,td{
	border: 2px solid blue;
	margin-left: auto;
	margin-right: auto;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<button style="color: white; background-color: red;" onclick="window.location.href='/'" class="btn btn-primary">Home Page</button>
<button style="color: white; background-color: red;" onclick="window.location.href='/order-menu'" class="btn btn-primary">Order Menu Page</button>
<table>
   	<thead>
   		<tr>
   			<th>Order Id</th>
   			<th>Product Id</th>
   			<th>User-name</th>
   		</tr>
   	</thead>
   	<tbody>
   	    <tr>
   			<td>${orders.orderId}</td>
   			<td>${orders.productId}</td>
   			<td>${orders.username}</td>
   		</tr>
   	</tbody>
   </table>
</body>
</html>