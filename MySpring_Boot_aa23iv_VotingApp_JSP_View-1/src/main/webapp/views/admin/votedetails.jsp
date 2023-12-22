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
		
			
			<h1>Candidate's Vote Details</h1>
			
			<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   			
   			
   		<div class="table-responsive">

<table >
    <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Candidate 1 Votes</th>
      <th scope="col">Candidate 2 Votes</th>
      <th scope="col">Candidate 3 Votes</th>
      <th scope="col">Candidate 4 Votes</th>
      <th scope="col">Actions</th>
    </tr>
 </thead>
<tbody>

  <c:forEach items="${candidates}" var="e">
    <tr>
      <td style="background-color:#ebe9eb">Voters</td>
      <td> ${e.candidate1}</td>
      <td> ${e.candidate2}</td>    
      <td> ${e.candidate3}</td>    
      <td> ${e.candidate4}</td>   
        <td>
      	<a href="/admin/deletecandidate/${e.id}"><img src= "../resources/image/delete.jpg" style="height:25px" alt="Delete"></a>
      </td>  
    </tr>
    </c:forEach>
    
    <tr>
      <td style="background-color:#ebe9eb">Total Votes</td>
      <td scope="col"><p>${c1}</p></td>
      <td scope="col"><p>${c2}</p></td>
      <td scope="col"><p>${c3}</p></td>
      <td scope="col"><p>${c4}</p></td>
    </tr>
 </tbody>
 
</table>
  
</div>
    
   		
   		
   		
   	</div>	
</body>
</html>