package Model;

import java.io.Serializable;

public class Produit implements Serializable {
	String nom;
	int quantite;

	public Produit(String nom, int quantite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
