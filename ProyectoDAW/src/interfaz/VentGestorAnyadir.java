package interfaz;


import Evento;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;

public class VentGestorAnyadir extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField locales;
	private JTextField ciudad;
	private JTextField anyo;
	private JTextField dia;
	private JTextField precio;
	private JTextArea descripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGestorAnyadir frame = new VentGestorAnyadir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentGestorAnyadir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(5, 27, 61, 14);

		txtNombre = new JTextField();
		txtNombre.setBounds(87, 24, 318, 20);
		txtNombre.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(5, 74, 39, 14);

		JComboBox cmbTipo = new JComboBox();
		cmbTipo.setBounds(87, 71, 113, 20);

		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(212, 74, 54, 14);

		JSpinner plazas = new JSpinner();
		plazas.setBounds(256, 71, 31, 20);
		plazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));
		

		JLabel lblReservadas = new JLabel("Reservadas:");
		lblReservadas.setBounds(297, 74, 96, 14);
		
		
		JSpinner reservadas = new JSpinner();
		reservadas.setBounds(362, 71, 31, 20);
		reservadas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(
				0), null, new Integer(1)));

		reservadas.getN

		locales = new JTextField();
		locales.setBounds(87, 118, 126, 20);
		locales.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(217, 121, 49, 14);

		ciudad = new JTextField();
		ciudad.setBounds(276, 118, 129, 20);
		ciudad.setText("");
		ciudad.setColumns(10);

		JLabel lblLocales = new JLabel("Locales:");
		lblLocales.setBounds(5, 121, 61, 14);

		descripcion = new JTextArea();
		descripcion.setBounds(15, 279, 385, 93);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(5, 254, 79, 14);

		JLabel lblDia = new JLabel("D\u00EDa:");
		lblDia.setBounds(5, 178, 45, 14);

		JComboBox mes = new JComboBox();
		mes.setBounds(175, 175, 91, 20);

		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(141, 178, 39, 14);

		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(280, 178, 33, 14);

		anyo = new JTextField();
		anyo.setBounds(326, 175, 79, 20);
		anyo.setColumns(10);

		dia = new JTextField();
		dia.setBounds(87, 175, 32, 20);
		dia.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(331, 390, 75, 23);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				Evento evento = new Evento(txtNombre.getText(), cmbTipo.getName(), locales.getText(), ciudad.getText(), 
						plazas.getValue(), reservadas.getValue(), descripcion.getText(), Integer.parseInt(precio.getText()),
						dia.getText()+"/" + mes.getName()+"/" + anyo.getText(), "Lunes", "12:00");
			
			} }
			);
		btnGuardar.setBounds(242, 390, 71, 23);

		precio = new JTextField();
		precio.setBounds(87, 216, 49, 20);
		precio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(5, 216, 45, 14);
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
		contentPane.add(ciudad);
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
		contentPane.add(descripcion);
	}
	
	public JFrame getFrame(){
		return this;
	}
}
