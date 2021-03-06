package gestores;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

import entidades.Entrada;
import entidades.Evento;
import entidades.Cliente;
import entidades.Oferta;

public class GestorEntrada {

	// compra sin oferta
	public static void compraEntr(String nomEvento, Cliente cliente,
			String numTar, String forPago, int numEnt) throws SQLException {
		Evento evento = GestorEvento.obtenerEvento(nomEvento);
		// llamara a existePlazasDisponibles
		if (existePlazasDisponibles(nomEvento, numEnt)) {

			// si quedan entradas, hara la compra y actualizara la base de
			// datos con las entradas reservadas y los puntos acumulados.
			actualBBDD(cliente, evento, numEnt);

			// finalmente imprimira la entrada
			generarEntrada(evento, cliente, numEnt);

			// registrar la compra
			GestorCompra.registrarCompra(evento, cliente, numTar, forPago,
					numEnt);

			generarHTML(evento, cliente, numEnt);
			
			JOptionPane
			.showMessageDialog(
					null,
					"Se ha generado su HTML con información de la entrada.\n Gracias.",
					"Gracias", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (!existePlazasDisponibles(nomEvento, numEnt)) {

			JOptionPane.showMessageDialog(null,
					"No puede comprar mas entradas, se han agotado.", "ERROR",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	// compra con oferta
	public static void compraEntrOferta(String nomEvento, Cliente cliente,
			String numTar, String forPago, int numEnt, String descOferta)
			throws SQLException {

		Evento evento = GestorEvento.obtenerEvento(nomEvento);
		Oferta oferta = GestorOferta.getOferta(descOferta);

		float descuento = oferta.getDescuento();
		// llamara a existePlazasDisponibles
		if (existePlazasDisponibles(nomEvento, numEnt)) {

			int puntOferta = oferta.getPuntos();

			if (comprobarPuntos(cliente, puntOferta)) {
				// si quedan entradas, hara la compra y actualizara la base de
				// datos con las entradas reservadas y los puntos acumulados.
				actualBBDD(cliente, evento, numEnt);

				// actualizar los datos del usuario con los puntos restantes.
				actualPuntosCliente(numEnt, cliente, puntOferta);

				// finalmente imprimira la entrada
				generarEntradaDesc(evento, cliente, numEnt, descuento);

				// registrar la compra
				GestorCompra.registrarCompra(evento, cliente, numTar, forPago,
						numEnt);

				generarHTML(evento, cliente, numEnt);
				
				JOptionPane
				.showMessageDialog(
						null,
						"Se ha generado su HTML con información de la entrada.\n Gracias.",
						"Gracias", JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"No hay puntos suficientes, se efectuara una compra sin la oferta.\n Gracias.",
								"ERROR", JOptionPane.WARNING_MESSAGE);
				compraEntr(nomEvento, cliente, numTar, forPago, numEnt);

				generarHTML(evento, cliente, numEnt);
			}
		} else if (!existePlazasDisponibles(nomEvento, numEnt)) {

			JOptionPane.showMessageDialog(null,
					"No puede comprar mas entradas, se han agotado.", "ERROR",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	public static void compraEntrNoReg(String nomEvento, Cliente cliente,
			String numTar, String forPago, int numEnt) throws SQLException {

		Evento evento = GestorEvento.obtenerEvento(nomEvento);
		// llamara a existePlazasDisponibles
		if (existePlazasDisponibles(nomEvento, numEnt)) {

			// si quedan entradas, hara la compra y actualizara la base de
			// datos con las entradas reservadas.
			actualBBDDnoReg(cliente, evento, numEnt);

			// Imprimir la entrada
			generarEntradaNoReg(evento, cliente, numEnt);

			generarHTML(evento, cliente, numEnt);
			
			JOptionPane
			.showMessageDialog(
					null,
					"Se ha generado su HTML con información de la entrada.\n Gracias.",
					"Gracias", JOptionPane.INFORMATION_MESSAGE);			

		} else if (!existePlazasDisponibles(nomEvento, numEnt)) {

			JOptionPane.showMessageDialog(null,
					"No puede comprar mas entradas, se han agotado.", "ERROR",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	private static void generarHTML(Evento evento, Cliente cliente, int numEnt) {

		ConversorXML p = new ConversorXML();
		cliente = Cliente.getInstance();

		int i = 0;

		for (i = 1; i <= numEnt; i++) {

			try {
				p.transform(evento.getNombre() + " - " + cliente.getNombre()
						+ " - " + i + ".xml", "ticket.xsl", evento.getNombre()
						+ " - " + cliente.getNombre() + " - " + i + ".html");
			} catch (TransformerException ex) {
				ex.printStackTrace();
			}

			try {
				p.abrir(evento.getNombre() + " - " + cliente.getNombre()
						+ " - " + i + ".html");

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

	}

	public static void generarEntrada(Evento evento, Cliente cliente, int numEnt)
			throws SQLException {

		evento = GestorEvento.obtenerEvento(evento.getNombre());
		cliente = Cliente.getInstance();
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

	// generar entrada para no registrado
	public static void generarEntradaNoReg(Evento evento, Cliente cliente,
			int numEnt) throws SQLException {

		cliente = Cliente.getInstance();
		evento = GestorEvento.obtenerEvento(evento.getNombre());
		int ultimoID = evento.getEntrReservadas() - numEnt;

		for (int i = 1; i <= numEnt; i++) {
			// id buscar el num max reservada e imprimir el num de entradas con
			// el nuevo id

			Entrada e = new Entrada(ultimoID++, evento.getNombre(),
					evento.toStringEntrada(evento), evento.getTipoEvento(),
					evento.getPrecio(), cliente.toStringEntrada(cliente));
			imprimirEntrada(e, cliente, evento, i);
		}

	}

	public static void generarEntradaDesc(Evento evento, Cliente cliente,
			int numEnt, float desc) throws SQLException {

		cliente = Cliente.getInstance();
		evento = GestorEvento.obtenerEvento(evento.getNombre());
		int ultimoID = evento.getEntrReservadas() - numEnt;

		// calcular descuento here
		float precioNew = 0;
		precioNew = evento.getPrecio() - (evento.getPrecio() * (desc / 100));

		for (int i = 1; i <= numEnt; i++) {
			// id buscar el num max reservada e imprimir el num de entradas con
			// el nuevo id

			Entrada e = new Entrada(ultimoID++, cliente.getDNI(),
					evento.getNombre(), evento.toStringEntrada(evento),
					evento.getTipoEvento(), precioNew,
					cliente.toStringEntrada(cliente));
			imprimirEntrada(e, cliente, evento, i);
		}

	}

	private static void imprimirEntrada(Entrada entrada, Cliente cliente,
			Evento evento, int num) {

		ConversorXML marshaller = new ConversorXML(entrada);
		cliente = Cliente.getInstance();

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

	private static boolean existePlazasDisponibles(String nomEvent, int numEnt)
			throws SQLException {
		// conectar base de datos para ver si existen plazas
		Evento ev = GestorEvento.obtenerEvento(nomEvent);
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
		int antPuntos = Cliente.getPuntosBBDD(cl.getDNI());

		nuevPuntos = antPuntos + (numEnt * 5);

		ConexionDB conexion = ConexionDB.getConexionDB();
		int i = ev.getEntrReservadas() + numEnt;

		conexion.setQuery("UPDATE clickntick.eventos SET EntradasReservadas = "
				+ i + " WHERE NombreEvento = '" + ev.getNombre() + "';");

		conexion.setQuery("UPDATE clickntick.clientes SET puntos = "
				+ nuevPuntos + " WHERE Usuario = '" + cl.getUsuario() + "';");

	}

	// actualiza las entradas reservadas en la bbdd para compras no registradas.
	private static void actualBBDDnoReg(Cliente cliente, Evento evento,
			int numEnt) throws SQLException {

		cliente = Cliente.getInstance();
		Evento ev = GestorEvento.obtenerEvento(evento.getNombre());
		ConexionDB conexion = ConexionDB.getConexionDB();
		int i = ev.getEntrReservadas() + numEnt;

		conexion.setQuery("UPDATE clickntick.eventos SET EntradasReservadas = "
				+ i + " WHERE NombreEvento = '" + ev.getNombre() + "';");

	}

	// resta los puntos que ha usado a los que ya habian.
	private static void actualPuntosCliente(int numEnt, Cliente cl,
			int puntOferta) throws SQLException {

		int i = 0;
		ConexionDB conexion = ConexionDB.getConexionDB();
		cl = Cliente.getInstance();
		int antPuntos = Cliente.getPuntosBBDD(cl.getDNI());

		i = antPuntos - puntOferta;
		conexion.setQuery("UPDATE clickntick.clientes SET puntos = " + i
				+ " WHERE Usuario = '" + cl.getUsuario() + "';");

	}

	private static boolean comprobarPuntos(Cliente cliente, int puntOferta)
			throws SQLException {
		ConexionDB conexion = ConexionDB.getConexionDB();
		cliente = Cliente.getInstance();
		ResultSet rs = null;
		boolean aux = false;
		int i = 0;

		rs = conexion
				.getQuery("SELECT puntos FROM clickntick.clientes WHERE Usuario = '"
						+ cliente.getUsuario() + "';");

		if (rs.next()) {
			i = rs.getInt("puntos");
		}

		if (i > puntOferta) {
			aux = true;
		}

		return aux;

	}

}
