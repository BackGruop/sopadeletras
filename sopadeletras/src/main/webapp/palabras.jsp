<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<h1 class="display-1">Backgroup Palabras</h1>

<!-- Importamos librerias de estilos -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/wordfind.css">

<!-- Importamos librerias JS juego y jquery -->
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/wordfind.js"></script>
<script src="js/wordfindgame.js"></script>
</head>

<body>
	<!-- Bienvenida importamos nombre de usuario -->
	<h3 class="display-4">
		Bienvenid@:	<%=session.getAttribute("nombre")%></h3>

	<div class="container">
		<div class="row w-100">
			<!-- Creamos contador e importamos el juego de puzzle -->
			<div class="col-md-8">
				<p>Tiempo:</p>
				<div id="timer">00</div>
				<div id='puzzle'></div>
			</div>

			<!-- Mensaje con la finalizacion de la partida utilzando ajax-->
			<div id="completo" style="display: none">
				<strong>Todas las palabras encontradas! </strong>:
			</div>
			<div id="ajaxPuntaje"></div>

			<!-- Muestra la lista de las palabras  -->
			<div class="col-md-4">
				<p>Encuentra las siguientes palabras:</p>
				<div id='words'></div>
			</div>

			<!-- Botones para salir del juego o reiniciar la partida -->
			<div class="row w-100">
				<div class="col-md-5 text-center">
					<form method="get" action="inicio.jsp">
						<input type="submit" value="Salir" class="btn btn-danger btn-lg">

						<button type="submit" onClick="refreshPage()"
							class="btn btn-danger btn-lg">Reiniciar</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>

			<!-- Reiniciar partida, refrescar pagina -->
			function refreshPage(){
			    window.location.reload();
			}

			<!-- Obtienendo la lista de palabras a travez de Servlet -->
			let palabras=[];
			<c:forEach var="tempPalabras" items="${listaPalabras}">
				palabras.push("${tempPalabras.palabras}");
				<!--document.write("${tempPalabras.palabras} <br>");-->
			</c:forEach>
			
			<!-- Comprobar tiempo -->
			 let timer = setInterval(juegoCompleto, 1000);
			 let tim = 0;
	
			 <!-- Comprobamos si se ha comppletado el puzzle -->
			 function juegoCompleto(){
			 	var l = document.getElementById("timer");
			 	l.innerHTML = tim;
			 	if ($('.puzzleSquare').hasClass('complete')){
			 		muestraPuntaje();
			 	}
			 	tim++
			 }
			 
		<!-- AJAX Muestra puntaje al completar todas las palabras -->
					var muestraPuntaje = function() {
			 		$.ajax({
			 			type: "GET",
			 			url : 'PuntosServlet',
			 			data: {tiempo: tim},
			 			success : function(responseText) {
			 				$('#ajaxPuntaje').text(responseText);
			 				<!-- Muestra mensaje juego completo -->
			 				$('#completo').show();
			 			}
			 		});
			 		clearInterval(timer);
			 	};

			<!-- Juego function -->			
			let puzzle = wordfind.newPuzzle(palabras, {
			    height: 10,
			    width: 10,
			    fillBlanks: false
			});

			 let gamePuzzle = wordfindgame.create(palabras, '#puzzle', '#words');			  
			 $('#solve').click(function() {
			  <!--clearInterval(timer);-->
			     wordfindgame.solve(gamePuzzle, palabras);
			 });       
</script>
</body>
</html>