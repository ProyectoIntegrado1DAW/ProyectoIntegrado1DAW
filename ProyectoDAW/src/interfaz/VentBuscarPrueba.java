package interfaz;

import gestores.ConexionDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JRadioButtonMenuItem;

import java.awt.List;

import javax.swing.JComboBox;

import java.awt.ScrollPane;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class VentBuscarPrueba {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentBuscarPrueba window = new VentBuscarPrueba();
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
	public VentBuscarPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonBuscar = new JButton("");
		//desde aqui
		buttonBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Connection con = null;
				try{
					
					ConexionDB conexion = ConexionDB.getConexionDB();
					
					ResultSet rs = conexion.getQuery("select * from clickntick.eventos;");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch (Exception e1){
					
				}finally{
					
					try{
						if(con != null)con.close();
					}catch(Exception ex){}
				}
			}
		});
		//Hasta aqui
		buttonBuscar.setBackground(Color.YELLOW);
		buttonBuscar.setIcon(new ImageIcon("C:\\Users\\dai\\git\\ProyectoIntegrado1DAW\\ProyectoDAW\\nuevas fotos\\lupa2.png"));
		buttonBuscar.setBounds(38, 11, 46, 46);
		frame.getContentPane().add(buttonBuscar);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setBounds(115, 22, 58, 14);
		frame.getContentPane().add(lblEvento);
		lblEvento.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(115, 37, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(224, 24, 46, 14);
		frame.getContentPane().add(lblFecha);
		lblFecha.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setBounds(221, 37, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton ButtonComprar = new JButton("COMPRAR");
		ButtonComprar.setBackground(Color.YELLOW);
		ButtonComprar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		ButtonComprar.setBounds(134, 200, 122, 39);
		frame.getContentPane().add(ButtonComprar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 78, 387, 113);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	}
	

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
