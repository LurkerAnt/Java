package JuEqCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
	static String url = "jdbc:mysql://remotemysql.com:3306/cXfoFhKaUb";
	static String bd = "cXfoFhKaUb";
	static String user = "cXfoFhKaUb";
	static String password = "KYiH3bjDhr";

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);

			System.out.println("Conexión realizada con éxito a: " + bd);

			if (conn != null) {
				System.out.println("Conexión realizada con éxito");
				conn.close();
			}

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver JDBC no encontrado");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error al conectarse a la BD");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error general");
			e.printStackTrace();
		}

	}

}
