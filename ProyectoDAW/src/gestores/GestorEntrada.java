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

	public static void compraEntr(String nomEvento, Cliente cliente, int numEnt) throws SQLException {
		Evento evento = GestorEvento.obtenerEvento(nomEvento);
		// llamara a existePlazasDisponibles
		if (existePlazasDisponibles(evento, numEnt)) {
			
			// si quedan entradas, hara la compra y actualizara la base de
			// datos.
			actualEntradas(evento, numEnt);

			// finalmente imprimira la entrada
			generarEntrada(evento, cliente, numEnt);

		}

	}

	public static void generarEntrada(Evento evento, Cliente cliente, int numEnt)
			throws SQLException {

		evento = GestorEvento.obtenerEvento(evento.getNombre());
		int ultimoID = evento.getEntrReservadas();
		int numEntrImpr = ultimoID - numEnt;

		for (int i = numEntrImpr; i <= ultimoID; i++) {
			// id buscar el num max reservada e imprimir el num de entradas con
			// el nuevo id

			Entrada e = new Entrada(numEntrImpr, cliente.getDNI(),
					evento.getNombre(), evento.toStringEntrada(evento),
					evento.getTipoEvento(), evento.getPrecio(),
					cliente.toStringEntrada(cliente));
			imprimirEntrada(e, cliente, evento);
		}

	}

	private static void imprimirEntrada(Entrada entrada, Cliente cliente, Evento evento) {

		ConversorXML marshaller = new ConversorXML(entrada);

		marshaller.crearDocumento();
		marshaller.crearArbolDOM();
		
		String nomCliente = cliente.getNombre();
		String nomEvento = evento.getNombre();

		File file = new File(nomEvento+" - "+nomCliente+".xml");

		try {
			marshaller.escribirDocumentoAXml(file);
		} catch (TransformerException ex) {

		}

	}

	private static boolean existePlazasDisponibles(Evento ev, int numEnt)
			throws SQLException {
		// conectar base de datos para ver si existen plazas
		boolean existen = false;

		if ((ev.getNumEntradas() - ev.getEntrReservadas()) > numEnt) {
			existen = true;
		}

		return existen;
	}

	private static void actualEntradas(Evento evento, int numEnt)
			throws SQLException {

		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		ConexionDB conexion = ConexionDB.getConexionDB();
		int i = ev.getEntrReservadas() + numEnt;

		conexion.setQuery("UPDATE clickntick.eventos SET EntradasReservadas = "
				+ i + " WHERE NombreEvento = '" + ev.getNombre() + "';");

	}

}
