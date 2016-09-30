package com.luis.cursospring.springtuto1;

import org.springframework.stereotype.Component;

//Le dice a Spring que esta clase es candidata para ser inyectada
@Component
public class Direccion {
	
	private String calle;
	private String direccion;
	private int cp;
	
	
	public Direccion() {
		super();
	}


	public Direccion(String calle, String direccion, int cp) {
		super();
		this.calle = calle;
		this.direccion = direccion;
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", direccion=" + direccion + "]";
	}
	
	
	
	

}
