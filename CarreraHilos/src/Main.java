import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Animal guepardo = new Animal("guepardo", 10);
		Animal liebre = new Animal("liebre", 20);
		Animal tortuga = new Animal("tortuga", 50);
		ArrayList<String> podium = new ArrayList<String>();
		
		tortuga.start();
		liebre.start();
		guepardo.start();
		
		do {
			if(!guepardo.isAlive()) {
				if(!podium.contains(guepardo.nombre)) {
					podium.add(guepardo.nombre);
				}
			}
			
			if(!liebre.isAlive()) {
				if(!podium.contains(liebre.nombre)) {
					podium.add(liebre.nombre);
				}
			}
			
			if(!tortuga.isAlive()) {
				if(!podium.contains(tortuga.nombre)) {
					podium.add(tortuga.nombre);
				}
			}
		}while(guepardo.isAlive() || liebre.isAlive() || tortuga.isAlive());
		
		for(String s : podium) {
			System.out.println(s);
		}
	}

}
