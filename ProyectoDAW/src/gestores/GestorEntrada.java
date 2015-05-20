package gestores;

import java.io.File;
import java.sql.SQLException;

import javax.xml.transform.TransformerException;

import entidades.Entrada;
import entidades.Evento;
import entidades.Cliente;

public class GestorEntrada {

	public static void reservarEntrada() {
	}

	// public static void compraEntrReg(Evento evento) {}

	public static void compraEntr(Evento evento, Entrada entrada, int numEnt) {

		// llamara a existePlazasDisponibles

		// si quedan entradas, hara la compra y actualizara la base de datos.
		// Restando las entradas compradas a las dispobnibles

		// finalmente imprimira la entrada

	}
	
	public static void generarEntrada(Evento evento, Cliente cliente, int numEnt) {
		
		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		int ultimoID = ev.getEntrReservadas();
		
		for (int i = 0; i < numEnt; i++) {
			// id buscar el num max reservada i a partir de ahi buscar
			
			Entrada e = new Entrada(IDentrada,IDevento,DNI,
					nombreEvento, informacion,tipoEntrada,
					Precio, datosCliente);
			imprimirEntrada(e);
		}
		
		
	}

	public static void imprimirEntrada(Entrada entrada) {
		
		ConversorXML marshaller = new ConversorXML(entrada);

		marshaller.crearDocumento();
		marshaller.crearArbolDOM();

		File file = new File("ticket2.xml");

		try {
			marshaller.escribirDocumentoAXml(file);
		} catch (TransformerException ex) {

		}
		
	}

	public static boolean existePlazasDisponibles(Evento evento, int numEnt)
			throws SQLException {
		// conectar base de datos para ver si existen plazas
		boolean existen = false;

		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		if ((ev.getNumEntradas() - ev.getEntrReservadas()) > numEnt) {
			existen = true;
		}

		return existen;
	}

	public static void actualEntradas(Evento evento, int numEnt) throws SQLException {

		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		ConexionDB conexion = ConexionDB.getConexionDB();
		int i = ev.getEntrReservadas() + numEnt;

		conexion.setQuery("UPDATE clickntick.eventos SET EntradasReservadas = " + i
				+ " WHERE NombreEvento = '" + ev.getNombre() + "';");

	}

}
