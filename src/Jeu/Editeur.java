package Jeu;

import java.util.ArrayList;

import Model.Editeur_modele;

public class Editeur {
	private ArrayList<Editeur> listeEditeur;
	private String nEditeur;
	
	/**
	 * constructeur classique
	 * @param nom nom de l'éditeur.
	 */
	public Editeur(String nom) {
		this.nEditeur = nom; 
	}
	
	public String getName() {
		return nEditeur;
	}
	/**
	 * remplis listeEditeur grace a editeurModele
	 * @return liste complète des éditeurs
	 */
	public ArrayList<Editeur> getAllEditeur() {
		//TODO
		return listeEditeur;
	}
	
	/**
	 * ajout de l'éditeur à la BDD s'il n'est pas déjà présent.
	 */
	public void ajoutBDD() {
		//TODO
		Editeur_modele.ajoutEditeur(this);
	}

	String toString(Editeur ed) {
		return ed.getName();
	}
}
