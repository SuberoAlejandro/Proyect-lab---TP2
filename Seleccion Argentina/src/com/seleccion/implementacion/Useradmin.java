package com.seleccion.implementacion;

import com.seleccion.conexion.Conexion;
import com.seleccion.interfa.IAccecibilidadUsuario;
import com.seleccion.modelo.User;

public class Useradmin implements IAccecibilidadUsuario {

	private Conexion cone;

	
	
	public Useradmin() {
		cone = new Conexion();
	}

	
	public void agregarUsuario(User usuario) {
		cone.prearaUnStatement(usuario, "insert into register values (null,?,?,?)");
		cone.agregarUsuario();
	}

	
	public boolean validarUser(User usuario) {
		return cone.validarUsuario(usuario, "select * from register where email=? and password=?");
	}

	//metodo para asignar la url para redireccionar a usuarios deacuerdo asus privilegios pre establecidos
	public String url(String email) {
		return this.nivelAcceso(email);
	}

	public void actualizaPassword(User usuario) {
		cone.actualizardatos(usuario);
	}
	
	
	
}
