package arrays;

import lector.Lector;

public class Main {
	
	public static void main(String[] args) {
		Lector lector = new Lector();
		System.out.println("Dimension del array:");
		
		int dimension = lector.leerNumEntero();
		
		int[] arrayEnteros = new int[dimension];
		
		for(int i=0;i<arrayEnteros.length;i++) {
			System.out.println("Introduce el " + (i+1) + " numero:");
			arrayEnteros[i] = lector.leerNumEntero();
		}
		
		int mayor = arrayEnteros[0];
		
		/*for(int i=0;i<arrayEnteros.length;i++) {
		 * 	int num = arrayEnteros[i];
		 * }
		 */
		for(int num: arrayEnteros) {
			if(num>mayor) {
				mayor = num;
			}
		}
		
		System.out.println("El numero mas grande es: " + mayor);
		
		int menor = arrayEnteros[0];
		
		for(int num: arrayEnteros) {
			if(num<menor) {
				menor = num;
			}
		}
		
		System.out.println("El numero mas pequeño es: " + menor);
		
	}

}
