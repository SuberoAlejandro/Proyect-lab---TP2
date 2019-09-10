package com.seleccion.interfa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IConnection {

	//metodo que devuelve una conecion a MySQL a la base de datos seleccion
	default public Connection startedConexion(Connection com) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			com = DriverManager.getConnection("jdbc:mysql://localhost:3306/seleccion", "root", "admin");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return com;
	}

	//metodo de cierre de conexion
	default public void closeConexion(Connection com) {
		if (startedConexion(com) != null) {
			try {
				com.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
