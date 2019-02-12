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
		
		Jeu j1=new Jeu(null, null, 0, null, null, null, null, false, null);
		
		
		tmJeu.put(1,j1);
		Fenetre fen=new Fenetre();
		
		
		
		//Note_modele.ajoutNote(new Note(0,0));
	}

}
