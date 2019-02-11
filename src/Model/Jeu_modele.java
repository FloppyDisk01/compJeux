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
		
		return true;
	}
	
	public static Jeu getJeu(int id) {
<<<<<<< HEAD
		Jeu jv=new Jeu(null, 0, null, null, null, null, false);
=======
		Jeu jv=new Jeu(null, null, id, null, null, null, null, false);
>>>>>>> branch 'master' of https://github.com/FloppyDisk01/compJeux.git
		
		return jv;
	}
	
	
	public static void ajoutJeu(Jeu jv) {
		tmJeu.put(tmJeu.lastKey()+1, jv);
		Connection cn=ConnexionBD.get_instance();
		Statement st=null;
		int estdlc=(jv.isDLC()) ? 1 : 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			st=cn.createStatement();
			String sql="INSERT INTO Jeu VALUES ("+
					Integer.toString(tmJeu.lastKey()+1 )
					+",'"+jv.getnJeu()+"',"+
					Double.toString(jv.getPrix())+","+
					Integer.toString(jv.getDatesortie())+","+
					Integer.toString(estdlc)+","+
					Integer.toString(Note_modele.getId(jv.getNote()))+","+
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
}
