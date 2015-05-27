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

import entidades.Cliente;
import entidades.Usuario;

public class VentCompraTicket {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private String nombreEvento;
	private int numEntradas;

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
	public VentCompraTicket(String nombreEvento, int numEntradas) {
		this.nombreEvento = nombreEvento;
		this.numEntradas = numEntradas;
		initialize();

	}

	public VentCompraTicket() {
		// TODO Auto-generated constructor stub
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Introduzca sus datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_1.setBounds(114, 84, 200, 38);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNombre.setBounds(41, 133, 86, 25);
		frame.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblApellido.setBounds(32, 169, 95, 25);
		frame.getContentPane().add(lblApellido);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCorreo.setBounds(0, 195, 127, 38);
		frame.getContentPane().add(lblCorreo);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTelefono.setBounds(0, 231, 127, 38);
		frame.getContentPane().add(lblTelefono);

		textNombre = new JTextField();
		textNombre.setForeground(Color.WHITE);
		textNombre.setColumns(10);
		textNombre.setBackground(Color.GRAY);
		textNombre.setBounds(137, 133, 208, 28);
		frame.getContentPane().add(textNombre);

		textApellido = new JTextField();
		textApellido.setForeground(Color.WHITE);
		textApellido.setColumns(10);
		textApellido.setBackground(Color.GRAY);
		textApellido.setBounds(137, 170, 208, 28);
		frame.getContentPane().add(textApellido);

		textCorreo = new JTextField();
		textCorreo.setForeground(Color.WHITE);
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.GRAY);
		textCorreo.setBounds(137, 203, 208, 28);
		frame.getContentPane().add(textCorreo);

		textTelefono = new JTextField();
		textTelefono.setForeground(Color.WHITE);
		textTelefono.setColumns(10);
		textTelefono.setBackground(Color.GRAY);
		textTelefono.setBounds(137, 239, 208, 28);
		frame.getContentPane().add(textTelefono);

		JButton buttonTicket = new JButton("TICKET");
		buttonTicket.setForeground(new Color(0, 0, 0));
		buttonTicket.setBackground(Color.YELLOW);
		buttonTicket.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		buttonTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String correo = textCorreo.getText();
				String telefono = textTelefono.getText();
				
				int telefonoInt = Integer.parseInt(telefono);
				
				Cliente c = Cliente.getInstanceNoReg(nombre,apellido,correo,telefonoInt);
				
				VentConfPago User = new VentConfPago(nombreEvento, c, numEntradas );
				User.getFrame().setVisible(true);
				frame.dispose();
				
				
			}
		});
		buttonTicket.setBounds(92, 297, 200, 50);
		frame.getContentPane().add(buttonTicket);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 437, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(166, 11, 46, 14);
		panel.add(lblNewLabel_2);

		JButton buttonAtras = new JButton("");
		buttonAtras.setBounds(243, 11, 1, 1);
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
	}

	public JFrame getFrame() {// llamada para poder cambiar de pantalla
		return frame;
	}
}
