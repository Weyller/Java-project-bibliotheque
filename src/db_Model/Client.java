package db_Model;

import java.util.ArrayList;

public class Client {
	
	
	private String nomClient;
	private String prenomClient;
	private String addClient;
	private String telClient;
	private String emailClient;
	private Double amende;
	private boolean estSuspendu;
	private ArrayList<Emprunt> emprunt;
	
	//=============================================
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAddClient() {
		return addClient;
	}
	public void setAddClient(String addClient) {
		this.addClient = addClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public Double getAmende() {
		return amende;
	}
	public void setAmende(Double amende) {
		this.amende = amende;
	}
	public boolean isEstSuspendu() {
		return estSuspendu;
	}
	public void setEstSuspendu(boolean estSuspendu) {
		this.estSuspendu = estSuspendu;
	}
	public ArrayList<Emprunt> getEmprunt() {
		return emprunt;
	}
	public void setEmprunt(ArrayList<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}
	
	
	
	
	
	
	

}
