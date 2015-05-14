package gestores;

public class GestorEvento {
	
	public static void altaEvento(){
		
		ConexionDB conexion = ConexionDB.getConexionDB();

		//boolean existe = comprobarExisteUsuario(cliente);
		//if( existe  = false) {
	
		conexion.setQuery("INSERT INTO clickntick.eventos VALUES ('','')");
		
		
		//}
		
	}
	
	public static void bajaEvento(){
		
		
		
	}
	public static void buscarEvento(){
		
		
		
		
	}
	public static void buscarEventoPlus(){
		
		
		
	}

}
