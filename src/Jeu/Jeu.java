package Jeu;

import Model.Jeu_modele;

public class Jeu {
	private String nJeu;
	private Double prix;
	private Editeur nEditeur;
	private Plateforme nPlateforme;
	private int note;
	private String lienBoutique;
	boolean isDLC;
	
	/**
	 * Constructeur classique de Jeu
	 * @param nomJ nom du jeu
	 * @param nomE nom de l'éditeur
	 * @param nomP nom de la plateforme
	 * @param noteVal note donnée au jeu
	 * @param prixVal prix du jeu
	 * @param DLC si le jeu est un dlc
	 * @param URL lien vers le jeu en boutique
	 */
	
	public Jeu(String nomJ, Editeur nomE, Plateforme nomP, int noteVal, Double prixVal, boolean DLC, String URL) {
		this.nJeu = nomJ;
		this.nEditeur = nomE;
		this.nPlateforme = nomP;
		this.note = noteVal;
		this.prix = prixVal;
		this.lienBoutique = URL;
		this.isDLC = DLC;
	}
	
	/**
	 * constructeur du jeu si l'URL n'est pas disponible
	 * @param nomJ
	 * @param nomE
	 * @param nomP
	 * @param noteVal
	 * @param prixVal
	 * @param DLC
	 */
	public Jeu(String nomJ, Editeur nomE, Plateforme nomP, int noteVal, Double prixVal, boolean DLC) {
		this.nJeu = nomJ;
		this.nEditeur = nomE;
		this.nPlateforme = nomP;
		this.note = noteVal;
		this.prix = prixVal;
		this.lienBoutique = null;
		this.isDLC = DLC;
	}
	
	/**
	 * constructeur de jeu par copie
	 * @param nouvJeu jeu a copier
	 */
	public Jeu(Jeu nouvJeu) {
		this.nJeu = nouvJeu.nJeu;
		this.nEditeur = nouvJeu.nEditeur;
		this.nPlateforme = nouvJeu.nPlateforme;
		this.note = nouvJeu.note;
		this.prix = nouvJeu.prix;
		this.lienBoutique = nouvJeu.lienBoutique;
		this.isDLC = nouvJeu.isDLC; 
	}
	
	/**
	 * requete sql pour ajouter un jeu a la BDD
	 */
	public void ajoutJeu() {
		//TODO 
		
	}
	
	/**
	 * requete sql pour remplacer ce jeu parun nouveau dans la BDD
	 * @param nouvJeu jeu à remplacer dans la BDD
	 */
	public void mofifJeu(Jeu nouvJeu) {
		//TODO 
	}
	
	/**
	 * requete sql pour supprimer le jeu a la BDD
	 */
	public void supprJeu() {
		//TODO 
	}
}
