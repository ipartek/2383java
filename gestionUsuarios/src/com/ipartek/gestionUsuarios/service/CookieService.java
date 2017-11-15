package com.ipartek.gestionUsuarios.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieService {
	
	public void createCookie(HttpServletResponse response, String nombre, String valor, int maxAge) {
		Cookie cookieLogin = new Cookie(nombre, valor);
		cookieLogin.setMaxAge(maxAge);
		
		response.addCookie(cookieLogin);
	}

	public void deleteCookie(HttpServletRequest request, HttpServletResponse response, String nombreCookie) {
		Cookie[] cs = request.getCookies();
		
		for(Cookie c : cs) {
			if(nombreCookie.equals(c.getName())) {
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}
		
	}

	public String getCookieValue(HttpServletRequest req, String string) {
		Cookie[] cs = req.getCookies();
		
		for(Cookie c : cs) {
			if("login".equals(c.getName())) {
				return c.getValue();
			}
		}
		return "";
	}

}
