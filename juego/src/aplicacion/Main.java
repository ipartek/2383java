package aplicacion;

import java.util.Scanner;

import juegos.interfaces.Jugable;
import juegos.letras.JuegoAhorcado;
import juegos.numeros.JuegoAdivinaNumero;
import juegos.numeros.JuegoAdivinaNumeroImpar;
import juegos.numeros.JuegoAdivinaNumeroPar;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	
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
		/*
		JuegoAdivinaNumero j = new JuegoAdivinaNumero(5, 5);
		j.muestraNombre();
		j.muestraInfo();
		j.juega();
		
		JuegoAdivinaNumeroPar jPar = new JuegoAdivinaNumeroPar(5, 4);
		jPar.muestraNombre();
		jPar.muestraInfo();
		jPar.juega();
		
		JuegoAdivinaNumeroImpar jImpar = new JuegoAdivinaNumeroImpar(5, 3);
		jImpar.muestraNombre();
		jImpar.muestraInfo();
		jImpar.juega();
		*/
		System.out.println("Bienvenido a mi juego!!");
		String seguir = "S";
		do {
			Jugable juego = eligeJuego();
			juego.muestraNombre();
			juego.muestraInfo();
			juego.juega();
			System.out.println("¿Quieres seguir jugando? S/N");
			seguir = sc.nextLine().toUpperCase();
		}while("S".equals(seguir));
		System.out.println("Bye!");
	}
	
	public static Jugable eligeJuego() {
		JuegoAdivinaNumero j = new JuegoAdivinaNumero(5);
		JuegoAdivinaNumeroPar jPar = new JuegoAdivinaNumeroPar(5);
		JuegoAdivinaNumeroImpar jImpar = new JuegoAdivinaNumeroImpar(5);
		JuegoAhorcado jAhorcado = new JuegoAhorcado(5, "alberto");
		
		Jugable[] juegos = new Jugable[4];
		
		juegos[0] = j;
		juegos[1] = jPar;
		juegos[2] = jImpar;
		juegos[3] = jAhorcado;
		
		do {
			/*
			 * for(int i=0;i<juegos.length;i++){
			 * 	Jugable juego = juegos[i];
			 * 	juego.muestraNombre();
			 * }
			 */
			System.out.println("Estos son los juegos a los que puedes jugar:");
			for(Jugable juego : juegos) {
				juego.muestraNombre();
			}
			System.out.println("Seleccciona un juego del 1 al " + juegos.length +":");
			int seleccion = sc.nextInt();
			sc.nextLine();
			
			if(seleccion>juegos.length || seleccion<1) {
				System.out.println("No has introducido un juego valido!!");
			}else {
				return (juegos[seleccion-1]);
			}
			
		}while(true);
	}

}
