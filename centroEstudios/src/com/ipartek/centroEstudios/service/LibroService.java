package com.ipartek.centroEstudios.service;

import javax.servlet.http.HttpServletRequest;

import com.ipartek.centroEstudios.dao.AccesoBD;
import com.ipartek.centroEstudios.domain.Asignatura;
import com.ipartek.centroEstudios.domain.Libro;

public class LibroService {
	
	public void createLibro(HttpServletRequest request) {
		Asignatura a = new Asignatura(new Integer(request.getParameter("asignatura")));
		
		Libro l = new Libro(request.getParameter("isbn"), 
				request.getParameter("titulo"), 
				request.getParameter("autor"), 
				request.getParameter("editorial"), 
				a);
		
		AccesoBD.createLibro(l);
	}

}
