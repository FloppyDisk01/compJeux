package Jeu;

import Model.Editeur_modele;
import Model.Genre_modele;
import Model.Jeu_modele;
import Model.Note_modele;
import Model.Plateforme_modele;

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
		boolean different=false;
		if(!jeuAModif.getNom().equals(this.getNom())) {
			
			different=true;
		}
		else if(Math.abs(this.prix-jeuAModif.getPrix())>0.1) {
			
		}
		else if(jeuAModif.getDate()!=datesortie) {
			different=true;
		}
			
		else if(jeuAModif.isDLC!=this.isDLC())
			different=true;
		else if(!(jeuAModif.getEditeur().getName().equals(this.getEditeur().getName())))
			different=true;
		else if(!(jeuAModif.getGenre().getName().equals(this.getGenre().getName())))
			different=true;
		else if(!(jeuAModif.getPlateforme().getName().equals(this.getPlateforme().getName())))
			different=true;
		else if(Math.abs(this.getNote().getNote_sur_20()-
				jeuAModif.getNote().getNote_sur_20())>0.1)
			different =true;
		else if(jeuAModif.getNote().getNbre_votants()!=this.getNote().getNbre_votants())
			different =true;
		else if(!(jeuAModif.getLienBoutique().equals(this.getLienBoutique())))
			different=true;
		
		if(different) {
			
			Jeu_modele.jvmodif(this,jeuAModif);
			setnJeu(jeuAModif.getNom());
			setPrix(jeuAModif.getPrix());
			setDatesortie(jeuAModif.getDate());
			setnEditeur(jeuAModif.getEditeur());
			setnPlateforme(jeuAModif.getPlateforme());
			setnGenre(jeuAModif.getGenre());
			setNote(jeuAModif.getNote());
			setLienBoutique(jeuAModif.getLienBoutique());
			setDLC(jeuAModif.isDLC());
			
		}
		
		
	}
	
	/**
	 * requete sql pour supprimer le jeu a la BDD
	 */
	public void supprJeu() {
		if(Jeu_modele.estenBD(this)) {
			System.out.println("test suppr de la modif");
			Jeu_modele.supprJeu(this);
			Editeur_modele.supprEditeur(this.getEditeur());
			Genre_modele.supprGenre(this.getGenre());
			Plateforme_modele.supprPlateforme(this.getPlateforme());
			Note_modele.supprNote(this.getNote());
			
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

	public Genre getnGenre() {
		return nGenre;
	}

	public void setnGenre(Genre nGenre) {
		this.nGenre = nGenre;
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
	
	public String toString() {
		return "Nom : "+getNom()+"\n"+
			"Prix : "+Double.toString(getPrix())+"\n"+
			"Date : "+Integer.toString(
					getDate())+"\n"+
			"Editeur : "+getEditeur().getName()+"\n"+
			"Genre : "+getGenre().getName()+"\n"+
			"Plateforme : "+getPlateforme().getName()+"\n"+
			"Note : "+Double.toString(getNote().getNote_sur_20())+"\n"+
			"Nombre votants : "+Integer.toString(
					getNote().getNbre_votants())+"\n"+
			"URL :"+ getLienBoutique()+"\n"+
			"EstDLC : "+Boolean.toString(isDLC);
	
	}
	
}
