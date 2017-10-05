package universidad;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Alumno alumno = new Alumno(0, "Alberto", "GCR", "1111");
		AccesoDB.saveAlumno(alumno);

		ArrayList<Alumno> alumnos = AccesoDB.getAlumnos();
		
		for(Alumno a : alumnos) {
			System.out.println(a.nombre + " " + a.apellidos);
		}
		
		ArrayList<Alumno> alumnosCarrera = AccesoDB.getAlumnosConCarrera();
		
		for(Alumno a : alumnosCarrera) {
			System.out.println(a.nombre + " " + a.apellidos + " " + a.carrera.nombre);
		}
		
		
		
	}

}
