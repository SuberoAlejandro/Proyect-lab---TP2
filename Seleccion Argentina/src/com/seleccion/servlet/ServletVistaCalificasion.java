package com.seleccion.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seleccion.implementacion.JugadorImp;
import com.seleccion.modelo.Jugador;

public class ServletVistaCalificasion extends HttpServlet {

	private static final long serialVersionUID = 3121209828084585042L;


	public ServletVistaCalificasion() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("html/text");
		
		JugadorImp juimp = new JugadorImp();
		
		List<Jugador> jugadores = null;
		
		int vistas = Integer.valueOf(request.getParameter("vista"));
		String posicion = request.getParameter("posicion");
		String url = "";
		String mensaje="";
		
		//codigo para controlar el flujo de las vistas de calificasion y presentacion
		if (vistas == 0) {
			if (posicion.equals("no")) {
				url = "PresentaJugadores.jsp";
			} else {
				url = "VistaJugadores.jsp";
				jugadores=juimp.presentarJugadores(posicion);
				mensaje=juimp.mensajeEnvio();
			}
		} else if (vistas == 1) {
			url = "Califica.jsp";
			jugadores=juimp.presentarJugadoresACalificar();
		} else if (vistas == 2) {
			url = "cargadedatos.jsp";
		}
		
		
		request.setAttribute("mensaje", mensaje );
		request.setAttribute("jugadores", jugadores);
		RequestDispatcher ds = request.getRequestDispatcher(url);
		ds.forward(request, response);
		
	}

}
