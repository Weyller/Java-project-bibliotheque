package db_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB_Setup {
	
	public static boolean success = false;
	
	
	/**
	 * 
	 * Main Method that initialise the database and the tables
	 * */
	public static void main(String[] args) {
	
		
		try {

			Connection con = DB_Connection.getConnection();

			Statement stmt;
			stmt = con.createStatement();
			con.setAutoCommit(false);

			 //-----------SuperAdministrateur----------------------//
            //stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS superadmin " + 
							"(id int(10) NOT NULL, " +
							"useradmin varchar(10) NOT NULL,  " +
							"passadmin varchar(10) NOT NULL)");
            
           // stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO superadmin (id, useradmin, passadmin) VALUES" +
		 			"(1, 'admin', 'admin123')"); 
            
			System.out.println("Created superadmin");
			
			//-----------Administration----------------------//
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS Administration " + 
							"(IdAdmin int(10)  NOT NULL AUTO_INCREMENT, " +
							"nomAdmin VARCHAR(50) NOT NULL, " +
							"PrAdmin VARCHAR(50) NOT NULL, " +
							"Login VARCHAR(10) NOT NULL, " +
							"Password VARCHAR(10) NOT NULL,  " +
					"PRIMARY KEY(IdAdmin))");
		 
			//stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO administration (IdAdmin, nomAdmin, PrAdmin, Login, Password)" +
		 			"VALUES (1, 'johachim', 'koffi', 'koffi', 'admin')"); 
			stmt.executeUpdate("INSERT INTO administration (IdAdmin, nomAdmin, PrAdmin, Login, Password)" +
		 			"VALUES (2, 'robitaille', 'antoine', 'antoine', 'admin')");
			stmt.executeUpdate("INSERT INTO administration (IdAdmin, nomAdmin, PrAdmin, Login, Password)" +
		 			"VALUES (3, 'desir', 'weyller', 'weyller', 'admin')");
			stmt.executeUpdate("INSERT INTO administration (IdAdmin, nomAdmin, PrAdmin, Login, Password)" +
		 			"VALUES (6, 'ww', 'www', 'w', 'w')");
			
			System.out.println("Created administration");
			//-----------Editeur----------------------//
			//stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS Editeur " + 
							"(IdEditeur int(10)  NOT NULL AUTO_INCREMENT, " +
							"NomEditeur VARCHAR(50) NOT NULL, " +							
					"PRIMARY KEY(IdEditeur))");
			

				
				System.out.println("Created Editeur");
			//-----------Auteur----------------------//
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS Auteur " + 
							"(IdAuteur int(10)  NOT NULL AUTO_INCREMENT, " +
							"NomAuteur VARCHAR(50) NOT NULL, " +
							"PrAuteur VARCHAR(50) NOT NULL,  " +
					"PRIMARY KEY(IdAuteur))");
			

			
			System.out.println("Created Auteur");
			//-----------TypeLivre----------------------//
			//stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS TypeLivre " + 
							"(IdTypeLivre int(10)  NOT NULL AUTO_INCREMENT, " +
							"LibType VARCHAR(50) NOT NULL,  " +
					"PRIMARY KEY(IdTypeLivre))");
			
			
			//stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO typelivre (IdTypeLivre, LibType) VALUES" +
		 			"(1, 'Ordinaire')"); 
			stmt.executeUpdate("INSERT INTO typelivre (IdTypeLivre, LibType) VALUES" +
		 			"(2, 'Ouvrage special')"); 
			
			System.out.println("Created Typelivre");
			//-----------Livre----------------------//
			stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Livre " + 
							"(Titre VARCHAR(50)  NOT NULL, " +
							"IdAuteur int(10) NOT NULL,  " +
							"FOREIGN KEY (IdAuteur) REFERENCES Auteur(IdAuteur), " +
							"PRIMARY KEY(Titre, IdAuteur) )");
            
            
			System.out.println("Created Livre");
          //-----------LivreEdition----------------------//
            stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS LivreEdition " + 
							"(ISBN BIGINT(16)  NOT NULL AUTO_INCREMENT, " +
							"DatePub VARCHAR(10) NOT NULL,  " +
							"NbPages VARCHAR(10) NOT NULL,  " +
							"Nombre int(10) DEFAULT 1,  " +
							"NbPret int(10) DEFAULT 0,  " +
							"IdEditeur int(10) NOT NULL,  " +
							"Titre VARCHAR(50) NOT NULL,  " +
							"IdAuteur int(10) NOT NULL,  " +
							"IdTypeLivre int(10) NOT NULL,  " +
							"FOREIGN KEY (IdEditeur) REFERENCES Editeur(IdEditeur), " +
							"FOREIGN KEY (IdEditeur) REFERENCES Editeur(IdEditeur), " +
							"FOREIGN KEY (Titre, IdAuteur) REFERENCES Livre(Titre, IdAuteur), " +
							"FOREIGN KEY (IdTypeLivre) REFERENCES TypeLivre(IdTypeLivre), " +
							"PRIMARY KEY(ISBN))");
            

          //-----------LivreExemplaire----------------------//
           // stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS LivreExemplaire " + 
							"(NumExemplaire int(10)  NOT NULL AUTO_INCREMENT, " +
							"ISBN BIGINT(16) NOT NULL,  " +
							"Disponibilite int(1) DEFAULT 1,  " +
							"FOREIGN KEY (ISBN) REFERENCES LivreEdition(ISBN), " +
							"PRIMARY KEY(NumExemplaire))");
            

