package com.luis.cursospring.springtuto6.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Luis Valdes
 * 
 * Permite asociar los resultados de la consulta con el POJO
 *
 */
public class AdminRowMapper implements RowMapper<Admin>{

	/**
	 * Unico metodo que obliga a declarar la interfaz. Este metodo sera llamado por
	 * queryForObject cuando...
	 */
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setIdAd(rs.getInt("idAd"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		admin.setNombre(rs.getString("nombre"));
		return admin;
	}

}
