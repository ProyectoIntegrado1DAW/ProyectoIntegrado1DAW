package interfaz;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import entidades.Cliente;
import gestores.ConexionDB;

import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class VentUsuario {

	JFrame frame;
	private Cliente c;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentUsuario window = new VentUsuario();
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
	public VentUsuario() {
		initialize();
	}

	public VentUsuario(Cliente c) {
		// TODO Auto-generated constructor stub

		this.c = c;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 450, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 435, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\icons.jpg"));
		lblNewLabel_3.setBounds(179, 0, 68, 50);
		panel.add(lblNewLabel_3);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentEvent User = new VentEvent(c);
				User.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\left.png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(10, 0, 70, 50);
		panel.add(button);

		JLabel lblNewLabel_1 = new JLabel("MI CUENTA");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_1.setBounds(153, 72, 151, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Configuracion");
		lblNewLabel_2.setBounds(88, 430, 117, 21);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.GRAY);

		JButton buttonCerrar = new JButton("Cerrar sesi\u00F3n");
		buttonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente.setInstanceOff();

				JOptionPane.showMessageDialog(null,
						"Su sesión ha sido cerrada.", "Gracias",
						JOptionPane.INFORMATION_MESSAGE);

				VentPrincipal User = new VentPrincipal();
				User.getFrame().setVisible(true);
				frame.dispose();

			}
		});
		buttonCerrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		buttonCerrar.setHorizontalAlignment(SwingConstants.LEFT);
		buttonCerrar.setBounds(88, 462, 117, 23);
		frame.getContentPane().add(buttonCerrar);
		buttonCerrar.setVerticalAlignment(SwingConstants.TOP);

		JButton buttonNoNotific = new JButton("Dejar de recibir notificaciones");
		buttonNoNotific.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		buttonNoNotific.setHorizontalAlignment(SwingConstants.LEFT);
		buttonNoNotific.setBounds(88, 496, 216, 23);
		frame.getContentPane().add(buttonNoNotific);

		JButton buttonBorrarCuenta = new JButton("Borrar cuenta");
		buttonBorrarCuenta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		buttonBorrarCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		buttonBorrarCuenta.setBounds(88, 530, 117, 23);
		frame.getContentPane().add(buttonBorrarCuenta);

		JButton buttonHome = new JButton("");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VentEvent Evento = new VentEvent();
					Evento.getFrame().setVisible(true);
					frame.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		buttonHome.setBorder(null);
		buttonHome.setOpaque(false);
		buttonHome.setContentAreaFilled(false);
		buttonHome.setBorderPainted(false);
		buttonHome
				.setIcon(new ImageIcon(
						"C:\\Users\\Asus\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\nueva home.png"));
		buttonHome.setBounds(369, 53, 55, 43);
		frame.getContentPane().add(buttonHome);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 414, 434, 162);
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED,
						null, null));
		scrollPane.setBounds(0, 147, 435, 272);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();

		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion
				.getQuery("select idcompra as \"ID\", nombreevento as \"Nombre del Evento\", numentradas as \"Num. de entradas\"  from clickntick.compras where dni='"
						+ c.getDNI() + "'");
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JTextPane txtpnPuntosDisponibles = new JTextPane();
		txtpnPuntosDisponibles.setBackground(new Color(192, 192, 192));
		txtpnPuntosDisponibles.setText("Puntos disponibles:");
		txtpnPuntosDisponibles.setBounds(10, 116, 141, 20);
		frame.getContentPane().add(txtpnPuntosDisponibles);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setBounds(379, 116, 24, 20);
		String puntos = ""+c.getPuntos();
		textPane.setText(puntos);
		frame.getContentPane().add(textPane);

	}

	public JFrame getFrame() {// llamada para poder cambiar de pantalla
		return frame;
	}
}
