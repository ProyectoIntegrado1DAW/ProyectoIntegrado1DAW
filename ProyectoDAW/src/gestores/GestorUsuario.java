package gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Usuario;
public class GestorUsuario {

	/*String nombre, String apellido,
	String direccion, String poblacion, String provincia, String CP,
	String pais, int puntos, String telefono, String email,
	String usuario, String password, String DNI*/
	
	public static void altaUsuario(Usuario usuario) throws SQLException {

		ConexionDB conexion = ConexionDB.getConexionDB();

		boolean existe = comprobarExisteUsuario(usuario);
		if( existe  = false) {
		
		conexion.setQuery("INSERT INTO clickntick.clientes VALUES (" + usuario.getDNI()
				+ ", " + usuario.getUsuario() + ", " + usuario.getPassword() + ", " + usuario.getPuntos() + ", "
				+ usuario.getNombre() + ", " + usuario.getApellido() + ", " + usuario.getDireccion() + ", "
				+ usuario.getPoblacion() + ", " + usuario.getProvincia() + ", " + usuario.getCP() + ", " + usuario.getPais() + ", "
				+ usuario.getTelefono() + ", " + usuario.getEmail());
		
		}

	}

	public static void bajaUsuario() {
	}

	public static boolean comprobarExisteUsuario(Usuario usuario) throws SQLException {
		
		ConexionDB conexion = ConexionDB.getConexionDB();
		ResultSet resultado;
		String DNI;
		ArrayList listaDni = new ArrayList();
		
		resultado = conexion.getQuery("SELECT DNI FROM clickntick.clientes");
		
		
		 while (resultado.next()) {  
			DNI = resultado.getString("DNI");
			listaDni.add(DNI);
		    }
		 
		 
		 boolean existe = false;
		 int i = 0;
		 while(resultado.next() && !existe) {
			 
			 if (listaDni.get(i).equals(usuario.getDNI())) {
				 existe = true;
			 }
		 }
		 
		 
		 return existe;
	}

	public static void comprobarExisteGestor() {
	}

}
