package AplicacionGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;

public class Bien extends JFrame {

	private JPanel contentPane;
	private JTextField txtYaPuedesEncontrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bien frame = new Bien();
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
	public Bien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Fichero de texto generado con éxito");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 74, 411, 25);
		contentPane.add(lblNewLabel);
		
		txtYaPuedesEncontrar = new JTextField();
		txtYaPuedesEncontrar.setEditable(false);
		txtYaPuedesEncontrar.setText("Tus ficheros están en tu carpeta principal");
		txtYaPuedesEncontrar.setBounds(82, 111, 276, 84);
		contentPane.add(txtYaPuedesEncontrar);
		txtYaPuedesEncontrar.setColumns(10);
	}

}
