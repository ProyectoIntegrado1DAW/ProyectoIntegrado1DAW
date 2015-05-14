package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.DropMode;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SpinnerNumberModel;

public class VentGestor extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreEvento;
	private JTextField Locales;
	private JTextField Ciudad;
	private JTextField txtDdmmaaaa;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGestor frame = new VentGestor();
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
	public VentGestor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre:");

		textNombreEvento = new JTextField();
		textNombreEvento.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");

		JComboBox comboTipoEvento = new JComboBox();

		JLabel lblPlazas = new JLabel("Plazas:");

		JSpinner plazas = new JSpinner();
		plazas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));

		JLabel lblReservadas = new JLabel("Reservadas:");

		JSpinner reservadas = new JSpinner();
		reservadas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(
				0), null, new Integer(1)));

		JLabel lblLugar = new JLabel("");

		TextArea descripcion = new TextArea();

		Locales = new JTextField();
		Locales.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad:");

		Ciudad = new JTextField();
		Ciudad.setText("");
		Ciudad.setColumns(10);

		JLabel lblLocales = new JLabel("Locales:");

		JTextArea textArea = new JTextArea();

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");

		JLabel lblDia = new JLabel("D\u00EDa:");

		JComboBox comboBox = new JComboBox();

		JLabel lblMes = new JLabel("Mes:");

		JLabel lblAo = new JLabel("A\u00F1o:");

		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");

		JButton btnGuardar = new JButton("Guardar");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel(
				"Precio");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				btnGuardar)
																		.addGap(18)
																		.addComponent(
																				btnCancelar)
																		.addGap(13))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblNombre)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblLocales)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				lblLugar))
																														.addComponent(
																																lblTipo))
																										.addGap(37)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				comboTipoEvento,
																																				0,
																																				117,
																																				Short.MAX_VALUE)
																																		.addGap(12)
																																		.addComponent(
																																				lblPlazas)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				plazas,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				lblReservadas)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				reservadas,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(12))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				Locales,
																																				GroupLayout.PREFERRED_SIZE,
																																				126,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				lblCiudad,
																																				GroupLayout.PREFERRED_SIZE,
																																				49,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				Ciudad,
																																				GroupLayout.DEFAULT_SIZE,
																																				129,
																																				Short.MAX_VALUE))
																														.addComponent(
																																textNombreEvento,
																																GroupLayout.DEFAULT_SIZE,
																																318,
																																Short.MAX_VALUE)))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblDia)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				textField,
																																				GroupLayout.PREFERRED_SIZE,
																																				19,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(12)
																																		.addComponent(
																																				lblMes))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addContainerGap()
																																		.addComponent(
																																				lblDescripcin,
																																				GroupLayout.PREFERRED_SIZE,
																																				79,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addGap(6)
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												109,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(24)
																										.addComponent(
																												lblAo)
																										.addGap(12)
																										.addComponent(
																												txtDdmmaaaa,
																												GroupLayout.DEFAULT_SIZE,
																												137,
																												Short.MAX_VALUE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblPrecio)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField_1,
																												GroupLayout.PREFERRED_SIZE,
																												49,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(14))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				textArea,
																				GroupLayout.PREFERRED_SIZE,
																				385,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(19)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(19)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblNombre)
														.addComponent(
																textNombreEvento,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 27,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboTipoEvento,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblTipo)
														.addComponent(
																plazas,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblReservadas)
														.addComponent(
																reservadas,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPlazas))
										.addGap(27)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				lblLugar))
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				Locales,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblLocales)
																		.addComponent(
																				lblCiudad)
																		.addComponent(
																				Ciudad,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(37)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblDia)
														.addComponent(
																txtDdmmaaaa,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblAo)
														.addComponent(
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMes)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrecio))
										.addGap(14)
										.addComponent(lblDescripcin)
										.addGap(18)
										.addComponent(textArea,
												GroupLayout.PREFERRED_SIZE, 93,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnGuardar)
														.addComponent(
																btnCancelar))
										.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
