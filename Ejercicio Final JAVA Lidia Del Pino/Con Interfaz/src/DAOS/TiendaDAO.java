package DAOS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EmpleadoTiendaConexion.ConexionBD;
import EmpleadoTiendaConexion.Tienda;

public class TiendaDAO {

	private ConexionBD conn;
	
	public TiendaDAO(ConexionBD conn) {
		this.conn = conn;
	}

	public void crearTablaTienda() throws SQLException {
		final String crear = "CREATE TABLE tienda(IDTIENDA INT PRIMARY KEY, NOMBRE VARCHAR(40), DIRECCION VARCHAR(50), POBLACION VARCHAR(40), PROVINCIA VARCHAR(40), CPOSTAL INT)";
		Statement st = conn.getConexion().createStatement();
		st.executeUpdate(crear);
		st.close();
	}
	
	public void insertar(Tienda t) throws SQLException {
		final String INSERT = "INSERT INTO tienda (idtienda, nombre, direccion, poblacion, provincia, cPostal) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = conn.getConexion().prepareStatement(INSERT);
		ps.setInt(1, t.getIdtienda());
		ps.setString(2, t.getNombre());
		ps.setString(3, t.getDireccion());
		ps.setString(4, t.getPoblacion());
		ps.setString(5, t.getProvincia()); 
		ps.setInt(6, t.getcPostal());
		ps.executeUpdate();
	}
	
	public void borrar(Tienda t) throws SQLException {
		final String DELETE = "DELETE FROM tienda WHERE idtienda = ?";
		PreparedStatement ps = conn.getConexion().prepareStatement(DELETE);
		ps.setInt(1, t.getIdtienda());
		ps.executeUpdate();
	}
	
	public void borrarPorID(int idtienda) throws SQLException {
		final String DELETE = "DELETE FROM tienda WHERE idtienda=?";
		PreparedStatement ps = conn.getConexion().prepareStatement(DELETE);
		ps.setInt(1, idtienda);
		ps.executeUpdate();
	}
	
	public void modificar(Tienda t) throws SQLException {
		final String UPDATE = "UPDATE tienda SET nombre = ?, direccion = ?, poblacion = ?, provincia = ?, cpostal = ? WHERE idtienda = ?";
		PreparedStatement ps = conn.getConexion().prepareStatement(UPDATE);
		ps.setString(1, t.getNombre());
		ps.setString(2, t.getDireccion());
		ps.setString(3, t.getPoblacion());
		ps.setString(4, t.getProvincia());
		ps.setInt(5, t.getcPostal());
		ps.setInt(6, t.getIdtienda());

		ps.executeUpdate();
	}

	public List<Tienda> listaTodasLasTiendas() throws SQLException{
		List<Tienda>listadetiendas=new ArrayList<Tienda>();
		final String SELECT = "SELECT * FROM tienda";
		Statement st=conn.getConexion().createStatement();
		ResultSet rs=st.executeQuery(SELECT);
		while(rs.next()) {
			
			int id=rs.getInt(1);
			String nombre= rs.getString(2);
			String direcc= rs.getString(3);
			String pob= rs.getString(4);
			String prov= rs.getString(5);
			int cPostal= rs.getInt(6);
			Tienda t=new Tienda(id, nombre, direcc, pob, prov, cPostal);
			listadetiendas.add(t);
		}
		return listadetiendas;
	}
	public void guardarEnTexto () throws IOException, SQLException {
		List<Tienda>listaTiendas=listaTodasLasTiendas();
		File f = new File("listadoDeTiendas.txt");
		FileWriter fw = new FileWriter(f);
		for(Tienda t : listaTiendas) {
			fw.write(t.toString()+ "\n");
		}
		fw.close();
	}

	
	}


