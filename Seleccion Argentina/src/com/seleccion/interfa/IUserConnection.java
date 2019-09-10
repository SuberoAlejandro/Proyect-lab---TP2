package com.seleccion.interfa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seleccion.modelo.User;

public interface IUserConnection {

	
	default public PreparedStatement prearaUserStatement(User usuario, String query, Connection com) {

		PreparedStatement ps = null;
		if (com != null) {
			try {
				ps = com.prepareStatement(query);
				ps.setString(1, usuario.getEmail());
				ps.setString(2, usuario.getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
		return ps;
	}

	
	//Valida un usuario
	default public boolean validar(PreparedStatement ps) {
		boolean st = false;
		try {
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	
	
	default public String retornaTipoUsuario(User usuario, Connection com) {
		String tipo = "";
		if (com != null) {
			try {
				PreparedStatement ps = prearaUserStatement(usuario, "SELECT id FROM register WHERE email  LIKE '%?%';",	com);
				ps.setString(1, usuario.getEmail());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					tipo = rs.getString(4);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
		return tipo;
	}

	
	//adiciona a la base de datos usuario
	default public void adicionar(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
	}

	
	
	default public void updatePassword2(User usuario, int num, Connection com) {
		PreparedStatement ps = null;
		String query = "UPDATE register SET password=?  WHERE id=? ";
		if (com != null) {
			try {
				ps = com.prepareStatement(query);
				ps.setString(1, usuario.getPassword());
				ps.setInt(2, num);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
	}

	
	//retorna id de usuario
	default public int idUsuario(User usuario, Connection com) {
		int id = 1;
		String query = "SELECT id FROM register WHERE email  LIKE '%?%';";
		PreparedStatement ps = null;
		if (com != null) {
			try {
				ps = com.prepareStatement(query);
				ps.setString(1, usuario.getEmail());
				//ps.setString(2, usuario.getPassword());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					id = rs.getInt(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

}
