package com.luis.cursospring.springtuto5.dao;

import java.util.List;

import com.luis.cursospring.springtuto5.pojo.Admin;
import com.luis.cursospring.springtuto5.pojo.Direccion;

public interface IDireccionDao {
	
	public void save(Direccion direccion);
	
	public List<Admin> findAll(Admin admin);
}
