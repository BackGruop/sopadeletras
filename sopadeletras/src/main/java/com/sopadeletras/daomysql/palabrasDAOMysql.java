package com.sopadeletras.daomysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.sopadeletras.dao.palabraDAO;
import com.sopadeletras.model.palabra;

public class  palabrasDAOMysql implements palabraDAO{

	public palabrasDAOMysql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<palabra> findall() {
		// TODO Auto-generated method stub
		Connection co =null;
		Statement stm= null;
		ResultSet rs= null;
		String sql;
		List<palabra> listaPalabras=new ArrayList<palabra>();
		//SQL SELECT
		sql = "SELECT * FROM palabras";
		
		try {
			//Abrir conexion
			co= Conexion.getConexion();
			stm= co.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()) {
			palabra p=new palabra();	
			p.setPalabras(rs.getString(1));
			p.setId(rs.getInt(2));
			listaPalabras.add(p);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error de conexion de la base de datos");
		}
		return listaPalabras;
		
	}

	@Override
	public palabra findbyId() {
		// TODO Auto-generated method stub
		return null;
	}

}
