package juego;

public class Main {
	
	public static void main(String[] args) {
		/*Juego juego = new Juego(5);
		juego.muestraVidasRestantes();
		//juego.nVidasRestantes--;
		juego.quitarVida();
		juego.quitarVida();
		juego.quitarVida();
		juego.quitarVida();
		juego.quitarVida();
		juego.muestraVidasRestantes();
		juego.reiniciarPartida();
		juego.actualizarRecord();
		juego.muestraVidasRestantes();
		
		Juego juego2 = new Juego(5);
		juego2.muestraVidasRestantes();
		juego2.actualizarRecord();*/
		
		JuegoAdivinaNumero j = new JuegoAdivinaNumero(5, 5);
		j.juega();
		
		JuegoAdivinaNumeroPar jPar = new JuegoAdivinaNumeroPar(5, 4);
		jPar.juega();
		
		JuegoAdivinaNumeroImpar jImpar = new JuegoAdivinaNumeroImpar(5, 3);
		jImpar.juega();
	}

}
