package interfaz;

import gestores.ConexionDB;
import entidades.Evento;

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

public class VentEvent {

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
					VentEvent window = new VentEvent();
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
	public VentEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 581);
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
								.getQuery("select nombreevento as \"Nombre\", descripcion as \"Descripcion\",tipoevento as \"Tipo\", ciudad as \"Ciudad\", fecha as \"Fecha\", precio as \"Precio\" from clickntick.eventos WHERE nombreevento LIKE '%"
										+ nombreEvento + "%'");

						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						eventos=new ArrayList<Evento>();
						while(rs.next()){
							Evento e=new Evento(rs.getString());
							eventos.add();
						}

					} else {

						ConexionDB conexion = ConexionDB.getConexionDB();

						ResultSet rs = conexion
								.getQuery("select nombreevento as \"Nombre\", descripcion as \"Descripcion\", tipoevento as \"Tipo\", ciudad as \"Ciudad\", fecha as \"Fecha\", precio as \"Precio\" from clickntick.eventos WHERE nombreevento LIKE '"
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

		JButton ButtonComprar = new JButton("COMPRAR");
		ButtonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Seleccione un evento",
							"ERROR", JOptionPane.WARNING_MESSAGE);

				} else {
					
					String nombre = (String) table.getValueAt(
							table.getSelectedRow(), 1);
					String descripcion = (String) table.getValueAt(
							table.getSelectedRow(), 2);
					VentCompra User = null;
					try {
						User = new VentCompra(nombre, descripcion);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					User.getFrame().setVisible(true);
					frame.dispose();

				}
			}
		});
		ButtonComprar.setBackground(Color.YELLOW);
		ButtonComprar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		ButtonComprar.setBounds(147, 471, 122, 39);
		frame.getContentPane().add(ButtonComprar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));
		scrollPane.setBounds(21, 152, 387, 308);
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
		panel.setBounds(0, 0, 434, 50);
		frame.getContentPane().add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Linkerk\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoSmall.png"));
		label.setBounds(166, 9, 116, 28);
		panel.add(label);

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion
				.getQuery("select nombreevento as \"Nombre\", descripcion as \"Descripcion\", tipoevento as \"Tipo\", ciudad as \"Ciudad\", fecha as \"Fecha\", precio as \"Precio\" from clickntick.eventos");

		table.setModel(DbUtils.resultSetToTableModel(rs));

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
