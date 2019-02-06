package Jeu;

import java.util.ArrayList;
import java.util.Date;

public class Jeu_video {
	private String nom;
	private double prix;
	private String genre;
	private String editeur;
	private Date date_sortie;
	private String plateforme;
	private boolean estDLC;
	
	private Note note;
	private Online online;

	

	public Jeu_video(String nom, double prix, String genre, String editeur, String plateforme, boolean estDLC,
			Note note,  Online online, Date date) {
		
		this.nom = nom;
		this.prix = prix;
		this.genre = genre;
		this.editeur = editeur;
		this.plateforme = plateforme;
		this.estDLC = estDLC;
		this.note = note;
	
		this.online = online;
		this.date_sortie=date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public String getPlateforme() {
		return plateforme;
	}

	public void setPlateforme(String plateforme) {
		this.plateforme = plateforme;
	}

	public boolean isEstDLC() {
		return estDLC;
	}

	public void setEstDLC(boolean estDLC) {
		this.estDLC = estDLC;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}



	public Online getOnline() {
		return online;
	}

	public void setOnline(Online online) {
		this.online = online;
	}

	public Date getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	
	
}
