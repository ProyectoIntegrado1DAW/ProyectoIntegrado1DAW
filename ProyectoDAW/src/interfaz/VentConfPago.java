package interfaz;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

import entidades.Cliente;
import entidades.Usuario;
import gestores.GestorEntrada;

import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class VentConfPago {

	private String descripcionOferta;
	private String nombreEvento;
	private Cliente cliente;
	private int numEntradas;
	private Cliente c;

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

	public VentConfPago(String descripcionOferta, String nombreEvento,
			Cliente cliente, int numEntradas) {

		this.descripcionOferta = descripcionOferta;
		this.nombreEvento = nombreEvento;
		this.cliente = cliente;
		this.numEntradas = numEntradas;
		initialize();
	}

	// no se usa de momento
	public VentConfPago(String nombreEvento, Cliente c, int numEntradas) {
		// TODO Auto-generated constructor stub
		
		this.nombreEvento = nombreEvento;
		this.numEntradas = numEntradas;
		this.c = c;
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

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(237, 45, 137, 20);
		frame.getContentPane().add(comboBox);

		textField = new JTextField("");
		textField.setBounds(237, 14, 137, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		comboBox.addItem("VISA");
		comboBox.addItem("Master Card");
		comboBox.addItem("El corte inglés");
		comboBox.addItem("Discover");
		comboBox.addItem("American Express");

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				try {
					int numTarjInt = 0;
					String numTarj = textField.getText();

					numTarjInt = Integer.parseInt(numTarj);
					String tipoTarjeta = (String) comboBox.getSelectedItem();
					
					System.out.println(tipoTarjeta);
					
					try {
						GestorEntrada.compraEntrNoReg(nombreEvento, cliente, numTarj, tipoTarjeta, numEntradas);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

//				} catch (Exception e) {
//
//					JOptionPane
//							.showMessageDialog(
//									null,
//									"Introduzca algun numero de tarjeta correcto (solo numeros)",
//									"ERROR", JOptionPane.WARNING_MESSAGE);
//
//				}
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnConfirmar.setBackground(Color.YELLOW);
		btnConfirmar.setBounds(124, 76, 129, 45);
		frame.getContentPane().add(btnConfirmar);

		JTextPane txtpnSeleccioneElTipo = new JTextPane();
		txtpnSeleccioneElTipo.setBackground(UIManager
				.getColor("Button.background"));
		txtpnSeleccioneElTipo.setText("Seleccione el tipo de tarjeta");
		txtpnSeleccioneElTipo.setBounds(10, 45, 157, 20);
		frame.getContentPane().add(txtpnSeleccioneElTipo);

		JTextPane txtpnNumeroDeTarjeta = new JTextPane();
		txtpnNumeroDeTarjeta.setText("Numero de tarjeta");
		txtpnNumeroDeTarjeta.setBackground(SystemColor.menu);
		txtpnNumeroDeTarjeta.setBounds(10, 14, 157, 20);
		frame.getContentPane().add(txtpnNumeroDeTarjeta);

	}

	public JFrame getFrame() {
		return frame;
	}
}
