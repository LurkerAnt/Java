package AplicacionGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOS.DAOException;
import DAOS.DAOManager;
import DAOS.MySQLDAOManager;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Bienvenida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() throws SQLException {
		setTitle("TRABAJO FINAL JAVA LIDIA DEL PINO");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnZara = new JMenu("Zara");
		menuBar.add(mnZara);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mnZara.add(mntmEmpleados);
		mntmEmpleados.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				DAOManager manager = new MySQLDAOManager();
				AplicacionEmpleado a = new AplicacionEmpleado(manager);
				a.setVisible(true);

			} catch (SQLException | DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
	

		
		JMenuItem mntmTiendas = new JMenuItem("Tiendas");
		mnZara.add(mntmTiendas);
		mntmTiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DAOManager manager = new MySQLDAOManager();
					AplicacionTienda t = new AplicacionTienda(manager);
					t.setVisible(true);
				} catch (SQLException | DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		JMenu mnFicheros = new JMenu("Ficheros");
		menuBar.add(mnFicheros);
		
		JMenuItem mntmCreartxt = new JMenuItem("Crear .txt");
		mnFicheros.add(mntmCreartxt);
		mntmCreartxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Texto te = new Texto();
					te.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			});
		
		JMenu mnSql = new JMenu("SQL");
		menuBar.add(mnSql);
		
		JMenuItem mntmRealizaTuConsulta = new JMenuItem("Escribe tu consulta");
		mnSql.add(mntmRealizaTuConsulta);
		
		JMenuItem mntmEmpleadosPorTienda = new JMenuItem("Empleados por tienda");
		mnSql.add(mntmEmpleadosPorTienda);
		mntmEmpleadosPorTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SeleccionandoTiendasYempleados s = new SeleccionandoTiendasYempleados();
					s.setVisible(true);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			});
		
		
		mntmRealizaTuConsulta.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			try {
				ConsultasSQL sq= new ConsultasSQL();
				sq.setVisible(true);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnBienvenidANuestra = new JTextPane();
		txtpnBienvenidANuestra.setEditable(false);
		txtpnBienvenidANuestra.setText("Bienvenid@ a nuestra aplicación para gestionar la base de datos de nuestras tiendas Zara. Desde aquí podrás dar de alta nuevos empleados, modificarlos, realizar consultas en formato SQL, introducir nuevas tiendas y exportar estos datos a un fichero de texto.\n\nPara cualquier duda o consulta contacte con nuestro servicio técnico en:\nlidiadelpinoolmo@gmail.com\n\n¡Gracias!");
		txtpnBienvenidANuestra.setBounds(35, 55, 368, 183);
		contentPane.add(txtpnBienvenidANuestra);
	}
}
