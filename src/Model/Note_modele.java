package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import Jeu.Jeu;
import Jeu.Note;
import Jeu.Plateforme;

public class Note_modele {
	
	static TreeMap<Integer,Note> tmNote;
	
	public Note_modele(){
        tmNote = new TreeMap<Integer,Note>();
    }
	
	

	public static int getId(Note n) {
		
		for(Entry<Integer, Note> entry : tmNote.entrySet()){
		      if(entry.getValue()==n) return entry.getKey();
		}
		return 0;
		
	}
	
	public static void supprNote(Note n) {
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM NoteWHERE Id_note="+
			Integer.toString(getId(n));
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
		tmNote.remove(n);
	}
	
	public static ArrayList<Note> getNoteTous(){
		ArrayList<Note> al=new ArrayList<Note>();
		
		return al;
	}
	
	public static boolean estenBD(Note n) {
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			
				sql="SELECT * FROM Note";
			
			
			
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				
				if(Integer.toString(getId(n)).equals(result.getString("Id_note")) ){
					
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
	
	public static Note getNote(int id) {
		return tmNote.get(id);
	}
	
	
	public static void ajoutNote(Note n) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		tmNote.put(tmNote.size()+1, n);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Note VALUES ("+
			Integer.toString(tmNote.size())+","+
					n.getNote_sur_20()+","+n.getNbre_votants()+")";
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
	
	public static TreeMap<Integer, Note> getTmNote() {
		return tmNote;
	}

	public static void setTmNote(TreeMap<Integer, Note> tmNote) {
		Note_modele.tmNote = tmNote;
	}
}
