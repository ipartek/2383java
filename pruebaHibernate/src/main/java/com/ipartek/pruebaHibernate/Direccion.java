package com.ipartek.pruebaHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column
	private String direccion;
	
	@Column
	private String cp;
	
	@Column
	private String pais;
	
	@OneToOne(mappedBy="direccion", fetch=FetchType.LAZY)
	private Alumno alumno;
	
	public Direccion() {
		
	}

	public Direccion(String direccion, String cp, String pais) {
		this.direccion = direccion;
		this.cp = cp;
		this.pais = pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
