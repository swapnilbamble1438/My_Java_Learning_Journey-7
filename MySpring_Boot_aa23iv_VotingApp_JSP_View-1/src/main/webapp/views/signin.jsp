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
		
		<form:form action = "/dologin" method = "post">
			<h1>Signin</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   			<c:if test="${param.error != null }">
			<span style="color:red">Please enter correct Username or password</span><br><br>
			</c:if>
			
			
			<c:if test="${param.logout != null}">
				<span style="color:red">You are successfully logout...</span><br><br>
			</c:if>
			
			Email Id: <input type = "text" name = "username" placeholder="Enter Your Email Id" required><br><br>

			Password: <input type = "password" name= "password" placeholder="Enter Your Password" required><br><br>
			
			<input type = "submit" value="Signin">
   	
   
   	</form:form>
   	
   	<br>
<hr>
<div style="color: firebrick">
<h2>For Signing-in as a Admin </h2>
<h3>Use</h3>
<h3>Email Id: admin</h3>
<h3>Password: admin</h3>
</div>
   	</div>	
</body>
</html>