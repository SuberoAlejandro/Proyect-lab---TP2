package com.seleccion.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seleccion.implementacion.JugadorImp;
import com.seleccion.modelo.Jugador;

public class ServletRegistroJugadores extends HttpServlet {

	private static final long serialVersionUID = 8359977799497176419L;

	public ServletRegistroJugadores() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("html/text");

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.valueOf(request.getParameter("edad"));
		double peso = Double.valueOf(request.getParameter("peso"));
		double altura = Double.valueOf(request.getParameter("altura"));
		String posicion = request.getParameter("posicion");
		int calificasion = Integer.valueOf(request.getParameter("calificasion"));
		int id = Integer.valueOf(request.getParameter("id"));
		int accion = Integer.valueOf(request.getParameter("carga"));

		JugadorImp jui = new JugadorImp();
		Jugador jugador = new Jugador(nombre, apellido, edad, peso, altura, posicion, calificasion);

		//codigo de control de flujo de vistas para agregado y calificasion de jugadores
		if (accion == 1) {
			jui.agregarJugador(jugador);
		} else if (accion == 0) {
			jugador.setId(id);
			jui.actualizarJugadro(jugador);
		}
	}
}
