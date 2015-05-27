package interfaz;

import entidades.Evento;
import gestores.GestorEvento;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;

public class VentGestorEditar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField locales;
	private JTextField ciudad;
	private JSpinner reservadas, plazas;
	private int reservadastxt, plazastxt;
	private JTextField anyo;
	private JTextField dia;
	private JTextField precio;
	private static JTextArea descripcion;
	private JComboBox mes, cmbTipo;
	private static String nombre;
	private static String descripcionC;
	private static String tipo;
	private static int numEntradas;
	private static String ciudadC;
	private static int reservadas1;
	private static int precio1;
	private static String locales1;

	private static Evento eventoEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGestorEditar frame = new VentGestorEditar(nombre,
							descripcionC, tipo, numEntradas, ciudadC, reservadas1,
							precio1, locales1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param fecha
	 * @param locales
	 * @param precio
	 * @param reservadas
	 */
	public VentGestorEditar(String nombre, String descripcion, String tipo,
			int numEntradas, String ciudad, int reservadas1, int precio1,
			String locales1) {

		this.nombre = nombre;
		this.descripcionC = descripcion;
		this.tipo = tipo;
		this.numEntradas = numEntradas;
		this.ciudadC = ciudad;
		this.reservadas1 = reservadas1;
		this.precio1 = precio1;
		this.locales1 = locales1;
		
		// JFRAME
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// NOMBRE
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(5, 27, 61, 14);

		txtNombre = new JTextField();
		txtNombre.setBounds(87, 24, 337, 20);
		txtNombre.setColumns(10);
		txtNombre.setText(nombre);

		// TIPO
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(5, 74, 39, 14);

		cmbTipo = new JComboBox();
		cmbTipo.setBounds(87, 71, 113, 20);
		GestorEvento g1 = new GestorEvento();
		ArrayList<String> tipos = g1.getArrayTipo();

		cmbTipo.addItem(tipo);

		cmbTipo.setSelectedItem(tipo);
		// PLAZAS
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(212, 74, 54, 14);

		plazas = new JSpinner();
		plazas.setBounds(266, 71, 31, 20);
		plazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));
		plazas.setValue(numEntradas);
		plazas.addChangeListener(new javax.swing.event.ChangeListener() {
			Object lastValue;

			public void stateChanged(ChangeEvent evt) {

				if (lastValue != null && !plazas.getValue().equals(lastValue)) {
					plazastxt = Integer.parseInt(lastValue.toString()) + 1;
				}
				lastValue = plazas.getValue();
			}
		});

		// RESERVADAS
		JLabel lblReservadas = new JLabel("Reservadas:");
		lblReservadas.setBounds(310, 74, 96, 14);

		reservadas = new JSpinner();
		reservadas.setBounds(393, 71, 31, 20);
		reservadas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(
				0), null, new Integer(1)));
		reservadas.setValue(reservadas1);

		reservadas.addChangeListener(new javax.swing.event.ChangeListener() {
			Object lastValue;

			public void stateChanged(ChangeEvent evt) {

				if (lastValue != null
						&& !reservadas.getValue().equals(lastValue)) {
					reservadastxt = Integer.parseInt(lastValue.toString()) + 1;
				}
				lastValue = reservadas.getValue();
			}
		});

		// LOCALES

		JLabel lblLocales = new JLabel("Locales:");
		lblLocales.setBounds(5, 121, 61, 14);

		locales = new JTextField(locales1);
		locales.setBounds(87, 118, 126, 20);
		locales.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(217, 121, 49, 14);
		// CIUDAD
		this.ciudad = new JTextField();
		this.ciudad.setBounds(276, 118, 148, 20);
		this.ciudad.setText(ciudad);
		this.ciudad.setColumns(10);

		// DESCRIPCION
		this.descripcion = new JTextArea();
		this.descripcion.setBounds(15, 279, 409, 93);
		this.descripcion.setText(descripcion);
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(5, 254, 79, 14);

		// FECHA
		JLabel lblDia = new JLabel("D\u00EDa:");
		lblDia.setBounds(5, 178, 45, 14);

		mes = new JComboBox();
		mes.setBounds(175, 175, 91, 20);

		mes.addItem("1");
		mes.addItem("2");
		mes.addItem("3");
		mes.addItem("4");
		mes.addItem("5");
		mes.addItem("6");
		mes.addItem("7");
		mes.addItem("8");
		mes.addItem("9");
		mes.addItem("10");
		mes.addItem("11");
		mes.addItem("12");

		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(141, 178, 39, 14);

		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(280, 178, 33, 14);

		anyo = new JTextField();
		anyo.setBounds(326, 175, 98, 20);
		anyo.setColumns(10);

		dia = new JTextField();
		dia.setBounds(87, 175, 32, 20);
		dia.setColumns(10);
		
		final JFormattedTextField precio = new JFormattedTextField (new Integer(precio1));
		precio.setBounds(87, 216, 49, 20);
		precio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(5, 216, 45, 14);

		// BOTONES
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(331, 390, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					closeFrame(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void closeFrame(ActionEvent e) throws SQLException {
				setVisible(false);
				VentGestorV1 v1 = new VentGestorV1();
				v1.getFrame().setVisible(true);
			}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					closeFrame(e);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}

			private void saveBtn(ActionEvent e) throws SQLException {
				GestorEvento g2 = new GestorEvento();
				// Eliminar evento
				ArrayList<Evento> eventos = g2.getArrayEvento();
				for (Evento ev2 : eventos) {
					if (ev2 == eventoEditar) {
						eventos.remove(ev2);
					}
				}

				// g2.bajaEvento();
				// Añadir evento
				Evento evento = new Evento(txtNombre.getText(),
						(String) cmbTipo.getSelectedItem(), locales.getText(),
						ciudadC, plazastxt, reservadastxt, descripcionC,
						Integer.parseInt(precio.getText()), dia.getText() + "/"
								+ (String) mes.getSelectedItem() + "/"
								+ anyo.getText(), "Lunes", "12:00");

				// g2.addEvent(evento);
			}

			private void closeFrame(ActionEvent e) throws SQLException {
				setVisible(false);
				VentGestorV1 v1 = new VentGestorV1();
				v1.getFrame().setVisible(true);
			}
		});
		btnGuardar.setBounds(242, 390, 71, 23);

		
		contentPane.setLayout(null);
		contentPane.add(btnGuardar);
		contentPane.add(btnCancelar);
		contentPane.add(lblNombre);
		contentPane.add(lblLocales);
		contentPane.add(lblTipo);
		contentPane.add(cmbTipo);
		contentPane.add(lblPlazas);
		contentPane.add(plazas);
		contentPane.add(lblReservadas);
		contentPane.add(reservadas);
		contentPane.add(locales);
		contentPane.add(lblCiudad);
		contentPane.add(this.ciudad);
		contentPane.add(txtNombre);
		contentPane.add(lblDia);
		contentPane.add(dia);
		contentPane.add(lblMes);
		contentPane.add(lblDescripcin);
		contentPane.add(mes);
		contentPane.add(lblAo);
		contentPane.add(anyo);
		contentPane.add(lblPrecio);
		contentPane.add(precio);
		contentPane.add(this.descripcion);
	}

	public JFrame getFrame() {
		return this;
	}
}
