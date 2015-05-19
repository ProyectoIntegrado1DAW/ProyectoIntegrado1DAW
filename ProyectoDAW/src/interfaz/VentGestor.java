package interfaz;




import entidades.Evento;
import gestores.GestorEvento;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentGestor implements TreeSelectionListener{

	private JFrame frame;
	private String seleccionado;
	private JTree tree;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGestor window = new VentGestor();
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
	
	
	
	
	
	public VentGestor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//PRUEBA
		
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JTREE
		
		//Nodos
		GestorEvento g1 = new GestorEvento();
		ArrayList<Evento> eventos = g1.getArrayEventos();
		ArrayList<String> tipos = g1.getArrayTipos();
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Eventos");
		DefaultMutableTreeNode evento = null;
		DefaultMutableTreeNode tipo = null;
		
		for(String tipo_ : tipos){
			tipo = new DefaultMutableTreeNode(tipo_);
			raiz.add(tipo);
			for(Evento evento_ : eventos){
				if(evento_.getTipoEvento().equals(tipo_)){
					evento = new DefaultMutableTreeNode(evento_.getNombre());
					tipo.add(evento);
				}
			}
		}
		
		
		//Modelo
		
		DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		
		//Declaracion
		tree = new JTree(modelo);
		tree.setBounds(0, 0, 225, 429);
		tree.getSelectionModel().addTreeSelectionListener(this);
		frame.getContentPane().add(tree);
		
		
		JButton quitar = new JButton("Quitar");
		quitar.setBounds(248, 177, 156, 50);
		frame.getContentPane().add(quitar);
		
		JButton anyadir = new JButton("Añadir");
		
		anyadir.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				VentGestorAnyadir ventanaGestor = new VentGestorAnyadir();
				ventanaGestor.getFrame().setVisible(true);
				frame.setVisible(false);} }
			);
		
		anyadir.setBounds(248, 25, 156, 50);
		frame.getContentPane().add(anyadir);
		
		JButton editar = new JButton("Editar");
		editar.setBounds(248, 99, 156, 50);
		editar.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Evento evSeleccionado = null;
				
				GestorEvento g1 = new GestorEvento();
				for(Evento ev : g1.getArrayEventos()){
					if(seleccionado.equals(ev.getNombre())){
						evSeleccionado = ev;
					}
				}
				VentGestorEditar ventanaGestor = new VentGestorEditar(evSeleccionado);
				ventanaGestor.getFrame().setVisible(true);
				frame.setVisible(false);
				} }
			);
		frame.getContentPane().add(editar);
	}
	public JFrame getFrame(){
		return frame;
	}

	public void valueChanged(TreeSelectionEvent e) {
		
		DefaultMutableTreeNode seleccion=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		
		Object objeto = seleccion.getUserObject();
		seleccionado = objeto.toString();
	}
}
