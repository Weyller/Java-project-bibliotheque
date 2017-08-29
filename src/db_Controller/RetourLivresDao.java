package db_Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetourLivresDao {
	
	//===============================================??????????????????????????
	public static int updateRetourLivre(int NumExemplaire,int idAdmin){
		int status=0;
		int indexIdEmprunt = 0;
		try{
			Connection con=DB_Connection.getConnection();
			con.setAutoCommit(false);
			
			status=retourPretLivre( NumExemplaire,idAdmin);
			System.out.println("status retour pret: " + status);
			
			if(status>0){
				PreparedStatement ps=con.prepareStatement("SELECT MAX(IdEmprunt) FROM emprunt;");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					
					indexIdEmprunt = rs.getInt(1);
					
				}
				System.out.println("Index emprunt: " + indexIdEmprunt);
			}
			
			//---------------------------------
			
			
			
			//---------------------------------
			if (indexIdEmprunt != 0 ) {
				
				PreparedStatement ps=con.prepareStatement("INSERT INTO Retour (IdEmprunt,idAdmin) VALUES (?,?);");
				ps.setInt(1,indexIdEmprunt);
				ps.setInt(2,idAdmin); 
				
				status= ps.executeUpdate();
				System.out.println(" Retour status: " + status);
				
			}
			
			
			
			con.commit();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return indexIdEmprunt;
	}
	
	
	//-------------------------------------------------------------------
	public static int retourPretLivre(int NumExemplaire,int idAdmin){
		int status=0;
		int status2=0;
		try{
			Connection con=DB_Connection.getConnection();
			con.setAutoCommit(false);
			status=updatebook(NumExemplaire, idAdmin);//updating 
			
			System.out.println("retour status avant:" + status);
			
			
			if(status>0 ){
			PreparedStatement ps=con.prepareStatement("UPDATE emprunt SET DatFin = CURRENT_TIMESTAMP, IdAdminR = ? WHERE NumExemplaire = ?;");
			ps.setInt(1,idAdmin);
			ps.setInt(2,NumExemplaire);
			status2=ps.executeUpdate();
			}
			
			con.commit();
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		System.out.println("retour status2 apres:" + status2);
		
		return status2;
	}
	public static int updatebook(int NumExemplaire, int idAmin){
		int status=0;
		int disponible=0 ;
		try{
			Connection con=DB_Connection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("select Disponibilite from livreexemplaire where NumExemplaire=?");
			ps.setInt(1,NumExemplaire);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				disponible=rs.getInt("Disponibilite");
				 
			}
			
			//----------------------------------
			boolean flag = checkIdAdmin(idAmin);
			//----------------------------------
			
			
			if(disponible == 0 && flag == true){
			PreparedStatement ps2=con.prepareStatement("update livreexemplaire set Disponibilite=? where NumExemplaire=?");
			ps2.setInt(1,disponible+1);
			ps2.setInt(2,NumExemplaire);
			 
			
			status=ps2.executeUpdate();
			}
			con.commit();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	//--------------------------------------------------------
	
	public static boolean checkIdAdmin(int idAdmin) {
		
		int status=0;
		int disponibilite=0,issued=0;
		
		boolean flag = false;
		
		try{
			Connection con=DB_Connection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM administration WHERE IdAdmin = ?");
			ps.setInt(1,idAdmin);
			ResultSet rs=ps.executeQuery();

			flag=rs.next();
			
			System.out.println("Flag  status:" + flag);
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return flag;
	}
	
	
	
	
	
	
}
