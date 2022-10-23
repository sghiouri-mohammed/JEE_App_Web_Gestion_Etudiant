<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Welcome Page </title>
</head>

<style>
	body{
        background-image: url('https://images.unsplash.com/photo-1484417894907-623942c8ee29?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2232&q=80');
        background-repeat: no-repeat;
        background-size: cover;
        
    }
	.hello-section{
        /* background-color:rgba(185, 149, 81, 0.702); */
        position: absolute;
        display: grid;
        grid-template-columns: auto;
        margin: auto;
        align-items: center;
        width: 40%;
        border-radius: 10px;
        margin-top: 300px;
        margin-left: 13%;
    }
    .grid-item-section{
        padding: 10px;
    }
    h3, h5{
        color: white;
        font-size: 30px;
        line-height:10px ;
    }
    span{
    	color:black;
    	
    }
    i{
    	font-size:50px;
    }
    footer {
	  position: fixed;
	  width: 100%;
	  left: 0;
	  bottom: 0;
	  padding:10px;
	}
</style>

<body>

		<%-- <%
			if(session.getAttribute("nom") == null || session.getAttribute("prenom") == null){
				response.sendRedirect("/tP1_JEE/Login");
			}
		%> --%>

		<header>
			<%@ include file='menu.jsp' %>
		</header>
		
		<div class="hello-section grid-section">
		    <div class="grid-item-section">
			    <c:if test="${nom != null && prenom != null }">
			    	<h3> <i>Welcome</i>  <span> <c:out value="${nom }"></c:out>  <c:out value="${prenom }"> </c:out> </h3></span>
			    </c:if>
			    <c:if test="${ empty nom  && empty prenom }">
			    	<h3> <i>Welcome</i>  </h3>
			    </c:if>
		        
		        <h5>This is a web JAV JEE Application</h5>
		    </div>
		
		</div>
		
		<%@ include file="footer.jsp" %>


</body>
</html>