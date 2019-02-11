package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import Jeu.Note;

public class Note_modele {
	
	static TreeMap<Integer,Note> tmNote;
	
	public static int getId(Note n) {
		return 1;
	}
	
	public static void supprNote(Note n) {
		
	}
	
	public static ArrayList<Note> getNoteTous(){
		ArrayList<Note> al=new ArrayList<Note>();
		
		return al;
	}
	
	public static boolean estenBD(Note n) {
		return true;
	}
	
	public static Note getNote(int id) {
		Note n=new Note(0,0);
		
		return n;
	}
	
	
	public static void ajoutNote(Note n) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Note VALUES (1,20,1000)";
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
