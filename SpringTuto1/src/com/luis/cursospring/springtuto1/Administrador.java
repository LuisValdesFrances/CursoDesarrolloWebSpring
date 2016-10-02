package com.luis.cursospring.springtuto1;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {

	private int idAd;
	private String nombre;
	
	//Le dice a Spring que este componente se va a inyectar desde otra clase ->@Component
	@Autowired
	private Direccion direccion;

	public Administrador(){
		
	}
	public Administrador(int idAd, String nombre) {
		this.idAd = idAd;
		this.nombre = nombre;

	}

	public void imprimirDireccion() {
		System.out.println(direccion.toString());
	}

	
	
	public int getIdAd() {
		return idAd;
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
	
	public void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Adminstrador [idAd=" + idAd + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	

}
