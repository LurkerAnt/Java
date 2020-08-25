package DAO.MYSQL;

import DAOS.DAOManager;
import DAOS.EquiposDAO;
import DAOS.JugadorDAO;
import jugadores_equipos.Jugador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLDaoManager implements DAOManager {
    String configUTF="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection conexion;

    private MySQLJugadorDAO jugadorDAO=null;
    private MySQLEquiposDAO equiposDAO=null;

    public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
        conexion= DriverManager.getConnection("jdbc:mysql://"+host+ "/"+ database+configUTF, username,password);
    }

    @Override
    public JugadorDAO getJugadorDAO() {
        if (jugadorDAO==null){
         jugadorDAO=new MySQLJugadorDAO(conexion);
        }
        return jugadorDAO;
    }

    @Override
    public EquiposDAO getEquiposDAO() {
        if (equiposDAO==null){
            equiposDAO=new MySQLEquiposDAO(conexion);
        }
        return equiposDAO;
    }

    public static void main(String[] args) throws DAOException, SQLException {
        MySQLDaoManager mySQLDaoManager= new MySQLDaoManager("localhost", "userJDBC", "12345", "equipos");
        List<Jugador> listaJugadores= mySQLDaoManager.getJugadorDAO().obtenerObjetos();
        for (Jugador j: listaJugadores) {
            System.out.println(j);

        }
    }

}
