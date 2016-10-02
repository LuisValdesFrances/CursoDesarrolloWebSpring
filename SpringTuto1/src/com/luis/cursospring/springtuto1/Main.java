package com.luis.cursospring.springtuto1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Permite acceder a la 'magia' de spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		Administrador adminstrador = (Administrador) applicationContext.getBean("id_admin");
		//adminstrador.imprimirDireccion();
		System.out.println(adminstrador.toString());
		((AbstractApplicationContext) applicationContext).close();
		

	}

}
