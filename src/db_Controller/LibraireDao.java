package db_Controller;
import java.sql.*;
public class LibraireDao {

	
	public static int sauvegardeLibraire(String nomAdmin,String PrAdmin,String Login,String Password){
		int status=0;
		//-------------------------------------------------------------------------
		if(nomAdmin.isEmpty() || PrAdmin.isEmpty() || Login.isEmpty() || Password.isEmpty()) {
			
			return 0;
			
		} else {
			
			try{
				Connection con=DB_Connection.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into administration(nomAdmin,PrAdmin,Login,Password) values(?,?,?,?)");
				ps.setString(1,nomAdmin);
				ps.setString(2,PrAdmin);
				ps.setString(3,Login);
				ps.setString(4,Password);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			
		}
		
		
		return status;
	}
	//===============================================================================
	public static int retirerLibraire(int id){
		int status=0;
		System.out.println(String.valueOf(id));
		String sId = String.valueOf(id).trim();
		
		//------------------------------------------------------
		if (sId.isEmpty()) {
			
			return 0;
			
		} else {
			

			try{
				Connection con=DB_Connection.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from administration where idAdmin=?");
				ps.setInt(1,id);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			
		}
		
		return status;
	}

	//=============================================================================
	public static boolean validerLibraire(String login,String password){
		boolean status=false;
		//----------------------------------------------
		if(login.isEmpty() || password.isEmpty()) {
			
			return false;
		} else {
			
			try{
				Connection con=DB_Connection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from administration where Login=? and Password=?");
				ps.setString(1,login);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				status=rs.next();
				con.close();
			}catch(Exception e){System.out.println(e);}
			
		}
		
		
		return status;
	}

}
