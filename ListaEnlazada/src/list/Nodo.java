package list;

public class Nodo<T> {

	private T dato;
	private Nodo<T> siguiente;
	
	public Nodo() {
		siguiente = null;
	}
	
	public Nodo(T dato) {
		siguiente = null;
		this.dato = dato;
	}
	
	public Nodo(T dato, Nodo<T> siguiente) {
		this.siguiente = siguiente;
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
}
