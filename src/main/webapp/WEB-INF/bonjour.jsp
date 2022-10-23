<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<title>bonjour</title>
</head>
<style>

	body{
		padding:20px;
	}
	.div-form{
		display:float;
		margin:auto;
		margin-top: 15%;
		width:40%;
		background-color: cornsilk;
		padding:20px;
		border-radius:40px;
		height:60%;
		font-size:15px;
	}
	
</style>
<body>
	<%@ include file="menu.jsp" %>
	
	<p> Ceci est paragraphe de la  page d'acceuil </p>
	
	<div class="div-form">
		
		<h3 style="text-align:center;"> Se connecter </h3>
	
		<form action="" method="POST">
			  <div class="form-group">
			    <label for="exampleInputEmail1"> Nom</label>
			    <input type="text" class="form-control" name="nom"  placeholder="Enter name">
			    <br>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Prenom</label>
			    <input type="text" class="form-control" name="prenom"  placeholder="prenom">
			  </div>
			  <br>
			  <button type="submit" class="btn btn-primary">Submit</button>
			  <br>
  		</form>
  		
	</div>
	
	<c:forEach var="utilisateur" items="${ utilisateurs }">
		<p> 
			<c:out value="${ utilisateur.nom }"/>
			<c:out value="${ utilisateur.prenom }"/> 
		</p>
		<p>  </p>
	</c:forEach> 
	

</body>
</html>