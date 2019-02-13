package Comparateur;
import Jeu.*;

import java.util.TreeMap;

import IHM.*;
import Model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jeu_modele j=new Jeu_modele();
		TreeMap<Integer,Jeu> tmJeu= Jeu_modele.getTmJeu();
		
		Editeur_modele ed=new Editeur_modele();
		TreeMap<Integer,Editeur> tmEditeur= Editeur_modele.getTmEditeur();
		
		Note_modele n=new Note_modele();
		TreeMap<Integer,Note> tmNote= Note_modele.getTmNote();
		
		Plateforme_modele pla=new Plateforme_modele();
		TreeMap<Integer,Plateforme> tmPlateforme= Plateforme_modele.getTmPlateforme();
		
		Genre_modele g=new Genre_modele();
		TreeMap<Integer,Genre> tmGenre= Genre_modele.getTmGenre();
		
		Utilisateur_modele u=new Utilisateur_modele();
		TreeMap<Integer,Utilisateur> tmUtilisateur= Utilisateur_modele.getTmUtilisateur();
		
		Reservation_modele re=new Reservation_modele();
		TreeMap<Integer,Integer> tmReservation= Reservation_modele.getTmReservation();
		
		Jeu_modele.viderBDD();
		Genre g1=new Genre("Aventure");
		Editeur ed1=new Editeur("Square Enix");
		Plateforme p1=new Plateforme("PS2");
		Note n1=new Note(15,300);
		Jeu jv1=new Jeu("Kingdom Hearts", g1, 2002, ed1, p1
				, n1, 50.0, false, "Lien");
		
		jv1.ajoutJeu();
		
		Genre g2=new Genre("Action");
		Editeur ed2=new Editeur("Nintendo");
		Plateforme p2=new Plateforme("Wii");
		Note n2=new Note(13,100);
		Jeu jv2=new Jeu("SSBB", g2, 2006, ed2, p2
				, n2, 30.0, false, "Lien2");
		
		jv2.ajoutJeu();
		
		Genre g3=new Genre("Combat");
		Editeur ed3=new Editeur("Nintendo");
		Plateforme p3=new Plateforme("Switch");
		Note n3=new Note(13,100);
		Jeu jv3=new Jeu("Animal Crossing", g3, 2017, ed3, p3
				, n3, 40.0, true, "Lien3");
		
		jv3.ajoutJeu();
		
		Genre g4=new Genre("Combat");
		Editeur ed4=new Editeur("Nintendo");
		Plateforme p4=new Plateforme("Switch");
		Note n4=new Note(13,100);
		Jeu jv4=new Jeu("Super street2", g4, 2017, ed4, p4
				, n4, 40.0, true, "Lien3");
		
		jv4.ajoutJeu();
		
		
		Fenetre fen=new Fenetre();
		
		
		
	}

}
