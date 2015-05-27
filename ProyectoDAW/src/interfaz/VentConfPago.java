package interfaz;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

import entidades.Cliente;

import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JTextField;

public class VentConfPago {
	
	private String descripcionOferta;
	private String nombreEvento;
	private Cliente cliente;
	private int numEntradas;

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentConfPago window = new VentConfPago();
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
	public VentConfPago() {
		initialize();
	}
	
	public VentConfPago(String descripcionOferta, String nombreEvento, Cliente cliente, int numEntradas) {
		
		this.descripcionOferta = descripcionOferta;
		this.nombreEvento = nombreEvento;
		this.cliente = cliente;
		this.numEntradas = numEntradas;
		initialize();
	}

	public VentConfPago(String nombreEvento, Cliente cliente,
			int numEntradasInt) {
		// TODO Auto-generated constructor stub
		
		this.nombreEvento = nombreEvento;
		this.cliente = cliente;
		this.numEntradas = numEntradasInt;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(237, 45, 137, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnConfirmar.setBackground(Color.YELLOW);
		btnConfirmar.setBounds(124, 76, 129, 45);
		frame.getContentPane().add(btnConfirmar);
		
		JTextPane txtpnSeleccioneElTipo = new JTextPane();
		txtpnSeleccioneElTipo.setBackground(UIManager.getColor("Button.background"));
		txtpnSeleccioneElTipo.setText("Seleccione el tipo de tarjeta");
		txtpnSeleccioneElTipo.setBounds(10, 45, 157, 20);
		frame.getContentPane().add(txtpnSeleccioneElTipo);
		
		JTextPane txtpnNumeroDeTarjeta = new JTextPane();
		txtpnNumeroDeTarjeta.setText("Numero de tarjeta");
		txtpnNumeroDeTarjeta.setBackground(SystemColor.menu);
		txtpnNumeroDeTarjeta.setBounds(10, 14, 157, 20);
		frame.getContentPane().add(txtpnNumeroDeTarjeta);
		
		textField = new JTextField();
		textField.setBounds(237, 14, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public JFrame getFrame(){
		return frame;
	}
}
