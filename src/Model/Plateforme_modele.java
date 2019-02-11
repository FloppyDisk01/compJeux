package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

import Jeu.Plateforme;

public class Plateforme_modele {
static TreeMap<Integer,Plateforme> tmPlateforme;
	
	public static int getId(Plateforme n) {
		return 1;
	}
	
	public static void supprPlateforme(Plateforme n) {
		
	}
	
	public static ArrayList<Plateforme> getPlateformeTous(){
		ArrayList<Plateforme> al=new ArrayList<Plateforme>();
		
		return al;
	}
	
	public static boolean estenBD(Plateforme n) {
		return true;
	}
	
	public static Plateforme getPlateforme(int id) {
		Plateforme p=new Plateforme("aaa");
		
		return p;
	}
	
	
	public static void ajoutPlateforme(Plateforme p) {
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Plateforme VALUES (1,'nomplateforme')";
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
