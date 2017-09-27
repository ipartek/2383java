package encapsulamiento;

public class Cliente {
	public String nombre;
	private String numCuenta;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNumCuenta() {
		return numCuenta.substring(numCuenta.length()-4);
	}
	
	public void setNumCuenta(String numCuenta) {
		if(numCuenta.length()==20) {
			this.numCuenta = numCuenta;
		}else {
			System.out.println("El numero de cuenta es incorrecto!!");
		}
	}
}
