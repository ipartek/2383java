
public class Main {

	public static void main(String[] args) {

		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		
		System.out.println(Thread.MAX_PRIORITY);
		
		h2.setPriority(Thread.MAX_PRIORITY);
		
		h1.start();
		h2.start();

	}

}
