<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<title> Liste des Users </title>
</head>
<style> th{text-align:center;} tr:nth-child(2n+1){ background-color:aliceblue}; </style>
<body style="padding:20px;">

	<h2> La liste des Users : </h2>
	<hr> <br> <br>

	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">id</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Login_id</th>
	      <th scope="col">Birthday</th>
	      <th scope="col">Phone Number</th>
	      <th scope="col">Modify</th>
	      <th scope="col">Delete User</th>
	      
	    </tr>
	  </thead>
	  
	  <% int i = 0; %>
	  
	  <tbody>
	  <c:forEach var="user" items="${users}">
	  	<tr>
	      <th scope="row"> <c:out value="${ user.id }"> </c:out></th>
	      <td align="center"> <c:out value="${ user.fname}"> </c:out> </td>
	      <td align="center"><c:out value="${user.lname }"> </c:out></td>
	      <td align="center"><c:out value="${user.login }"> </c:out></td>
	      <td align="center"><c:out value="${user.dob }"> </c:out></td>
	      <td align="center"><c:out value="${user.mobile }"> </c:out></td>
	      <td align="center"> 
		      <a href="http://localhost:8080/tP1_JEE/Modifyservlet?id=${user.id}">  
			      	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-app-indicator" viewBox="0 0 16 16">
		  				<path d="M5.5 2A3.5 3.5 0 0 0 2 5.5v5A3.5 3.5 0 0 0 5.5 14h5a3.5 3.5 0 0 0 3.5-3.5V8a.5.5 0 0 1 1 0v2.5a4.5 4.5 0 0 1-4.5 4.5h-5A4.5 4.5 0 0 1 1 10.5v-5A4.5 4.5 0 0 1 5.5 1H8a.5.5 0 0 1 0 1H5.5z"/>
		  				<path d="M16 3a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
				    </svg> 
			   </a>
	      </td>
	      <td align="center"> 
	      	<a href="http://localhost:8080/tP1_JEE/DeleteServlet?id=${user.id}"> 
		      	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
	  				<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
				</svg> 
			</a>
		  </td>
	    </tr>
	  </c:forEach>
	    
	    
	  </tbody>
	</table>

</body>
</html>