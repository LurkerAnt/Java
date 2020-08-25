package AplicacionGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOS.DAOException;
import DAOS.DAOManager;
import DAOS.EmpleadoDAO;
import DAOS.MySQLDAOManager;
import DAOS.TiendaDAO;
import EmpleadoTiendaConexion.ConexionBD;
import EmpleadoTiendaConexion.Empleado;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Texto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Texto frame = new Texto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Texto() {
		setTitle("GENERADOR DE FICHEROS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEligeElFormato = new JLabel("Genera un fichero de texto con todos los empleados o tiendas");
		lblEligeElFormato.setBounds(31, 6, 414, 59);
		contentPane.add(lblEligeElFormato);
		
		JButton btnEmpleadosEntxt = new JButton("Empleados en .txt");
		btnEmpleadosEntxt.setBounds(54, 98, 157, 93);
		contentPane.add(btnEmpleadosEntxt);
		btnEmpleadosEntxt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionBD c=new ConexionBD();
					EmpleadoDAO em=new EmpleadoDAO(c);
					em.guardarEnTexto();
					Bien b = new Bien();
					b.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
		JButton btnTiendasEntxt = new JButton("Tiendas en .txt");
		btnTiendasEntxt.setBounds(262, 101, 157, 86);
		contentPane.add(btnTiendasEntxt);
		
		JLabel lblPinchaEnEl = new JLabel("Pincha en el botón para generarlo");
		lblPinchaEnEl.setBounds(109, 221, 336, 16);
		contentPane.add(lblPinchaEnEl);
		btnTiendasEntxt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ConexionBD c=new ConexionBD();
					TiendaDAO tienda=new TiendaDAO(c);
					tienda.guardarEnTexto();
					Bien b = new Bien();
					b.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
	}
	
	//Esto no pude hacerlo.. por lo que he optado por hacer otro jframe con bien para avisar de que se ha 
	//realizado la accion
	private void popUp() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ya tienes un fichero con tu txt");
		panel.add(label);
		contentPane.add(panel);
	}

}
