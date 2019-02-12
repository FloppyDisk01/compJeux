package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import Jeu.Jeu;

public class Jeu_modele {
	private static TreeMap<Integer,Jeu> tmJeu;
	
	public Jeu_modele(){
        tmJeu = new TreeMap<Integer,Jeu>();
    }
	
	public static int getId(Jeu jv) {
		for(Entry<Integer, Jeu> entry : tmJeu.entrySet()){
		      if(entry.getValue()==jv) return entry.getKey();
		}
		return 0;
	}
	
	public static void supprJeu(Jeu jv) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM Jeu WHERE Id_jeu="+
			Integer.toString(getId(jv));
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
		tmJeu.remove(jv);
	}
	
	public static ArrayList<Jeu> getJeuTous(){
		ArrayList<Jeu> al=new ArrayList<Jeu>();
		for(Entry<Integer, Jeu> entry : tmJeu.entrySet()){
		      al.add(entry.getValue());
		}
		
		return al;
	}
	
	public static boolean estenBD(Jeu jv) {
		int estdlc=(jv.isDLC()) ? 1 : 0;
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			if(estdlc==1) {
				sql="SELECT * FROM Jeu WHERE estDLC=1";
			}
			else{
				sql="SELECT * FROM Jeu WHERE estDLC=0";
			}
			
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				
				if(Integer.toString(getId(jv)).equals(result.getString("Id_jeu")) ){
					
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
	
	public static Jeu getJeu(int id) {
		
		return tmJeu.get(id);
	}
	
	
	public static void ajoutJeu(Jeu jv) {
		tmJeu.put(tmJeu.size()+1, jv);
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		int estdlc=(jv.isDLC()) ? 1 : 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Jeu VALUES ("+
					Integer.toString(tmJeu.size()+1 )
					+",'"+jv.getnJeu()+"',"+
					Double.toString(jv.getPrix())+","+
					Integer.toString(jv.getDatesortie())+","+
					Integer.toString(estdlc)+","+
					Integer.toString(Note_modele.getId(jv.getNote()))+","+
					Integer.toString(Plateforme_modele.getId(jv.getnPlateforme()))+","+
					Integer.toString(Genre_modele.getId(jv.getGenre()))+","+
					Integer.toString(Editeur_modele.getId(jv.getnEditeur()))+","+")";
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
	
	public static TreeMap<Integer,Jeu> getTmJeu(){
		return Jeu_modele.tmJeu;
	}
}
