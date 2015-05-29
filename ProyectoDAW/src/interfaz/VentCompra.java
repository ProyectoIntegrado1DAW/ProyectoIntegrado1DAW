package interfaz;

import entidades.Cliente;
import entidades.Evento;
import gestores.ConexionDB;
import gestores.GestorEvento;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;

public class VentCompra {

	private JFrame frame;
	private JTextField textTitulo;
	private JTable table;
	private JTextField textField;
	private String nombreEvento;
	private String descripcion;
	private Cliente c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String nombreEvento = null;
					String descripcion = null;

					VentCompra window = new VentCompra(nombreEvento,
							descripcion);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public VentCompra() throws SQLException {
		initialize();

	}

	public VentCompra(String nombreEvento, String descripcion)
			throws SQLException {

		this.nombreEvento = nombreEvento;
		this.descripcion = descripcion;
		initialize();
	}

	public VentCompra(String nombreEvento, String descripcion, Cliente c)
			throws SQLException {
		// TODO Auto-generated constructor stub

		this.nombreEvento = nombreEvento;
		this.descripcion = descripcion;
		this.c = c;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */

	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
			}
		} else {
		}
	}

	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 435, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(202, 24, 0, 0);
		lblNewLabel_1
				.setIcon(new ImageIcon(
						"C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoSmall.png"));
		panel.add(lblNewLabel_1);

		JButton buttonEvent = new JButton("");
		buttonEvent.setBounds(282, 24, 1, 1);
		buttonEvent.addActionListener(new ActionListener() {
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

		Evento ev = getEvent(nombreEvento);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(177, 0, 70, 50);
		lblNewLabel_2
				.setIcon(new ImageIcon(
						"C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\icons.jpg"));
		panel.add(lblNewLabel_2);

		buttonEvent.setBorder(null);
		buttonEvent.setOpaque(false);
		buttonEvent.setContentAreaFilled(false);
		buttonEvent.setBorderPainted(false);
		buttonEvent.setBackground(Color.YELLOW);
		buttonEvent
				.setIcon(new ImageIcon(
						"C:\\Users\\Asus\\Desktop\\fotos proyecto\\nuevas fotos\\home.png"));
		panel.add(buttonEvent);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton
				.setIcon(new ImageIcon(
						"C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\left.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentEvent window = new VentEvent();
				window.getFrame().setVisible(true);
				frame.dispose();

			}
		});
		btnNewButton.setBounds(10, 0, 70, 50);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1
				.setIcon(new ImageIcon(
						"C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\bus.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (c != null) {
					VentUsuario User = new VentUsuario(c);
					User.getFrame().setVisible(true);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe crearse una cuenta para entrar aqui.",
							"ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(370, 0, 55, 50);
		panel.add(btnNewButton_1);

		JLabel lblImagenEvento = new JLabel();
		lblImagenEvento
				.setIcon(new ImageIcon("C:\\Users\\Linkerk\\Downloads\\ejemplo.gif"));
		lblImagenEvento.setBackground(Color.GRAY);
		lblImagenEvento.setForeground(Color.BLACK);
		lblImagenEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenEvento.setBounds(0, 49, 435, 114);
		frame.getContentPane().add(lblImagenEvento);

		textTitulo = new JTextField(nombreEvento);
		textTitulo.setEditable(false);
		textTitulo.setForeground(Color.WHITE);
		textTitulo.setColumns(10);
		textTitulo.setBackground(Color.DARK_GRAY);
		textTitulo.setBounds(37, 174, 364, 23);
		frame.getContentPane().add(textTitulo);

		JTextArea areaInfo = new JTextArea(descripcion);
		areaInfo.setEditable(false);
		areaInfo.setForeground(Color.WHITE);
		areaInfo.setBackground(Color.GRAY);
		areaInfo.setBounds(37, 208, 324, 101);
		frame.getContentPane().add(areaInfo);

		JButton buttonFacebook = new JButton("");
		buttonFacebook
				.setIcon(new ImageIcon(
						"C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\face.png"));
		buttonFacebook.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buttonFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				URI uri = null;
				try {
					uri = new URI(
							"https://www.facebook.com/pages/Click-n-Tick/1586975411580100");
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				open(uri);

			}
		});
		buttonFacebook.setBounds(313, 320, 48, 43);
		buttonFacebook.setBorder(null);
		buttonFacebook.setOpaque(false);
		buttonFacebook.setContentAreaFilled(false);
		buttonFacebook.setBorderPainted(false);
		//
		frame.getContentPane().add(buttonFacebook);

		final JCheckBox chckbxComprarSinOferta = new JCheckBox(
				"Comprar sin oferta");
		chckbxComprarSinOferta.setBounds(286, 370, 115, 23);
		frame.getContentPane().add(chckbxComprarSinOferta);

		JLabel lblNewLabel = new JLabel("Elige la oferta:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 330, 118, 23);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 364, 260, 76);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		textField = new JTextField("1");
		textField.setBounds(358, 417, 32, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCantidad.setBounds(290, 417, 82, 23);
		frame.getContentPane().add(lblCantidad);

		JButton buttonComprar = new JButton("COMPRAR");
		buttonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// table.getValueAt(table.getSelectedRow(), column);//poder
				// seleccionar eventos

				// Cliente cliente = Cliente.getInstance();

				String numEntradas = textField.getText();
				int numEntradasInt = Integer.parseInt(numEntradas);
				c = Cliente.getInstance();

				if (c == null) {

					VentCompraTicket User = new VentCompraTicket(nombreEvento,
							numEntradasInt);
					User.getFrame().setVisible(true);
					frame.dispose();

				} else {

					if (!chckbxComprarSinOferta.isSelected()) {

						if (table.getSelectedRow() == -1) {

							JOptionPane.showMessageDialog(null,
									"Seleccione una oferta", "ERROR",
									JOptionPane.WARNING_MESSAGE);

						} else {

							String descripcionOferta = (String) table
									.getValueAt(table.getSelectedRow(), 0);
							VentConfPago User = new VentConfPago(
									descripcionOferta, nombreEvento, c,
									numEntradasInt);
							User.getFrame().setVisible(true);
							frame.dispose();

						}
					} else {
						boolean ofertas = chckbxComprarSinOferta.isSelected();
						VentConfPago User = new VentConfPago(nombreEvento, c,
								numEntradasInt, ofertas);
						User.getFrame().setVisible(true);
						frame.dispose();
					}
				}

			}
		});
		buttonComprar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		buttonComprar.setBackground(Color.YELLOW);
		buttonComprar.setForeground(Color.BLACK);
		buttonComprar.setBounds(138, 451, 129, 45);
		frame.getContentPane().add(buttonComprar);

		JButton buttontwitter = new JButton("");
		buttontwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				URI uri = null;
				try {
					uri = new URI("https://twitter.com/ClicknTick");
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				open(uri);

			}
		});
		buttontwitter
				.setIcon(new ImageIcon(
						"C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\twit.png"));
		buttontwitter.setBounds(358, 320, 48, 43);
		// desde aqui esto sirve para que los bordes de los botones no aparezcan
		buttontwitter.setBorder(null);
		buttontwitter.setOpaque(false);
		buttontwitter.setContentAreaFilled(false);
		buttontwitter.setBorderPainted(false);
		// hasta aqui
		frame.getContentPane().add(buttontwitter);

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion
				.getQuery("select descripcion as \"Ofertas\", puntos as \"Coste:\", descuento as \"Descuento:\" from clickntick.ofertas");
		table.setModel(DbUtils.resultSetToTableModel(rs));

	}

	private Evento getEvent(String nombreEvento) throws SQLException {

		Evento v = GestorEvento.obtenerEvento(nombreEvento);

		return v;

	}

	public JFrame getFrame() {
		return frame;
	}
}
