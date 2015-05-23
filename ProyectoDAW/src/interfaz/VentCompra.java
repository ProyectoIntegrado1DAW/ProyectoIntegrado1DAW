package interfaz;

import entidades.Evento;
import gestores.ConexionDB;
import gestores.GestorEvento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;

public class VentCompra {

	private JFrame frame;
	private JTextField textTitulo;
	private JTable table;
	private JTextField textField;
	private String nombreEvento;
	private String descripcion;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String nombreEvento = null;
					String descripcion = null;
					
					VentCompra window = new VentCompra(nombreEvento, descripcion);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public VentCompra() throws SQLException {
		initialize();

	}
	
	public VentCompra(String nombreEvento, String descripcion) throws SQLException {
		
		this.nombreEvento = nombreEvento;
		this.descripcion = descripcion;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 0, 435, 50);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\LogoSmall.png"));
		panel.add(lblNewLabel_1);
		
		JButton buttonEvent = new JButton("");
		buttonEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					try {
						VentEvent Evento = new VentEvent();
						Evento.getFrame().setVisible(true);
						frame.dispose();
					} catch (Exception e2){
						e2.printStackTrace();
					}
			}
		});
		
		Evento ev = getEvent(nombreEvento);
		
		buttonEvent.setBorder(null);
		buttonEvent.setOpaque(false);
		buttonEvent.setContentAreaFilled(false);
		buttonEvent.setBorderPainted(false);
		buttonEvent.setBackground(Color.YELLOW);
		buttonEvent.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\fotos proyecto\\nuevas fotos\\home.png"));
		panel.add(buttonEvent);
		
		JLabel lblImagenEvento = new JLabel();
		lblImagenEvento.setIcon(new ImageIcon("C:\\Users\\dai\\Desktop\\vinarock_300x300.png"));
		lblImagenEvento.setBackground(Color.GRAY);
		lblImagenEvento.setForeground(Color.BLACK);
		lblImagenEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenEvento.setBounds(0, 49, 435, 114);
		frame.getContentPane().add(lblImagenEvento);

		textTitulo = new JTextField(nombreEvento);
		textTitulo.setEditable(false);
		textTitulo.setForeground(Color.WHITE);
		textTitulo.setColumns(10);
		textTitulo.setBackground(Color.DARK_GRAY);
		textTitulo.setBounds(37, 174, 364, 23);
		frame.getContentPane().add(textTitulo);
		
		JTextArea areaInfo = new JTextArea(descripcion);
		areaInfo.setEditable(false);
		areaInfo.setForeground(Color.WHITE);
		areaInfo.setBackground(Color.GRAY);
		areaInfo.setBounds(37, 208, 324, 101);
		frame.getContentPane().add(areaInfo);
		
		JButton buttonFacebook = new JButton("");
		buttonFacebook.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\face.png"));
		buttonFacebook.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		buttonFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonFacebook.setBounds(300, 487, 48, 43);
		buttonFacebook.setBorder(null);
		buttonFacebook.setOpaque(false);
		buttonFacebook.setContentAreaFilled(false);
		buttonFacebook.setBorderPainted(false);
		//
		frame.getContentPane().add(buttonFacebook);
		
		JButton buttonComprar = new JButton("COMPRAR");
		buttonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//table.getValueAt(table.getSelectedRow(), column);//poder seleccionar eventos
				
			}
		});
		buttonComprar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		buttonComprar.setBackground(Color.YELLOW);
		buttonComprar.setForeground(Color.BLACK);
		buttonComprar.setBounds(135, 487, 129, 32);
		frame.getContentPane().add(buttonComprar);
		
		JLabel lblNewLabel = new JLabel("Elige la oferta");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 320, 118, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton buttonBuscar = new JButton("");
		buttonBuscar.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\lupa1.png"));
		buttonBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection con = null;
				try{
					ConexionDB conexion = ConexionDB.getConexionDB();
					
					ResultSet rs = conexion.getQuery("select puntos as \"Coste:\", descuento as \"Descuento:\" from clickntick.ofertas");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch (Exception e1){
					
				}finally{
					
					try{
						if(con != null)con.close();
					}catch(Exception ex){}
				}
			}
		});
		
		
		buttonBuscar.setBounds(10, 348, 54, 43);
		//desde aqui esto sirbe para que los bordes de los botones no aparezcan
		buttonBuscar.setBorder(null);
		buttonBuscar.setOpaque(false);
		buttonBuscar.setContentAreaFilled(false);
		buttonBuscar.setBorderPainted(false);
		//asta aqui 
		frame.getContentPane().add(buttonBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 387, 192, 76);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(358, 395, 32, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCantidad.setBounds(266, 395, 82, 23);
		frame.getContentPane().add(lblCantidad);
		
		JButton buttontwitter = new JButton("");
		buttontwitter.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\twit.png"));
		buttontwitter.setBounds(361, 487, 48, 43);
		//desde aqui esto sirbe para que los bordes de los botones no aparezcan
		buttontwitter.setBorder(null);
		buttontwitter.setOpaque(false);
		buttontwitter.setContentAreaFilled(false);
		buttontwitter.setBorderPainted(false);
		//asta aqui 
		frame.getContentPane().add(buttontwitter);
		
	
	}
	
	private Evento getEvent(String nombreEvento) throws SQLException {
		
		Evento v = GestorEvento.obtenerEvento(nombreEvento);
		
		return v;
		
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
