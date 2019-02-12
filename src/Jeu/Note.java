package Jeu;

import Model.Genre_modele;
import Model.Note_modele;

public class Note {
	private double note_sur_20;
	private int nbre_votants;
	
	public Note(double note, int nbre) {
		note_sur_20=note;
		nbre_votants=nbre;
	}

	public double getNote_sur_20() {
		return note_sur_20;
	}

	public void setNote_sur_20(double note_sur_20) {
		this.note_sur_20 = note_sur_20;
	}

	public int getNbre_votants() {
		return nbre_votants;
	}

	public void setNbre_votants(int nbre_votants) {
		this.nbre_votants = nbre_votants;
	}
	
	public void ajoutBDD() {
		//TODO
		Note_modele.ajoutNote(this);
	}
	
	public String toString() {
		return Double.toString(getNote_sur_20())+","
				+Integer.toString(getNbre_votants());
	}
}
