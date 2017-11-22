package com.ipartek.centroEstudios.service;

import java.util.ArrayList;

import com.ipartek.centroEstudios.dao.AccesoBD;
import com.ipartek.centroEstudios.domain.Asignatura;

public class AsignaturaService {
	
	public ArrayList<Asignatura> getAsignaturas(){
		return AccesoBD.getAsignaturas();
	}
	
	public ArrayList<Asignatura> getAsignaturasWithProfesor(){
		ArrayList<Asignatura> asignaturas = AccesoBD.getAsignaturas();
		
		for(Asignatura a : asignaturas) {
			
		}
		
		return asignaturas;
	}

}
