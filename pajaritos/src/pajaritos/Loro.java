package pajaritos;

public class Loro extends Ave{
	
	private String region;
	public String color;
	
	public Loro(String sexo, int edad, String region, String color) {
		super(sexo, edad);
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getRegion() {
		switch (region) {
			case "N":
				return "norte";
			case "S":
				return "Sur";
			case "E":
				return "Este";
			default:
				return "Oeste";
			
		}
	}
}
