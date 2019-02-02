package Jeu;

public class Jeu {
	private String nJeu;
	private Editeur nEditeur;
	private Genre nGenre;
	private Plateforme nPlateforme;
	
	public Jeu(String nomJ, Editeur nomE, Genre nomG, Plateforme nomP) {
		this.nJeu = nomJ;
		this.nEditeur = nomE;
		this.nGenre = nomG;
		this.nPlateforme = nomP;
	}
}
