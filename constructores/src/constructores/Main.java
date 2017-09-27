package constructores;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Alumno a = new Alumno("Alberto","GDC", new Date());
		a.mostrarDatos();
	}

}
