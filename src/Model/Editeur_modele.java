package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Objects;
import java.util.TreeMap;

import Jeu.Editeur;
import Jeu.Jeu;

public class Editeur_modele {
	static TreeMap<Integer,Editeur> tmEditeur;
	
	public Editeur_modele(){
        tmEditeur = new TreeMap<Integer,Editeur>();
    }
	
	public static TreeMap<Integer, Editeur> getTmEditeur() {
		return tmEditeur;
	}

	public static void setTmEditeur(TreeMap<Integer, Editeur> tmEditeur) {
		Editeur_modele.tmEditeur = tmEditeur;
	}

	public static int getId(Editeur ed) {
		
		for(Entry<Integer, Editeur> entry : tmEditeur.entrySet()){
		      if(entry.getValue()==ed) return entry.getKey();
		}
		return 0;
	
	}
	
	public static void supprEditeur(Editeur ed) {
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM Editeur WHERE Id_editeur="+
			Integer.toString(getId(ed));
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		tmEditeur.remove(getId(ed));
		
	}
	
	public static ArrayList<Editeur> getEditeurTous(){
		ArrayList<Editeur> al=new ArrayList<Editeur>();
		
		return al;
	}
	
	public static boolean estenBD(Editeur ed) {
		
		
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			
			sql="SELECT * FROM Editeur";
			
			
			
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				
				if(getId(ed)==result.getInt("Id_editeur") ){
					
					estbd=true;
					
				}
				
			}
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return estbd;
		
	}
	
	public static Editeur getEditeur(int id) {
		return tmEditeur.get(id);
	}
	
	
	public static void ajoutEditeur(Editeur ed) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		
		
		if(tmEditeur.isEmpty()) tmEditeur.put(1, ed);
		else tmEditeur.put(tmEditeur.lastKey()+1, ed);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Editeur VALUES ("+
			Integer.toString(tmEditeur.size())+",'"+ed.getName()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
