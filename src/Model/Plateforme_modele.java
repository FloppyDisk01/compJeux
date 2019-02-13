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

import Jeu.Plateforme;
import Jeu.Jeu;

public class Plateforme_modele {
	static TreeMap<Integer,Plateforme> tmPlateforme;
	
	public Plateforme_modele(){
        tmPlateforme = new TreeMap<Integer,Plateforme>();
    }
	
	

	public static int getId(Plateforme ed) {
		
		for(Entry<Integer, Plateforme> entry : tmPlateforme.entrySet()){
		      if(entry.getValue()==ed) return entry.getKey();
		}
		return 0;
	
	}
	
	public static void supprPlateforme(Plateforme ed) {
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="DELETE FROM Plateforme WHERE Id_plateforme="+
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
		tmPlateforme.remove(getId(ed));
		
	}
	
	public static ArrayList<Plateforme> getPlateformeTous(){
		ArrayList<Plateforme> al=new ArrayList<Plateforme>();
		
		return al;
	}
	
	public static boolean estenBD(Plateforme ed) {
		
		
		boolean estbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql;
			
				sql="SELECT * FROM Plateforme";
			
			
			
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				
				if(Integer.toString(getId(ed)).equals(result.getString("Id_plateforme")) ){
					
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
	
	public static Plateforme getPlateforme(int id) {
		return tmPlateforme.get(id);
	}
	
	
	public static void ajoutPlateforme(Plateforme ed) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		
		if(tmPlateforme.isEmpty()) tmPlateforme.put(1, ed);
		else tmPlateforme.put(tmPlateforme.lastKey()+1, ed);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Plateforme VALUES ("+
					Integer.toString(tmPlateforme.size())+",'"+ed.getName()+"')";
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
	
	public static TreeMap<Integer, Plateforme> getTmPlateforme() {
		return tmPlateforme;
	}

	public static void setTmPlateforme(TreeMap<Integer, Plateforme> tmPlateforme) {
		Plateforme_modele.tmPlateforme = tmPlateforme;
	}
	
	
}
