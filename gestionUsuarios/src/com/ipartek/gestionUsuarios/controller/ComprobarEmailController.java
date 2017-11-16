package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.service.UsuarioService;

/**
 * Servlet implementation class ComprobarEmailController
 */
@WebServlet(name = "comprobarEmail", urlPatterns = { "/comprobarEmail" })
public class ComprobarEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean existe = usuarioService.existeUsuario(request.getParameter("email"));
		
		response.getWriter().write(existe.toString());
	}

}
