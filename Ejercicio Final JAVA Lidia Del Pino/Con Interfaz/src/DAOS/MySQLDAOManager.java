package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import EmpleadoTiendaConexion.ConexionBD;
import EmpleadoTiendaConexion.Empleado;

//Para controlar los DAOS de tienda y empleado
Jugador
public class MySQLDAOManager implements DAOManager {
	private ConexionBD conn;
	
	private TiendaDAO tienda=null;
	private EmpleadoDAO empleado=null;
	
	
	public MySQLDAOManager() throws SQLException {
		conn = new ConexionBD();
	}


	@Override
	public TiendaDAO getTiendaDAO() {
		if(tienda == null) {
			tienda = new TiendaDAO(conn);
		}
		return tienda;
	}


	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		if (empleado == null) {
			empleado = new EmpleadoDAO(conn);
		}
		return empleado;
	}
	
	public static void main(String[]args) throws SQLException, DAOException {
		MySQLDAOManager man = new MySQLDAOManager();
		List<Empleado>empleados = man.getEmpleadoDAO().listaTodosEmpleados();
		System.out.println(empleados);
	}


}
