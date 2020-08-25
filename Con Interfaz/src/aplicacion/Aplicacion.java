package aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import DAOS.DAOException;
import DAOS.DAOManager;
import DAOS.MySQLDAOManager;
import JuEqCon.Empleado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Aplicacion extends JFrame { 

	private DAOManager manager;

	private EmpleadoTabla model;

	private JPanel contentPane;
	private JTextField textoIdempleado;
	private JTextField textoNombre;
	private JTextField textoIdtienda;
	private JTextField textonventas;
	private JTextField textoEdad;
	private JTable table;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException {

		DAOManager manager = new MySQLDAOManager();
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new Aplicacion(manager).setVisible(true);
				} catch (DAOException ex) {
					Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});

	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Aplicacion(DAOManager manager) throws DAOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdEmpleado = new JLabel("ID EMPLEADO");
		contentPane.add(lblIdEmpleado);

		textoIdempleado = new JTextField();
		textoIdempleado.setEnabled(false);
		textoIdempleado.setEditable(false);
		textoIdempleado.setBounds(106, 6, 62, 26);
		contentPane.add(textoIdempleado);
		textoIdempleado.setColumns(10);
/*int idempleado, int idtienda, String nombre, int numeroVentas, int edad*/
		
		JLabel lblNombre = new JLabel("NOMBRE");
		contentPane.add(lblNombre);
		textoNombre = new JTextField();
		textoNombre.setBounds(266, 6, 62, 26);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lblIdTienda = new JLabel("ID TIENDA");
		contentPane.add(lblIdTienda);
//idtienda
		textoIdtienda = new JTextField();
		textoIdtienda.setBounds(404, 6, 40, 26);
		contentPane.add(textoIdtienda);
		textoIdtienda.setColumns(10);
		
		JLabel lblVentasRealizadas = new JLabel("VENTAS REALIZADAS");
		contentPane.add(lblVentasRealizadas);

		textonventas = new JTextField();
		textonventas.setBounds(106, 36, 75, 26);
		contentPane.add(textonventas);
		textonventas.setColumns(10);
		
		JLabel lblEdad = new JLabel("EDAD");
		contentPane.add(lblEdad);

		textoEdad = new JTextField();
		textoEdad.setBounds(270, 36, 62, 26);
		contentPane.add(textoEdad);
		textoEdad.setColumns(10);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(6, 74, 117, 29);
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkIfNotEmpty()) {
					Empleado empleado = new Empleado();
					empleado.setIdempleado(Integer.parseInt(textoIdempleado.getText()));
					empleado.setIdtienda(Integer.parseInt(textoIdtienda.getText()));
					empleado.setNombre(textoNombre.getText());
					empleado.setNumeroVentas(Integer.parseInt(textonventas.getText()));
					empleado.setEdad(Integer.parseInt(textoEdad.getText()));
					try {
						manager.getEmpleadoDAO().insertar(empleado);
						model.updateModel();
						model.fireTableDataChanged();

					} catch (DAOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else
					System.out.println("Faltan datos");

			}
		});
		contentPane.add(btnAgregar);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(126, 77, 117, 29);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Empleado empleado = new Empleado();
				empleado.setIdempleado(Integer.parseInt(textoIdempleado.getText()));
				try {
					manager.getEmpleadoDAO().borrar(empleado);
					model.updateModel();
					model.fireTableDataChanged();

				} catch (DAOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(241, 77, 117, 29);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkIfNotEmpty()) {
					Empleado empleado = new Empleado();
					empleado.setIdempleado(Integer.parseInt(textoIdempleado.getText()));
					empleado.setIdtienda(Integer.parseInt(textoIdtienda.getText()));
					empleado.setNombre(textoNombre.getText());
					empleado.setNumeroVentas(Integer.parseInt(textonventas.getText()));
					empleado.setEdad(Integer.parseInt(textoEdad.getText()));
					try {
						try {
							manager.getEmpleadoDAO().modificar(empleado);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						model.updateModel();
						model.fireTableDataChanged();

					} catch (DAOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					System.out.println("Faltan datos");

			}
		});

		JButton btnLimpiar = new JButton("LIMPIAR CAMPOS");
		btnLimpiar.setBounds(382, 74, 62, 29);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textoIdempleado.setText(null);
				textoIdtienda.setText(null);
				textoNombre.setText(null);
				textonventas.setText(null);
				textoEdad.setText(null);
			}

		});

		table = new JTable();
		table.setBounds(49, 132, 361, 122);
		model = new EmpleadoTabla(manager.getEmpleadoDAO());
		model.updateModel();
		table.setModel(model);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textoIdempleado.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textoIdtienda.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textoNombre.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textonventas.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					textoEdad.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				}
			}
		});
		;
		contentPane.add(new JScrollPane(table));

	}

	public boolean checkIfNotEmpty() {
		if (!textoIdempleado.getText().isEmpty() && !textonventas.getText().isEmpty()
				&& !textoIdtienda.getText().isEmpty() && !textoNombre.getText().isEmpty()
				&& !textoEdad.getText().isEmpty())
			return true;
		else
			return false;
	}
}
