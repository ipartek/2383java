package constructores;

import java.util.Date;

public class Alumno {
	
	public String nombre;
	public String apellidos;
	public Date fechaAlta;
	
	public Alumno(String nombre, String apellidos, Date fechaAlta) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaAlta = fechaAlta;
	}
	
	public void mostrarDatos() {
		System.out.println(nombre + " " + apellidos + " " + fechaAlta);
	}

}
