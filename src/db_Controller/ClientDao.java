package db_Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * Class for Client Data Access
 * */
public class ClientDao {
	
	/*
	 * Method pour inscrire un client
	 * */
	public static int sauvegardeClient(String NomClient, String PrClient,String AdrClient, String CelClient,String EmailClient){
		int status=0;
		
		if( NomClient.isEmpty() || PrClient.isEmpty() || NomClient.isEmpty() || AdrClient.isEmpty() || CelClient.isEmpty() || EmailClient.isEmpty()){
			
			return 0;
		}
		
		else{

			try{
						
				Connection	con=DB_Connection.getConnection();
				
				con.setAutoCommit(false);
				
				PreparedStatement ps=con.prepareStatement("INSERT INTO `client`(`NomClient`, `PrClient`, `AdrClient`, `CelClient`, `EmailClient`) VALUES(?,?,?,?,?)");
				ps.setString(1,NomClient);
				ps.setString(2,PrClient);
				ps.setString(3,AdrClient);
				ps.setString(4,CelClient);
				ps.setString(5,EmailClient);
			
				//ps.executeUpdate();
				status= ps.executeUpdate();
				System.out.println(" Client ajout status: " + status);
				//-------------------------------------------------------------------------
				
				con.commit();
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			return status;
			
			
		}
	}
	
	
	
	
	
	
	

}
