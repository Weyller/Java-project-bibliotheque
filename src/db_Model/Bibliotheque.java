package db_Model;

import java.util.ArrayList;
import java.util.Collections;

public class Bibliotheque {
	
	
	private ArrayList<Livre> inventaireLivres;

	
	public Bibliotheque() {
		
		 this.inventaireLivres = new ArrayList<Livre>();
	}
	
	 public Bibliotheque(ArrayList<Livre> autresLivres) {
	        if (autresLivres == null) {
	            throw new NullPointerException("null pointer");
	        } else
	            this.inventaireLivres = autresLivres;
	    }
	

	 public boolean add(Livre livre) {
	        if (livre != null && !livre.equals("")) {
	            throw new IllegalArgumentException("Can't be empty");
	        }
	        inventaireLivres.add(livre);
	        return true;
	    }

	    public ArrayList<Livre> findTitles(String titre) {
	        for(Livre b: inventaireLivres) {
	            if(titre.compareTo(b.getTitre())== 0) {
	                return inventaireLivres;
	            }
	        }
	        return null;
	    }

	    public void sort() {
	        Collections.sort(inventaireLivres);
	    }

	    public String toString() {
	        return Bibliotheque.this.toString();
	    }
}
