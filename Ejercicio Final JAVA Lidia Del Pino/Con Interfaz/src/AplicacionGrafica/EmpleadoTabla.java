package AplicacionGrafica;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAOS.DAOException;
import DAOS.EmpleadoDAO;
import EmpleadoTiendaConexion.Empleado;

public class EmpleadoTabla extends AbstractTableModel {
	private EmpleadoDAO empleado;
	private List<Empleado> datos = new ArrayList<>();

	public void updateModel() throws DAOException, SQLException {
		datos = empleado.listaTodosEmpleados();
	}

	public EmpleadoTabla(EmpleadoDAO empleado) {
		this.empleado = empleado;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID empleado";
		case 1:
			return "ID tienda";
		case 2:
			return "Nombre";
		case 3:
			return "Edad";
		case 4:
			return "Ventas realizadas";
		}
		return super.getColumnName(column);
	}

	@Override
	public int getRowCount() {
		return datos.size(); 
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= 0) {
			Empleado preguntado = datos.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return preguntado.getIdempleado();
			case 1:
				return preguntado.getIdtienda();
			case 2:
				return preguntado.getNombre();
			case 3:
				return preguntado.getEdad();
			case 4:
				return preguntado.getNumeroVentas();

			default:
				return "Errores en getvalueat";
			}
		}
		else return "Errores en getvalueat";
	}

}
