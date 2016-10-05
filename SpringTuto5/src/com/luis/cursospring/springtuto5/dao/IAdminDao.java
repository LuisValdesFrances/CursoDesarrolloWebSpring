package com.luis.cursospring.springtuto5.dao;

import java.util.List;

import com.luis.cursospring.springtuto5.pojo.Admin;

public interface IAdminDao {

	public void save(Admin admin);
	
	public List<Admin> findAll();
	
	public Admin findById(int id);
	
	public List<Admin> findByNombre(String nombre);
	
	public void update(Admin admin);
	
	public void delete (Admin admin);
	
	public int[] saveAll(List<Admin> admins);
}
