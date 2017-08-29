package db_Controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;



public class LivresDao {
	
	static Connection	con=DB_Connection.getConnection();
	
public static int sauvegardeLivre(long isbn,String date,int pages,int nombre, String NomEditeur, String titre, String NomAuteur, String PrAuteur ,int type){
	int status=0;
	if(String.valueOf(isbn).isEmpty() || date.isEmpty() || String.valueOf(pages).isEmpty() || String.valueOf(nombre).isEmpty()
			|| NomEditeur.isEmpty() || titre.isEmpty() || NomAuteur.isEmpty() || PrAuteur.isEmpty() || String.valueOf(type).isEmpty()) {
		
		return 0;
	} else {
		
		try{
			
			//Connection	con=DB_Connection.getConnection();
			con.setAutoCommit(false);
			
			PreparedStatement ps3=con.prepareStatement("INSERT INTO Auteur (NomAuteur, PrAuteur) VALUES (?,?)");
			//ps3.setInt(1,idAuteur);
			 ps3.setString(1,NomAuteur);
			 ps3.setString(2,PrAuteur);
			
			status= ps3.executeUpdate();
			System.out.println(" Auteur status: " + status);
			
			int idAuteur = retrieveLastIdAuteur();
			
			
			//--------------------------------------
			
				PreparedStatement ps1=con.prepareStatement("INSERT INTO livre (Titre, IdAuteur) VALUES (?,?)");
				ps1.setString(1,titre);
				ps1.setInt(2,idAuteur);
				
				status= ps1.executeUpdate();
				System.out.println(" Livre status: " + status);
				
				
				
			//----------------------------------------------
				PreparedStatement ps4=con.prepareStatement("INSERT INTO Editeur (NomEditeur) VALUES (?)");
				ps4.setString(1,NomEditeur);
				 
				
				status= ps4.executeUpdate();
				System.out.println(" Editeur status: " + status);
				
				int IdEditeur = retrieveLastIdEdit();
				
			//------------------------------------------
			// con=DB_Connection.getConnection();
		/*	PreparedStatement ps=con.prepareStatement("insert into livreedition(ISBN,DatePub,NbPages,Nombre,IdEditeur, Titre,IdAuteur,IdTypeLivre) values(?,?,?,?,?,?,?,?)");
			ps.setLong(1,isbn);
			ps.setString(2,date);
			ps.setInt(3,pages);
			ps.setInt(4,nombre);
			ps.setInt(5,IdEditeur);
			ps.setString(6,titre);
			ps.setInt(7,idAuteur);
			ps.setInt(8,type);

			//status += 1;
			
			//ps.executeUpdate();
			status= ps.executeUpdate();
			System.out.println(" livreedition status: " + status); */
				
			Statement ps = con.createStatement();
			String r = "insert into livreedition(ISBN,DatePub,NbPages,Nombre,IdEditeur, Titre,IdAuteur,IdTypeLivre) "+
					" values( " + isbn + ", '"+date+"',"+ pages + ", "  + nombre + ", "+ IdEditeur + ", '" + titre +"',"+
					idAuteur + ", " + type +")";
			status= ps.executeUpdate(r);
			System.out.println(" livreedition status: " + status);
			//-------------------------------------------------------------------------
			
		
			
			PreparedStatement ps2=con.prepareStatement("INSERT INTO livreexemplaire (ISBN) VALUES (?)");
			ps2.setLong(1,isbn);
			 
			for (int i = 0; i<nombre ; i ++){
				
				status= ps2.executeUpdate();
				System.out.println(" livreexemplaire status : " + status);
			}
			
	
			//-------------------------------------------------------------------------
			
			
			con.commit();
			//con.close();
			
		}catch(Exception e){System.out.println(e);}
		
	}
	
	
	return status;
}

//=====================================================================================

public static int retrieveLastIdEdit(){
	
	int id = 0;
	boolean status=false;
	try{
		//Connection con=DB_Connection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT max(IdEditeur) as max from editeur");
		
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		System.out.println(" Statut idEdit : " + status);
		if(status){
			
			id = rs.getInt("max");
			
		}
		
		System.out.println(" Max idEditeur : " + id);
		//con.close();
	}catch(Exception e){System.out.println(e);}
	

	return id;
}


//-----------------------------------------------

public static int retrieveLastIdAuteur(){
	
	int id = 0;
	boolean status=false;
	
	
	
	try{
		//Connection con=DB_Connection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT max(IdAuteur) as max from auteur");
		
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		System.out.println(" Statut idAuteur : " + status);
		if(status){
			
			id = rs.getInt("max");
			
		}
		
		System.out.println(" Max idAuteur : " + id);
		//con.close();
	}catch(Exception e){System.out.println(e);}
	

	return id;
}


}
