package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import entidades.Cliente;
import gestores.GestorUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentRegistro {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTlf;
	private JTextField textEdad;
	private JTextField textUsuario;
	private JPasswordField textContrasenya;
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
		frame.setBounds(100, 100, 735, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogoHere = new JLabel("");
		lblLogoHere
				.setIcon(new ImageIcon("C:\\Users\\hejuso\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoSmall.png"));
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

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTelfono.setBounds(20, 255, 127, 38);
		frame.getContentPane().add(lblTelfono);

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

		JLabel label_6 = new JLabel("Contraseña");
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
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				String nombre;
				String apellidos;
				String correo;
				String telefono;
				String edad;
				String usuario;
				String contrasenya;
				String dni;
				String direccion;
				String pais;
				String poblacion;
				String provincia;
				String cp;

				nombre = textNombre.getText();
				apellidos = textApellido.getText();
				correo = textCorreo.getText();
				telefono = textTlf.getText();
				edad = textEdad.getText();
				usuario = textUsuario.getText();
				contrasenya = textContrasenya.getText();
				dni = textDNI.getText();
				direccion = textDireccion.getText();
				pais = textPais.getText();
				poblacion = textPoblacion.getText();
				provincia = textProvincia.getText();
				cp = textCP.getText();
				int cpInt = 0;
				int tlfnInt = 0;

				if (!cp.equals("")) {

					cpInt = Integer.parseInt(cp);

					if (!telefono.equals("")) {

						tlfnInt = Integer.parseInt(telefono);

					}

				}

				Cliente.setInstanceOff();
				Cliente c = Cliente.getInstance(dni, usuario, contrasenya,
						nombre, apellidos, direccion, poblacion, provincia,
						cpInt, pais, tlfnInt, correo);
				Cliente.setInstanceOff();

				try {

					if (usuario.equals("") || contrasenya.equals("")
							|| nombre.equals("") || apellidos.equals("")
							|| correo.equals("") || tlfnInt == 0
							|| edad.equals("") || dni.equals("")
							|| direccion.equals("") || pais.equals("")
							|| poblacion.equals("") || provincia.equals("")
							|| cpInt == 0) {
						JOptionPane.showMessageDialog(null,
								"Se ha dejado algun campo sin rellenar",
								"ERROR", JOptionPane.WARNING_MESSAGE);
					} else {

						GestorUsuario.altaUsuario(c);
						JOptionPane.showMessageDialog(null,
								"Ha sido registrado con éxito.", "Enhorabuena",
								JOptionPane.INFORMATION_MESSAGE);
						VentUsuario User = new VentUsuario();
						User.getFrame().setVisible(true);
						frame.dispose();

					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "La cuenta ya existe",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		button.setBackground(Color.BLACK);
		button.setBounds(209, 463, 282, 52);
		frame.getContentPane().add(button);

		textContrasenya = new JPasswordField();
		textContrasenya.setForeground(Color.WHITE);
		textContrasenya.setBackground(Color.DARK_GRAY);
		textContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textContrasenya.setBounds(163, 402, 200, 28);
		frame.getContentPane().add(textContrasenya);

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
	public JFrame getFrame(){//llamada para poder cambiar de pantalla
		return frame;
	}
}
