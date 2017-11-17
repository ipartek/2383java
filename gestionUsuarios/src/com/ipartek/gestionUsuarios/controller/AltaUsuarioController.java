package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.UsuarioService;

/**
 * Servlet implementation class AltaUsuarioController
 */
@WebServlet(name = "altaUsuario", urlPatterns = { "/altaUsuario" })
public class AltaUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService = null;
	
	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean alta = usuarioService.addUsuario(request);
		
		if(request.getParameter("ajax")!=null) {
			PrintWriter pw = response.getWriter();
			if(alta) {
				Usuario usuario = usuarioService.getUsuarioByEmail(request.getParameter("email"));
				Gson gson = new Gson();
				pw.write(gson.toJson(usuario));
			}else {
				pw.write("altaKO");
			}
		}else {
			if(alta) {
				response.sendRedirect("login.jsp?usuarioOK=true");
			}else {
				response.sendRedirect("altaUsuario.jsp");
			}	
		}	

	}

}
