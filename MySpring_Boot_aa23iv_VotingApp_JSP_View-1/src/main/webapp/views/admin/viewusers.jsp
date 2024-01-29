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
    
    
  <link rel="stylesheet" href="../resources/css/style.css" />
	<link rel="stylesheet" href="../resources/css/bootstrap.css" />
	<link rel="stylesheet" href="../resources/css/bootstrap2.css" />
	<link rel="stylesheet" href="../resources/css/table.css" />
</head>
<body>
<%@include file = "base.jsp" %>
		
		<div style="text-align: center">
		
			
			<h1>All Voter's Details</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   			
   		<div class="table-responsive">
<table>

    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Password</th>
      <th scope="col">Email</th>
      <th scope="col">Phone No.</th>
      <th scope="col">Actions</th>
    </tr>
 
	<c:forEach items="${users}" var="e">
    <tr>
      <td> ${e.id}</td>
      <td> ${e.name}</td>
      <td> ${e.password}</td>    
      <td> ${e.email}</td>    
      <td> ${e.phone}</td>   
        <td>
      	<a href="/admin/edituser/${e.id}"><img src="../resources/image/update.png" style="height:25px" alt="Update"></a>
      	<a href="/admin/deleteuser/${e.id}"><img src= "../resources/image/delete.jpg" style="height:25px" alt="Delete"></a>
      </td>  
    </tr>
    </c:forEach>
 
</table>
  </div>

   		
   		
   		
   		
   	</div>	
</body>
</html>