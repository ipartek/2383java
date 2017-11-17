package com.ipartek.gestionUsuarios.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ipartek.gestionUsuarios.dao.AccesoDB;
import com.ipartek.gestionUsuarios.domain.Usuario;

public class UsuarioService {
	
	public boolean addUsuario(HttpServletRequest request) {
		Usuario u = new Usuario(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("email"), request.getParameter("pass"));
		
		boolean existeMail = AccesoDB.existeEmail(request.getParameter("email"));
		
		if(existeMail) {
			return false;
		}else {
			AccesoDB.addUsuario(u);
			return true;
		}
	}

	public ArrayList<Usuario> getUsuarios() {
		return AccesoDB.getUsuarios();
	}

	public Usuario login(String email, String pass) {
		return AccesoDB.login(email, pass);
	}

	public Boolean existeUsuario(String email) {
		return AccesoDB.existeEmail(email);
	}

	public Usuario getUsuarioByEmail(String email) {
		return AccesoDB.getUsuarioByEmail(email);
	}

}
