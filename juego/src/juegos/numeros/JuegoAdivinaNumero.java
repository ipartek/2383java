package juegos.numeros;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import juegos.Juego;
import juegos.interfaces.Jugable;

public class JuegoAdivinaNumero extends Juego implements Jugable{
	
	public int numeroAdivinar;
	private Random random = new Random(new Date().getTime());
	
	public JuegoAdivinaNumero(int nVidasRestantes) {
		super(nVidasRestantes);
	}

	public void juega() {
		reiniciarPartida();
		
		Scanner sc = new Scanner(System.in);

		//private boolean sigoVivo = true;
		
		do {
			//System.out.println("Adivina el numero que es entre 0 y 10");
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
	
	public void reiniciarPartida() {
		super.reiniciarPartida();
		numeroAdivinar = random.nextInt(11);
	}
	
	public boolean validaNumero(int numero) {
		return true;
	}

	public void muestraNombre() {
		System.out.println("Adivina un numero!!");
		
	}

	public void muestraInfo() {
		System.out.println("Adivina un numero de 0 a 10 en " + getNVidasRestantes() + " intentos.");
	}

}
