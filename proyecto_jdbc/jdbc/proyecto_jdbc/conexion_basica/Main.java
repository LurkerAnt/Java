package conexion_basica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static void main (String[]Args) throws ClassNotFoundException{
		Connection conexion=null;
		String jdbc="jdbc:mysql://localhost:3306/equipos_BD";
		//para drivers antiguos, por compatibilidad
		//Class.forName("com.mysql.jdbc.Driver");
		
		try {
			conexion=DriverManager.getConnection(jdbc, "equipo_BD", "equipo_BD");
		}catch (SQLException sql){
			sql.printStackTrace();
		}finally {
			if (conexion!=null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
