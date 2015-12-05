<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.Order" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Orders</title>
</head>

<body>
	<div id = "container">
		<h1 style="text-align:left;float:left;">Users</h1> 
		<form action="loginSuccess.jsp" style="text-align:right;float:right;">
			<input type="submit" value="Home">
		</form>
		<hr style="clear:both;"/>
		
		<table>
		<%
		List<Order> orders;
		orders = (List)(request.getSession().getAttribute("orders"));
		
		if (orders != null){
		
		  for (Order o : orders){ 
		%>
		
			<tr>
			  <td><%=o.getOrderId()%></td>
			  <td><%=o.getCustomerId()%></td>
			  <td><%=o.getOrderDate()%></td>
			  <td><%=o.getOrderStatus()%></td>
			</tr>
		
		<% 
		  }
		}
		%>
		</table>
	</div>
</body>

</html>