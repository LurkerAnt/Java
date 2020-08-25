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
import javax.swing.border.EmptyBorder;

import DAOS.DAOException;
import DAOS.DAOManager;
import DAOS.MySQLDAOManager;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				Aplicacion a = new Aplicacion(manager);
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
