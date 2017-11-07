package com.ipartek.gestionUsuarios.service;

import javax.servlet.http.HttpServletRequest;

import com.ipartek.gestionUsuarios.dao.AccesoDB;
import com.ipartek.gestionUsuarios.domain.Usuario;

public class UsuarioService {
	
	public boolean addUsuario(HttpServletRequest request) {
		Usuario u = new Usuario(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("email"));
		
		boolean existeMail = AccesoDB.existeEmail(request.getParameter("email"));
		
		if(existeMail) {
			return false;
		}else {
			AccesoDB.addUsuario(u);
			return true;
		}
	}

}
