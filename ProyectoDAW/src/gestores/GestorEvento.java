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

	public static void bajaEvento(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		conexion.setQuery("DELETE FROM clickntick.eventos where nombreevento = '"
				+ evento.getNombre() + "'");

	}

	public static void buscarEvento(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();
		conexion.getQuery("SELECT * from clickntick.eventos WHERE tipoevento ='"
				+ evento.getTipoEvento() + "'");

	}

	public static void buscarEventoPlus(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		conexion.getQuery("SELECT * from clickntick.eventos WHERE nombreevento ='"
				+ evento.getNombre() + "'");

	}

}
