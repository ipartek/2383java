package main;

import pajaritos.Ave;

public class Main {

	public static void main(String[] args) {
		Ave.metodoEstatico();
		System.out.println(Ave.atributoEstatico);
		
		Ave a = new Ave("", 3);

		Ave a2 = new Ave("", 2);
		
		System.out.println(a.atributoEstatico);
		a.atributoEstatico = 3;
		System.out.println(a2.atributoEstatico);
	}

}
