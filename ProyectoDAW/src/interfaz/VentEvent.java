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
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 50);
		panel.setBackground(Color.YELLOW);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Imagen evento");
		lblNewLabel.setBounds(10, 81, 134, 99);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Imagen evento");
		label.setBounds(10, 217, 134, 99);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Imagen evento");
		label_1.setBounds(10, 360, 134, 99);
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(label_1);

		textOneEvent = new JTextField();
		textOneEvent.setBounds(154, 74, 270, 23);
		textOneEvent.setForeground(Color.WHITE);
		textOneEvent.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(textOneEvent);
		textOneEvent.setColumns(10);

		textTwoEvent = new JTextField();
		textTwoEvent.setBounds(154, 211, 270, 23);
		textTwoEvent.setForeground(Color.WHITE);
		textTwoEvent.setColumns(10);
		textTwoEvent.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(textTwoEvent);

		textThreeEvent = new JTextField();
		textThreeEvent.setBounds(154, 351, 270, 23);
		textThreeEvent.setForeground(Color.WHITE);
		textThreeEvent.setColumns(10);
		textThreeEvent.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(textThreeEvent);

		JTextArea infoOneEvent = new JTextArea();
		infoOneEvent.setBounds(164, 108, 234, 77);
		infoOneEvent.setForeground(Color.WHITE);
		infoOneEvent.setBackground(Color.GRAY);
		frame.getContentPane().add(infoOneEvent);

		infoTwoEvent = new JTextArea();
		infoTwoEvent.setBounds(164, 245, 234, 77);
		infoTwoEvent.setForeground(Color.WHITE);
		infoTwoEvent.setBackground(Color.GRAY);
		frame.getContentPane().add(infoTwoEvent);

		infoThreeEvent = new JTextArea();
		infoThreeEvent.setBounds(164, 385, 234, 77);
		infoThreeEvent.setForeground(Color.WHITE);
		infoThreeEvent.setBackground(Color.GRAY);
		frame.getContentPane().add(infoThreeEvent);
	}

	public JFrame getFrame() {

		return frame;
	}

}
