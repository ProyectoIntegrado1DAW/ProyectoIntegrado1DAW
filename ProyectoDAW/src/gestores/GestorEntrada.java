package gestores;
import entidades.Evento;
import entidades.Cliente;

public class GestorEntrada {
	
	public static void reservarEntrada(){}
	
	public static void compraEntrReg(Evento evento){
		
		Cliente client = Cliente.getInstance();
		
		}
	
	
	public static void compraEntr(Evento evento, Cliente cliente){
		
		// llamara a existePlazasDisponibles
		
		// si quedan entradas, hara la compra y actualizara la base de datos.
		// Restando las entradas compradas a las dispobnibles
		
		// finalmente imprimira la entrada
	
		}
	
	public static void imprimirEntrada(Evento evento, Cliente cliente){}
	
	public static boolean existePlazasDisponibles(Evento evento){
		//conectar base de datos para ver si existen plazas
		boolean existen = false;
		
		
		return existen;
	}
	
	public static void actualEntradas(Evento evento){
		// actualizar los datos de la base de datos, restar numero de entradas a disponibles.
	}
	

}
