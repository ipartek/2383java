package com.ipartek.centroEstudios.domain;

public class Asignatura {
	
	private int id;
	private String nombre;
	
	public Asignatura(int id) {
		this.id = id;
	}
	
	public Asignatura(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
