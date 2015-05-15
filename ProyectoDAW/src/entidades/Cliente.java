package entidades;

public class Cliente extends Usuario {

	private int puntos;

	public Cliente(String DNI, String usuario, String password, String nombre,
			String apellido, String direccion, String poblacion,
			String provincia, int CP, String pais, int telefono,
			String email) {

		super(DNI, usuario, password, nombre, apellido, direccion, poblacion,
				provincia, CP, pais, telefono, email);
		this.puntos = 0;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
