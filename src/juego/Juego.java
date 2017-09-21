package juego;

public abstract class Juego {
	
	private int nVidasRestantes;
	private int nVidasIniciales;
	private static int record = 0;

	public Juego(int nVidasRestantes) {
		this.nVidasRestantes = nVidasRestantes;
		this.nVidasIniciales = nVidasRestantes;
	}
	
	public void muestraVidasRestantes() {
		System.out.println("Te quedan " + nVidasRestantes + " vidas");
	}
	
	public boolean quitarVida() {
		nVidasRestantes--;
		if(nVidasRestantes>0) {
			return true;
		}else {
			System.out.println("Game Over");
			return false;
		}
	}
	
	public void reiniciarPartida() {
		nVidasRestantes = nVidasIniciales;
	}
	
	public void actualizarRecord() {
		if(nVidasRestantes>record) {
			record = nVidasRestantes;
			System.out.println("Has batido el RECORD!!!");
		}else if(nVidasRestantes==record) {
			System.out.println("Has igualado el record, CASI!!!");
		}
	}
	
	public abstract void juega();

}
