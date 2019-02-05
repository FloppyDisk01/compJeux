package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Jeu.Jeu_video;

public class ConnexionBD {
	
	
	public static void ajoutJV() {
		String url ="jdbc:mysql://mysql-ltpgame.alwaysdata.net/ltpgame_bd_projet";
		String login = "ltpgame_";
		String passwd = "projet4A";
		Connection cn=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, login, passwd);
			st=cn.createStatement();
			String sql="INSERT INTO Jeu_video VALUES ('1','a',30.0,'aventure','nintendo','ps4','1')";
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ajoutJV();
	}
}