package interfaz;
import entidades.Evento;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class VentGestor {

	private JFrame frame;
	private ArrayList<Evento> eventos = new ArrayList<Evento>();
	private ArrayList<String> tipos = new ArrayList<String>();

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
	
	public void addEvento(Evento ev){
		
		eventos.add(ev);
		
	}
	
	public VentGestor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//PRUEBA
		Evento ev1 = new Evento("Nombre1", "Tipo1", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev2 = new Evento("Nombre2", "Tipo1", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev3 = new Evento("Nombre3", "Tipo2", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev4 = new Evento("Nombre4", "Tipo3", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev5 = new Evento("Nombre5", "Tipo2", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev6 = new Evento("Nombre6", "Tipo3", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev7 = new Evento("Nombre7", "Tipo4", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev8 = new Evento("Nombre8", "Tipo4", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev9 = new Evento("Nombre9", "Tipo5", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		Evento ev0 = new Evento("Nombre0", "Tipo5", "Locales", "Ciudad1", 24, 35, "Descripcion", 20, "Fecha", "Lunes", "Hora");
		
		this.addEvento(ev1);
		this.addEvento(ev2);
		this.addEvento(ev3);
		this.addEvento(ev4);
		this.addEvento(ev5);
		this.addEvento(ev6);
		this.addEvento(ev7);
		this.addEvento(ev8);
		this.addEvento(ev9);
		this.addEvento(ev0);
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JTREE
		
		//Nodos
		
		for(Evento evento_ : eventos){
			if(tipos.contains(evento_.getTipoEvento()) == false){
				tipos.add(evento_.getTipoEvento());
			}
		}
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
		JTree tree = new JTree(modelo);
		tree.setBounds(0, 0, 225, 429);
		frame.getContentPane().add(tree);
	}
}
