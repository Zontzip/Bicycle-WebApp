<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.Product" %>
<%@ page import="com.example.business.ShoppingCart" %>
<%@ page import="com.example.business.CartItem" %>
<%@ page import="com.example.business.User" %>
	
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Products</title>
</head>
<body>
	<div id = "Container">
		<h1>Products</h1>
		<table>
			<tr>
			<td><b>Name</b></td>
			<td><b>Description</b></td>
			<td><b>Price</b></td>
			<td><b>Quantity</b></td>
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
						<input type="text" name = "quantity" maxlength = "2" size = "1" value = "0" style="text-align:center;" />
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
			<td><b>Name</b></td>
			<td><b>Description</b></td>
			<td><b>Price</b></td>
			<td><b>Quantity</b></td>
			</tr>	
			
			<% 
			User user = (User) (request.getSession().getAttribute("user"));
			ShoppingCart shoppingCart = user.getShoppingCart();
			List<CartItem> cartContents = new ArrayList<CartItem>();
			cartContents = shoppingCart.cartContents();
			Product p;
			// Iterate through item lines in cart, for each item line get item and quantity
			for(CartItem ci : cartContents) { 
				p = (Product) ci.getProduct(); %>
				<tr>
					<td><%=p.getProductName()%></td>
					<td><%=p.getProductDescription()%></td>	 
					<td><%=p.getProductPrice()%> Euro</td>
					<td style="text-align:center;"><%=ci.getProductQuantity()%></td>
					<td><form action="FrontController" method="post">
					   	<input type="hidden" name="action" value="RemoveFromCart" />
						<input type="hidden" name="itemIndex" value="<%=cartContents.indexOf(ci)%>" />	  	   
						<input type="submit" value="Remove" /></form>
					</td>
				</tr>
			<% } %>
			<tr><td><b>Total price: </b><%=shoppingCart.cartTotal()%> Euro</td></tr>
		</table>
	</div>
</body>
</html>