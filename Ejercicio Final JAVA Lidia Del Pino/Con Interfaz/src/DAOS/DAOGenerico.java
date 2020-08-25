package DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EmpleadoTiendaConexion.ConexionBD;

public class DAOGenerico {
	private ConexionBD conn;
	private ResultSet rs;
	private Integer filasAfectadas;

	public DAOGenerico(ConexionBD conn) {
		this.conn = conn;
	}

	public DAOGenerico(String sentencia) throws SQLException {
		ejecuta(sentencia);
	}

	public void ejecuta(String sentencia) throws SQLException {
		try {
		PreparedStatement ps = conn.getConexion().prepareStatement(sentencia);
		boolean tipoResultado = ps.execute(sentencia);

		if (tipoResultado) {
			rs = ps.getResultSet();
		} else {
			filasAfectadas = ps.getUpdateCount();
		} 
		
		}catch(SQLException e1) {
			e1.printStackTrace(); 

		}
			
			
		
	}

	public ResultSet getResultSet() {
		return rs;
	}

	public Integer getFilasAfectadas() {
		return filasAfectadas;
	}

}
