package lector;

import java.util.Scanner;

public class Lector {
	
	public String leerCadena() {
		Scanner sc = new Scanner(System.in);
		
		/*String texto = sc.nextLine();
		
		return texto;*/
		
		return sc.nextLine();
	}
	
	public int leerNumEntero() {
		Scanner sc = new Scanner(System.in);
		
		return sc.nextInt();
	}

}
