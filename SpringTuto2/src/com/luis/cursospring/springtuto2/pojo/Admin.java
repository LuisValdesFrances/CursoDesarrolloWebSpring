package com.luis.cursospring.springtuto2.pojo;

import java.util.Date;

public class Admin {

	private int idAd;
	private String nombre;
	private String cargo;
	private Date fechaCreacion;
	public int getIdAd() {
		return idAd;
	}
	
	

	public Admin(int idAd, String nombre, String cargo, Date fechaCreacion) {
		super();
		this.idAd = idAd;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Admin(String nombre, String cargo, Date fechaCreacion) {
		super();
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Admin(){
		
	}
	
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion="
				+ fechaCreacion + "]";
	}

}
