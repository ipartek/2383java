package ajedrez;

public class Torre extends Pieza{

	public Torre(String color, String posicion, boolean comida) {
		super(color, posicion, comida);
	}
	
	public void mover() {
		System.out.println("me muevo como una torre");
	}

}
