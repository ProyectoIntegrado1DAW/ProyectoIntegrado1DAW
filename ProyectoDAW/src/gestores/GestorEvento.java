package gestores;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Evento;

public class GestorEvento {

	private static ArrayList<Evento> eventos = new ArrayList<Evento>();
	private static ArrayList<String> tipos = new ArrayList<String>();

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

	public static Evento obtenerEvento(String nomEvento) throws SQLException {

		Evento eventos = null;
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;

		String nombre = null;
		String tipoEvento = null;

		int numEntradas = 0;
		int entrReservadas = 0;

		String descripcion = null;
		String locales = null;
		String ciudad = null;
		Date fecha = null;
		int precio = 0;

		String DiaSemana = null;
		String hora = null;

		resultado = conexion
				.getQuery("SELECT * FROM clickntick.eventos WHERE nombreevento = '"
						+ nomEvento + "';");

		while (resultado.next()) {

			nombre = resultado.getString("nombreevento");
			tipoEvento = resultado.getString("tipoevento");
			numEntradas = resultado.getInt("numentradas");
			entrReservadas = resultado.getInt("entradasreservadas");
			descripcion = resultado.getString("descripcion");
			locales = resultado.getString("locales");
			ciudad = resultado.getString("ciudad");
			fecha = resultado.getDate("fecha");
			precio = resultado.getInt("precio");
			DiaSemana = resultado.getString("diasemana");
			hora = resultado.getString("hora");

			eventos = new Evento(nombre, tipoEvento, locales, ciudad,
					numEntradas, entrReservadas, descripcion, precio,
					fecha.toString(), DiaSemana, hora);

		}

		return eventos;

	}

	public static ArrayList getArrayTipo() {

		for (Evento ev : eventos) {
			if (tipos.contains(ev.getTipoEvento()) != true) {

				tipos.add(ev.getTipoEvento());

			}
		}
		return tipos;
	}

	public static ArrayList getArrayEvento() throws SQLException {

		Evento e = null;
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;

		String nombre = null;
		String tipoEvento = null;

		int numEntradas = 0;
		int entrReservadas = 0;

		String descripcion = null;
		String locales = null;
		String ciudad = null;
		Date fecha = null;
		int precio = 0;

		String DiaSemana = null;
		String hora = null;

		resultado = conexion.getQuery("SELECT * FROM clickntick.eventos;");

		while (resultado.next()) {

			nombre = resultado.getString("nombreevento");
			tipoEvento = resultado.getString("tipoevento");
			numEntradas = resultado.getInt("numentradas");
			entrReservadas = resultado.getInt("entradasreservadas");
			descripcion = resultado.getString("descripcion");
			locales = resultado.getString("locales");
			ciudad = resultado.getString("ciudad");
			fecha = resultado.getDate("fecha");
			precio = resultado.getInt("precio");
			DiaSemana = resultado.getString("diasemana");
			hora = resultado.getString("hora");

			e = new Evento(nombre, tipoEvento, locales, ciudad, numEntradas,
					entrReservadas, descripcion, precio, fecha.toString(),
					DiaSemana, hora);

			eventos.add(e);

		}

		return eventos;
	}

	public static void bajaEvento(String string) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		conexion.setQuery("DELETE FROM clickntick.eventos where nombreevento = '"
				+ string + "'");

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

	public static void actualizarEvento(Evento evento) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		conexion.setQuery("UPDATE clickntick.eventos SET nombreevento='"
				+ evento.getNombre() + "', tipoevento='"
				+ evento.getTipoEvento() + "',locales='" + evento.getLocales()
				+ "',ciudad='" + evento.getCiudad() + "',numentradas='"
				+ evento.getNumEntradas() + "',entradasreservadas='"
				+ evento.getEntrReservadas() + "',descripcion='"
				+ evento.getDescripcion() + "',precio='" + evento.getPrecio()
				+ "',fecha='" + evento.getFecha() + "' where nombreevento= '"+evento.getNombre()+"'");

	}

}
