<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ventana de logueo</title>
<meta name="keywords" content="html5, css3, Javacript, diseño web" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<link rel="stylesheet" href="clinificar.css">
<script type="text/javascript">

			function revisar(elemento){
				if(elemento.value==''){
					elemento.className='error';
				}else{
					elemento.className='input';
				}
			}
			
			function revisaLongitud(elemento, min){
				if(elemento.value!==''){ 
					var data = elemento.value;
					if(data.length<min){
						elemento.className='error';
					}else{
						elemento.className='input';
					}
				}
			}

			function revisarEmail(elemento){
				if(elemento.value!==''){
					var data = elemento.value;
					var exp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
					if(!exp.test(data)){
						elemento.className='error';
					}else{
						elemento.className='input';
					}	
				}
			}
			

			function validar(){
				var datosCorrectos=true;
				var error="";
				if(document.getElementById("password").value==""){
					datosCorrectos=false;
					error="\n Esta Vacio";
				}
				
				if(document.getElementById("email").value==""){
					datosCorrectos=false;
					error="\n Debes Poner Un correo";
				}
				
				
				var exp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

				if(!exp.test(document.getElementById("email").value)){
					datosCorrectos=false;
					error="\n Email Invalido";
				}
				

				if(!datosCorrectos){
					alert('Hay Errores En El formulario'+error);
				}
				
					
				 return enviar();
			}



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



</head>

<body>


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
			<h2 align="center">Ingrese los datos de para Registrarse</h2>
        </div>

        <div class="login" align="center" >
        <h2>Verificacion de identidad</h2>
                <br>
                <form action="salve" method="post"  onsubmit="return validar()">

                <input type="email" name="email" id="email"  class="input" placeholder="Ingrese email" onblur="revisar(this); revisarEmail(this)" onkeyup="revisar(this); revisarEmail(this)" autocomplete="off" required /><br>
                <br> 
                <input type="password" name="password" id="password"  class="input" placeholder="Ingrese password" onblur="revisar(this)" onkeyup="revisar(this)" autocomplete="off" required/><br>
                <br>
                <input type="submit" value="Guardar" class="boton"/>
                 <input id="tarea" name="tarea" id="tarea" type="hidden" value="registrar">		
                  <input type="reset" value="Borrar" class="boton"/> 
                   <input type="button" value="salir" class="boton" onclick="location='index.jsp'" />
                </form>
        </div>
    </div>
    
</body>
</html>
