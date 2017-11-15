package com.ipartek.gestionUsuarios.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.CookieService;
import com.ipartek.gestionUsuarios.service.UsuarioService;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService usuarioService;
	CookieService cookieService;

	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
		cookieService = new CookieService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario u = usuarioService.login(request.getParameter("email"), request.getParameter("pass"));
		
		if(u!=null) {
			
			if(request.getParameter("recuerdame")!=null) {
				cookieService.createCookie(response, "login", request.getParameter("email") + "," + request.getParameter("pass"), 100 * 24 * 60 * 60);
			}else {
				cookieService.deleteCookie(request, response, "login");
			}
			
			request.getSession().setAttribute("usuario", u);
			
			response.sendRedirect("usuarioController");
		}else {
			cookieService.deleteCookie(request, response, "login");
			
			response.sendRedirect("login.jsp?error=true");
		}
	}

}
