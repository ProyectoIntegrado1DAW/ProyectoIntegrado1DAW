package gestores;
import entidades.Evento;
import entidades.Cliente;

public class GestorEntrada {
	
	public static void reservarEntrada(){}
	
	public static void comprarEntrada(Evento evento){
		
		Cliente client = Cliente.getInstance();
		
		
		String info_evento = evento.toString();
		String info_cliente = client.toStringEntrada(client); 
	}
	
	public static void imprimirEntrada(){}

}
