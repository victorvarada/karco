package com.isidis.prototype.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL{

	private static String url = "jdbc:postgresql://localhost:5432/karco";
	private static String user = "postgres";
	private static String passwd = "karco78";
	private static Connection connect;
	

	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
}