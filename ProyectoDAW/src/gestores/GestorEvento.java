package gestores;

import entidades.Evento;

public class GestorEvento {

	public static void altaEvento(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		// boolean existe = comprobarExisteUsuario(cliente);
		// if( existe = false) {

		conexion.setQuery("INSERT INTO clickntick.eventos (nombreevento, tipoevento, locales, ciudad, numentradas, entradasreservadas, descripcion, precio, fecha, diasemana, hora) VALUES ('"
				+ evento.getNombre()
				+ "','"
				+ evento.getTipoEvento()
				+ "','"
				+ evento.getLocales()
				+ "','"
				+ evento.getCiudad()
				+ "',"
				+ evento.getNumEntradas()
				+ ","
				+ evento.getEntrReservadas()
				+ ",'"
				+ evento.getDescripcion()
				+ "',"
				+ evento.getPrecio()
				+ ",'"
				+ evento.getFecha()
				+ "','"
				+ evento.getDiaSemana()
				+ "','" + evento.getHora() + "')");

		// }

	}

	public static void bajaEvento() {

		ConexionDB conexion = ConexionDB.getConexionDB();

		conexion.setQuery("DELETE FROM clickntick.eventos where ");

	}

	public static void buscarEvento() {

	}

	public static void buscarEventoPlus() {

	}

}
