package encapsulamiento;

public class Main {

	public static void main(String[] args) {
		Cliente c = new Cliente("Alberto");
		c.setNumCuenta("1234567890123456789");

		System.out.println(c.getNumCuenta());
	}

}
