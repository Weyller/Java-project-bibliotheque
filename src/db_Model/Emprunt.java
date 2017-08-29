package db_Model;

import java.util.Date;
import java.util.List;

public class Emprunt {
	
	private Date dateDebut;
	private Date dateFin;
	private Client client;
	private Livre livre;
	
	
	
	//=============================================
	
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	
	
	
	
	
}
