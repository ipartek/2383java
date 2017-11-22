package com.ipartek.centroEstudios.service;

import com.ipartek.centroEstudios.dao.AccesoBD;
import com.ipartek.centroEstudios.domain.Profesor;

public class ProfesorService {
	
	public Profesor getProfesorById(int idProfesor) {
		return AccesoBD.getProfesorById(idProfesor);
	}

}
