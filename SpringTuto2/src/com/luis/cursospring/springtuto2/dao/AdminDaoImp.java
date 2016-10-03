package com.luis.cursospring.springtuto2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.luis.cursospring.springtuto2.pojo.Admin;
import com.luis.cursospring.springtuto2.pojo.AdminRowMapper;

//Clase candidata para ser inyectada mediante el nombre "AdminDao"
@Component("adminDao")
public class AdminDaoImp implements IAdminDao{

	private NamedParameterJdbcOperations jdbcTemplate;
	
	//Spring va a crear y confirurar el bean
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean save(Admin admin) {
		
		//MapSqlParameterSource paramMap = new MapSqlParameterSource();
		//paramMap.addValue("nombre", admin.getNombre());
		//paramMap.addValue("cargo", admin.getCargo());
		//SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd");
		//paramMap.addValue("fechaCreacion", formatData.format(admin.getFechaCreacion()));
		
		//Si los nombres de los getters y setters coinciden con el campo, see puede automatizar con este metodo
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbcTemplate.update(
				"insert into admin (nombre, cargo, fechaCreacion) values(:nombre, :cargo, :fechaCreacion)", 
				paramMap) == 1;
	}

	public List<Admin> findAll() {
		/*
		return jdbcTemplate.query("select * from admin", new RowMapper<Admin>(){
			//Permite asociar los resultados de la consulta con el POJO
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException{
				Admin admin = new Admin();
				admin.setIdAd(rs.getInt("idAd"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getDate("fechaCreacion"));
				admin.setNombre(rs.getString("nombre"));
				return admin;
			}
		});
		*/
		return jdbcTemplate.query("select * from admin", new AdminRowMapper());
	}

	public Admin findById(int idAd) {
//		return (Admin) jdbcTemplate.query("selec * from admin where idAd= idAd", 
//				new MapSqlParameterSource("idAd", id), new AdminRowMapper());
		return jdbcTemplate.queryForObject("select * from admin where idAd=:idAd", 
				new MapSqlParameterSource("idAd", idAd), new AdminRowMapper());
	}

	public List<Admin> findByNombre(String nombre) {
		return jdbcTemplate.query("select * from admin where nombre like :nombre", 
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

	public boolean update(Admin admin) {
		return jdbcTemplate.update("update admin set nombre=:nombre, cargo=:cargo, fechaCreacion=:fechaCreacion"
				+ " where idAd = :idAd", 
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	public boolean delete(int idAd) {
		return jdbcTemplate.update("delete from admin where idAd=:idAd", 
				new MapSqlParameterSource("idAd", idAd)) == 1;
	}
	
	/**
	 * @Transactional Hace una insercion multiple como operacion atomica: Si alguna falla, no se realiza ninguna.
	 */
	@Transactional
	public int[] saveAll(List<Admin> admins) {
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());
		return jdbcTemplate.batchUpdate("insert into admin (idAd, nombre, cargo, fechaCreacion) values(:idAd, :nombre, :cargo, :fechaCreacion)", 
				batchArgs);
	}

	

}
