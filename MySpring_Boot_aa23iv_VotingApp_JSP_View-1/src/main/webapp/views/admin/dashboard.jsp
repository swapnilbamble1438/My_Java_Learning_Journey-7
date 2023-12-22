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
    
    
    <link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
</head>
<body>
<%@include file = "base.jsp" %>
		
		<div style="text-align: center">
		
			
			<h1>Admin Dashboard</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   			
   				
		<h3>Candidate 1 : Total Votes = <b style="color: limegreen"><span>${c1}</span></b></h3>
		<h3>Candidate 2 : Total Votes = <b style="color: limegreen"><span>${c2}</span></b></h3>
		<h3>Candidate 3 : Total Votes = <b style="color: limegreen"><span> ${c3}</span></b></h3>
		<h3>Candidate 4 : Total Votes = <b style="color: limegreen"><span> ${c4}</span></b></h3>
		
   
   	</div>	
</body>
</html>