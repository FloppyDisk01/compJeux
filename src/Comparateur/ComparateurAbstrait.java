package Comparateur;

import java.util.Comparator;

import Jeu.Jeu;

public abstract class ComparateurAbstrait implements Comparator<Jeu>{
	 Jeu jvrecherche;

	 
	public abstract int comparer(Jeu jv);
	
	@Override
	public int compare(Jeu arg0, Jeu arg1) {
		// TODO Auto-generated method stub
		return comparer(arg0)-comparer(arg1);
	}
	
	
}
