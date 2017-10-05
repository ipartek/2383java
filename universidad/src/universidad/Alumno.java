package universidad;

public class Alumno {
	public int id;
	public String nombre;
	public String apellidos;
	public String dni;
	public Carrera carrera;
	
	public Alumno(int id, String nombre, String apellidos, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public Alumno(int id, String nombre, String apellidos, String dni, Carrera carrera) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.carrera = carrera;
	}

}
