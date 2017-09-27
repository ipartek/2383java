package mates;

public class Main {

	public static void main(String[] args) {
		
		for(int i=1;i<26;i++) {
			boolean esPrimo = true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					esPrimo=false;
				}
			}
			if(esPrimo) {
				System.out.println("Es primo " + i);
			}
		}
		
		int resultado = 0, ultimo = 0, siguiente = 1;
		System.out.println("Los primeros 20 numeros de fibonacci son:");
		
		for(int i=0;i<20;i++) {
			resultado = ultimo + siguiente;
			
			if(i==0) {
				resultado = 0;
			}
			
			if(i>=2) {
				ultimo = siguiente;
				siguiente = resultado;
			}
			
			System.out.print( resultado + " ");
		}

	}

}
