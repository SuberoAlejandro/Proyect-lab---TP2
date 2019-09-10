package com.seleccion.interfa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.seleccion.modelo.Jugador;


public interface IJugadorConnection {

	//metodo que devuelve un statement
	default public PreparedStatement JugarorPreparedStatement(Jugador jugador, String query, Connection com) {
		PreparedStatement pst = null;
		if (com != null) {
			try {
				pst = com.prepareStatement(query);
				pst.setString(1, jugador.getNombre());
				pst.setString(2, jugador.getApellido());
				pst.setInt(3, jugador.getEdad());
				pst.setDouble(4, jugador.getPeso());
				pst.setDouble(5, jugador.getAltura());
				pst.setString(6, jugador.getPosicion());
				pst.setInt(7, jugador.getCalificasion());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
		return pst;
	}
	
	
	//metodo para agregar la calificasion a la base de datos
	default public void calificarJugaror(Jugador jugador, String query, Connection com) {	
		if (com != null) {
			try {
				PreparedStatement pst = com.prepareStatement(query);
				pst.setInt(1, jugador.getCalificasion());
				pst.setInt(2, jugador.getId());
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
	}
	

	//metodo para adicionar un jugador a la base de datos
	default public void addUser(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no establece el statement");
		}
	}

}
