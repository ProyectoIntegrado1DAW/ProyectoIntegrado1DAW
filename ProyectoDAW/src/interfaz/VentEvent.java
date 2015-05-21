package interfaz;

import gestores.ConexionDB;

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
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class VentEvent {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

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
		frame.setBounds(100, 100, 450, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton buttonBuscar = new JButton("");
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Festival",
				"Concierto", "Opera", "sdfs" }));
		comboBox.setBounds(286, 121, 122, 20);
		frame.getContentPane().add(comboBox);

		// desde aqui
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;

				String nombreEvento = textField.getText();
				Object tipo = comboBox.getSelectedItem();

				try {

					ConexionDB conexion = ConexionDB.getConexionDB();

					ResultSet rs = conexion
							.getQuery("select nombreevento as \"Nombre\", tipoevento as \"Tipo\", ciudad as \"Ciudad\", fecha as \"Fecha\", precio as \"Precio\" from clickntick.eventos WHERE nombreevento LIKE '"
									+ nombreEvento
									+ "%' AND tipoevento = '"
									+ tipo + "';");

					table.setModel(DbUtils.resultSetToTableModel(rs));

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
		ButtonComprar.setBackground(Color.YELLOW);
		ButtonComprar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		ButtonComprar.setBounds(149, 557, 122, 39);
		frame.getContentPane().add(ButtonComprar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 152, 387, 378);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
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

		JLabel label = new JLabel("asfsfasf");
		label.setBounds(166, 9, 116, 28);
		panel.add(label);

		JButton button = new JButton("");
		button.setOpaque(false);
		button.setForeground(Color.YELLOW);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(360, 9, 51, 28);
		panel.add(button);

		JButton button_1 = new JButton("");
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(Color.YELLOW);
		button_1.setBounds(10, 0, 67, 50);
		panel.add(button_1);

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
