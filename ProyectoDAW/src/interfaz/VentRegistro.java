package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class VentRegistro {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTlf;
	private JTextField textEdad;
	private JTextField textUsuario;
	private JPasswordField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentRegistro window = new VentRegistro();
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
	public VentRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogoHere = new JLabel("");
		lblLogoHere.setIcon(new ImageIcon("C:\\Users\\dai\\Desktop\\Workspace - Proyecto\\ProyectoDAW\\LogoSmall.png"));
		lblLogoHere.setBounds(163, 29, 111, 38);
		frame.getContentPane().add(lblLogoHere);
		
		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label.setBounds(38, 108, 127, 38);
		frame.getContentPane().add(label);
		
		textNombre = new JTextField();
		textNombre.setForeground(Color.WHITE);
		textNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBackground(Color.GRAY);
		textNombre.setBounds(184, 108, 200, 28);
		frame.getContentPane().add(textNombre);
		
		JLabel label_1 = new JLabel("Apellidos");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_1.setBounds(38, 157, 127, 38);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Correo");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_2.setBounds(38, 206, 127, 38);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_3.setBounds(38, 255, 127, 38);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Edad");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_4.setBounds(38, 304, 127, 38);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Usuario");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_5.setBounds(38, 353, 127, 38);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Contrase\u00F1a");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_6.setBounds(10, 402, 155, 38);
		frame.getContentPane().add(label_6);
		
		textApellido = new JTextField();
		textApellido.setForeground(Color.WHITE);
		textApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textApellido.setColumns(10);
		textApellido.setBackground(Color.GRAY);
		textApellido.setBounds(184, 160, 200, 28);
		frame.getContentPane().add(textApellido);
		
		textCorreo = new JTextField();
		textCorreo.setForeground(Color.WHITE);
		textCorreo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.GRAY);
		textCorreo.setBounds(184, 206, 200, 28);
		frame.getContentPane().add(textCorreo);
		
		textTlf = new JTextField();
		textTlf.setForeground(Color.WHITE);
		textTlf.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textTlf.setColumns(10);
		textTlf.setBackground(Color.GRAY);
		textTlf.setBounds(184, 255, 200, 28);
		frame.getContentPane().add(textTlf);
		
		textEdad = new JTextField();
		textEdad.setForeground(Color.WHITE);
		textEdad.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textEdad.setColumns(10);
		textEdad.setBackground(Color.GRAY);
		textEdad.setBounds(184, 304, 200, 28);
		frame.getContentPane().add(textEdad);
		
		textUsuario = new JTextField();
		textUsuario.setForeground(Color.WHITE);
		textUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		textUsuario.setBackground(Color.DARK_GRAY);
		textUsuario.setBounds(184, 353, 200, 28);
		frame.getContentPane().add(textUsuario);
		
		JButton button = new JButton("CREAR CUENTA");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button.setBackground(Color.BLACK);
		button.setBounds(86, 464, 282, 52);
		frame.getContentPane().add(button);
		
		textContraseña = new JPasswordField();
		textContraseña.setForeground(Color.WHITE);
		textContraseña.setBackground(Color.DARK_GRAY);
		textContraseña.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textContraseña.setBounds(184, 402, 200, 28);
		frame.getContentPane().add(textContraseña);
	}
}
