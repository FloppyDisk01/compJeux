package Jeu;

import java.util.ArrayList;

import Model.Genre_modele;
import Model.Plateforme_modele;

public class Plateforme {
	private ArrayList<Plateforme> listePlateforme;
	private String nPlateforme;
	
	public Plateforme(String nomP) {
		this.nPlateforme = nomP; 
	}
	public String getName() {
		return nPlateforme;
	}
	/**
	 * remplis listePlateforme grace a plateformeModele
	 * @return liste compl�te des plateformes
	 */
	public ArrayList<Plateforme> getAllPlateforme() {
		//TODO
		return listePlateforme;
	}
	
	/**
	 * ajout de la plateforme � la BDD s'il n'est pas d�j� pr�sent.
	 */
	public void ajoutBDD() {
		//TODO
		Plateforme_modele.ajoutPlateforme(this);
	}
}
