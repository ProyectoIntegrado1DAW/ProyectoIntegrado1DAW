package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class VentCompraTicket {

	private JFrame frame;
	private JTextField textUsuario;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textEdad;
	private JPasswordField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentCompraTicket window = new VentCompraTicket();
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
	public VentCompraTicket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setBounds(18, 57, 127, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1.setBounds(18, 91, 127, 38);
		frame.getContentPane().add(lblNewLabel_1);

		textUsuario = new JTextField();
		textUsuario.setForeground(Color.WHITE);
		textUsuario.setBackground(Color.DARK_GRAY);
		textUsuario.setBounds(157, 57, 208, 28);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNombre.setBounds(59, 223, 86, 25);
		frame.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblApellido.setBounds(50, 259, 95, 25);
		frame.getContentPane().add(lblApellido);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCorreo.setBounds(18, 295, 127, 38);
		frame.getContentPane().add(lblCorreo);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTelefono.setBounds(18, 334, 127, 38);
		frame.getContentPane().add(lblTelefono);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEdad.setBounds(18, 371, 127, 38);
		frame.getContentPane().add(lblEdad);

		JButton buttonRegistrarse = new JButton("REGISTRARME");
		buttonRegistrarse.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		buttonRegistrarse.setForeground(Color.WHITE);
		buttonRegistrarse.setBackground(Color.BLACK);
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VentUsuario User = new VentUsuario();
					User.getFrame().setVisible(true);
					frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		buttonRegistrarse.setBounds(118, 162, 193, 38);
		frame.getContentPane().add(buttonRegistrarse);

		JLabel lbltodaviaNoTienes = new JLabel(
				"\u00BFtodavia no tienes cuenta? Creala ahora y empieza a acumular puntos");
		lbltodaviaNoTienes.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		lbltodaviaNoTienes.setBounds(46, 137, 345, 14);
		frame.getContentPane().add(lbltodaviaNoTienes);

		textNombre = new JTextField();
		textNombre.setForeground(Color.WHITE);
		textNombre.setColumns(10);
		textNombre.setBackground(Color.GRAY);
		textNombre.setBounds(157, 223, 208, 28);
		frame.getContentPane().add(textNombre);

		textApellido = new JTextField();
		textApellido.setForeground(Color.WHITE);
		textApellido.setColumns(10);
		textApellido.setBackground(Color.GRAY);
		textApellido.setBounds(157, 259, 208, 28);
		frame.getContentPane().add(textApellido);

		textCorreo = new JTextField();
		textCorreo.setForeground(Color.WHITE);
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.GRAY);
		textCorreo.setBounds(157, 298, 208, 28);
		frame.getContentPane().add(textCorreo);

		textTelefono = new JTextField();
		textTelefono.setForeground(Color.WHITE);
		textTelefono.setColumns(10);
		textTelefono.setBackground(Color.GRAY);
		textTelefono.setBounds(157, 334, 208, 28);
		frame.getContentPane().add(textTelefono);

		textEdad = new JTextField();
		textEdad.setForeground(Color.WHITE);
		textEdad.setColumns(10);
		textEdad.setBackground(Color.GRAY);
		textEdad.setBounds(157, 371, 208, 28);
		frame.getContentPane().add(textEdad);

		JLabel lblModoDePago = new JLabel("Modo de pago");
		lblModoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModoDePago.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblModoDePago.setBounds(18, 408, 130, 38);
		frame.getContentPane().add(lblModoDePago);

		JButton buttonPayPal = new JButton("PayPal");
		buttonPayPal.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonPayPal.setForeground(Color.WHITE);
		buttonPayPal.setBackground(Color.DARK_GRAY);
		buttonPayPal.setBounds(18, 452, 95, 38);
		frame.getContentPane().add(buttonPayPal);

		JButton buttonCreditCard = new JButton("Tarjeta de cr\u00E9dito");
		buttonCreditCard.setForeground(Color.WHITE);
		buttonCreditCard.setBackground(Color.DARK_GRAY);
		buttonCreditCard.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		buttonCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCreditCard.setBounds(133, 452, 208, 38);
		frame.getContentPane().add(buttonCreditCard);

		JButton buttonTicket = new JButton("TICKET");
		buttonTicket.setForeground(new Color(0, 0, 0));
		buttonTicket.setBackground(Color.YELLOW);
		buttonTicket.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		buttonTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonTicket.setBounds(92, 510, 200, 50);
		frame.getContentPane().add(buttonTicket);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 437, 50);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);

		JButton buttonAtras = new JButton("");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					VentLogin Evento = new VentLogin();
					Evento.getFrame().setVisible(true);
					frame.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		buttonAtras.setBorder(null);
		buttonAtras.setOpaque(false);
		buttonAtras.setContentAreaFilled(false);
		buttonAtras.setBorderPainted(false);
		buttonAtras.setBackground(Color.YELLOW);
		buttonAtras
				.setIcon(new ImageIcon(
						"C:\\Users\\Asus\\Desktop\\fotos proyecto\\nuevas fotos\\right.png"));
		panel.add(buttonAtras);

		textContraseña = new JPasswordField();
		textContraseña.setForeground(Color.WHITE);
		textContraseña.setBackground(Color.DARK_GRAY);
		textContraseña.setBounds(157, 91, 208, 28);
		frame.getContentPane().add(textContraseña);
	}
}
