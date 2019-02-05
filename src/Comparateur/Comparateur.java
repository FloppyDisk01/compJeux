package Comparateur;

import java.util.Comparator;

import Jeu.Jeu_video;

public abstract class Comparateur implements Comparator<Jeu_video>{
	private Jeu_video jv_recherche;
	public int comparer(Jeu_video jv) {
		int score=0;
		
		if(this.jv_recherche.getNom()== jv.getNom()) {
			score=score+0;
		}
		
		
		
		return score;
	}
	public int compare(Jeu_video jv1,Jeu_video jv2) {
		return comparer(jv1)-comparer(jv2);
	}
}
