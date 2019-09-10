<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar de usuarios</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link rel="stylesheet" href="clinificar.css">
</head>
<body>

<script>
		function enviar() {
			var email = document.getElementById('email').value;
			var password = document.getElementById('password').value;
			var tarea = document.getElementById('tarea').value;
			var dataen = '&email=' + email + '&password=' + password+'&tarea='+tarea;

			$.ajax({
				type : 'post',
				url : 'registro',
				data : dataen,
				success : function(resp) {
					$("#respa").html(resp);
				}
			});
			return false;
		}
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
                <h2 align="center">Ingrese los datos de para actualizar el password</h2>
            </div>
    
            <div class="login" align="center" >

	<form method="post" onsubmit="return enviar();">
		<input type="email" name="email" id="email" placeholder="Ingrese email" required/><br>
		<br> 
		<input type="password" name="password" id="password" placeholder="Ingrese password" required/>
		<br> 
		
		<input id="tarea" name="tarea" id="tarea" type="hidden" value="cambiar">		
        <br>
            <input type="submit" value="Guardar" class="boton"/> 
			<input type="reset" value="Borrar" class="boton" /> 
			<input type="button" value="Salir" onclick="location='index.jsp'" class="boton"/>
		
    </form>
</div>
</div>
</body>
</html>