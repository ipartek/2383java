package ajedrez;

public class Peon extends Pieza{

	public Peon(String color, String posicion, boolean comida) {
		super(color, posicion, comida);
	}
	
	public void mover() {
		System.out.println("me muevo como un peon");
	}

}
