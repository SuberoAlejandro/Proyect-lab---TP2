
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calificasion de jugadores</title>
<meta name="keywords" content="html5, css3, Javacript, diseño web" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link rel="stylesheet" href="clinificar.css">
</head>
<body class="body">

	<script>
		$(document).ready(function() {

			$().ajaxStart(function() {
				$('#loading').show();
				$('#result').hide();
			}).ajaxStop(function() {
				$('#loading').hide();
				$('#result').fadeIn('slow');
			});

			$('#form, #fat, #fo3').submit(function() {

				$.ajax({
					type : 'POST',
					url : $(this).attr('action'),
					data : $(this).serialize(),

					success : function(data) {
						$('#result').html(data);
					}
				})
				return false;
			});
		})
	</script>

	<div class="padre">
		<header class="header">
			<div class="menu">
				<div class="logo"></div>
				<div class="cabeza">
					<h1 align="center">Seleccionado Argentino de Basquetbol</h1>
				</div>
				<div class="social"></div>
			</div>
		</header>

		<div class="entrada" align="center">
			<h2 align="center">Director tecnico de la selección Calificasión de Jugadores</h2>
			<div class="contenedorform">

				<table border="1" class="tablas">
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
							<td>${items.nombre}</td>
							<td>${items.apellido}</td>
							<td>${items.edad}</td>
							<td>${items.peso}</td>
							<td>${items.altura}</td>
							<td>${items.posicion}</td>
							<td align="center">
							    <form id="fo3" action="cargarjugadores" method="post" name="fo3">
									    <input type="text" name="calificasion" id="nombre" placeholder="${items.calificasion}" /> 
										<input id="prodId" name="nombre" id="nombre" type="hidden" value="${items.nombre}"> 
										<input id="prodId" name="apellido" id="apellido" type="hidden" value="${items.apellido}"> 
										<input id="prodId" name="edad" id="edad" type="hidden" value="${items.edad}">
									    <input id="prodId" name="peso" id="peso" type="hidden" value="${items.peso}"> 
									    <input id="prodId" name="altura" id="altura" type="hidden" value="${items.altura}"> 
									    <input id="prodId" name="posicion" id="posicion" type="hidden" value="${items.posicion}">
									    <input id="prodId" name="id" id="id" type="hidden" value="${items.id}"> 
									    <input id="prodId" name="carga" id="carga" type="hidden" value="0">
									    <input type="submit" value="Guardar" />
								</form></td>
						</tr>
					</c:forEach>
				</table>
				<div class="colunna">
					<input type="button" value=" Menu de inicio" onclick="location='cargadedatos.jsp'" id="lista" class="boton" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>