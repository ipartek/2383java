
public class Animal extends Thread{
	
	public String nombre;
	public int prioridad;
	private String inicial;

	public Animal(String nombre, int prioridad) {
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.inicial = nombre.toUpperCase().substring(0,1);
		//this.setPriority(prioridad);
	}
	
	@Override
	public void run() {
		for(int metros = 1;metros <= 30;metros++) {
			System.out.print(inicial);
			try {
				Thread.sleep(prioridad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" Ha terminado " + nombre);
	}
}
