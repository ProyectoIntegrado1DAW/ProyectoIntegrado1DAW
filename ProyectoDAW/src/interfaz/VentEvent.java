package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentEvent {

	private JFrame frame;
	private JTextField textOneEvent;
	private JTextField textTwoEvent;
	private JTextField textThreeEvent;
	private JTextArea infoTwoEvent;
	private JTextArea infoThreeEvent;

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
		frame.setBounds(100, 100, 450, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 438, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(220, 9, 66, 14);
		panel.add(lblNewLabel_1);
		
		JButton buttonAtras = new JButton("");
		buttonAtras.setBounds(291, 16, 1, 1);
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					try {
						VentUsuario Evento = new VentUsuario();
						Evento.getFrame().setVisible(true);
						frame.dispose();
					} catch (Exception e2){
						e2.printStackTrace();
					}
			}
		});
		
		
		buttonAtras.setBorder(null);
		buttonAtras.setOpaque(false);
		buttonAtras.setContentAreaFilled(false);
		buttonAtras.setBorderPainted(false);
		buttonAtras.setBackground(Color.YELLOW);
		buttonAtras.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\fotos proyecto\\nuevas fotos\\right.png"));
		panel.add(buttonAtras);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\left.png"));
		button.setForeground(Color.YELLOW);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentPrincipal User = new VentPrincipal();
				User.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		button.setBackground(Color.YELLOW);
		button.setBounds(10, 11, 51, 28);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("Imagen evento");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 81, 134, 99);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Imagen evento");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(10, 217, 134, 99);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Imagen evento");
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(10, 360, 134, 99);
		frame.getContentPane().add(label_1);
		
		textOneEvent = new JTextField();
		textOneEvent.setForeground(Color.WHITE);
		textOneEvent.setBackground(Color.DARK_GRAY);
		textOneEvent.setBounds(154, 74, 270, 23);
		frame.getContentPane().add(textOneEvent);
		textOneEvent.setColumns(10);
		
		textTwoEvent = new JTextField();
		textTwoEvent.setForeground(Color.WHITE);
		textTwoEvent.setColumns(10);
		textTwoEvent.setBackground(Color.DARK_GRAY);
		textTwoEvent.setBounds(154, 211, 270, 23);
		frame.getContentPane().add(textTwoEvent);
		
		textThreeEvent = new JTextField();
		textThreeEvent.setForeground(Color.WHITE);
		textThreeEvent.setColumns(10);
		textThreeEvent.setBackground(Color.DARK_GRAY);
		textThreeEvent.setBounds(154, 351, 270, 23);
		frame.getContentPane().add(textThreeEvent);
		
		JTextArea infoOneEvent = new JTextArea();
		infoOneEvent.setForeground(Color.WHITE);
		infoOneEvent.setBackground(Color.GRAY);
		infoOneEvent.setBounds(164, 108, 234, 77);
		frame.getContentPane().add(infoOneEvent);
		
		infoTwoEvent = new JTextArea();
		infoTwoEvent.setForeground(Color.WHITE);
		infoTwoEvent.setBackground(Color.GRAY);
		infoTwoEvent.setBounds(164, 245, 234, 77);
		frame.getContentPane().add(infoTwoEvent);
		
		infoThreeEvent = new JTextArea();
		infoThreeEvent.setForeground(Color.WHITE);
		infoThreeEvent.setBackground(Color.GRAY);
		infoThreeEvent.setBounds(164, 385, 234, 77);
		frame.getContentPane().add(infoThreeEvent);
	}
	public JFrame getFrame(){
		return frame;
	}
}
