<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.Product" %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body bgcolor="#E6E6FA">
	<h1>Products</h1>
	<table>
	<%
	List<Product> products;
	products = (List)(request.getSession().getAttribute("products"));
	
	if (products != null){
	
	  for (Product p : products){ 
	%>
	
		<tr>
		  <td><%=p.getProductId()%></td>
		  <td><%=p.getProductName()%></td>
		  <td><%=p.getProductDescription()%></td>
		  <td><%=p.getProductPrice()%></td>
		</tr>
		<form action="FrontController" method="post">
	     <input type="hidden" name="action" value="AddToCart" />
         <input type="submit" value="Add to Cart" />
    	</form>   
	
	<% 
	  }
	}
	%>
	</table>
</body>
</html>