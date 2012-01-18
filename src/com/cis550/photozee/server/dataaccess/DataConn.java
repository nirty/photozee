package com.cis550.photozee.server.dataaccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataConn {
	
	static String url = "*************************************";
	static String db = "**********";
    static String driver = "com.mysql.jdbc.Driver";
    static String user  = "*************";
    static String pass  = "***********";
	
	private DataConn(){
		
	}
	
    public static Connection getConn() {  
    	
    	
        Connection conn = null;   

        
        try {
          
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,user,pass);
          
        } catch (Exception e) {
            
            // error
            System.err.println("Mysql Connection Error: ");
            
            // for debugging error
            e.printStackTrace();
        }
    
        return conn;
    }

}
