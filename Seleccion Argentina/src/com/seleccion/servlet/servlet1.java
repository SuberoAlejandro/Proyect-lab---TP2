package com.seleccion.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seleccion.implementacion.Useradmin;
import com.seleccion.modelo.User;

public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servlet1() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("html/text");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Useradmin u = new Useradmin();
		
		//codigo de flujo de acceso 
		if (u.validarUser(new User(email, password))) {
			response.sendRedirect(u.url(email));
		} else {
			RequestDispatcher ds = request.getRequestDispatcher("registrarse.jsp");
			ds.forward(request, response);
		}
	}
}
