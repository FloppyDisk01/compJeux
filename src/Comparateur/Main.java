package Comparateur;
import Jeu.*;

import java.util.TreeMap;

import IHM.*;
import Model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre fen=new Fenetre();
		TreeMap<Integer,Jeu> tmJeu= Jeu_modele.getTmJeu();
		tmJeu.put(1, new Jeu(null, null, 0, null, null, null, null, false, null));
		
		//Note_modele.ajoutNote(new Note(0,0));
	}

}
