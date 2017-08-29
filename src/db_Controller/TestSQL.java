package db_Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSQL {

	public static void main(String[] args) {
		int status=0;
		int disponibilite=0,issued=0;
		
		boolean flag = false;
		
		try{
			Connection con=DB_Connection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM administration WHERE IdAdmin = 7");
			// ps.setInt(1,noExemplaire);
			ResultSet rs=ps.executeQuery();

			flag=rs.next();
			
			System.out.println("Flag  status:" + flag);
			con.close();
			
		}catch(Exception e){System.out.println(e);}

	}

}
