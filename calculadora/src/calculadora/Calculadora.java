package calculadora;

public class Calculadora {
	
	public int suma(int numero1, int numero2) {
		return numero1 + numero2;
	}
	
	public int resta(int numero1, int numero2) {
		return numero1 - numero2;
	}
	
	public int multiplicacion(int numero1, int numero2) {
		return numero1 * numero2;
	}
	
	public int division(int numero1, int numero2) {
		if(numero2==0) {
			System.out.println("No se puede dividir entre 0");
			return 0;
		}else {
			return numero1 / numero2;
		}
	}

}
