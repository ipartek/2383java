package calculadora;

import lector.Lector;

public class Main {

	public static void main(String[] args) {
		Lector lector = new Lector();
		Calculadora calc = new Calculadora();
		
		System.out.println("Sumar 2 numeros");
		
		System.out.println("Numero 1:");
		int n1 = lector.leerNumEntero();
		System.out.println("Numero 2:");
		int n2 = lector.leerNumEntero();
		
		System.out.println("El resultado dela suma es: " + calc.suma(n1, n2));

	}

}
