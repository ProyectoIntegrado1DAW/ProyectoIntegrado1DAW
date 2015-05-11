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
	private JTextField textDNI;
	private JTextField textDireccion;
	private JTextField textPais;
	private JTextField textPoblacion;
	private JTextField textProvincia;
	private JTextField textCP;

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
		frame.setBounds(100, 100, 700, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogoHere = new JLabel("");
		lblLogoHere
				.setIcon(new ImageIcon(
						"C:\\Users\\dai\\git\\ProyectoIntegrado1DAW(1)\\ProyectoDAW\\LogoSmall.png"));
		lblLogoHere.setBounds(292, 38, 111, 38);
		frame.getContentPane().add(lblLogoHere);

		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label.setBounds(10, 108, 127, 38);
		frame.getContentPane().add(label);

		textNombre = new JTextField();
		textNombre.setForeground(Color.WHITE);
		textNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBackground(Color.GRAY);
		textNombre.setBounds(163, 115, 200, 28);
		frame.getContentPane().add(textNombre);

		JLabel label_1 = new JLabel("Apellidos");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_1.setBounds(10, 157, 127, 38);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Correo");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_2.setBounds(10, 206, 127, 38);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Tel\u00E9fono");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_3.setBounds(20, 255, 127, 38);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Edad");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_4.setBounds(10, 304, 127, 38);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("Usuario");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_5.setBounds(20, 353, 127, 38);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("Contrase\u00F1a");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		label_6.setBounds(0, 394, 155, 38);
		frame.getContentPane().add(label_6);

		textApellido = new JTextField();
		textApellido.setForeground(Color.WHITE);
		textApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textApellido.setColumns(10);
		textApellido.setBackground(Color.GRAY);
		textApellido.setBounds(163, 164, 200, 28);
		frame.getContentPane().add(textApellido);

		textCorreo = new JTextField();
		textCorreo.setForeground(Color.WHITE);
		textCorreo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.GRAY);
		textCorreo.setBounds(163, 213, 200, 28);
		frame.getContentPane().add(textCorreo);

		textTlf = new JTextField();
		textTlf.setForeground(Color.WHITE);
		textTlf.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textTlf.setColumns(10);
		textTlf.setBackground(Color.GRAY);
		textTlf.setBounds(163, 262, 200, 28);
		frame.getContentPane().add(textTlf);

		textEdad = new JTextField();
		textEdad.setForeground(Color.WHITE);
		textEdad.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textEdad.setColumns(10);
		textEdad.setBackground(Color.GRAY);
		textEdad.setBounds(163, 311, 200, 28);
		frame.getContentPane().add(textEdad);

		textUsuario = new JTextField();
		textUsuario.setForeground(Color.WHITE);
		textUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textUsuario.setColumns(10);
		textUsuario.setBackground(Color.DARK_GRAY);
		textUsuario.setBounds(163, 360, 200, 28);
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
		textContraseña.setBounds(163, 402, 200, 28);
		frame.getContentPane().add(textContraseña);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblDni.setBounds(337, 108, 127, 38);
		frame.getContentPane().add(lblDni);

		textDNI = new JTextField();
		textDNI.setForeground(Color.WHITE);
		textDNI.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textDNI.setColumns(10);
		textDNI.setBackground(Color.GRAY);
		textDNI.setBounds(474, 115, 200, 28);
		frame.getContentPane().add(textDNI);

		textDireccion = new JTextField();
		textDireccion.setForeground(Color.WHITE);
		textDireccion.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textDireccion.setColumns(10);
		textDireccion.setBackground(Color.GRAY);
		textDireccion.setBounds(474, 164, 200, 28);
		frame.getContentPane().add(textDireccion);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblDireccin.setBounds(337, 157, 127, 38);
		frame.getContentPane().add(lblDireccin);

		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n");
		lblPoblacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoblacin.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblPoblacin.setBounds(337, 255, 127, 38);
		frame.getContentPane().add(lblPoblacin);

		textPais = new JTextField();
		textPais.setForeground(Color.WHITE);
		textPais.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textPais.setColumns(10);
		textPais.setBackground(Color.GRAY);
		textPais.setBounds(474, 213, 200, 28);
		frame.getContentPane().add(textPais);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblProvincia.setBounds(337, 304, 127, 38);
		frame.getContentPane().add(lblProvincia);

		JLabel lblCodigopostal = new JLabel("CP");
		lblCodigopostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigopostal.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCodigopostal.setBounds(337, 353, 127, 38);
		frame.getContentPane().add(lblCodigopostal);

		textPoblacion = new JTextField();
		textPoblacion.setForeground(Color.WHITE);
		textPoblacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textPoblacion.setColumns(10);
		textPoblacion.setBackground(Color.GRAY);
		textPoblacion.setBounds(474, 262, 200, 28);
		frame.getContentPane().add(textPoblacion);

		textProvincia = new JTextField();
		textProvincia.setForeground(Color.WHITE);
		textProvincia.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textProvincia.setColumns(10);
		textProvincia.setBackground(Color.GRAY);
		textProvincia.setBounds(474, 311, 200, 28);
		frame.getContentPane().add(textProvincia);

		textCP = new JTextField();
		textCP.setForeground(Color.WHITE);
		textCP.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textCP.setColumns(10);
		textCP.setBackground(Color.GRAY);
		textCP.setBounds(474, 360, 200, 28);
		frame.getContentPane().add(textCP);

		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblPas.setBounds(337, 206, 127, 38);
		frame.getContentPane().add(lblPas);
	}
}
