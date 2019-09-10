<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="iso-8559-1" />
<meta name="keywords" content="html5, css3, Javacript, diseño web"/>
<title>Carga de Jugadores</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link rel="stylesheet" href="calificaEstilos.CSS">
</head>

<body class="body">


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
			<h2 align="center">Director tecnico de la selección Argentina</h2>
			<div class="contenedorform">

				<div class="colunna">
					<table class="tabla">
						<tr>
							<td colspan="2" align="center" width="200px">
							
							<form name="fo3" action="vistacontrol" method="post" id="fo3">
							<input id="prodId" name="vista" id="vistas" type="hidden" value="1">
							<input type="submit" value="Calificar Jugadores" id="califica" class="boton" />
							</form> 
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center" width="200px">
							<form name="fat" action="vistacontrol" method="post" id="fat">
							<input id="prodId" name="vista" id="vistas" type="hidden" value="0">
							<input id="prodId" name="posicion" id="vistas" type="hidden" value="no">
							<input type="submit" value="Lista de Jugadores" id="vista" class="boton" />
							
							</form> 
							
							</td>
						</tr>
						<tr>
					</table>
					<div class="password"> <a href="PasswordActualiza.jsp">Cambiar password</a></div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>


