package DAOS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EmpleadoTiendaConexion.ConexionBD;
import EmpleadoTiendaConexion.Empleado;

public class EmpleadoDAO{

	private ConexionBD conn;
	
	public EmpleadoDAO(ConexionBD conn) {
		this.conn=conn; 
	}

	public void crearTabla() throws SQLException {
		final String crear = "CREATE TABLE empleado(IDEMPLEADO INT AUTO_INCREMENT PRIMARY KEY, IDTIENDA INT(2), NOMBRE VARCHAR(40), NVENTAS INT(2), EDAD INT(2))";
		Statement st = conn.getConexion().createStatement();
		st.executeUpdate(crear);
		st.close();
	}


	public void insertar(Empleado e) throws DAOException {
		final String INSERT = "INSERT INTO empleado (idempleado, idtienda, nombre, nVentas, edad) VALUES (NULL,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.getConexion().prepareStatement(INSERT);
			//ps.setInt(1, e.getIdempleado());
			ps.setInt(1, e.getIdtienda());
			ps.setString(2, e.getNombre());
			ps.setInt(3, e.getNumeroVentas());
			ps.setInt(4, e.getEdad());
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DAOException("error en la inserción");
			
		}
	}

	public void modificar(Empleado e) throws SQLException, DAOException {
		final String UPDATE = "UPDATE empleado SET idtienda = ?, nombre = ?, nVentas = ?, edad = ? WHERE  idempleado = ? ";
		//es el statement, no la posicion en la base de datos
		//en resultset si q es
		try{
			PreparedStatement ps = conn.getConexion().prepareStatement(UPDATE);
			ps.setInt(1, e.getIdtienda());
			ps.setString(2, e.getNombre());
			ps.setInt(3, e.getNumeroVentas());
			ps.setInt(4, e.getEdad());
			ps.setInt(5, e.getIdempleado());
			ps.executeUpdate();
		} catch(SQLException e1) {
			e1.printStackTrace();
			throw new DAOException("error en la modificación");
		}
				
	}

	public void borrar(Empleado e) throws DAOException {
		final String DELETE = "DELETE FROM empleado WHERE idempleado = ?";
		try {
		PreparedStatement ps = conn.getConexion().prepareStatement(DELETE);
		ps.setInt(1, e.getIdempleado());
		ps.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
			throw new DAOException("error en el borrado");
		}
	}


	public List<Empleado> listaTodosEmpleados() throws SQLException{
		List<Empleado>listadeempleados=new ArrayList<Empleado>();
		final String SELECT = "SELECT * FROM EMPLEADO";
		Statement st=conn.getConexion().createStatement();
		ResultSet rs=st.executeQuery(SELECT);
		while(rs.next()) {
			int id=rs.getInt(1);
			int idt= rs.getInt(2);
			String no= rs.getString(3);
			int numeroVentas= rs.getInt(4);
			int edad =rs.getInt(5);
			Empleado e=new Empleado(id, idt, no, numeroVentas, edad);
			listadeempleados.add(e);
		}
		return listadeempleados;
	}
	
	public void guardarEnTexto () throws IOException, SQLException {
		List<Empleado>listaEmpleados=listaTodosEmpleados();
		File f = new File("listadoDeEmpleados.txt");
		FileWriter fw = new FileWriter(f);
		for(Empleado e : listaEmpleados) {
			fw.write(e.toString()+ "\n");
		}
		fw.close();
	}

	
	
	}


