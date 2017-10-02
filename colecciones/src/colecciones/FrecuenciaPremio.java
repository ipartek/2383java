package colecciones;

public class FrecuenciaPremio {
	
	private int numeroPremiado, numVeces;

	public FrecuenciaPremio(int numeroPremiado, int numVeces) {
		this.numeroPremiado = numeroPremiado;
		this.numVeces = numVeces;
	}

	public int getNumeroPremiado() {
		return numeroPremiado;
	}

	public void setNumeroPremiado(int numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}

	public int getNumVeces() {
		return numVeces;
	}

	public void setNumVeces(int numVeces) {
		this.numVeces = numVeces;
	}
	
}
