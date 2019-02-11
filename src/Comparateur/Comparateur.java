package Comparateur;

import Jeu.Jeu;

public class Comparateur extends ComparateurAbstrait{
	
	public Comparateur(Jeu jv){
		this.jvrecherche=jv;
		
	}
	

	@Override
	public int comparer(Jeu jv) {
		// TODO Auto-generated method stub
		int score=0;
		
		
		
		return score;
	}
	
	public int minimum(int a, int b, int c) {                            
        return Math.min(Math.min(a, b), c);                                      
    } 
}
