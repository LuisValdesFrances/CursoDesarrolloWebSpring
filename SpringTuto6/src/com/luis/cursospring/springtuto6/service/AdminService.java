package com.luis.cursospring.springtuto6.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.cursospring.springtuto6.dao.IAdminDao;
import com.luis.cursospring.springtuto6.pojo.Admin;

/**
 * Clase wrapper (Envolvente que se encarga de hacer de intermediaria entre las llamadas al modelo y el controlador)
 * @author lvaldes
 *
 */
@Service
public class AdminService {

		@Autowired
		private IAdminDao adminDao;
		
		public void save(Admin admin){
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			adminDao.save(admin);
		}
		
		public List<Admin>findAll(){
			return adminDao.findAll();
		}

		public Admin findById(int id) {
			return adminDao.findById(id);
		}

		public void saveOrUpdate(Admin admin) {
			if(admin.getIdAd() == 0){
				save(admin);
			}else{
				adminDao.update(admin);
			}
		}

		public void delete(int id) {
			Admin admin = adminDao.findById(id);
			adminDao.delete(admin);
		}
}
