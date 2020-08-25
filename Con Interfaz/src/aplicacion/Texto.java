package aplicacion;

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
import JuEqCon.ConexionBD;
import JuEqCon.Empleado;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblEligeElFormato = new JLabel("Elige el formato de fichero que necesites. Yo te lo genero");
		contentPane.add(lblEligeElFormato, BorderLayout.NORTH);
		
		JButton btnEmpleadosEntxt = new JButton("Empleados en .txt");
		contentPane.add(btnEmpleadosEntxt, BorderLayout.WEST);
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
		contentPane.add(btnTiendasEntxt, BorderLayout.CENTER);
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
