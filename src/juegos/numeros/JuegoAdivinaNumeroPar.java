package juegos.numeros;

public class JuegoAdivinaNumeroPar extends JuegoAdivinaNumero{

	public JuegoAdivinaNumeroPar(int nVidasRestantes) {
		super(nVidasRestantes);
	}
	

	public boolean validaNumero(int numero) {
		if(numero%2==0) {
			return true;
		}else {
			System.out.println("El numero es impar");
			return false;
		}
	}
	
	public void muestraNombre() {
		System.out.println("Adivina un numero PAR!!");
	}
	
	public void muestraInfo() {
		System.out.println("Adivina un numero PAR de 0 a 10 en " + getNVidasRestantes() + " intentos.");
	}
	
	public void reiniciarPartida() {
		do {
			super.reiniciarPartida();
		}while(numeroAdivinar%2!=0);
	}

}
