package com.luis.cursospring.springtuto5.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luis.cursospring.springtuto5.pojo.Admin;
import com.luis.cursospring.springtuto5.pojo.Direccion;

@Transactional
@Repository
public class DireccionDaoImp implements IDireccionDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion direccion) {
		getSession().save(direccion);
	}

	@Override
	public List<Admin> findAll(Admin admin) {
		Criteria crit = getSession().createCriteria(Direccion.class)
				.setFetchMode("admin", FetchMode.JOIN)//Hace la reunion natural ->reune las direcciones de un administrador
				.add(Restrictions.eq("admin.idAd", admin.getIdAd()))//Restriccion que fuerza a que el admin sea el mismo que la reunion natural
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//Evita el producto cruzado (Solo resultados distintos
		return crit.list();
	}

	
	

	

}
