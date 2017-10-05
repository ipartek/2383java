package list;

public class Main {

	public static void main(String[] args) {
		ListaEnlazada<Integer> lista = new ListaEnlazada<Integer>();
		
		System.out.println(lista.longitud());
		
		lista.insertarPrimero(1);
		lista.insertarPrimero(2);
		lista.insertar(3);
		
		for(int i=0;i<lista.longitud();i++) {
			System.out.println(lista.devuelvePos(i));
		}
		

	}

}
