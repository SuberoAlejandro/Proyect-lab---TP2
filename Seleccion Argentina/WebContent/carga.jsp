<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="SeleccionadoArgentino.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
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
            type: 'POST',
            url: $(this).attr('action'),
            data: $(this).serialize(),
          
            success: function(data) {
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
				<div class="cabeza"><h1 align="center">Seleccionado Argentino de Basquetbol</h1></div>
				<div class="social"></div>
			</div>
		</header>

		<div class="entrada" align="center">
			<h2 align="center">Ingrese los jugadores</h2>
			<div class="contenedorform">
				 <form id="fo3" action="cargarjugadores" method="post" name="fo3">
					<table>
						<tr>
							<td width="13%"><label>Nombre</label></td>
							<td width="87%"><input type="text" name="nombre" id="nombre" placeholder="Ingrese nombre" required/></td>
						</tr>
						<tr>
							<td width="13%"><label>Apellido</label></td>
							<td width="87%"><input type="text" name="apellido" id="apellido" placeholder="Ingrese apellido" required /></td>
						</tr>
						<tr>
							<td width="13%"><label>Edad</label></td>
							<td width="87%"><input type="text" name="edad"  id="edad" placeholder="Ingrese edad" required/></td>
						</tr>
						<tr>
							<td width="13%"><label>Peso</label></td>
							<td width="87%"><input type="text" name="peso" id="peso" placeholder="Ingrese peso" required/></td>
						</tr>
						<tr>
							<td width="13%"><label>Altura</label></td>
							<td width="87%"><input type="text" name="altura" id="altura" placeholder="Ingrese altura" required/></td>
						</tr>
						<tr>
							<td><label>Posición</label></td> 
							<td><select name="posicion" id="posicion"> 
									<option value="Base">Base</option>
									<option value="Ayuda Base">Ayuda Base</option>
									<option value="Ala">Ala</option>
									<option value="Ala Pivot">Ala Pivot</option>
									<option value="Pivot">Pivot</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><div class="divbotones">
									<input type="submit" value="Guardar" />
									<input id="prodId" name="calificasion" id="calificasion" type="hidden" value="0">
									<input id="prodId" name="carga" id="carga" type="hidden" value="1">
									<input id="prodId" name="id" id="id" type="hidden" value="0">
									<input type="reset" value="Borrar" />
									<input type="button" value="Salir" onclick="location='index.jsp'"/>
								</div></td>
						</tr>
					</table>
				</form>
				<div class="password"> <a href="PasswordActualiza.jsp">Cambiar password</a></div>
			</div>
		</div>
	</div>
</body>
</html>