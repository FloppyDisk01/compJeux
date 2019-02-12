package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import Comparateur.Utilisateur;

public class Reservation_modele {
	public static TreeMap<Integer,Integer> tmReservation;
	
	public static boolean estenBD(int Id_jeu, int Id_utilisateur) {
		boolean estenbd=false;
		
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="SELECT * FROM Reservation";
			ResultSet result =st.executeQuery(sql);
			
			while(result.next()) {
				
				
				if(Id_jeu==Integer.parseInt(result.getString("Id_jeu"))
						&& Id_utilisateur==Integer.parseInt(result.getString("Id_utilisateur"))){
					
					estenbd=true;
					
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
		return estenbd;
	}
}
