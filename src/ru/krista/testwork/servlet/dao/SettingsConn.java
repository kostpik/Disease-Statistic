package ru.krista.testwork.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SettingsConn {

	//private final  Logger logger = Logger.getLogger(SettingsConn.class.getName());
          private static  String hostName = "localhost";
          private static String dbName = "statistic";
          private static String userName = "root";
          private static String password = "root";
       
  
	     public SettingsConn(String hostName, String dbName, String userName, String password) {
			
			this.hostName = hostName;
			this.dbName = dbName;
			this.userName = userName;
			this.password = password;
	     }	
			public SettingsConn() {
				
			
		}

	    public  Connection getMySQLConn(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException    {
		      Class.forName("com.mysql.jdbc.Driver");		   
		              // Структура URL Connection для MySQL:
		             // Например:
		              // jdbc:mysql://localhost:3306/simplehr
		     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;		  
		     Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		     return conn;	
  }
	    public  Connection getPostgresConn(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException    {
	    	Class.forName("com.postgresql.Driver");		   
	    	// Структура URL Connection для MySQL:
	    	// Например:
	    	// jdbc:mysql://localhost:3306/simplehr
	    	String connectionURL = "jdbc:postgresql://" + hostName + ":3306/" + dbName;		  
	    	Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	    	return conn;	
	    }
	    public static Connection getMySQLConnDefault()     {
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
				System.out.println(e.getMessage());
			}		   
	    	// Структура URL Connection для MySQL:
	    	// Например:
	    	// jdbc:mysql://localhost:3306/simplehr
	    	String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;		  
	    	Connection conn=null;
			try {
				conn = DriverManager.getConnection(connectionURL, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
			}
	    
			return conn;	
	    }
	    public static Connection getPostgreSQLConnDefault()     {
	    	try {
	    		Class.forName("com.postgres.Driver");
	    	} catch (ClassNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		e.getMessage();
	    		System.out.println(e.getMessage());
	    	}		   
	    	// Структура URL Connection для MySQL:
	    	// Например:
	    	// jdbc:mysql://localhost:3306/simplehr
	    	String userName ="zkxazsktmhihga";
	    	String nameDB="dakug3qv9ui9q9";
	    	String password = "670b57eea4e7e3890f1578601dca37e052433f90adc8fd88deeae0a16576534c";
	    	String connectionURL = "jdbc:postgres://" + "ec2-54-228-251-254.eu-west-1.compute.amazonaws.com" + ":5432/" + nameDB+
	    			"?sslmode=require";		  
	    	Connection conn=null;
	    	try {
	    		conn = DriverManager.getConnection(connectionURL, userName, password);
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		System.out.println(e.getMessage());
	    		return null;
	    	}
	    	
	    	return conn;	
	    }

	
}		
		