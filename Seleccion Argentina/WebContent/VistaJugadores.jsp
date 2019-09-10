<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de jugadores</title>
<meta name="keywords" content="html5, css3, Javacript, diseño web" />
<link rel="stylesheet" href="clinificar.css">
</head>
<body>



	<div class="padre">
		<header class="header">
			<div class="menu">
				<div class="logo"></div>
				<div class="cabeza"><h1 align="center">Seleccionado Argentino de Basquetbol</h1></div>
				<div class="social"></div>
			</div>
		</header>
		<div class="entrada" align="center">
		<h2 align="center">Director tecnico de la selección Calificasión de Jugadores</h2>
		<div class="contenedorform">
				
				<p><%out.print(request.getAttribute("mensaje")); %></p>
				
				
				<table class="table">
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th>Peso</th>
						<th>Altura</th>
						<th>Posición</th>
						<th>Calificasión</th>
					</tr>
					<c:forEach var="items" items="${jugadores}">
						<tr>
							<td align="center">${items.nombre}</td>
							<td align="center">${items.apellido}</td>
							<td align="center">${items.edad}</td>
							<td align="center">${items.peso}</td>
							<td align="center">${items.altura}</td>
							<td align="center">${items.posicion}</td>
							<td align="center">${items.calificasion}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="table">
					<input type="button" value=" Seleción de posición" onclick="location='PresentaJugadores.jsp'" id="lista" class="boton" />
					<input type="button" value="Salir" onclick="location='index.jsp'" id="salir" class="boton" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
