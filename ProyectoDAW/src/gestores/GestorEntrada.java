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

	public static void compraEntr(String nomEvento, Cliente cliente, int numEnt)
			throws SQLException {
		Evento evento = GestorEvento.obtenerEvento(nomEvento);
		// llamara a existePlazasDisponibles
		if (existePlazasDisponibles(evento, numEnt)) {

			// si quedan entradas, hara la compra y actualizara la base de
			// datos con las entradas reservadas y los puntos acumulados.
			actualBBDD(cliente, evento, numEnt);

			// actualizar el precio si hay ofertas? if cliente.puntos > 5
			// (oferta min), pero solo si quiere el cliente? ... y la oferta que
			// quiera
			// actualizar los datos del usuario con los puntos restantes.

			// finalmente imprimira la entrada
			generarEntrada(evento, cliente, numEnt);

			// registrar la compra (con el precio actualizado si hay oferta)

		}

	}

	public static void generarEntrada(Evento evento, Cliente cliente, int numEnt)
			throws SQLException {

		evento = GestorEvento.obtenerEvento(evento.getNombre());
		int ultimoID = evento.getEntrReservadas() - numEnt;

		for (int i = 1; i <= numEnt; i++) {
			// id buscar el num max reservada e imprimir el num de entradas con
			// el nuevo id

			Entrada e = new Entrada(ultimoID++, cliente.getDNI(),
					evento.getNombre(), evento.toStringEntrada(evento),
					evento.getTipoEvento(), evento.getPrecio(),
					cliente.toStringEntrada(cliente));
			imprimirEntrada(e, cliente, evento, i);
		}

	}

	private static void imprimirEntrada(Entrada entrada, Cliente cliente,
			Evento evento, int num) {

		ConversorXML marshaller = new ConversorXML(entrada);

		marshaller.crearDocumento();
		marshaller.crearArbolDOM();

		String nomCliente = cliente.getNombre();
		String nomEvento = evento.getNombre();

		File file = new File(nomEvento + " - " + nomCliente + " - " + num
				+ ".xml");

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

	private static void actualBBDD(Cliente cliente, Evento evento, int numEnt)
			throws SQLException {

		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		Cliente cl = Cliente.getInstance();
		int nuevPuntos = 0;
		int antPuntos = cl.getPuntos(); // no suma bien los puntos.
		
		nuevPuntos = antPuntos + (numEnt * 5);

		ConexionDB conexion = ConexionDB.getConexionDB();
		int i = ev.getEntrReservadas() + numEnt;

		conexion.setQuery("UPDATE clickntick.eventos SET EntradasReservadas = "
				+ i + " WHERE NombreEvento = '" + ev.getNombre() + "';");

		conexion.setQuery("UPDATE clickntick.clientes SET Puntos = "
				+ nuevPuntos + " WHERE Usuario = '" + cl.getUsuario()
				+ "';");

	}

	// restara los puntos que ha usado a los que ya habian.
	private static void actualPuntosCliente(int numEnt, Cliente cl) {

		int i = 0;
		ConexionDB conexion = ConexionDB.getConexionDB();
		cl = Cliente.getInstance();
		int antPuntos = cl.getPuntos();

		i = antPuntos - (numEnt * 5);
		conexion.setQuery("UPDATE clickntick.clientes SET Puntos = " + i
				+ " WHERE Usuario = '" + cl.getUsuario() + "';");

	}

	private static void registrarCompra() {
	}

	public static void getOfertas() {
	}

	public static void actualizarPrecio() {
	}

}
