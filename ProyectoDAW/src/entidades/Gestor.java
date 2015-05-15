package entidades;

public class Gestor extends Usuario {

	private static Gestor instance = null;

	private Gestor(String DNI, String nombre, String usuario, String password) {

		super(DNI, nombre, usuario, password);

	}

	public static Gestor getInstance(String DNI, String nombre, String usuario,
			String password) {

		if (instance == null) {

			return instance = new Gestor(DNI, nombre, usuario, password);

		} else {

			return instance;
		}
	}

	public static Gestor getInstance() {
		return instance;
	}

	public static void setInstance() { // cerrar sesion
		instance = null;
	}
}
