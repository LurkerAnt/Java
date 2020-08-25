package AplicacionGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAOS.DAOException;
import DAOS.DAOGenerico;
import DAOS.DAOManager;
import EmpleadoTiendaConexion.ConexionBD;
import EmpleadoTiendaConexion.Tienda;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class ConsultasSQL extends JFrame {
	private DAOManager manager;
	private JPanel contentPane;
	private JTextField textField;
	private ConexionBD conn = new ConexionBD();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultasSQL frame = new ConsultasSQL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ConsultasSQL() throws SQLException {
		setTitle("REALIZA TUS CONSULTAS EN SQL");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(25, 31, 387, 57);
		contentPane.add(textField);
		textField.setColumns(10);

		table = new JTable();
		table.setBounds(35, 100, 373, 124);
		contentPane.add(table);
		DefaultTableModel model = new DefaultTableModel();

		table.setModel(model);

		JButton botonEjecutar = new JButton("EJECUTAR CONSULTA");
		botonEjecutar.setBounds(25, 236, 205, 29);
		contentPane.add(botonEjecutar);

		botonEjecutar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				DAOGenerico dg = new DAOGenerico(conn);
				try {
					System.out.println(s);
					// dg.ejecuta(s);

					ConexionBD conn = new ConexionBD();
					Connection conexion = conn.getConexion();

					String sql = textField.getText();

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

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

		});

		JLabel lblRecuerdaEscribirTu = new JLabel("Si cometes errores NO se ejecutará tu consulta");
		lblRecuerdaEscribirTu.setBounds(25, 6, 387, 16);
		contentPane.add(lblRecuerdaEscribirTu);

		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(265, 236, 117, 29);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConsultasSQL frame = new ConsultasSQL();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

	}
}
