package juegos.numeros;

public class JuegoAdivinaNumeroImpar extends JuegoAdivinaNumero{

	public JuegoAdivinaNumeroImpar(int nVidasRestantes) {
		super(nVidasRestantes);
	}
	

	public boolean validaNumero(int numero) {
		if(numero%2!=0) {
			return true;
		}else {
			System.out.println("El numero es par");
			return false;			
		}
	}
	
	public void muestraNombre() {
		System.out.println("Adivina un numero IMPAR!!");
	}
	
	public void muestraInfo() {
		System.out.println("Adivina un numero IMPAR de 0 a 10 en " + getNVidasRestantes() + " intentos.");
	}
	
	public void reiniciarPartida() {
		do {
			super.reiniciarPartida();
		}while(numeroAdivinar%2==0);		
	}

}
