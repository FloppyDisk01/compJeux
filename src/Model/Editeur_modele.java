package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Objects;
import java.util.TreeMap;

import Jeu.Editeur;

public class Editeur_modele {
	static TreeMap<Integer,Editeur> tmEditeur;
	
	public static int getId(Editeur ed) {
		return 1;
	}
	
	public static void supprEditeur(Editeur ed) {
		
	}
	
	public static ArrayList<Editeur> getEditeurTous(){
		ArrayList<Editeur> al=new ArrayList<Editeur>();
		
		return al;
	}
	
	public static boolean estenBD(Editeur ed) {
		return true;
	}
	
	public static Editeur getEditeur(int id) {
		Editeur ed=new Editeur("aaa");
		
		return ed;
	}
	
	
	public static void ajoutEditeur(Editeur ed) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Editeur VALUES (1,'nomediteur')";
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
