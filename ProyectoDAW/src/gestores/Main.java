package gestores;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.TransformerException;

import entidades.Entrada;
import gestores.ConversorXML;
import entidades.Cliente;
import entidades.Evento;

public class Main {

	public static void main(String[] args) throws SQLException {
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String nombres;
		Cliente cliente;

		// resultado = conexion.getQuery("select * from clickntick.clientes");

		/*
		 * while (resultado.next()) { nombres = resultado.getString("nombre");
		 * System.out.println("nombre: " + nombres); }
		 */
		/*Evento evento = new Evento("MuerteMachin",
				"Festival del mal", "Muchos", "Lepe", 666, 0, "Sangre", 20,
				"2016-6-6", "Sabado", "6:06");*/

		/*
		Evento guay = GestorEvento.obtenerEvento("MuerteMachin");
		
		System.out.println(guay.toStringEntrada(guay));

		cliente = Cliente.getInstance("11d", "mmarin", "1234", "Miquel",
				"Marin", "c/ valencia", "Suma", "Valencia", 23445, "Aspa�a",
				8457463, "Shurprim@gmail.com");
		
		GestorUsuario.altaUsuario(cliente);
		//GestorUsuario.logIn("mmarin", "1234");
		*/
		/*
		Entrada e = new Entrada(25,"20666665Y","Vi�acipote","concerto","General", 1000.6f, "Miquel caracrater");

		ConversorXML marshaller = new ConversorXML(e);

		marshaller.crearDocumento();
		marshaller.crearArbolDOM();

		File file = new File("ticket2.xml");

		try {
			marshaller.escribirDocumentoAXml(file);
		} catch (TransformerException ex) {

		}
		*/
		
	}
}