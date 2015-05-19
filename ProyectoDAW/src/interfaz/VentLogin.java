package interfaz;

import gestores.GestorUsuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class VentLogin {

	private JFrame frame;
	private JPasswordField textfield_pass;
	private JButton button_entrar;
	private JLabel label;
	private JButton button;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentLogin window = new VentLogin();
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
	public VentLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 430, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_usuario = new JLabel("USUARIO");
		label_usuario.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		label_usuario.setBounds(39, 153, 127, 38);
		frame.getContentPane().add(label_usuario);
		
		JLabel label_password = new JLabel("CONTRASE\u00D1A");
		label_password.setHorizontalAlignment(SwingConstants.RIGHT);
		label_password.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_password.setBounds(39, 181, 127, 52);
		frame.getContentPane().add(label_password);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setBounds(182, 157, 200, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textfield_pass = new JPasswordField();
		textfield_pass.setEchoChar('¬');
		textfield_pass.setForeground(Color.WHITE);
		textfield_pass.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textfield_pass.setBackground(Color.GRAY);
		textfield_pass.setBounds(182, 187, 200, 28);
		frame.getContentPane().add(textfield_pass);
		
		button_entrar = new JButton("ENTRAR");
		button_entrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String usuario;
					String password;
					
					boolean test;
					
					usuario = textField.getText();
					password = textfield_pass.getText();
					
					test = GestorUsuario.logIn(usuario, password);
					
					if (test){
						
						VentEvent User = new VentEvent();
						User.getFrame().setVisible(true);
						frame.dispose();
						
					}else{
						
						JOptionPane.showMessageDialog(null, "Ha introducido un usuario y contraseña incorrecto", "ERROR", JOptionPane.WARNING_MESSAGE);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "Ha introducido un usuario y contraseña incorrecto", "ERROR", JOptionPane.WARNING_MESSAGE);
					
					e.printStackTrace();
				}
			
			}
		});
		button_entrar.setForeground(Color.WHITE);
		button_entrar.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button_entrar.setBackground(Color.DARK_GRAY);
		button_entrar.setBounds(118, 262, 187, 52);
		frame.getContentPane().add(button_entrar);
		
		label = new JLabel("\u00BFTodav\u00EDa no tienes cuenta?");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(118, 327, 187, 50);
		frame.getContentPane().add(label);
		
		button = new JButton("REGISTRARME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					VentRegistro User = new VentRegistro();
					User.getFrame().setVisible(true);
					frame.dispose();
					
				}catch (Exception e1){
					
					e1.printStackTrace();
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(96, 376, 229, 52);
		frame.getContentPane().add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoBig.png"));
		lblNewLabel.setBounds(106, 11, 209, 116);
		frame.getContentPane().add(lblNewLabel);
		
		

	}
	
	public JFrame getFrame(){
		
		return frame;
	}
}
