package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
/*
import Jeu.Editeur;

public class Editeur_modele {
	private static TreeMap<Integer,Editeur> tmEditeur;
	
	public static int getid(Editeur e) {
		for(Entry<Integer, Editeur> entry : tmEditeur.entrySet()) {
			if(Objects.equals(e, entry.getValue())) return entry.getKey();
		}
		return 0;
	}
	
	public static void supprEditeur(Editeur e) {
		Connection cn= null;
		Statement st=null;
		//String id= Integer.toString(getid(e));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=ConnexionBD.get_instance();
			st=cn.createStatement();
			String sql="DELETE FROM Editeur WHERE nom="+e.getnom()+";";
			st.executeUpdate(sql);
			tmEditeur.remove(getid(e));
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	static void ajoutEditeur(Editeur e) {
		
	}
	
	
}*/
