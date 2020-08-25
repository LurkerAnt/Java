package JuEqCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private static final String URL="jdbc:mysql://localhost:3306/zaratienda";
	private static final String BD="zaratienda";
	private static final String USER="root";
	private static final String PWD="";
	private Connection conn = null;
	static Statement sentencia = null; 
	
	public ConexionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection(URL, USER, PWD);

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
			
	}
	
	public Connection getConexion() {
		return conn;
	}
	
	public void cierra() {
		if(conn!=null) {
				try {
				conn.close();
				conn=null; 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
