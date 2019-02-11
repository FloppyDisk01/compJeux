package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import Jeu.Jeu;

public class Jeu_modele {
	static TreeMap<Integer,Jeu> tmJeu;
	
	public static int getId(Jeu jv) {
		for(Entry<Integer, Jeu> entry : tmJeu.entrySet()){
		      if(entry.getValue()==jv) return entry.getKey();
		}
		return 0;
	}
	
	public static void supprJeu(Jeu jv) {
		/*Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Jeu VALUES (1,'nomediteur')";
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
		tmJeu.remove(jv);*/
	}
	
	public static ArrayList<Jeu> getJeuTous(){
		ArrayList<Jeu> al=new ArrayList<Jeu>();
		for(Entry<Integer, Jeu> entry : tmJeu.entrySet()){
		      al.add(entry.getValue());
		}
		
		return al;
	}
	
	public static boolean estenBD(Jeu jv) {
		
		return true;
	}
	
	public static Jeu getJeu(int id) {
		Jeu jv=new Jeu(null, null, null, id, null, false, null);
		
		return jv;
	}
	
	
	public static void ajoutJeu(Jeu jv) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Jeu VALUES (1,'nomediteur')";
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
