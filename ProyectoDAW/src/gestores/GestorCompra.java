package gestores;

import java.sql.ResultSet;

import entidades.Cliente;
import entidades.Evento;

public class GestorCompra {

	public static void registrarCompra(Evento ev, Cliente cliente,
			String numTar, String forPago, int numEnt) {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;

		conexion.setQuery("INSERT INTO clickntick.compras (nombreevento, dni, numtarjeta, formapago, numentradas) "
				+ "VALUES ('"
				+ ev.getNombre()
				+ "','"
				+ cliente.getDNI()
				+ "','" + numTar + "','" + forPago + "','" + numEnt + "')");

	}

	public static void getCompras() {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;

	}

}
