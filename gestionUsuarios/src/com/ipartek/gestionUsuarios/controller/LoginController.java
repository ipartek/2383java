package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.UsuarioService;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie nuevaCookie = new Cookie("prueba", "AY!! mi cookie");
		
		nuevaCookie.setMaxAge(10);
		
		response.addCookie(nuevaCookie);
		
		Cookie[] cs = request.getCookies();
		
		for(Cookie c : cs) {
			System.out.println(c.getName());
		}
		
		Usuario u = usuarioService.login(request.getParameter("email"), request.getParameter("pass"));
		
		if(u!=null) {
			request.getSession().setAttribute("usuario", u);
			
			response.sendRedirect("usuarioController");
		}else {
			response.sendRedirect("login.jsp?error=true");
		}
	}

}
