package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import Comparateur.Utilisateur;
import Jeu.Jeu;

public class Utilisateur_modele {
	
	public static TreeMap<Integer,Utilisateur> tmUtilisateur;
	
	public Utilisateur_modele(){
        tmUtilisateur = new TreeMap<Integer,Utilisateur>();
    }
	
	public static String getMdp(Utilisateur u) {
		String mdp=null;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="SELECT * FROM Utilisateur";
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				if(u.getNom().equals(result.getString("nom")) ){
					
					mdp=result.getString("mdp");
					
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
		
		return mdp;
		
	}
	
	public static int getId(String nom) {
		int id=0;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="SELECT * FROM Utilisateur";
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				if(nom.equals(result.getString("nom")) ){
					
					id=result.getInt("Id_utilisateur");
					
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
		
		return id;
		
	}
	
	public static boolean estAdmin(Utilisateur u) {
		boolean estadmin=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="SELECT * FROM Utilisateur";
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				int test =0;
				
				if(u.getNom().equals(result.getString("nom")) ){
					
					test=result.getInt("estAdmin");
					
				}
				if(test==1) estadmin=true;
				else estadmin=false;
				
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
		return estadmin;
	}

	public static TreeMap<Integer, Utilisateur> getTmUtilisateur() {
		return tmUtilisateur;
	}

	public static void setTmUtilisateur(TreeMap<Integer, Utilisateur> tmUtilisateur) {
		Utilisateur_modele.tmUtilisateur = tmUtilisateur;
	}
	
	
}
