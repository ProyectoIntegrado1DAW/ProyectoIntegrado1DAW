package interfaz;
import entidades.Evento;
import gestores.GestorEvento;

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
import java.sql.SQLException;
import java.util.ArrayList;

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
	private JSpinner reservadas, plazas;
	private int reservadastxt, plazastxt;
	private JTextField anyo;
	private JTextField dia;
	private JTextField precio;
	private JTextArea descripcion;
	private JComboBox mes, cmbTipo;
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
	//JFRAME
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	//NOMBRE
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(5, 27, 61, 14);

		txtNombre = new JTextField();
		txtNombre.setBounds(87, 24, 318, 20);
		txtNombre.setColumns(10);
		
	//TIPO
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(5, 74, 39, 14);

		cmbTipo = new JComboBox();
		cmbTipo.setBounds(87, 71, 113, 20);
		GestorEvento g1 = new GestorEvento();
		ArrayList<String> tipos = g1.getArrayTipo();
		
		for(String tipo : tipos){
			cmbTipo.addItem(tipo);
		}
		
	//PLAZAS
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(212, 74, 54, 14);

		plazas = new JSpinner();
		plazas.setBounds(256, 71, 31, 20);
		plazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));
		plazas.addChangeListener(new javax.swing.event.ChangeListener() {
			Object lastValue;
	        public void stateChanged(ChangeEvent evt) {

	                if (lastValue != null && !plazas.getValue().equals(lastValue)) {
	                   plazastxt=Integer.parseInt(lastValue.toString())+1;
	                }
	                lastValue = plazas.getValue();
	        }
	    });

		//RESERVADAS
		JLabel lblReservadas = new JLabel("Reservadas:");
		lblReservadas.setBounds(297, 74, 96, 14);
		
		reservadas = new JSpinner();
		reservadas.setBounds(362, 71, 31, 20);
		reservadas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(
				0), null, new Integer(1)));
		
		reservadas.addChangeListener(new javax.swing.event.ChangeListener() {
			Object lastValue;
	        public void stateChanged(ChangeEvent evt) {

	                if (lastValue != null && !reservadas.getValue().equals(lastValue)) {
	                   reservadastxt=Integer.parseInt(lastValue.toString())+1;
	                }
	                lastValue = reservadas.getValue();
	        }
	    });
		
	//LOCALES
		locales=new JTextField();
		locales.setBounds(87, 118, 126, 20);
		locales.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(217, 121, 49, 14);
	//CIUDAD
		ciudad = new JTextField();
		ciudad.setBounds(276, 118, 129, 20);
		ciudad.setText("");
		ciudad.setColumns(10);

		JLabel lblLocales = new JLabel("Locales:");
		lblLocales.setBounds(5, 121, 61, 14);
	
	//DESCRIPCION
		descripcion = new JTextArea();
		descripcion.setBounds(15, 279, 385, 93);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(5, 254, 79, 14);

	//FECHA
		JLabel lblDia = new JLabel("D\u00EDa:");
		lblDia.setBounds(5, 178, 45, 14);

		mes = new JComboBox();
		mes.setBounds(175, 175, 91, 20);
		
		mes.addItem("Enero");
		mes.addItem("Febrero");
		mes.addItem("Marzo");
		mes.addItem("Abril");
		mes.addItem("Mayo");
		mes.addItem("Junio");
		mes.addItem("Agosto");
		mes.addItem("Septiembre");
		mes.addItem("Octubre");
		mes.addItem("Diciembre");
		mes.addItem("Enero");
		
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
		
	//BOTONES
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(331, 390, 75, 23);
		btnCancelar.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					closeFrame(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		private void closeFrame(ActionEvent e) throws SQLException{
			setVisible(false);
			VentGestor v1 = new VentGestor();
			v1.getFrame().setVisible(true);
		}
		}
		);
			
			
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(plazastxt);
				System.out.println(reservadastxt);
				Evento evento = new Evento(txtNombre.getText(), (String) cmbTipo.getSelectedItem(), locales.getText(), ciudad.getText(), 
						plazastxt, reservadastxt, descripcion.getText(), Integer.parseInt(precio.getText()),
						dia.getText()+"/" + (String) mes.getSelectedItem()+"/" + anyo.getText(), "Lunes", "12:00");
				//GestorEvento g2 = new GestorEvento();
				//g2.addEvent(evento);
				try {
					closeFrame(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}private void closeFrame(ActionEvent e) throws SQLException{
				setVisible(false);
				VentGestor v1 = new VentGestor();
				v1.getFrame().setVisible(true);
			}}
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
