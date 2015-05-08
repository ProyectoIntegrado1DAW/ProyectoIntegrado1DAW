package entidades;

public class Usuario {

	private String nombre;
	private String apellido;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String CP;
	private String pais;
	private String telefono;
	private String email;
	private String password;
	private String DNI;

	public Usuario(){}
	
	public Usuario(String nombre, String apellido, String direccion,
			String poblacion, String provincia, String CP, String pais,
			String telefono, String email, String password, String DNI) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.poblacion=poblacion;
		this.provincia = provincia;
		this.CP = CP;
		this.pais = pais;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.DNI = DNI;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