//            
			System.out.println("Created livreexemplaire");
			
				
			
          //-----------Client----------------------//
          //  stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Client " + 
							"(IdClient int(10)  NOT NULL AUTO_INCREMENT, " +
							"NomClient VARCHAR(50) NOT NULL,  " +
							"PrClient VARCHAR(50) NOT NULL,  " +
							"AdrClient VARCHAR(50) NOT NULL,  " +
							"CelClient VARCHAR(15) NOT NULL,  " +
							"EmailClient VARCHAR(50) NOT NULL,  " +
							"PRIMARY KEY(IdClient))");
            
          //  stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO `client` (IdClient, NomClient, PrClient, AdrClient, CelClient, EmailClient) VALUES" +
		 			"(1, 'Robitaille', 'Antoine', '36 rue Jarry montreal', '5148548954', 'antoine@gmail.com')"); 
			stmt.executeUpdate("INSERT INTO `client` (IdClient, NomClient, PrClient, AdrClient, CelClient, EmailClient) VALUES" +
		 			"(2, 'Desir', 'Weyller', '23 rue Vogue Dorval', '5148889774', 'weyller@gmail.com')"); 
			stmt.executeUpdate("INSERT INTO `client` (IdClient, NomClient, PrClient, AdrClient, CelClient, EmailClient) VALUES" +
		 			"(3, 'Joachim', 'Koffi', '90 rue Parc Montreal', '5144445555', 'koffi@gmail.com')"); 
            
			System.out.println("Created client");
          //-----------FilAttente----------------------//
            stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS FilAttente " + 
							"(IdFil int(10)  NOT NULL AUTO_INCREMENT, " +
							"DatDebut datetime DEFAULT CURRENT_TIMESTAMP,  " +
							"IdClient int(10) NOT NULL,  " +
							"Titre VARCHAR(50) NOT NULL,  " +
							"IdAuteur int(10) NOT NULL,  " +
							"DatFin datetime NOT NULL,  " +
							"FOREIGN KEY (Titre, IdAuteur) REFERENCES Livre(Titre, IdAuteur), " +
							"FOREIGN KEY (IdClient) REFERENCES Client(IdClient), " +
							"PRIMARY KEY(IdFil))");
        	System.out.println("Created fileattente");
            //-----------Emprunt----------------------//
           // stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Emprunt " + 
							"(IdEmprunt int(10)  NOT NULL AUTO_INCREMENT, " +
							"DatDebut datetime DEFAULT CURRENT_TIMESTAMP,  " +
							"DatFin datetime DEFAULT NULL,  " +
							"NumExemplaire int(11) NOT NULL,  " +
							"IdClient int(10) NOT NULL,  " +
							"IdAdmin int(10) NOT NULL,  " +
							"IdAdminR int(10) DEFAULT NULL,  " +
							"FOREIGN KEY (NumExemplaire) REFERENCES livreexemplaire(NumExemplaire), " +
							"FOREIGN KEY (IdClient) REFERENCES Client(IdClient), " +
							"FOREIGN KEY (IdAdmin) REFERENCES Administration(IdAdmin), " +
							"PRIMARY KEY(IdEmprunt))");
            
		 			
			
			System.out.println("Created emprunt");
			
            
            //-----------Retour----------------------//
          //  stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Retour " + 
							"(IdRetour int(10)  NOT NULL AUTO_INCREMENT, " +
							"DatRetour datetime DEFAULT CURRENT_TIMESTAMP,  " +
							"IdEmprunt int(10) NOT NULL,  " +
							"IdAdmin int(10) NOT NULL,  " +
							"FOREIGN KEY (IdEmprunt) REFERENCES Emprunt(IdEmprunt), " +
							"FOREIGN KEY (IdAdmin) REFERENCES Administration(IdAdmin), " +
							"PRIMARY KEY(IdRetour))"); 
        	System.out.println("Created retour");
          //-----------Relance----------------------//
         //   stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Relance " + 
							"(IdRelance int(10)  NOT NULL AUTO_INCREMENT, " +
							"DatDebutR datetime DEFAULT CURRENT_TIMESTAMP,  " +
							"DatFinR datetime DEFAULT NULL,  " +
							"IdEmprunt int(10) NOT NULL,  " +
							"FOREIGN KEY (IdEmprunt) REFERENCES Emprunt(IdEmprunt), " +
							"PRIMARY KEY(IdRelance))");
        	System.out.println("Created relance");
            //-----------Amende----------------------//
           // stmt = con.createStatement();
            stmt.executeUpdate(
            		"CREATE TABLE IF NOT EXISTS Amende " + 
							"(IdAmende int(10)  NOT NULL AUTO_INCREMENT, " +
							"DatEmise datetime DEFAULT CURRENT_TIMESTAMP,  " +
							"MontAmende VARCHAR(10) NOT NULL,  " +
							"IdRelance int(10) NOT NULL,  " +
							"FOREIGN KEY (IdRelance) REFERENCES Relance(IdRelance), " +
							"PRIMARY KEY(IdAmende))");
            
        	System.out.println("Created amende");
            
        	//----------------------------------------------------------------
        	success = true;
        	
        	con.commit();
            stmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		
		
		
	}


}
