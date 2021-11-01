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

<c:forEach var="tempPalabras" items="${listaPalabras }">

${tempPalabras}<br>
</c:forEach>


</body>
</html>