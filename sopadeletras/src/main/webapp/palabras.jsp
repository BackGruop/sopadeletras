<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Palabras</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">   		
	<script src="js/bootstrap.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/wordfind.css">	
	
	
	<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	<script src="js/wordfind.js"></script>
    <script src="js/wordfindgame.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	
	
</head>

<body>

<h2>Bienvenid@:<%= session.getAttribute("nombre") %></h2>


<div class="container">
	
		<!--  <div class="col-md-4 text-center">
			<button type="button" id="solve" class="btn btn-warning btn-lg">Resolver</button>
		</div>
		
	<div class="alert alert-success text-center fade" role="alert" id="puntosAlert">
		<p>¡¡Enhorabuena!! Se ha guardado tu puntuación de <strong><span id="puntos"></span></strong></p>			
		<form><input type="submit" value="jugar de nuevo" class="btn btn-dark"></form>
	</div>
	-->	
	
	<div class="row w-100">
		<div class="col-md-8">
			<div id="timer">00</div>
			<div id='puzzle'></div>
		</div>
		

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
		
		<div class="col-md-4">
			<p>Encuentra las siguientes palabras:</p>
			<div id='words'></div>
			<!--  <div id="puntuacion"></div>-->	
			<div class="row w-100">
				<div class="col-md-4 text-center">
					<form method="get" action="inicio.jsp">
					<input type="submit" value="Salir" class="btn btn-danger btn-lg">
					</form>
					<button type="submit" onClick="refreshPage()" class="btn btn-danger btn-lg">Reiniciar</button>
					
				</div>
			</div>
		</div>
	</div>
</div>	

<script>
			<!-- Reiniciar -->
			function refreshPage(){
			    window.location.reload();
			}
			<!-- Obtienendo la lista de palabras -->
			var palabras=[];
			<c:forEach var="tempPalabras" items="${listaPalabras}">
				palabras.push("${tempPalabras.palabras}");
				<!--document.write("${tempPalabras.palabras} <br>");-->
			</c:forEach>
			
			<!-- Juego function app-ajax -->
			
			var puzzle = wordfind.newPuzzle(palabras, {
			    height: 10,
			    width: 10,
			    fillBlanks: false
			});
			   
			 var gamePuzzle = wordfindgame.create(palabras, '#puzzle', '#words');
			  
			 $('#solve').click(function() {
			 <!-- clearInterval(timer);-->
			     wordfindgame.solve(gamePuzzle, palabras);
			 });
			 
			 <!-- Comprobar tiempo -->
			 
			 var timer = setInterval(voyComprobando, 1000);
			 var t = 0;
			 function voyComprobando(){
			 	var l = document.getElementById("timer");
			 	l.innerHTML = t;
			 	if ($('.puzzleSquare').hasClass('complete')){
			 		hasAcertado();
			 	}
			 	t++
			 }

			$(document).ready(function() {
			 	$('#userName').blur(function() {
			 		$.ajax({
			 			url : 'GetUserServlet',
			 			data : {
			 				userName : $('#userName').val()
			 			},
			 			success : function(responseText) {
			 				$('#ajaxGetUserServletResponse').text(responseText);
			 			}
			 		});
			 	});
			 });
			
	            
</script>

</body>
</html>