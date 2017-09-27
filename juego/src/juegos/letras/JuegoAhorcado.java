package juegos.letras;

import java.util.Scanner;

import juegos.Juego;
import juegos.interfaces.Jugable;

public class JuegoAhorcado extends Juego implements Jugable {

	private String cadena;
	private Scanner sc = new Scanner(System.in);

	public JuegoAhorcado(int nVidasRestantes, String cadena) {
		super(nVidasRestantes);
		this.cadena = cadena;
	}

	@Override
	public void juega() {
		reiniciarPartida();
		StringBuilder cadenaOculta = new StringBuilder("");

		for (int i = 0; i < cadena.length(); i++) {
			cadenaOculta.append("-");
		}
		do {
			System.out.println("La palabra secreta es:" + cadenaOculta.toString());

			System.out.println("Introduce una letra");

			String letra = sc.nextLine();

			if (cadena.indexOf(letra) >= 0) {
				for (int i = 0; i < cadena.length(); i++) {
					if (cadena.charAt(i) == letra.charAt(0)) {
						cadenaOculta.setCharAt(i, letra.charAt(0));
					}
				}

				if (cadena.equals(cadenaOculta.toString())) {
					System.out.println("Has acertado la palabra secreta!!");
					System.out.println(cadenaOculta);
					break;
				}
			} else {
				if (!quitarVida()) {
					break;
				}
			}
		} while (true);
	}

	@Override
	public void muestraNombre() {
		System.out.println("El Ahorcado");

	}

	@Override
	public void muestraInfo() {
		System.out.println("Adivina la palabra secreta!!");

	}

}
