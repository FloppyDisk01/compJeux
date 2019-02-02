package Jeu;

public class Note {
	private double note_sur_20;
	private int nombre_votants;
	
	public Note(double note_sur_20, int nombre_votants) {
		
		this.note_sur_20 = note_sur_20;
		this.nombre_votants = nombre_votants;
	}

	public double getNote() {
		return note_sur_20;
	}

	public void setNote(double note_sur_20) {
		this.note_sur_20 = note_sur_20;
	}

	public int getNombre_votants() {
		return nombre_votants;
	}

	public void setNombre_votants(int nombre_votants) {
		this.nombre_votants = nombre_votants;
	}
	
	
}
