package gestores;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import entidades.Entrada;
import gestores.ConversorXML;
import entidades.Cliente;
import entidades.Evento;
import entidades.Oferta;


public class Main {

	public static void main(String[] args) throws SQLException {
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String nombres;
		Cliente cliente;
		Cliente cliente2;
		String datosXML = "ticket.xml";
		String entradaXSL = "ticket.xsl";
		String salidaHTML = "ticket.html";
		
		// resultado = conexion.getQuery("select * from clickntick.clientes");

		/*
		 * while (resultado.next()) { nombres = resultado.getString("nombre");
		 * System.out.println("nombre: " + nombres); }
		 */
		Evento evento = new Evento("MuerteMachin",
				"Festival del mal", "Muchos", "Lepe", 666, 0, "Sangre", 20,
				"2016-6-6", "Sabado", "6:06");

		/*
		Evento guay = GestorEvento.obtenerEvento("MuerteMachin");
		
		System.out.println(guay.toStringEntrada(guay));

		cliente = Cliente.getInstance("11d", "mmarin", "1234", "Miquel",
				"Marin", "c/ valencia", "Suma", "Valencia", 23445, "Aspaña",
				8457463, "Shurprim@gmail.com");
		
		GestorUsuario.altaUsuario(cliente);
		//GestorUsuario.logIn("mmarin", "1234");
		*/
		
		Entrada e = new Entrada(25,"20666665Y","TICKETS",evento.toStringEntrada(evento),"General", 1000.6f, "Miquel");

		ConversorXML marshaller = new ConversorXML(e);

		marshaller.crearDocumento();
		marshaller.crearArbolDOM();

		File file = new File("ticket.xml");

		try {
			marshaller.escribirDocumentoAXml(file);
		} catch (TransformerException ex) {

		}
		

		ConversorXML p = new ConversorXML(e);

		try {
			p.transform(datosXML, entradaXSL, salidaHTML);
		} catch (TransformerException ex) {
			ex.printStackTrace();
		}
		
		
		try {
			p.abrir(salidaHTML);
		} catch (IOException ex) {			
			ex.printStackTrace();
		}
		
	
	//cliente = Cliente.getInstance("11d", "mmarin", "1234", "Miquel", "Marin", "c/ valencia", "Suma", "Valencia", 23445, "Aspaña", 8457463, "Shurprim@gmail.com");
		//GestorUsuario.altaUsuario(cliente);
		
		
		/*cliente2 = Cliente.getInstance("122d", "hejuso", "1234", "hector", "Juan", "c/ alzira", "Alzira", "Valencia", 33445, "Aspaña", 8463, "prim@gmail.com");
		 GestorUsuario.altaUsuario(cliente2);*/
		
//		Evento evento2 = new Evento("Unodostres",
//				"Festival del mal", "Muchos", "Lepe", 666, 0, "Sangre", 20,
//				"2016-6-6", "Sabado", "6:06");
//		GestorEvento.altaEvento(evento2);
//		
//		GestorEntrada.compraEntr("Unodostres", cliente2,"2334-2222-3423-43434"," VISA",  1);
//		GestorEntrada.compraEntrNoReg("Unodostres", cliente, 1);
//		Oferta oferta = new Oferta(1, "Descuento chachi", 10);
		//GestorOferta.insertarOferta(oferta);
		
//		GestorEntrada.compraEntrOferta("Unodostres", cliente2, "2334-2222-3423-43434"," VISA", 1, "Descuento chachi");
	}
}