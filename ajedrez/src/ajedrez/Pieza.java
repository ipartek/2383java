package ajedrez;

public abstract class Pieza {
	
	public String color;
	public String posicion;
	public boolean comida;
	
	public Pieza(String color, String posicion, boolean comida) {
		this.color = color;
		this.posicion = posicion;
		this.comida = comida;
	}
	
	public abstract void mover();

}
