package com.luis.cursospring.springtuto2;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
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
			adminDao.save(admin);
			
			List<Admin> admins = adminDao.findAll();
			for(Admin admin2: admins){
				System.out.println(admin2);
			}
			
		}catch(CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}
		catch(DataAccessException ex){
			ex.printStackTrace();
		}
		((AbstractApplicationContext) applicationContext).close();
		

	}

}
