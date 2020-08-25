package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    // esto se ha tenido que añadir el chorro de config despues de la database por
    // problemas de compatibilidad de UTF (franja horaria)
    // https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
    //Estos datos no se modifican asique final y private.
    private final String JDBC = "jdbc:mysql://localhost:3306/equipos";
    private final String configUTF = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private final String USER = "userJDBC";
    private final String PASSWORD = "12345";

    private Connection conexion = null;
    private Statement sentenciaSQL = null;

    //constructor, llama al método de abajo
    public ConexionBD() {
        conexionABaseDeDatos();
    }

    //inicia la BD en caso de que se haya cerrado.
    public void conexionABaseDeDatos() {
        try {
            conexion = DriverManager.getConnection(JDBC+configUTF, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error en su conexion, compurebela e intentelo de nuevo");
        }
    }

    //Cierra BD
    public void cerrarConexionABD() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Devuelve conexion, no se si lo usare pero ahi está.
    public Connection getConexion() {
        return conexion;
    }
}
