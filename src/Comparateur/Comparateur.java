package Comparateur;

import Jeu.Jeu;

public class Comparateur extends ComparateurAbstrait{
	
	public Comparateur(Jeu jv){
		this.jvrecherche=jv;
	}
	

	@Override
	public int comparer(Jeu jv) {
		// TODO Auto-generated method stub
		Double score=0.0;
		
		//ajout note jeu
		score += jv.getNote().getNote_sur_20()*jv.getNote().getNbre_votants();
		//nom
		score += 100 * Distance(jv.getNom(), jvrecherche.getNom());
		//genre
		score += 80 * Distance(jv.getGenre().getName(), jvrecherche.getGenre().getName());
		//prix
		score += 80*(1-(jv.getPrix()-jvrecherche.getPrix()));
		//date sortie
		score += 50*(1-(jv.getDate()-jvrecherche.getDate()));
		//plateforme
		score += 30 * Distance(jv.getPlateforme().getName(), jvrecherche.getPlateforme().getName());
		//Editeur
		score += 30 * Distance(jv.getEditeur().getName(), jvrecherche.getEditeur().getName());
		System.out.println("score = :" + Double.toString(score));
		return score.intValue();
	}
	
	public int minimum(int a, int b, int c) {                            
        return Math.min(Math.min(a, b), c);                                      
    } 
	
	public int Distance(String lhs, String rhs) {      
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];        
                                                                                 
        for (int i = 0; i <= lhs.length(); i++)                                 
            distance[i][0] = i;                                                  
        for (int j = 1; j <= rhs.length(); j++)                                 
            distance[0][j] = j;                                                  
                                                                                 
        for (int i = 1; i <= lhs.length(); i++)                                 
            for (int j = 1; j <= rhs.length(); j++)                             
                distance[i][j] = minimum(                                        
                        distance[i - 1][j] + 1,                                  
                        distance[i][j - 1] + 1,                                  
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));
                                                                                 
        return distance[lhs.length()][rhs.length()];                           
    }   
}
