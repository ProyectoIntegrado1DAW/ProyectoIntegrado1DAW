package interfaz;

import gestores.ConexionDB;
import gestores.GestorEvento;
import entidades.Cliente;
import entidades.Evento;
import entidades.Gestor;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JRadioButtonMenuItem;

import java.awt.List;

import javax.swing.JComboBox;

import java.awt.ScrollPane;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.table.TableModel;

public class VentGestorV1 {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	private ArrayList<Evento> eventos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGestorV1 window = new VentGestorV1();
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
	 * @wbp.parser.entryPoint
	 */
	public VentGestorV1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 761, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton buttonBuscar = new JButton("");
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Todos",
				"Festival", "Concierto", "Opera" }));
		comboBox.setBounds(286, 121, 122, 20);
		frame.getContentPane().add(comboBox);

		// desde aqui
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;

				String nombreEvento = textField.getText();
				Object tipo = comboBox.getSelectedItem();

				try {
					if (tipo.equals("Todos")) {

						ConexionDB conexion = ConexionDB.getConexionDB();

						ResultSet rs = conexion
								.getQuery("select * from clickntick.eventos WHERE nombreevento LIKE '%"
										+ nombreEvento + "%'");

						table.setModel(DbUtils.resultSetToTableModel(rs));

						eventos = new ArrayList<Evento>();
						// while(rs.next()){
						// Evento e=new Evento(rs.getString());
						// eventos.add();
						// }

					} else {

						ConexionDB conexion = ConexionDB.getConexionDB();

						ResultSet rs = conexion
								.getQuery("select * from clickntick.eventos WHERE nombreevento LIKE '"
										+ nombreEvento
										+ "%' AND tipoevento = '" + tipo + "';");

						table.setModel(DbUtils.resultSetToTableModel(rs));

					}

				} catch (Exception e1) {

				} finally {

					try {
						if (con != null)
							con.close();
					} catch (Exception ex) {

						JOptionPane.showMessageDialog(null, ex);

					}
				}
			}
		});

		// Hasta aqui
		buttonBuscar.setBackground(Color.YELLOW);
		buttonBuscar
				.setIcon(new ImageIcon(
						"C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\lupa1.png"));
		buttonBuscar.setBounds(21, 95, 46, 46);
		frame.getContentPane().add(buttonBuscar);

		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setBounds(87, 95, 58, 14);
		frame.getContentPane().add(lblEvento);
		lblEvento.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));

		textField = new JTextField();
		textField.setBounds(87, 121, 189, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton BotonAnyadir = new JButton("A\u00F1adir");
		BotonAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentGestorAnyadir ventanaGestor = new VentGestorAnyadir();
				ventanaGestor.getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		BotonAnyadir.setBackground(Color.YELLOW);
		BotonAnyadir.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		BotonAnyadir.setBounds(613, 152, 122, 39);
		frame.getContentPane().add(BotonAnyadir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		scrollPane.setBounds(21, 152, 582, 174);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblTipo.setBounds(286, 96, 58, 14);
		frame.getContentPane().add(lblTipo);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 745, 50);
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\left.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentPrincipal window = new VentPrincipal();
				window.getFrame().setVisible(true);
				frame.dispose();
				Gestor.setInstance();
				
			}
		});
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(10, 0, 70, 50);
		panel.add(button);

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion
				.getQuery("select * from clickntick.eventos");

		table.setModel(DbUtils.resultSetToTableModel(rs));

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Seleccione un evento",
							"ERROR", JOptionPane.WARNING_MESSAGE);

				} else {

					String nombre = (String) table.getValueAt(
							table.getSelectedRow(), 1);
					String descripcion = (String) table.getValueAt(
							table.getSelectedRow(), 7);
					String tipo = (String) table.getValueAt(
							table.getSelectedRow(), 2);
					String ciudad = (String) table.getValueAt(
							table.getSelectedRow(), 4);
					int numEntradas = (Integer) table.getValueAt(
							table.getSelectedRow(), 5);
					int reservadas = (Integer) table.getValueAt(
							table.getSelectedRow(), 6);
					int precio = (Integer) table.getValueAt(
							table.getSelectedRow(), 8);
					String locales = (String) table.getValueAt(
							table.getSelectedRow(), 3);
					
					// int numEntradasToInt = Integer.parseInt(numEntradas);
					
					VentGestorEditar User = null;
					User = new VentGestorEditar(nombre, descripcion, tipo,
							numEntradas, ciudad, reservadas, precio, locales);
					User.getFrame().setVisible(true);
					frame.setVisible(false);

				}

			}
		});
		btnEditar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnEditar.setBackground(Color.YELLOW);
		btnEditar.setBounds(613, 215, 122, 39);
		frame.getContentPane().add(btnEditar);

		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = (String) table.getValueAt(
						table.getSelectedRow(), 0);
				GestorEvento.bajaEvento(nombre);
				ConexionDB conexion = ConexionDB.getConexionDB();
				ResultSet rs = conexion
						.getQuery("select * from clickntick.eventos");
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		btnQuitar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnQuitar.setBackground(Color.YELLOW);
		btnQuitar.setBounds(613, 287, 122, 39);
		frame.getContentPane().add(btnQuitar);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JFrame getFrame() {

		return frame;
	}
}
