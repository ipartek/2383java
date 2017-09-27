package pajaritos;

public class Canario extends Ave{
	
	private int tamano;
	
	public Canario(String sexo, int edad, int tamano) {
		super(sexo, edad);
		this.tamano = tamano;
	}
	
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	public String getTamano() {
		if(tamano<15) {
			return "Es bajo";
		}else if (tamano > 30) {
			return "Es alto";
		}else {
			return "Es mediano";
		}
	}

}
