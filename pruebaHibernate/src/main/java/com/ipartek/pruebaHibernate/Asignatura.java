package com.ipartek.pruebaHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignaturas")
public class Asignatura {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String nombre;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="asig_alu"
		, joinColumns = {@JoinColumn(name="asignaturas_id")}
		, inverseJoinColumns = {@JoinColumn(name="alumnos_id")})
	private List<Alumno> alumnos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
