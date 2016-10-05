package com.luis.cursospring.springtuto6.dao;

import java.util.List;

import com.luis.cursospring.springtuto6.pojo.Admin;
import com.luis.cursospring.springtuto6.pojo.Direccion;

public interface IDireccionDao {
	
	public void save(Direccion direccion);
	
	public List<Admin> findAll(Admin admin);
}
