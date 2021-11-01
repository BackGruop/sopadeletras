<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Palabras</title>
</head>
<body>
<h1>Palabras JSP</h1>
<script>

var palabras=[];
<c:forEach var="tempPalabras" items="${listaPalabras}">
//palabras.push(${tempPalabras}.id);
alert(${tempPalabras});
//${tempPalabras}<br>
</c:forEach>
console.log(palabras);
</script>

</body>
</html>