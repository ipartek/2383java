package excepciones;

import java.util.Calendar;

public class Fecha {

	private int anyo = 0;
	private int mes = 1;
	private int dia = 1;

	public static final int MESES_ANYO = 12;

	public static boolean esBisiesto(int anyo) {
		if((anyo%4 == 0 && anyo%100 != 0)||anyo%400==0) {
			return true;
		}
		
		return false;
	}

	public Fecha() {
		Calendar cal = Calendar.getInstance();
		this.anyo = cal.get(Calendar.YEAR);
		this.mes = cal.get(Calendar.MONTH) + 1;
		this.dia = cal.get(Calendar.DAY_OF_MONTH);
	}

	public Fecha(int anyo, int mes, int dia) throws FechaException{
		this.anyo = anyo;
		//this.mes = mes;
		setMes(mes);
		//this.dia = dia;
		setDia(dia);
	}

	public Fecha(Fecha f) {
		this.anyo = f.anyo;
		this.mes = f.mes;
		this.dia = f.dia;
	}

	public boolean esBisiesto() {
		if((this.anyo%4 == 0 && this.anyo%100 != 0)||this.anyo%400==0) {
			return true;
		}
		
		return false;
	}

	public void setanyo(int anyo) {
		this.anyo = anyo;
	}

	public int getAnyo() {
		return this.anyo;
	}

	public void setMes(int mes) throws FechaException{
		if(mes<1 || mes>12) {
			throw new FechaException("Mes erroneo");
		}else {
			this.mes = mes;
		}
	}

	public int getMes() {
		return this.mes;
	}

	public void setDia(int dia) throws FechaException{
		if(dia<1 || dia>31) {
			throw new FechaException("La fecha tiene que ser entre 1 y 31");
		}else {
			switch(this.mes) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					this.dia = dia;
					break;
				case 2:
					if(esBisiesto()) {
						if(dia>29) {
							throw new FechaException("El dia " + dia + " para el mes " + this.mes + " no es valido!!");
						}else {
							this.dia = dia;
						}
					}else {
						if(dia>28) {
							throw new FechaException("El dia " + dia + " para el mes " + this.mes + " no es valido!!");
						}else {
							this.dia = dia;
						}
					}
					break;
				default:
					if(dia>30) {
						throw new FechaException("El dia " + dia + " para el mes " + this.mes + " no es valido!!");
					}else {
						this.dia = dia;
					}
			}
		}
	}

	public int getDia() {
		return this.dia;
	}

	public void set(int anyo, int mes, int dia) throws FechaException{
		this.anyo = anyo;
		setMes(mes);
		setDia(dia);
	}

	public void set(Fecha f) {
		this.anyo = f.anyo;
		this.mes = f.mes;
		this.dia = f.dia;
	}

	public String toString() {
		return "La fecha es: " + this.dia + "/" + this.mes + "/" + this.anyo;
	}

	public boolean equals(Object o) throws FechaException{
		if(o instanceof Fecha) {
			Fecha f = (Fecha) o;
			if(f.dia == this.dia && f.mes == this.mes && f.anyo == this.anyo) {
				return true;
			}else {
				return false;
			}
		}else {
			throw new FechaException("Fecha no valida");
		}
	}
}
