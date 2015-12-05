<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.Customer" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Users</title>
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
		List<Customer> customers;
		customers = (List)(request.getSession().getAttribute("customers"));
		
		if (customers != null){
		
		  for (Customer c : customers){ 
		%>
		
			<tr>
			  <td><%=c.getId()%></td>
			  <td><%=c.getUsername()%></td>
			  <td><%=c.getFirstName()%></td>
			  <td><%=c.getLastName()%></td>
			  <td><%=c.getPassword()%></td>
			</tr>
		
		<% 
		  }
		}
		%>
		</table>
	</div>
</body>

</html>