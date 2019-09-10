package com.seleccion.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seleccion.implementacion.Useradmin;
import com.seleccion.modelo.User;

public class servletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletRegistro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("html/text");

		Useradmin u = new Useradmin();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tarea=request.getParameter("tarea"); 
		User user = new User(email, password);
				
		//control de flujo de vistas para las funcionabilidades de registro y cambio de clave de usuarios 
		if (tarea.equals("registrar")) {
			u.agregarUsuario(user);
		}else if (tarea.equals("cambiar")){
			u.actualizaPassword(user);
		}

		
		RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
		dp.forward(request, response);
	}

}
