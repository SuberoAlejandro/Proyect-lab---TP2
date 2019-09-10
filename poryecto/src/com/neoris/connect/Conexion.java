package com.neoris.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Conexion {

		private Connection com; 
		
		
		public Conexion (){
			startedConexion();
		}
		
		
		public Connection startedConexion() {
			
			if (com == null) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					com = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpneoris","root", "");
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 return com;
		}
		
		
		public void closeConexion() {
			if (startedConexion()!=null) {
				 try {
						com.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			 }
		}
		
		
		
		
		
		
		
		
}
