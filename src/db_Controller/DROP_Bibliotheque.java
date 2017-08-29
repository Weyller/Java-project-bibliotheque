package db_Controller;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DROP_Bibliotheque {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/DB_Bibliotheque";
		Connection con = DriverManager.getConnection(url, "root", "");

		System.out.println("URL: " + url);
		System.out.println("Connection: " + con);
		Statement stmt;			
		stmt= con.createStatement();
		//-------------suppression des table--------------//
		stmt.executeUpdate("DROP TABLE Amende");
		stmt.executeUpdate("DROP TABLE Relance");
		stmt.executeUpdate("DROP TABLE Retour");
		stmt.executeUpdate("DROP TABLE Emprunt");
		stmt.executeUpdate("DROP TABLE FilAttente");
		stmt.executeUpdate("DROP TABLE Client");
		stmt.executeUpdate("DROP TABLE LivreExemplaire");
		stmt.executeUpdate("DROP TABLE LivreEdition");
		stmt.executeUpdate("DROP TABLE Livre");
		stmt.executeUpdate("DROP TABLE Administration");	
		stmt.executeUpdate("DROP TABLE Editeur");
		stmt.executeUpdate("DROP TABLE Auteur");
		stmt.executeUpdate("DROP TABLE TypeLivre");
		//-------------Fin suppression des table--------------//
		stmt.close();
		con.close();
		url = "jdbc:mysql://localhost:3306/";
        con = DriverManager.getConnection(url, "root", "");
         
         System.out.println("URL: " + url);
         System.out.println("Connection: " + con);
         
         stmt = con.createStatement();
         
         stmt.executeUpdate("DROP DATABASE DB_Bibliotheque");
         stmt.close();
         con.close();	
	}
     catch( Exception e){
	  e.printStackTrace();
  }
}
}

