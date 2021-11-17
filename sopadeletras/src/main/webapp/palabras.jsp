<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Backgroup Palabras</title>
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
	
	<div class="row w-100">
		<div class="col-md-8">
			<div id="timer">00</div>
			<div id='puzzle'></div>
		</div>
		<div id="completo" style="display: none"><strong>Todas las palabras encontradas! </strong>:</div>
			<div id="ajaxPuntaje"></div>
		
		<div class="col-md-4">
			<p>Encuentra las siguientes palabras:</p>
			<div id='words'></div>	
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
			let palabras=[];
			<c:forEach var="tempPalabras" items="${listaPalabras}">
				palabras.push("${tempPalabras.palabras}");
				<!--document.write("${tempPalabras.palabras} <br>");-->
			</c:forEach>
			
			
			<!-- Comprobar tiempo -->
			 
			 let timer = setInterval(juegoCompleto, 1000);

			 let tim = 0;

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