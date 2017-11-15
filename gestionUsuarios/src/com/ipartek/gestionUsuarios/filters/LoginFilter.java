package com.ipartek.gestionUsuarios.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.gestionUsuarios.domain.Usuario;
import com.ipartek.gestionUsuarios.service.CookieService;
import com.ipartek.gestionUsuarios.service.UsuarioService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/privado/*")
public class LoginFilter implements Filter {
	
	UsuarioService usuarioService;
	CookieService cookieService;

	public void init(FilterConfig fConfig) throws ServletException {
		usuarioService = new UsuarioService();
		cookieService = new CookieService();
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(req.getSession().getAttribute("usuario")!=null) {
			res.sendRedirect("../usuarioController");
		}else {
			
			String valor = cookieService.getCookieValue(req, "login");

			if("".equals(valor)) {
				res.sendRedirect("../login.jsp");
			}else {
				String[] datosUsuario = valor.split(",");
				Usuario usuario = usuarioService.login(datosUsuario[0], datosUsuario[1]);
				
				req.getSession().setAttribute("usuario", usuario);
				
				res.sendRedirect("../usuarioController");
			}
			
			
		}
		
		
	}
}
