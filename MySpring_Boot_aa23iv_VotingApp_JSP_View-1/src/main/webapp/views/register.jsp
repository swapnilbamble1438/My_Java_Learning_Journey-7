<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 
<%@ page isELIgnored= "false" %>

    <!-- jstl uri -->
   <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>




<!--responsive purpose  -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    
    <link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body>
<%@include file = "base.jsp" %>
			
			
		<div style="text-align: center">
		
			
			<h1>User Registration</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   			
   			<form:form action="createuser" method="post">
	
			
			User Name: <input type = "text" name = "name" placeholder="Enter Your User Name" required><br><br>
			
			Password: <input type = "password" name= "password" placeholder="Enter Your Password" required><br><br>
			
			Email Id: <input type = "text" name= "email" placeholder="Enter Your Email Id" required><br><br>
			
			Phone No: <input type = "number" name= "phone" placeholder="Enter Your Phone No" required><br><br>
			
			
			<input type = "submit" value="Signup">
			
		
		</form:form>
   
   	</div>	



</body>
</html>