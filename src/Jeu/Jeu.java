package Jeu;

import Model.Editeur_modele;
import Model.Jeu_modele;

public class Jeu {
	private String nJeu;
	private Genre nGenre;
	private Double prix;
	private int datesortie;
	private Editeur nEditeur;
	private Plateforme nPlateforme;
	private Note note;
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
	
	public Jeu(String nomJ, Genre g, int date, Editeur nomE, Plateforme nomP, Note note, Double prixVal, boolean DLC, String URL) {
		this.nJeu = nomJ;
		this.nGenre = g;
		this.datesortie=date;
		this.nEditeur = nomE;
		this.nPlateforme = nomP;
		this.note = note;
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
	public Jeu(String nomJ, Genre g, int date, Editeur nomE, Plateforme nomP, Note note, Double prixVal, boolean DLC) {
		this.nJeu = nomJ;
		this.nGenre = g;
		this.datesortie=date;
		this.nEditeur = nomE;
		this.nPlateforme = nomP;
		this.note = note;
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
		this.datesortie=nouvJeu.datesortie;

		this.nGenre = nouvJeu.nGenre;
		this.nEditeur = nouvJeu.nEditeur;
		this.nPlateforme = nouvJeu.nPlateforme;
		this.note = nouvJeu.note;
		this.prix = nouvJeu.prix;
		this.lienBoutique = nouvJeu.lienBoutique;
		this.isDLC = nouvJeu.isDLC; 
	}
	
	public String getNom() {
		return nJeu;
	}
	public Genre getGenre() {
		return nGenre;
	}
	public Plateforme getPlateforme() {
		return nPlateforme;
	}
	public Editeur getEditeur()
	{
		return nEditeur;
	}

	public int getDate() {
		return datesortie;
	}
	
	/**
	 * requete sql pour ajouter un jeu a la BDD
	 */
	public void ajoutJeu() {
		if(!(Jeu_modele.estenBD(this))) {
			this.getEditeur().ajoutBDD();
			
			this.getPlateforme().ajoutBDD();
			this.getNote().ajoutBDD();
			this.getGenre().ajoutBDD();
			Jeu_modele.ajoutJeu(this);	
		}
	}
	
	/**
	 * requete sql pour remplacer ce jeu parun nouveau dans la BDD
	 * @param nouvJeu jeu à remplacer dans la BDD
	 */
	public void modifJeu(Jeu jeuAModif) {
		if(Jeu_modele.estenBD(jeuAModif)) {
			Jeu_modele.supprJeu(jeuAModif);
			Jeu_modele.ajoutJeu(this);
		}
	}
	
	/**
	 * requete sql pour supprimer le jeu a la BDD
	 */
	public void supprJeu() {
		if(Jeu_modele.estenBD(this)) {
			System.out.println("supprJeudansjeu");
			Jeu_modele.supprJeu(this);
			
		}
			
	}

	public String getnJeu() {
		return nJeu;
	}

	public void setnJeu(String nJeu) {
		this.nJeu = nJeu;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getDatesortie() {
		return datesortie;
	}

	public void setDatesortie(int datesortie) {
		this.datesortie = datesortie;
	}

	public Editeur getnEditeur() {
		return nEditeur;
	}

	public void setnEditeur(Editeur nEditeur) {
		this.nEditeur = nEditeur;
	}

	public Plateforme getnPlateforme() {
		return nPlateforme;
	}

	public void setnPlateforme(Plateforme nPlateforme) {
		this.nPlateforme = nPlateforme;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getLienBoutique() {
		return lienBoutique;
	}

	public void setLienBoutique(String lienBoutique) {
		this.lienBoutique = lienBoutique;
	}

	public boolean isDLC() {
		return isDLC;
	}

	public void setDLC(boolean isDLC) {
		this.isDLC = isDLC;
	}
	
	String toString(Jeu jv) {
		return "Nom : "+jv.getNom()+"\n"+
			"Prix : "+Double.toString(jv.getPrix())+"\n"+
			"Date : "+Integer.toString(
					jv.getDate())+"\n"+
			"Editeur : "+jv.getEditeur().getName()+"\n"+
			"Genre : "+jv.getGenre().getName()+"\n"+
			"Plateforme : "+jv.getPlateforme().getName()+"\n"+
			"Note : "+Double.toString(jv.getNote().getNote_sur_20())+"\n"+
			"Nombre votants : "+Integer.toString(
					jv.getNote().getNbre_votants())+"\n"+
			"URL :"+ jv.getLienBoutique()+"\n"+
			"EstDLC : "+Boolean.toString(jv.isDLC);
	
	}
}
