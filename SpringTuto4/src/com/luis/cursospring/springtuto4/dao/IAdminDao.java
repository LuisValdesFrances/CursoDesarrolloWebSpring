package com.luis.cursospring.springtuto4.dao;

import java.util.List;

import com.luis.cursospring.springtuto4.pojo.Admin;

public interface IAdminDao {

	public boolean save(Admin admin);
	
	public List<Admin> findAll();
	
	public Admin findById(int id);
	
	public List<Admin> findByNombre(String nombre);
	
	public boolean update(Admin admin);
	
	public boolean delete (int id);
	
	public int[] saveAll(List<Admin> admins);
}
