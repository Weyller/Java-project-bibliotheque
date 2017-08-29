package db_Model;

import java.util.ArrayList;

public class Livre implements Comparable<Livre>{

	
	private String titre;
	private ArrayList<Auteur> auteur;
	private String Isbn;
	private ArrayList<Editeur>editeur;
	private TypeDeLivre typeLivre;
	private boolean estDisponible;
	private int quantite;
	
	



	//=============================================
	

	public Livre(String titre, ArrayList<Auteur> auteur, String isbn, ArrayList<Editeur> editeur, TypeDeLivre typeLivre,
			boolean estDisponible,int quantite) {
		
		if(titre == null && auteur == null && isbn == null && editeur == null && typeLivre == null && quantite == 0) {
            throw new IllegalArgumentException("Can't be null");
        }
        if(titre.isEmpty() && auteur.isEmpty() && isbn.isEmpty() && editeur.isEmpty()) {
            throw new IllegalArgumentException("Can't be empty");
        }
		
		this.titre = titre;
		this.auteur = auteur;
		this.Isbn = isbn;
		this.editeur = editeur;
		this.typeLivre = typeLivre;
		this.estDisponible = estDisponible;
		this.quantite = quantite;
	}
	
	
	
	//=============================================
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public ArrayList<Auteur> getAuteur() {
		return auteur;
	}
	public void setAuteur(ArrayList<Auteur> auteur) {
		this.auteur = auteur;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public ArrayList<Editeur> getEditeur() {
		return editeur;
	}
	public void setEditeur(ArrayList<Editeur> editeur) {
		this.editeur = editeur;
	}
	public TypeDeLivre getTypeLivre() {
		return typeLivre;
	}
	public void setTypeLivre(TypeDeLivre typeLivre) {
		this.typeLivre = typeLivre;
	}
	public boolean isEstDisponible() {
		return estDisponible;
	}
	public void setEstDisponible(boolean estDisponible) {
		this.estDisponible = estDisponible;
	}
	
	public int getQuantite() {
		return quantite;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	//---------------------------------------------------
	@Override
	public int compareTo(Livre autresLivres) {
		
		return titre.compareTo(autresLivres.titre);
	}
	
	public boolean equals(Object o) {
        if(!(o instanceof Livre)) {
            return false;
       }
        Livre b = (Livre) o;
        return b.titre.equals(titre)
                && b.auteur.equals(auteur);
   }
	

	
	
	
	
}
