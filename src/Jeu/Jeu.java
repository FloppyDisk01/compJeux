package Jeu;

public class Jeu {
	private String nJeu;
	private Genre nGenre;
	private double prix;
	private Editeur nEditeur;
	private Plateforme nPlateforme;
	private Note note;
	boolean isDLC;
	
	public Jeu(String nomJ, Editeur nomE, Genre nomG, Plateforme nomP, Note noteVal, double prixVal, boolean DLC) {
		this.nJeu = nomJ;
		this.nEditeur = nomE;
		this.nGenre = nomG;
		this.nPlateforme = nomP;
		this.note = noteVal;
		this.prix = prixVal;
		this.isDLC = DLC;
	}
}
