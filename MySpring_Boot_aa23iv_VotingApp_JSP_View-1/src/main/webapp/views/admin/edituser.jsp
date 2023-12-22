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
    
    <link rel="stylesheet" href="/resources/css/style.css" />
	<link rel="stylesheet" href="/resources/css/bootstrap.css" />
	<link rel="stylesheet" href="/resources/css/bootstrap2.css" />
	<link rel="stylesheet" href="/resources/css/table.css" />

</head>
<body>
<%@include file = "base.jsp" %>
		
		<div style="text-align: center">
		
			
			<h1>Update User</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   				<form:form action="/admin/updateuser" method="post" object="${user}">
    					
    					<input type="hidden" value="${user.id}" name="id">
    					
    				
    						Enter Name:
    						<input type="text" name="name" value="${user.name}"
    						class="form-control" required>
    				
    					<br><br>
    						
    						Enter Password:
    						<input type="text" name="password" value="${user.password}"
    						class="form-control" required>
    				
    					<br><br>
    					
							Enter Email:
    						<input type="email" name="email" value="${user.email}"
    						class="form-control" required>
    				
    					<br><br>
    						
    						Enter Phone No:
    						<input type="number" name="phone" value="${user.phone}"
    						class="form-control" required>
    					
    					<br><br>
    					
    						<input type = "submit" value="Update">
    				
    				
    				</form:form>
   			
   			
   		
   		
   		
   		
   	</div>	
</body>
</html>