package juego;

public class JuegoAdivinaNumeroImpar extends JuegoAdivinaNumero{

	public JuegoAdivinaNumeroImpar(int nVidasRestantes, int numeroAdivinar) {
		super(nVidasRestantes, numeroAdivinar);
	}
	

	public boolean validaNumero(int numero) {
		if(numero%2!=0) {
			return true;
		}else {
			System.out.println("El numero es par");
			return false;			
		}
	}

}
