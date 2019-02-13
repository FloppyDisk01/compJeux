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
			System.out.println("test"+Integer.toString(getId(jv)));
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
		System.out.println("test apres sql "+Integer.toString(getId(jv)));
		tmJeu.remove(getId(jv));
	}
	
	public static void viderBDD() {
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM Jeu";
			st.executeUpdate(sql);
			sql="DELETE FROM Editeur";
			st.executeUpdate(sql);
			sql="DELETE FROM Note";
			st.executeUpdate(sql);
			sql="DELETE FROM Plateforme";
			st.executeUpdate(sql);
			sql="DELETE FROM Genre";
			st.executeUpdate(sql);
			sql="DELETE FROM Reservation";
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
	
	public static ArrayList<Jeu> getJeuTous(){
		ArrayList<Jeu> al=new ArrayList<Jeu>();
		for(Entry<Integer, Jeu> entry : tmJeu.entrySet()){
		      al.add(entry.getValue());
		}
		
		return al;
	}
	
	public static boolean estenBD(Jeu jv) {
		
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			
			
				sql="SELECT * FROM Jeu";
			
			
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
		if(tmJeu.isEmpty()) tmJeu.put(1, jv);
		else tmJeu.put(tmJeu.lastKey()+1, jv);
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		int estdlc=(jv.isDLC()) ? 1 : 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			
			
			String sql="INSERT INTO Jeu VALUES ("+
					Integer.toString(tmJeu.lastKey() )
					+",'"+jv.getNom()+"','"+
					Double.toString(jv.getPrix())+"','"+
					Integer.toString(jv.getDatesortie())+"',"+
					Integer.toString(estdlc)+","+
					Integer.toString(Note_modele.getId(jv.getNote()))+","+
					Integer.toString(Plateforme_modele.getId(jv.getnPlateforme()))+","+
					Integer.toString(Genre_modele.getId(jv.getGenre()))+","+
					Integer.toString(Editeur_modele.getId(jv.getnEditeur()))+",'"+
					jv.getLienBoutique()+"')";
			
			
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

	public static void jvmodif(Jeu jeu, Jeu jeuAModif) {
		// TODO Auto-generated method stub
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		int estdlc=(jeuAModif.isDLC()) ? 1 : 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			
			
			String sql="UPDATE Jeu SET nom = '"+jeuAModif.getNom()+
					"',prix ="+Double.toString(jeuAModif.getPrix())+
					",date_sortie ="+Integer.toString(jeuAModif.getDate())+
					", estDLC="+Integer.toString(estdlc)+" WHERE Id_jeu = "+
					Integer.toString(getId(jeu));
				    
				System.out.println(sql);
			
			
			st.executeUpdate(sql);
			
			sql="UPDATE Note SET note_sur_20 = "+Double.toString(
					jeuAModif.getNote().getNote_sur_20())+
					" ,nombre_votants ="+Integer.toString(
							jeuAModif.getNote().getNbre_votants())+" WHERE Id_note = "+
					Integer.toString(Note_modele.getId(jeu.getNote()));
				    
				System.out.println(sql);
			
			
			st.executeUpdate(sql);
			
			sql="UPDATE Editeur SET nom = '"+jeuAModif.getEditeur().getName()+
					" ' "+" WHERE Id_editeur = "+
					Integer.toString(Editeur_modele.getId(jeu.getEditeur()));
				    
				System.out.println(sql);
			
			
			st.executeUpdate(sql);
			
			sql="UPDATE Plateforme SET nom = '"+jeuAModif.getPlateforme().getName()+
					" ' "+" WHERE Id_plateforme = "+
					Integer.toString(Plateforme_modele.getId(jeu.getPlateforme()));
				    
				System.out.println(sql);
			
			
			st.executeUpdate(sql);
			
			sql="UPDATE Genre SET nom = '"+jeuAModif.getGenre().getName()+
					" ' "+" WHERE Id_genre = "+
					Integer.toString(Genre_modele.getId(jeu.getGenre()));
				    
				System.out.println(sql);
			
			
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
