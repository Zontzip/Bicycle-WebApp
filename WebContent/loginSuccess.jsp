<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Home Page</title>
</head>

<body>
	<div id = "container">
		<h1 style="text-align:left;float:left;">Welcome</h1> 
		<form action="loginSuccess.jsp" style="text-align:right;float:right;">
			<input type="submit" value="Home">
		</form>
		<hr style="clear:both;"/>
		
		<c:set var="customer" value="${sessionScope.customer}"/>
		<b>Hello <c:out value="${customer.firstName}"/>, you are now logged in...</b>
		<b>What would like to do?</b>
		
		<br/><br/>
		
		<form action="FrontController" method="post">
		     <input type="hidden" name="action" value="ListCustomers" />
	         <input type="submit" value="List Customers" />
	    </form>
	    
	    <br/><br/>
	    
	    <form action="FrontController" method="post">
		     <input type="hidden" name="action" value="ListProducts" />
	         <input type="submit" value="View Products" />
	    </form> 
	    
	    <br/><br/>
	    
	    <form action="FrontController" method="post">
			 <input type="hidden" name="action" value="ListCartItems" />
		     <input type="hidden" name="action" value="ListOrders" />
	         <input type="submit" value="View Orders" />
	    </form> 
	    
	    <br/><br/>
	    
	    <form action="login.html" method="post">
	         <input type="submit" value="Sign Out" />
	    </form> 
	</div>        		
</body>

</html>