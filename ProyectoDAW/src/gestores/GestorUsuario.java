package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Cliente;

public class GestorUsuario {

	/*
	 * String nombre, String apellido, String direccion, String poblacion,
	 * String provincia, String CP, String pais, int puntos, String telefono,
	 * String email, String cliente, String password, String DNI
	 */

	public static void altaUsuario(Cliente cliente) throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();

		boolean existe = comprobarExisteUsuario(cliente);
		if (existe = false) {

			conexion.setQuery("INSERT INTO clickntick.clientes VALUES ('"
					+ cliente.getDNI() + "', '" + cliente.getUsuario() + "', '"
					+ cliente.getPassword() + "', " + cliente.getPuntos()
					+ ", '" + cliente.getNombre() + "', '"
					+ cliente.getApellido() + "', '" + cliente.getDireccion()
					+ "', '" + cliente.getPoblacion() + "', '"
					+ cliente.getProvincia() + "', '" + cliente.getCP()
					+ "', '" + cliente.getPais() + "', '"
					+ cliente.getTelefono() + "', '" + cliente.getEmail()
					+ "');");

		} else {
			System.out.println("YA EXISTE ");
		}

	}

	public static boolean logIn(String usuario, String pass)
			throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		boolean login = false;
		String pas = "";
		resultado = conexion
				.getQuery("SELECT Password FROM clickntick.clientes WHERE usuario = '"
						+ usuario + "'");

		if (resultado != null) {
			System.out.println("Encuentra el usuario siii");
			while (resultado.next()){
				pas = resultado.getString("Password");
			}
			
			if (pass.equals(pas)) {
				login = true;
				System.out.println("Logeado siii");
			}
		}

		return login;

	}

	public static boolean logInGestor(String usuario, String pass)
			throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		boolean login = false;
		String pas = "";
		resultado = conexion
				.getQuery("SELECT Password FROM clickntick.gestores WHERE usuario = '"
						+ usuario + "'");

		if (resultado != null) {
			System.out.println("Encuentra el usuario siii");
			while (resultado.next()){
				pas = resultado.getString("Password");
			}
			
			if (pass.equals(pas)) {
				login = true;
				System.out.println("Logeado siii");
			}
		}

		return login;

	}
	
	private static boolean comprobarExisteUsuario(Cliente cliente)
			throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String DNI;
		ArrayList listaDni = new ArrayList();
		boolean existe = false;

		resultado = conexion
				.getQuery("SELECT DNI FROM clickntick.clientes WHERE DNI = '"
						+ cliente.getDNI()+"';");
		if (resultado.next()) {
			existe = true;
		}

		/*
		 * while (resultado.next()) { DNI = resultado.getString("DNI");
		 * listaDni.add(DNI); }
		 * 
		 * 
		 * 
		 * int i = 0; while(resultado.next() && !existe) {
		 * 
		 * if (listaDni.get(i).equals(cliente.getDNI())) { existe = true; } }
		 */

		return existe;
	}

	// public static void comprobarExisteGestor() {}
	// public static void bajaUsuario() {}

}
