<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Palabras</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">   		
	<script src="js/bootstrap.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	<script src="js/app-ajax.js" type="text/javascript"></script>
	
	
</head>
<body>
<h1>Palabras JSP</h1>
	

	<h2>Bienvenid@: <%= session.getAttribute("nombre") %></h2>
	
	
<div class="container">

	<div class="col-md-4">
		<p>Encuentra estas palabras:</p>
		<div id='palabras'></div>
			
	</div>
	
</div>	

<script>

			var palabras=[];
			<c:forEach var="tempPalabras" items="${listaPalabras}">
			
				<!-- palabras.push("${tempPalabras.palabras}";-->
				document.write("${tempPalabras.palabras} <br>");
			</c:forEach>
			

</script>

</body>
</html>