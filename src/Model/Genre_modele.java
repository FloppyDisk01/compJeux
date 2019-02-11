package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

import Jeu.Genre;

public class Genre_modele {
static TreeMap<Integer,Genre> tmGenre;
	
	public static int getId(Genre g) {
		return 1;
	}
	
	public static void supprGenre(Genre g) {
		
	}
	
	public static ArrayList<Genre> getGenreTous(){
		ArrayList<Genre> al=new ArrayList<Genre>();
		
		return al;
	}
	
	public static boolean estenBD(Genre g) {
		return true;
	}
	
	public static Genre getGenre(int id) {
		Genre g=new Genre("aaa");
		
		return g;
	}
	
	
	public static void ajoutGenre(Genre n) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Genre VALUES (1,'nomgenre')";
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
