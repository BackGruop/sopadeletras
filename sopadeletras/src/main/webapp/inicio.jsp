<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<h1 class=display-2>Sopa de Letras</h1>
	<link rel="stylesheet" href="css/bootstrap.min.css">   		
	<script src="js/bootstrap.min.js"></script>  
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h3 class="display-4">Sopa de letras BackGroup</h3>
	<div class="container">
		<form action="LoginServlet" method="post">
			<label>Nombre</label>
			<input type="text" name="nombre"> 
			<label>Contraseña</label>
			<input type="text" name="contrasena"> 
			<button type="submit">Enviar</button>
		</form>
	</div>
</body>
</html>