package com.seleccion.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;

import com.seleccion.interfa.IConnection;
import com.seleccion.interfa.IJugadorConnection;
import com.seleccion.interfa.IJugadorlistaYOrden;
import com.seleccion.modelo.Jugador;

public class JugadorConnection implements IConnection, IJugadorConnection, IJugadorlistaYOrden {

	private Connection com;
	private PreparedStatement pst;
	private Jugador jugador;
	private String mensaje = "";

	//constructor de la clase crea la coneccion de trabajo
	public JugadorConnection() {
		this.com = startedConexion(com);
		this.pst = null;
	}

	
	//metodo para extraer jugadores de la base de datos
	public void extraerJugador(String query) {
		if (com != null) {
			try {
				Statement st = com.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					this.lista.add(new Jugador(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"),
							rs.getDouble("peso"), rs.getDouble("altura"), rs.getString("posicion"),
							rs.getInt("calificacion"), rs.getInt("id")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no hay conexion no esperes algo");
		}
		// closeConexion(com);
	}

	//metodo que adiciona un jugador
	public void agregarjugador(String query, Jugador jugador) {
		this.addUser(this.JugarorPreparedStatement(jugador, query, com));
		// this.closeConexion(com);
	}

	
	//metodo que devuelve una lista de jugadores a calificar
	public List<Jugador> listacalificar(String query) {
		extraerJugador(query);
		return this.lista;
	}

	
	//metodo para calificar jugadores
	public void calificojugador(Jugador jugador) {
		this.calificarJugaror(jugador, "UPDATE jugadores SET calificacion=?  WHERE id=?;", com);
	}

	
	
	//metodo que ejecuta la extracion de los jugadores por posicion 
		public void metodoOrdenarh(String orden) {
			this.metodoSiOrden(orden);
			metodoOrdenado();
		}
	
	
	//metodo que devuelve la lista de todas las posiciones de los jugadores 
	public List<Jugador> presentarResultados1(String query) {
		extraerJugador(query);
		metodoOrdenarh("Base");
		metodoOrdenarh("Ayuda Base");
		metodoOrdenarh("Ala");
		metodoOrdenarh("Ala Pivot");
		metodoOrdenarh("Pivot");
		return this.listaPantalla;
	}

	
	//metodo que devuelve la lista de una de las posiciones de los jugadores 
	public List<Jugador> presentarResultados2(String orden) {
		extraerJugador("select * from jugadores where posicion='" + orden.trim() + "';");
		this.metodoOrdenarh(orden);
		return this.listaPantalla;
	}

	
	//metodo ordena la lista de jugadores y agrega mensaje y devuelve las tres primeras posiciones
	public void metodoOrdenado() {
		if (this.listab.size() > 3) {
			for (int i = 0; i < 3; i++) {
				this.listaPantalla.add(this.listab.get(i));
				mensaje();
			}
		} else {
			for (Jugador jugador : listab) {
				this.listaPantalla.add(jugador);
			}
		}
		this.listab.removeAll(this.listab);
	}

	
	//metodo que genera el mensaje cuando hay el empate de calificasion
	public void mensaje() {
		if (listab.get(0).getCalificasion() == listab.get(1).getCalificasion() && listab.get(1).getCalificasion() == listab.get(2).getCalificasion()) {
			mensaje = "Hay un empate de calificación en la posición de  " + listab.get(0).getPosicion();
		}
	}

	
	//metodo getters
	public String getMensaje() {
		return mensaje;
	}

	
}
