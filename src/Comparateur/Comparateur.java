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
