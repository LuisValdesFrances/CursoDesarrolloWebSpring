package com.luis.cursospring.springtuto4.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Le dice a Spring que esta clase es candidata para ser inyectada desde un componente -> @Autowired
@Component
public class Direccion {
	
	private String calle;
	private String direccion;
	private String cp;
	
	
	public Direccion() {
		super();
	}


	public Direccion(String calle, String direccion, String cp) {
		super();
		this.calle = calle;
		this.direccion = direccion;
		this.cp = cp;
	}
	
	//Le dice a Spring que este componente se va a inyectar desde otra clase ->@Component
	@Autowired
	public void setCalle(@Value("Biar") String calle){
		this.calle = calle;
	}
	
	//Le dice a Spring que este componente se va a inyectar desde otra clase ->@Component
	@Autowired
	public void setCp(@Value("03430")String cp){
		this.cp = cp;
	}


	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	}
	
	
	
	

}
