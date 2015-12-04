<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.User" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<table>
	<%
	List<User> users;
	users = (List)(request.getSession().getAttribute("users"));
	
	if (users != null){
	
	  for (User u : users){ 
	%>
	
		<tr>
		  <td><%=u.getId()%></td>
		  <td><%=u.getUsername()%></td>
		  <td><%=u.getFirstName()%></td>
		  <td><%=u.getLastName()%></td>
		  <td><%=u.getPassword()%></td>
		</tr>
	
	<% 
	  }
	}
	%>
	</table>
</body>

</html>