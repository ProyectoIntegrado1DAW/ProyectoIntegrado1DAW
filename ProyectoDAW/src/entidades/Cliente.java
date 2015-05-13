package entidades;

public class Cliente extends Usuario {

	private int puntos;

	public Cliente(String DNI, String usuario, String password, int puntos,
			String nombre, String apellido, String direccion, String poblacion,
			String provincia, String CP, String pais, String telefono,
			String email) {
		
		super(DNI, usuario, password, nombre, apellido, direccion, poblacion, provincia, CP, pais, telefono, email);
		this.puntos = puntos;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
