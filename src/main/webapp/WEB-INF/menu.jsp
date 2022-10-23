<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<style>
	.grid-container {
        display: grid;
        grid-template-columns: auto 20% auto auto auto auto auto;
        padding: 10px;
        position: fixed;
	    width: 100%;
	    left: -10px;
	    top: -10px;
        margin-right: 10px;
    }

    .grid-item {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 14px;
        font-size: 30px;
        text-align: center;
        font-family:serif;
        transition: all 1s ease;;
    }
    .hov:hover{
        background-color: burlywood;
    }
    a{
    text-decoration:none;
    color:black;
    
    }
    .hov{
    	font-size:23px;
    }
    .name{
    	font-family:monospace;
    }
</style>


<nav class="grid-container">
    <div class="grid-item name "> 
    	<c:if test="${nom == null || prenom == null }">
    		<c:out value="Welcome Page"></c:out> 
	    </c:if>
	    <c:if test="${nom != null && prenom != null}">
	    	<c:out value="${nom }"></c:out> 
    		<c:out value="${prenom }"> </c:out>
	    </c:if>
    	 
    </div>
    
    <div class="grid-item"></div>
    <div class="grid-item"></div>
    <div class="grid-item hov"><a href="Welcome">Home</a></div>
    <div class="grid-item hov"><a href="#">About</a></div>
    <div class="grid-item hov"><a href="">Contact Me</a></div>
    <c:if test="${nom == null || prenom == null }">
    	<div class="grid-item hov"><a href="Login">Log in</a></div>
    </c:if>
    <c:if test="${nom != null && prenom != null}">
    	<div class="grid-item hov"><a href="Logout">Log out</a></div>
    </c:if>
</nav>


