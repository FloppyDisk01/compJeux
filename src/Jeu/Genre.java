package Jeu;

import java.util.ArrayList;

import Model.Editeur_modele;
import Model.Genre_modele;

public class Genre {
	private ArrayList<Genre> listeGenre;
	private String nGenre;
	
	public Genre(String nomG) {
		this.nGenre = nomG; 
	}
	
	public String getName() {
		return nGenre;
	}
	/**
	 * remplis listeGenre grace a genreModele
	 * @return liste complète des genres
	 */
	public ArrayList<Genre> getAllGenre() {
		//TODO
		return listeGenre;
	}
	
	public void ajoutBDD() {
		//TODO
		Genre_modele.ajoutGenre(this);
	}
	
	String toString(Genre g) {
		return g.getName();
	}
}
