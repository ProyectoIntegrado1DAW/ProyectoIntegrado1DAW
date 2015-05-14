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

		//resultado = conexion.getQuery("select * from clickntick.clientes");

		/*
		 * while (resultado.next()) { nombres =
		 * resultado.getString("nombre"); System.out.println("nombre: " +
		 * nombres); }
		 */
		Evento evento = new Evento(1,"23452D","MuerteMachin", "Festival del mal", "Muchos", "Lepe",666, 0, "Sangre", 20, "2016-6-6","Sabado","6:06");

		GestorEvento.altaEvento(evento);
	}
}