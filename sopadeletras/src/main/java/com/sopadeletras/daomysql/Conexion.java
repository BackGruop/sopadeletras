package com.sopadeletras.daomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Conexion _conn;
	private static Connection con = null;
	private String password = "";
	private String usuario = "root";
	private String url = "jdbc:mysql://localhost:3306/sopadeletras?user=" + usuario + "&password=" + password;
	
	private Conexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			if ( con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conetcra");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No se pudo encontrar la clase");
			e.printStackTrace();
			
		}
		
	}
	
	public static synchronized Connection getConexion() {
		if(_conn==null) {
			_conn = new Conexion();
		}
		return con;
	}

}
