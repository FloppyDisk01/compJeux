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

import Jeu.Genre;
import Jeu.Jeu;

public class Genre_modele {
	static TreeMap<Integer,Genre> tmGenre;
	
	public Genre_modele(){
        tmGenre = new TreeMap<Integer,Genre>();
    }
	
	

	public static int getId(Genre ed) {
		
		for(Entry<Integer, Genre> entry : tmGenre.entrySet()){
		      if(entry.getValue()==ed) return entry.getKey();
		}
		return 0;
	
	}
	
	public static void supprGenre(Genre ed) {
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM Genre WHERE Id_genre="+
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
		tmGenre.remove(ed);
		
	}
	
	public static ArrayList<Genre> getGenreTous(){
		ArrayList<Genre> al=new ArrayList<Genre>();
		
		return al;
	}
	
	public static boolean estenBD(Genre ed) {
		
		
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			
				sql="SELECT * FROM Genre";
			
			
			
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				
				if(Integer.toString(getId(ed)).equals(result.getString("Id_genre")) ){
					
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
	
	public static Genre getGenre(int id) {
		return tmGenre.get(id);
	}
	
	
	public static void ajoutGenre(Genre ed) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		tmGenre.put(tmGenre.size()+1, ed);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Genre VALUES ("+
			Integer.toString(tmGenre.size())+",'"+ed.getName()+"')";
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
	
	
	public static TreeMap<Integer, Genre> getTmGenre() {
		return tmGenre;
	}

	public static void setTmGenre(TreeMap<Integer, Genre> tmGenre) {
		Genre_modele.tmGenre = tmGenre;
	}
	
}
