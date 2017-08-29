package db_Controller;

import java.sql.Connection;
import java.sql.DriverManager;

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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_Bibliotheque2","root","root");
			System.out.println("Connection to DB ... success");
			
		}catch(Exception e){System.out.println(e);}
		
		
		
		return con;
	}

}

