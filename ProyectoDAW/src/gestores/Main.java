package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cliente;
import entidades.Evento;

public class Main {

	public static void main(String[] args) throws SQLException {
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String nombres;

		// resultado = conexion.getQuery("select * from clickntick.clientes");

		/*
		 * while (resultado.next()) { nombres = resultado.getString("nombre");
		 * System.out.println("nombre: " + nombres); }
		 */
		Evento evento = new Evento("MuerteMachin",
				"Festival del mal", "Muchos", "Lepe", 666, 0, "Sangre", 20,
				"2016-6-6", "Sabado", "6:06");

		GestorEvento.altaEvento(evento);

		/*Cliente cliente = new Cliente("11d", "mmarin", "1234", "Miquel",
				"Marin", "c/ valencia", "Suma", "Valencia", 23445, "Aspaña",
				8457463, "Shurprim@gmail.com");*/
		//GestorUsuario.altaUsuario(cliente);
		//GestorUsuario.logIn("mmarin", "1234");
	}
}