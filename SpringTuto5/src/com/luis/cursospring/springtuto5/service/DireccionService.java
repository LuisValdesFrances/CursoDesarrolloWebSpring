package com.luis.cursospring.springtuto5.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.cursospring.springtuto5.dao.IAdminDao;
import com.luis.cursospring.springtuto5.dao.IDireccionDao;
import com.luis.cursospring.springtuto5.pojo.Admin;
import com.luis.cursospring.springtuto5.pojo.Direccion;

/**
 * Clase wrapper (Envolvente que se encarga de hacer de intermediaria entre las llamadas al modelo y el controlador)
 * @author lvaldes
 *
 */
@Service
public class DireccionService {

		@Autowired
		private IAdminDao adminDao;
		@Autowired
		private IDireccionDao direccionDao;
		
		public void save(Admin admin, Direccion direccion){
			//Le digo a la  direccion a que adminstrador pertenece
			direccion.setAdmin(admin);
			direccionDao.save(direccion);
			
		}
		
		public List<Admin>findAll(int idAd){
			Admin admin = adminDao.findById(idAd);
			return direccionDao.findAll(admin);
		}
}
