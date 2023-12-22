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
		
			
			<h1>User Dashboard</h1>
			
		<!--  content start -->	
		
		
		
		<div class="container">
  
  <div class="layout">

		<div class = "col col-main">
		
		
   		
   		<!-- 1st Col Start -->
		
		<table>
						<h2>User Details:</h2>
							<img src="../resources/image/user.png" height="125px" alt="User Icon">
							
					</table>
						
						<table border = '1' align='center'>
							
							<tr>
								<th>Id: </th>
							<th> <h4>${user.id}</h4></th>
							</tr>
							
							<tr>
								<th>Name: </th>
								<th> <h4>${user.name}</h4></th>
							</tr>
							
						
								<tr>
									<th>Email Id: </th>
									<th><h4>${user.email}</h4> </th>
								</tr>
					
								<tr>
									<th>Phone No.: </th>
									<th><h4>${user.phone}</h4> </th>
								</tr>
								
								<tr>
									<th>Status.: </th>
									<th><h4>${status}</h4> </th>
								</tr>

								
				
						</table>
		
		<!-- 1st Col End  -->
		
		</div>
	
	<div class = "col col-complementary">

<!-- 2nd Col start -->

<form:form action = "/addcandidate" method ="post">

<c:if test="${msg != null}">
			<h3 style="color:red"> ${msg} </h3>
			<% session.removeAttribute("msg"); %>
   			</c:if>
   		
		
 <h4 style="color:red">${user.name} </h4> 

	Do Voting<br>
	
	<input value="${user.email}" name = "email" type="hidden" >
 <br>
 <input type="radio" name="candidate"  value ="candidate1" required>Candidate 1  <br><br>
  <input type="radio" name="candidate"  value = "candidate2" required>Candidate 2 <br><br>
  <input type="radio" name="candidate"  value = "candidate3" required>Candidate 3 <br><br>
  <input type="radio" name="candidate"  value = "candidate4" required>Candidate 4 <br><br>
    
    <br>
 


<input type = "submit" value="Vote">

</form:form>

<!-- 2nd Col End -->

</div>
</div>
</div>
		
			
			
			
			
			
			
   <!-- content end -->
   	</div>	
</body>
</html>