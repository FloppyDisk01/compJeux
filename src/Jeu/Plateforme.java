package Jeu;

import java.util.ArrayList;

public class Plateforme {
	private ArrayList<Plateforme> listePlateforme;
	private String nPlateforme;
	
	public Plateforme(String nomP) {
		this.nPlateforme = nomP;
	}
	
	/**
	 * remplis listePlateforme grace a plateformeModele
	 * @return liste complète des plateformes
	 */
	public ArrayList<Plateforme> getAllPlateforme() {
		//TODO
		return listePlateforme;
	}
	
	/**
	 * ajout de la plateforme à la BDD s'il n'est pas déjà présent.
	 */
	public void ajoutBDD() {
		//TODO
	}
}
