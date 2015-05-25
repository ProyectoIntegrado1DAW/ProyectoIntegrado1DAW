package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class VentPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentPrincipal window = new VentPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 430, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button_entrar = new JButton("ENTRAR");
		button_entrar.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentEvent User = new VentEvent();
				User.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		button_entrar.setForeground(Color.WHITE);
		button_entrar.setBackground(Color.BLACK);
		button_entrar.setBounds(37, 217, 326, 52);
		frame.getContentPane().add(button_entrar);
		
		JButton button_login = new JButton("LOGIN");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentLogin User = new VentLogin();
				User.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		button_login.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button_login.setForeground(Color.WHITE);
		button_login.setBackground(Color.BLACK);
		button_login.setBounds(37, 289, 326, 52);
		frame.getContentPane().add(button_login);
		
		JLabel lblRegistrateYComienza = new JLabel("Registrate y comienza a acumular puntos");
		lblRegistrateYComienza.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblRegistrateYComienza.setBounds(37, 345, 292, 14);
		frame.getContentPane().add(lblRegistrateYComienza);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoBig.png"));
		lblNewLabel.setBounds(98, 23, 213, 182);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnGestor = new JButton("Gestor");
		btnGestor.setBackground(new Color(240, 248, 255));
		btnGestor.setBounds(325, 0, 89, 23);
		btnGestor.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				VentLoginGestor gestor = new VentLoginGestor();
				gestor.getFrame().setVisible(true);
				
			} }
				);
		frame.getContentPane().add(btnGestor);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
