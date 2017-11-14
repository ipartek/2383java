package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.UsuarioService;

@WebServlet(name = "usuarioController", urlPatterns = { "/usuarioController" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario")!=null) {	
			ArrayList<Usuario> usuarios = usuarioService.getUsuarios();
			
			request.setAttribute("usuarios", usuarios);
			
			request.getRequestDispatcher("privado/listaUsuarios.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
