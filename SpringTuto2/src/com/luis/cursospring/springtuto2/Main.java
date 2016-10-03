package com.luis.cursospring.springtuto2;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.luis.cursospring.springtuto2.dao.IAdminDao;
import com.luis.cursospring.springtuto2.pojo.Admin;
import com.luis.cursospring.springtuto2.pojo.AdminRowMapper;

public class Main {

	public static void main(String[] args) {
		//Permite acceder a la 'magia' de spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		System.out.println("Stars SpringTuto2");
		
		IAdminDao adminDao = (IAdminDao) applicationContext.getBean("adminDao");
		
		Admin admin = new Admin();
		admin.setNombre("Felino");
		admin.setCargo("Don Gato");
		admin.setFechaCreacion(new Date());
		
		try{
			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin(20, "admin 20", "cargo x", new Date()));
			admins.add(new Admin(21, "admin 21", "cargo x", new Date()));
			admins.add(new Admin(22, "admin 22", "cargo x", new Date()));
			admins.add(new Admin(23, "admin 23", "cargo x", new Date()));
			
			adminDao.saveAll(admins);
			
		}catch(CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}
		catch(DataAccessException ex){
			ex.printStackTrace();
		}
		((AbstractApplicationContext) applicationContext).close();
		

	}

}
