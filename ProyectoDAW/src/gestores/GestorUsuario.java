package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Gestor;

public class GestorUsuario {

	private JFrame frame;

	/*
	 * String nombre, String apellido, String direccion, String poblacion,
	 * String provincia, String CP, String pais, int puntos, String telefono,
	 * String email, String cliente, String password, String DNI
	 */

	public static Cliente getCliente(String user) throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		Cliente c = null;
		String nombre;
		String apellido;
		String direccion;
		String poblacion;
		String provincia;
		int CP;
		String pais;
		int telefono;
		String email;
		String usuario;
		String password;
		String DNI;

		resultado = conexion
				.getQuery("SELECT * FROM clickntick.clientes WHERE usuario = '"
						+ user + "';");
		while (resultado.next()) {

			nombre = resultado.getString("Nombre");
			apellido = resultado.getString("Apellido");
			direccion = resultado.getString("Direccion");
			poblacion = resultado.getString("Poblacion");
			provincia = resultado.getString("Provincia");
			CP = resultado.getInt("CodPostal");
			pais = resultado.getString("Pais");
			telefono = resultado.getInt("Telefono");
			email = resultado.getString("Email");
			usuario = resultado.getString("Usuario");
			password = resultado.getString("Password");
			DNI = resultado.getString("DNI");

			c = Cliente.getInstance(DNI, usuario, password, nombre, apellido,
					direccion, poblacion, provincia, CP, pais, telefono, email);
		}

		return c;

	}

	private static void getGestor(String user) throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String nombre;
		String usuario;
		String password;
		String DNI;

		resultado = conexion
				.getQuery("SELECT * FROM clickntick.gestores WHERE usuario = '"
						+ user + "';");
		while (resultado.next()) {

			nombre = resultado.getString("Nombre");

			usuario = resultado.getString("Usuario");
			password = resultado.getString("Password");
			DNI = resultado.getString("DNI");

			Gestor.getInstance(DNI, nombre, usuario, password);
		}

	}

	public static void altaUsuario(Cliente cliente) {

		ConexionDB conexion = ConexionDB.getConexionDB();

		boolean existe;
		try {
			existe = comprobarExisteUsuario(cliente);
			// System.out.println(existe);
			if (!existe) {

				conexion.setQuery("INSERT INTO clickntick.clientes VALUES ('"
						+ cliente.getDNI() + "', '" + cliente.getUsuario()
						+ "', '" + cliente.getPassword() + "', "
						+ cliente.getPuntos() + ", '" + cliente.getNombre()
						+ "', '" + cliente.getApellido() + "', "
						+ cliente.getEdad() + " , '" + cliente.getDireccion()
						+ "', '" + cliente.getPoblacion() + "', '"
						+ cliente.getProvincia() + "', '" + cliente.getCP()
						+ "', '" + cliente.getPais() + "', '"
						+ cliente.getTelefono() + "', '" + cliente.getEmail()
						+ "');");

				JOptionPane.showMessageDialog(null,
						"Ha sido registrado con éxito.", "Enhorabuena",
						JOptionPane.INFORMATION_MESSAGE);

			}else{
				
				JOptionPane.showMessageDialog(null, "La cuenta ya existe",
						"ERROR", JOptionPane.WARNING_MESSAGE);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "La cuenta ya existe", "ERROR",
					JOptionPane.WARNING_MESSAGE);
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
			while (resultado.next()) {
				pas = resultado.getString("Password");
			}

			if (pass.equals(pas)) {
				login = true;
				getCliente(usuario);
			}
		}

		return login;

	}

	public static void logOut() {

		Cliente.setInstanceOff();

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
			while (resultado.next()) {
				pas = resultado.getString("Password");
			}

			if (pass.equals(pas)) {
				login = true;
				getGestor(usuario);
			}
		}

		return login;

	}

	private static boolean comprobarExisteUsuario(Cliente cliente)
			throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		// String DNI;
		// ArrayList listaDni = new ArrayList();
		boolean existe = false;

		resultado = conexion
				.getQuery("SELECT usuario FROM clickntick.clientes WHERE usuario = '"
						+ cliente.getUsuario() + "';");
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

	// public static void getCompras(String dni) {
	// // Este metodo devolvera las compras que ha realizado un usuario.
	// ConexionDB conexion = ConexionDB.getConexionDB();
	// ResultSet resultado;
	// resultado = conexion
	// .getQuery("SELECT * FROM clickntick.compras WHERE DNI = '"
	// + dni + "';");
	// }

	// public static void bajaUsuario() {}

}
