package colecciones;

import java.io.Serializable;

public class Premio implements Serializable{
	private int dia, mes, anyo, numeroPremiado;

	public Premio(int dia, int mes, int anyo, int numeroPremiado) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.numeroPremiado = numeroPremiado;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getNumeroPremiado() {
		return numeroPremiado;
	}

	public void setNumeroPremiado(int numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}
	
	
}
