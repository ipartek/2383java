package list;

public class ListaEnlazada<T> {

	private int tamano;
	private Nodo<T> primero;
	
	/**
	 * Crea una nueva lista enlazada
	 */
	public ListaEnlazada() {
		vaciar();
	}
	
	
	/**
	 * Vacia la lista enlazada
	 */
	public void vaciar() {
		primero = null;
		tamano = 0;
	}
	
	/**
	 * Devuelve si una lista esta vacia o no
	 * @return true si la lista esta vacia false si tiene datos
	 */
	public boolean esVacia() {
		return primero == null;
	}
	
	/**
	 * Devuelve la longitud de la lista
	 * @return valor entero con la longitud de la lista
	 */
	public int longitud() {
		return tamano;
	}
	
	/**
	 * Inserta un nodo al principio de la lista, si ya hay un nodo lo sustituye haciendo que el anterior pase a ser el segundo 
	 * @param objeto
	 */
	public void insertarPrimero(Object  objeto) {
		T dato = (T) objeto;
		Nodo<T> nodoNuevo = new Nodo<T>(dato);
		if(primero == null) {
			primero = nodoNuevo;
		}else {
			nodoNuevo.setSiguiente(primero);
			primero = nodoNuevo;
		}
		
		tamano++;
		
	}
	
	public void insertar(Object objeto) {
		Nodo<T> nodoAux = primero;
		T dato = (T) objeto;
		Nodo<T> nodoNuevo = new Nodo<T>(dato);
		
		while(nodoAux.getSiguiente()!=null) {
			nodoAux = nodoAux.getSiguiente();
		}
		
		nodoAux.setSiguiente(nodoNuevo);
		tamano++;
	}
	
	public T devuelvePos(int pos) {
		Nodo<T> nodoAux = null;
		int contador = 0;
		if(pos<0 || pos>=tamano) {
			System.out.println("Posicion incorrecta");
		}else {
			nodoAux = primero;
			while(nodoAux.getSiguiente()!=null) {
				if(contador==pos) {
					return nodoAux.getDato();
				}else {
					nodoAux = nodoAux.getSiguiente();
					contador++;
				}
				
			}
			return nodoAux.getDato();
		}
		
		return null;
	}
}
