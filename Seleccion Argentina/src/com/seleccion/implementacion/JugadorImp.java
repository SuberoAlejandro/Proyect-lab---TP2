package com.seleccion.implementacion;

import java.util.List;

import com.seleccion.conexion.JugadorConnection;

import com.seleccion.modelo.Jugador;

public class JugadorImp {

	private JugadorConnection player;

	public JugadorImp() {
		player = new JugadorConnection();
	}

	public void agregarJugador(Jugador jugador) {
		player.agregarjugador("insert into Jugadores values (null,?,?,?,?,?,?,?);", jugador);
	}

	public void actualizarJugadro(Jugador jugador) {
		player.calificojugador(jugador);

	}

	
	public List<Jugador> presentarJugadoresACalificar() {
		return player.listacalificar("select * from Jugadores;");
	}

	//metodo que devuelve lista de jugadores a presentar
	public List<Jugador> presentarJugadores(String orden) {
		if (orden.equals("Todas")) {
			 return player.presentarResultados1("select * from Jugadores;");
		} else {
			return player.presentarResultados2(orden);
		}
	}

	//metodo que devuelve el mensaje si hay un empate de calificacion
	public String mensajeEnvio() {
		return player.getMensaje();
	}
	
	
	
	
}
