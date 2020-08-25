package aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAOS.DAOException;
import DAOS.DAOManager;
import DAOS.MySQLDAOManager;
import JuEqCon.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class AplicacionTienda extends JFrame {
	private DAOManager manager;

	private TiendaTablaModel model;
	
	private JPanel contentPane;
	private JTextField textoIdtienda;
	private JTextField textoNombre;
	private JTextField textoDireccion;
	private JTextField textoPoblacion;
	private JTextField textoCPostal;
	private JTextField textoProvincia;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		DAOManager manager = new MySQLDAOManager();
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new AplicacionTienda(manager).setVisible(true);
				} catch (DAOException ex) {
					Logger.getLogger(AplicacionTienda.class.getName()).log(Level.SEVERE, null, ex);
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
	public AplicacionTienda(DAOManager manager) throws DAOException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		JLabel lblIdtienda = new JLabel("ID Tienda");
		lblIdtienda.setBounds(6, 6, 61, 16);
		contentPane.add(lblIdtienda);
		
		textoIdtienda = new JTextField();
		textoIdtienda.setBounds(67, 1, 130, 26);
		contentPane.add(textoIdtienda);
		textoIdtienda.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(0, 34, 61, 16);
		contentPane.add(lblNombre);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(67, 29, 130, 26);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(209, 34, 61, 16);
		contentPane.add(lblDireccion);
		
		textoDireccion = new JTextField();
		textoDireccion.setBounds(290, 34, 130, 26);
		contentPane.add(textoDireccion);
		textoDireccion.setColumns(10);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(0, 63, 61, 16);
		contentPane.add(lblPoblacion);
		
		textoPoblacion = new JTextField();
		textoPoblacion.setBounds(67, 67, 130, 26);
		contentPane.add(textoPoblacion);
		textoPoblacion.setColumns(10);
		
		JLabel lblCpostal = new JLabel("cPostal");
		lblCpostal.setBounds(209, 72, 61, 16);
		contentPane.add(lblCpostal);
		
		textoCPostal = new JTextField();
		textoCPostal.setBounds(280, 72, 130, 26);
		contentPane.add(textoCPostal);
		textoCPostal.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(225, 6, 61, 16);
		contentPane.add(lblProvincia);
		
		textoProvincia = new JTextField();
		textoProvincia.setBounds(280, 1, 130, 26);
		contentPane.add(textoProvincia);
		textoProvincia.setColumns(10);
		
		table = new JTable();
		table.setBounds(49, 132, 361, 122);
		model = new TiendaTablaModel(manager.getTiendaDAO());
		model.updateModel();
		table.setModel(model);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() >= 0) {
					textoNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textoIdtienda.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					textoProvincia.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					textoPoblacion.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					textoDireccion.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textoCPostal.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				}
			}
		});
		;
		contentPane.add(new JScrollPane(table));

	
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.setBounds(6, 74, 117, 29);
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkIfNotEmpty()) {
					Tienda tienda = new Tienda();
					tienda.setIdtienda(Integer.parseInt(textoIdtienda.getText()));
					tienda.setNombre(textoNombre.getText());
					tienda.setDireccion(textoDireccion.getText());
					tienda.setPoblacion(textoPoblacion.getText());
					tienda.setProvincia(textoProvincia.getText());
					tienda.setcPostal(Integer.parseInt(textoCPostal.getText()));
					try {
						manager.getTiendaDAO().insertar(tienda);
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
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setBounds(241, 77, 117, 29);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkIfNotEmpty()) {
					Tienda tienda = new Tienda();
					tienda.setIdtienda(Integer.parseInt(textoIdtienda.getText()));
					tienda.setNombre(textoNombre.getText());
					tienda.setDireccion(textoProvincia.getText());
					tienda.setPoblacion(textoDireccion.getText());
					tienda.setProvincia(textoPoblacion.getText());
					tienda.setcPostal(Integer.parseInt(textoCPostal.getText()));
					try {
						manager.getTiendaDAO().modificar(tienda);
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

		JButton btnBorrar = new JButton("borrar");
		btnBorrar.setBounds(126, 77, 117, 29);
		contentPane.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tienda tienda = new Tienda();
				tienda.setIdtienda(Integer.parseInt(textoIdtienda.getText()));
				try {
					manager.getTiendaDAO().borrar(tienda);
					model.updateModel();
					model.fireTableDataChanged();

				} catch (DAOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		JButton btnLimpiar = new JButton("limpiar");
		btnLimpiar.setBounds(382, 74, 62, 29);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textoNombre.setText(null);
				textoIdtienda.setText(null);
				textoProvincia.setText(null);
				textoDireccion.setText(null);
				textoPoblacion.setText(null);
				textoCPostal.setText(null);
			}

		});

		
	}
	public boolean checkIfNotEmpty() {
		if (!textoIdtienda.getText().isEmpty() && !textoDireccion.getText().isEmpty()
				&& !textoPoblacion.getText().isEmpty()
				&& !textoNombre.getText().isEmpty() && !textoProvincia.getText().isEmpty()
				&& !textoCPostal.getText().isEmpty())
			return true;
		else
			return false;
	}
}
