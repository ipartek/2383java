package juego;

import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego{
	
	public int numeroAdivinar;
	
	public JuegoAdivinaNumero(int nVidasRestantes, int numeroAdivinar) {
		super(nVidasRestantes);
		this.numeroAdivinar = numeroAdivinar;
	}

	public void juega() {
		reiniciarPartida();
		
		Scanner sc = new Scanner(System.in);

		//private boolean sigoVivo = true;
		
		do {
			System.out.println("Adivina el numero que es entre 0 y 10");
			int numeroTeclado = sc.nextInt();
			if(validaNumero(numeroTeclado)) {
				if(numeroTeclado == numeroAdivinar) {
					System.out.println("Acertaste!!");
					actualizarRecord();
					break;
				}else {
					//sigoVivo = quitarVida();
					//if(sigoVivo) {
					if(quitarVida()) {
						muestraVidasRestantes();
						if(numeroTeclado>numeroAdivinar) {
							System.out.println("El numero es menor");
						}else {
							System.out.println("El numero es mayor");
						}
					}else {
						break;
					}
				}
			}else {
				System.out.println("El numero es incorrecto!! Sigue intentandolo...");
			}
		}while(true);
		//}while(sigoVivo);
		
		/*if(numeroTeclado == numeroAdivinar) {
			System.out.println("Acertaste!!");
		}else {
			if(quitarVida()) {
				
			}
		}*/
	}
	
	public boolean validaNumero(int numero) {
		return true;
	}

}
