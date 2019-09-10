package com.seleccion.interfa;


//metodo que establece la accecibilidad de los usuarios a las partes de la web
public interface IAccecibilidadUsuario {

	default public String nivelAcceso(String email) {
		String url = "";
		if (email.equals("secretaria@seleccion.com")) {
			url = "carga.jsp";
		} else if (email.equals("dt@seleccion.com")) {
			url = "cargadedatos.jsp";
		} else {
			url = "registrarse.jsp";
		}
		return url;
	}
}
