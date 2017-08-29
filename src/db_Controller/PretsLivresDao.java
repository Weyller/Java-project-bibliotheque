package db_Controller;
import java.sql.*;


/*
 * Methods to manage book loans
 * 
 * */
public class PretsLivresDao {
	
public static boolean checkLivre(int noExemplaire){
	boolean status=false;
	try{
		Connection con=DB_Connection.getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps=con.prepareStatement("SELECT * FROM livreexemplaire where NumExemplaire=?");
		ps.setInt(1,noExemplaire);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.commit();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int sauvegardePretLivre(int noExemplaire,int idClient,int idAdmin){
	int status=0;
	try{
		Connection con=DB_Connection.getConnection();
		con.setAutoCommit(false);
		status=updateExemplaireLivre(noExemplaire);//updating quantity and issue
		
		//System.out.println("status from update " + status);
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into emprunt(NumExemplaire,IdClient,IdAdmin) values(?,?,?)");
		ps.setInt(1,noExemplaire);
		ps.setInt(2,idClient);
		ps.setInt(3,idAdmin);
		 
		status=ps.executeUpdate();
		//System.out.println("status from insert " + status);
		}
		
		//-------------------------------------------------
		//UPDATE emprunt set DatFin = NOW() + INTERVAL 15 DAY where idEmprunt = 9
		if(status>0) {
			PreparedStatement ps1=con.prepareStatement("UPDATE emprunt set DatFin = NOW() + INTERVAL 18 DAY where NumExemplaire = ?");
			ps1.setInt(1,noExemplaire);
			
			status=ps1.executeUpdate();
			//System.out.println("status from udate datefin " + status);
		}
		//-------------------------------------------------
				
		if(status>0) {
			PreparedStatement ps2=con.prepareStatement("UPDATE livreexemplaire set Disponibilite = 0 where NumExemplaire = ?");
			ps2.setInt(1,noExemplaire);
					
			status=ps2.executeUpdate();	
			//System.out.println("status from disponible " + status);
		}
		
		con.commit();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updateExemplaireLivre(int noExemplaire){
	int status=0;
	int disponibilite=0,issued=0;
	try{
		Connection con=DB_Connection.getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps=con.prepareStatement("select Disponibilite from livreexemplaire where NumExemplaire=?");
		ps.setInt(1,noExemplaire);
		ResultSet rs=ps.executeQuery();

				
		if(rs.next()){
			disponibilite=rs.getInt("Disponibilite");
			
		} 
		//System.out.println("Disponibilite :" + disponibilite);
		
		PreparedStatement ps2=null;
		if(disponibilite>0){
		ps2 = con.prepareStatement("update livreexemplaire set Disponibilite=? where NumExemplaire=?");
		ps2.setInt(1,disponibilite-1);
		ps2.setInt(2,noExemplaire);
		status=ps2.executeUpdate();
		//System.out.println("Dsiponibilite  status:" + status);
		
		}
		
		
		con.setAutoCommit(false);
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
}
