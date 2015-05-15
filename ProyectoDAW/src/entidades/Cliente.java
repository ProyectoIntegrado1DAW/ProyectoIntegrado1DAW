package entidades;

public class Cliente extends Usuario {

	private int puntos;

	private static Cliente instance = null;

	private Cliente(String DNI, String usuario, String password, String nombre,
			String apellido, String direccion, String poblacion,
			String provincia, int CP, String pais, int telefono, String email) {

		super(DNI, usuario, password, nombre, apellido, direccion, poblacion,
				provincia, CP, pais, telefono, email);
		this.puntos = 0;
	}

	public static Cliente getInstance(String DNI, String usuario,
			String password, String nombre, String apellido, String direccion,
			String poblacion, String provincia, int CP, String pais,
			int telefono, String email) {
		if (instance == null)
			return instance = new Cliente(DNI, usuario, password, nombre,
					apellido, direccion, poblacion, provincia, CP, pais,
					telefono, email);
		else
			return instance;

	}

	public static Cliente getInstance() {

		return instance;
	}

	public static void setInstance() { // cerrar sesion
		instance = null;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String toStringEntrada(Cliente cliente) {
		String info = "";

		info = info + cliente.getNombre() + " " + cliente.getApellido() + "\n"
				+ cliente.getEmail() + "\n" + cliente.getTelefono();
		;

		return info;
	}
}
