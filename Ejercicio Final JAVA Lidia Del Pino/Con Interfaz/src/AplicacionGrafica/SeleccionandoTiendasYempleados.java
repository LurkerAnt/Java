package AplicacionGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAOS.DAOGenerico;
import EmpleadoTiendaConexion.ConexionBD;

import javax.swing.JTable;
import javax.swing.JScrollBar;

public class SeleccionandoTiendasYempleados extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionandoTiendasYempleados frame = new SeleccionandoTiendasYempleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public SeleccionandoTiendasYempleados() throws SQLException {
		setTitle("SELECCIONA UNA TIENDA PARA VER SUS EMPLEADOS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table1 = new JTable();
		table1.setBounds(6, 6, 438, 141);
		contentPane.add(table1);
		DefaultTableModel model = new DefaultTableModel();

		table1.setModel(model);

		ConexionBD conn = new ConexionBD();
		Connection conexion = conn.getConexion();
		String sql = "SELECT * FROM tienda";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(sql);

		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			model.addColumn(rsmd.getColumnName(i));
		}
		while (rs.next()) {
			List<String> dato = new ArrayList<>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dato.add(rs.getString(i));
			}
			model.addRow(dato.toArray());
		}


		
		//Tabla de los empleados x cada tienda
		table2 = new JTable();
		table2.setBounds(6, 159, 438, 112);
		contentPane.add(table2);
		
		//para q salga empleadostable2.setModel(model);
/**/
		
		//String sql2 = "SELECT * FROM empleado WHERE idtienda = ?";
		//PreparedStatement ps = conn.getConexion().prepareStatement(sql2);
		

		
		/**/
		
		
		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table1.getSelectedRow() >= 0) {
					
					String idtiendatabla= (String) table1.getValueAt(table1.getSelectedRow(), 0 );
					System.out.println(idtiendatabla);
					try {
						final String SELECT = "SELECT * FROM empleado WHERE idtienda = ?";
						PreparedStatement ps = conn.getConexion().prepareStatement(SELECT);
						ps.setString(1, idtiendatabla);
						ResultSet rs=ps.executeQuery();

						
						ResultSetMetaData rsmd = rs.getMetaData();
						
						DefaultTableModel model = new DefaultTableModel();
						table2.setModel(model);
						
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							model.addColumn(rsmd.getColumnName(i));
						}
						while (rs.next()) {
							List<String> dato = new ArrayList<>();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								dato.add(rs.getString(i));
							}
							model.addRow(dato.toArray());
						}

						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		;
	}
}
