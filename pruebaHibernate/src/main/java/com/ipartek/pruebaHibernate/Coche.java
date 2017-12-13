package com.ipartek.pruebaHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="coches")
public class Coche {
	
	@Id
	@Column
	private String matricula;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@Column
	private String color;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alumnos_id")
	private Alumno alumno;
	
	public Coche() {
		
	}

	public Coche(String matricula, String marca, String modelo, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
