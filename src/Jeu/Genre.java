package Jeu;

import java.util.ArrayList;

public class Genre {
	private ArrayList<Genre> listeGenre;
	private String nGenre;
	
	public Genre(String nomG) {
		this.nGenre = nomG; 
	}
	
	/**
	 * remplis listeGenre grace a genreModele
	 * @return liste complète des genres
	 */
	public ArrayList<Genre> getAllGenre() {
		//TODO
		return listeGenre;
	}
}
