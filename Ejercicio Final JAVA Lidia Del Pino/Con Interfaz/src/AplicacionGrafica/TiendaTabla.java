package AplicacionGrafica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAOS.DAOException;
import DAOS.TiendaDAO;
import EmpleadoTiendaConexion.Tienda;

public class TiendaTabla extends AbstractTableModel{

	private TiendaDAO tienda;
	private List<Tienda> datos = new ArrayList<>(); 

	public void updateModel() throws DAOException, SQLException {
		datos = tienda.listaTodasLasTiendas();
	}

	public TiendaTabla(TiendaDAO tienda) {
		this.tienda = tienda;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "idtienda";
		case 1:
			return "nombre";
		case 2:
			return "direccion";
		case 3:
			return "poblacion";
		case 4:
			return "provincia";
		case 5:
			return "cPostal";
		}
		return super.getColumnName(column);
	}

	@Override
	public int getRowCount() {
		return datos.size(); 
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= 0) {
			Tienda preguntado = datos.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return preguntado.getIdtienda();
			case 1:
				return preguntado.getNombre();
			case 2:
				return preguntado.getDireccion();
			case 3:
				return preguntado.getPoblacion();
			case 4:
				return preguntado.getProvincia();
			case 5:
				return preguntado.getcPostal();

			default:
				return "Errores en getvalueat";
			}
		}
		else return "Errores en getvalueat";
	}

}
