package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentCompra {

	private JFrame frame;
	private JTextField textTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentCompra window = new VentCompra();
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
	public VentCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 451, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 435, 50);
		frame.getContentPane().add(panel);
		
		JLabel lblImagenEvento = new JLabel("Imagen evento");
		lblImagenEvento.setBackground(Color.GRAY);
		lblImagenEvento.setForeground(Color.BLACK);
		lblImagenEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenEvento.setBounds(0, 49, 435, 133);
		frame.getContentPane().add(lblImagenEvento);
		
		textTitulo = new JTextField();
		textTitulo.setForeground(Color.WHITE);
		textTitulo.setColumns(10);
		textTitulo.setBackground(Color.DARK_GRAY);
		textTitulo.setBounds(37, 193, 364, 23);
		frame.getContentPane().add(textTitulo);
		
		JTextArea areaInfo = new JTextArea();
		areaInfo.setForeground(Color.WHITE);
		areaInfo.setBackground(Color.GRAY);
		areaInfo.setBounds(37, 227, 324, 101);
		frame.getContentPane().add(areaInfo);
		
		JLabel lblCompartir = new JLabel("COMPARTIR");
		lblCompartir.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblCompartir.setBounds(37, 357, 109, 23);
		frame.getContentPane().add(lblCompartir);
		
		JButton buttonFacebook = new JButton("FACEBOOK");
		buttonFacebook.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buttonFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonFacebook.setBounds(47, 391, 102, 23);
		frame.getContentPane().add(buttonFacebook);
		
		JButton ButtonTWITTER = new JButton("TWITTER");
		ButtonTWITTER.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		ButtonTWITTER.setBounds(177, 391, 89, 23);
		frame.getContentPane().add(ButtonTWITTER);
		
		JButton buttonComprar = new JButton("COMPRAR");
		buttonComprar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		buttonComprar.setBackground(Color.YELLOW);
		buttonComprar.setForeground(Color.BLACK);
		buttonComprar.setBounds(137, 447, 129, 32);
		frame.getContentPane().add(buttonComprar);
	}
}
