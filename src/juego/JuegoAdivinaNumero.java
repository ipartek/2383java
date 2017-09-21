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
		System.out.println("Adivina el numero que es entre 0 y 10");
		Scanner sc = new Scanner(System.in);
		
		int numeroTeclado = sc.nextInt();
		
		if(numeroTeclado == numeroAdivinar) {
			System.out.println("Acertaste!!");
		}
	}

}
