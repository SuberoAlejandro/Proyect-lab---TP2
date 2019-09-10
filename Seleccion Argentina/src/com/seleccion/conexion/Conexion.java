package com.seleccion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seleccion.interfa.IConnection;
import com.seleccion.interfa.IUserConnection;
import com.seleccion.modelo.User;

public class Conexion implements IUserConnection, IConnection{

	private Connection com;
	private PreparedStatement ps;
	private boolean st = false;

	
	public Conexion() {
		this.com = startedConexion(com);
	}

	
	
	public PreparedStatement prearaUnStatement(User usuario, String query) {

		if (startedConexion(com) != null) {
			try {
				ps = com.prepareStatement(query);
				ps.setString(1, usuario.getEmail());
				ps.setString(2, usuario.getPassword());
				ps.setString(3, usuario.getClass().getName());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
		return ps;
	}

	
	
	public void agregarUsuario() {
		try {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConexion(com);
	}

	
	
	public boolean validarUsuario(User usuario, String query) {
		try {
			ps = com.prepareStatement(query);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());

			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConexion(com);
		return st;
	}

	
	
	public void actualizardatos(User usuario) {
		this.updatePassword2(usuario, this.idUsuario(usuario, com), com);
	}
	
}
