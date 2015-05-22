package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Oferta;

public class GestorOferta {

	public static Oferta getOferta(String desc) throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		Oferta of = null;
		resultado = conexion
				.getQuery("SELECT * FROM clickntick.ofertas WHERE descripcion = '"
						+ desc + "';");

		if (resultado.next()) {

			int puntos = resultado.getInt("puntos");
			String descripcion = resultado.getString("descripcion");
			float descuento = resultado.getFloat("descuento");

			of = new Oferta(puntos, descripcion, descuento);
		}

		return of;
	}

	public static ResultSet getResultSetOfertas() {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion.getQuery("SELECT * FROM clickntick.ofertas;");

		return rs;
	}

	public static void insertarOferta(Oferta oferta) {

		ConexionDB conexion = ConexionDB.getConexionDB();
		conexion.setQuery("INSERT INTO clickntick.ofertas (puntos, descripcion, descuento) VALUES ('"
				+ oferta.getPuntos()
				+ "','"
				+ oferta.getDescripcion()
				+ "','"
				+ oferta.getDescuento() + "')");
	}

	public static void borrarOferta(String desc) {

		ConexionDB conexion = ConexionDB.getConexionDB();
		conexion.setQuery("DELETE FROM clickntick.ofertas WHERE descripcion = '"
				+ desc + "';");

	}

}
