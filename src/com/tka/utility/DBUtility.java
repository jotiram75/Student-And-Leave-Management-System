package com.tka.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
	private static String path = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3305/batch433_db";
    private static String username = "root";
    private static String password = "4125";
    
    private static Connection con = null;
    private static Statement stmt = null;
    
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		

	        Class.forName(path);
	        con = DriverManager.getConnection(url, username, password);
	        stmt = con.createStatement();
	        
	        
	        return con;
        
	}

}
