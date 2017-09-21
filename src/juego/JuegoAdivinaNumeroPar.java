package juego;

public class JuegoAdivinaNumeroPar extends JuegoAdivinaNumero{

	public JuegoAdivinaNumeroPar(int nVidasRestantes, int numeroAdivinar) {
		super(nVidasRestantes, numeroAdivinar);
	}
	

	public boolean validaNumero(int numero) {
		if(numero%2==0) {
			return true;
		}else {
			System.out.println("El numero es impar");
			return false;
		}
	}

}
