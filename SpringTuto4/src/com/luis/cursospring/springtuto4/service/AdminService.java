package com.luis.cursospring.springtuto4.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.cursospring.springtuto4.dao.IAdminDao;
import com.luis.cursospring.springtuto4.pojo.Admin;

@Service
public class AdminService {

		@Autowired
		private IAdminDao adminDao;
		
		public boolean save(Admin admin){
			//SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd");
			//admin.setFechaCreacion(formatData.format(new Date()));
			admin.setFechaCreacion(new Date());
			return adminDao.save(admin);
		}
		
		public List<Admin>findAll(){
			return adminDao.findAll();
		}

		public Admin findById(int id) {
			return adminDao.findById(id);
		}

		public boolean saveOrUpdate(Admin admin) {
			if(admin.getIdAd() == 0){
				return save(admin);
			}else{
				return adminDao.update(admin);
			}
		}
}
