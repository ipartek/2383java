package com.ipartek.centroEstudios.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.centroEstudios.service.AsignaturaService;
import com.ipartek.centroEstudios.service.LibroService;

@WebServlet(name = "nuevoLibro", urlPatterns = { "/nuevoLibro" })
public class NuevoLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AsignaturaService asignaturaService;
	private LibroService libroService;
	

	public void init() throws ServletException {
		asignaturaService = new AsignaturaService();
		libroService = new LibroService();
	}
       
    public NuevoLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("asignaturas", asignaturaService.getAsignaturas());
		
		request.getRequestDispatcher("nuevoLibro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		libroService.createLibro(request);
	}

}
