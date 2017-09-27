package pajaritos;

public class Ave {
	
	private String sexo;
	public int edad;
	public static int atributoEstatico = 0;

	public Ave(String sexo, int edad) {
		//this.sexo = sexo;
		setSexo(sexo);
		this.edad = edad;
	}
	
	public void setSexo(String sexo) {
		if("M".equalsIgnoreCase(sexo) || "H".equalsIgnoreCase(sexo)) {
			this.sexo = sexo.toUpperCase();
		}
	}
	
	public String getSexo() {
		if("M".equals(sexo)) {
			return "Macho";
		}else {
			return "Hembra";
		}
	}
	
	public static void metodoEstatico() {
		System.out.println("estatico");
	}
}
