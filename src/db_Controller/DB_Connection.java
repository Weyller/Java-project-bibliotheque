package db_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * Class for database access
 * */
public class DB_Connection {
	
	/*
	 * Method that connect to database
	 * */
	public static Connection getConnection(){
		Connection con=null;
		String username = "root";
		String password = "root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			System.out.println("Connection to DB ... success");
			
			
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE DATABASE IF NOT EXISTS DB_Bibliotheque");
			
			stmt.executeUpdate("use DB_Bibliotheque");
			
			
		}catch(Exception e){System.out.println(e);}
		
		
		
		return con;
	}

}

