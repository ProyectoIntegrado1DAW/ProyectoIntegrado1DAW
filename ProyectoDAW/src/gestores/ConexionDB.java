package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private String _usuario = "postgres";
	private String _pwd = "123";
	private static String _bd = "clickntick";
	static String _url = "jdbc:postgresql://localhost:5433/" + _bd;
	private Connection conn = null;
	// modo singleton
	private static ConexionDB instance = null; 

	
	private ConexionDB() {

		try {
			Class.forName("org.postgresql.Driver");
			conn = (Connection) DriverManager.getConnection(_url, _usuario,
					_pwd);
			
		} catch (SQLException ex) {
			System.out
					.println("Hubo un problema al intentar conecarse a la base de datos"
							+ _url);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public static ConexionDB getConexionDB() {
		
		if (instance == null) {
			instance = new ConexionDB();
		} 
		
		return instance;
	}
	
	public Connection getConnection(){
		
		return conn;
	}
	// fin modo singleton

	public ResultSet getQuery(String _query) {
		Statement state = null;
		ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public void setQuery(String _query) {

		Statement state = null;

		try {
			state = (Statement) conn.createStatement();
			state.execute(_query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}