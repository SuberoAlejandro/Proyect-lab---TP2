
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords" content="html5, css3, Javacript, diseño web" />
<link rel="stylesheet" href="clinificar.css">

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
		
		<div class="div" align="center">
						<h2>Selecione una posición a mostrar</h2>
			
			<form id="fo3" action="vistacontrol" method="post" name="fo3">
				<table class="table">
					
					<tr>
						<td align="center" ><label >Posición</label></td>
						<td align="center">
						<select name="posicion" id="posicion">
								<option value="Base">Base</option>
								<option value="Ayuda Base">Ayuda Base</option>
								<option value="Ala">Ala</option>
								<option value="Ala Pivot">Ala Pivot</option>
								<option value="Pivot">Pivot</option>
								<option value="Todas">Todas</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						
						<input name="vista" id="vistas" type="hidden" value="0">
						<input type="submit" value="Ver jugadores"	id="lista" class="boton"/>
						
						</td>
					</tr>
				</table>
			</form>
		</div>

		
<!-- 				<div class="colunna"> -->
<!-- 					<input type="button" value=" Menu de inicio" onclick="location='cargadedatos.jsp'" id="lista" class="boton"/> -->
<!-- 				</div> -->
			</div>
</body>
</html>