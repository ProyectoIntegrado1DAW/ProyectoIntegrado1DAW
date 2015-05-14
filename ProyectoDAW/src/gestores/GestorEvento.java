package gestores;

import entidades.Evento;

public class GestorEvento {

	public static void altaEvento(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		// boolean existe = comprobarExisteUsuario(cliente);
		// if( existe = false) {

		conexion.setQuery("INSERT INTO clickntick.eventos VALUES ("
				+ evento.getIDEvento() + ",'" + evento.getDNIGestor() + "','"
				+ evento.getNombre() + "','" + evento.getTipoEvento() + "','"
				+ evento.getLocales() + "','" + evento.getCiudad() + "',"
				+ evento.getNumEntradas() + "," + evento.getEntrReservadas()
				+ ",'" + evento.getDescripcion() + "'," + evento.getPrecio()
				+ "," + evento.getFecha() + ",'" + evento.getDiaSemana()
				+ "','" + evento.getHora() + "')");

		// }

	}

	public static void bajaEvento() {

	}

	public static void buscarEvento() {

	}

	public static void buscarEventoPlus() {

	}

}
