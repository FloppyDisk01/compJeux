package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnexionBD {
	private  String url ="jdbc:mysql://mysql-ltpgame.alwaysdata.net/ltpgame_bd_projet";
	private String passwd = "projet4A";
	private String login = "ltpgame_";
	private static Connection cn;
	
	private ConnexionBD() {
		try {
			cn=DriverManager.getConnection(url, login, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection get_instance() {
		ConnexionBD connect=new ConnexionBD();
		return cn;
		
		
	}
	
	/*public static void ajoutJV() {
		
		
		
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
	}*/
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ajoutJV();
	}*/
}