<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sopa de Letras</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">   		
	<script src="js/bootstrap.min.js"></script>  
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2 id="titulo">Sopa de letras BackGroup</h2>

		<form action="LoginServlet" method="post">
			<input type="text" name="nombre" placeholder="Nombre" required autofocus/> 
			<input type="text" name="contrasena" placeholder="Contrasena" required/> 
			<button id="enviar name="enviar" "type="submit" class="btn">Enviar</button>
		</form>

</body>
</html>