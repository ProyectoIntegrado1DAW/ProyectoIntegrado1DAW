package gestores;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;
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

	public static ResultSet getResultSetComprasClientes(String DNI) {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet rs = conexion
				.getQuery("SELECT * FROM clickntick.compras WHERE dni = '"+DNI+"'");

		
		return rs;
	}

}
