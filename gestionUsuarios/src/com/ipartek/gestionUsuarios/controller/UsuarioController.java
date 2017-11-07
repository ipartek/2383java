package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.dao.AccesoDB;
import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.UsuarioService;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(name = "usuarioController", urlPatterns = { "/usuarioController" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated mehod stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean alta = usuarioService.addUsuario(request);
		
		if(alta) {
			response.sendRedirect("usuarioOK.html");
		}else {
			response.sendRedirect("altaUsuario.html");
		}
		
		
	}

}
