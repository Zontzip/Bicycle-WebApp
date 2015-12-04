<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.Product" %>
<%@ page import="com.example.business.ShoppingCart" %>
<%@ page import="com.example.business.User" %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body bgcolor="#E6E6FA">

	<h1>Products</h1>
	<table>
		<tr>
		<td><b>Name</b></td>
		<td><b>Description</b></td>
		<td><b>Price</b></td>
		</tr>
		
		<%
		List<Product> products;
		products = (List)(request.getSession().getAttribute("products"));
		
		if (products != null){
			for (Product p : products) { %>
			<tr>
				<td><%=p.getProductName()%></td>
				<td><%=p.getProductDescription()%></td>
				<td><%=p.getProductPrice()%> Euro</td>
				<td><form action="FrontController" method="post">
				    <input type="hidden" name="action" value="AddToCart" />
				    <input type="hidden" name="itemIndex" value="<%=products.indexOf(p)%>" />
				<input type="submit" value="Add to Cart" />
	 			</form></td>
			</tr>	
			<% 
			}
		}
		%>
	</table>
	
	<h1>Shopping Cart</h1>
	<table>  
		<tr>
		<td>Name</td>
		<td>Description</td>
		<td>Price</td>
		</tr>	
		
		<% 
		User user = (User) (request.getSession().getAttribute("user"));
		ShoppingCart shoppingCart = user.getShoppingCart();
		List<Product> cartContents = new ArrayList<Product>();
		cartContents = shoppingCart.cartContents();

		for(Product p : cartContents) { %>
		<tr>
			<td><%=p.getProductName()%></td>
			<td><%=p.getProductDescription()%></td>	 
			<td><%=p.getProductPrice()%> Euro</td>
			<td><form action="FrontController" method="post">
			   	<input type="hidden" name="action" value="RemoveFromCart" />
				<input type="hidden" name="itemIndex" value="<%=cartContents.indexOf(p)%>" />	  	   
				<input type="submit" value="Remove from Shopping Cart" /></form>
			</td>
		</tr>
		<% } %>
		<tr><td>Total price: <%=shoppingCart.cartTotal()%> </td></tr>
	</table>
	
</body>
</html>