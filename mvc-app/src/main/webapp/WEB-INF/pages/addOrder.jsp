<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<button onclick="window.location.href='/'" class="btn btn-primary">Home Page</button>
<button onclick="window.location.href='/order-menu'" class="btn btn-primary">Order Menu Page</button>
	<div style="text-align: center;">
	<h3>Add Order Details</h3>
	<form:form method="post" modelAttribute="command" action="/add-order/saved">
        <div>
            <label>Order Id</label>&nbsp;&nbsp;
            <form:input path="orderId"  id="orderId" />
        </div>
        <div>
            <label>Product Id</label>&nbsp;
            <form:input path="productId" id="productId" />
        </div>
        <div>
            <label>User-Name</label>&nbsp;
            <form:input path="username" id="username" />
        </div>
        
        <div>
            <input type="submit" value="Add">
        </div>
    </form:form>
    </div>
</body>
</html>