package entidades;

public class Usuario {

	private String nombre;
	private String apellido;
	private String direccion;
	private String poblacion;
	private String provincia;
	private int CP;
	private String pais;
	private int telefono;
	private String email;
	private String usuario;
	private String password;
	private String DNI;
	

	public Usuario() {
	}
	
	
	// usuario gestor
	public Usuario(String DNI, String nombre, String usuario, String password) {
		
		this.DNI = DNI;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
		
	}

	public Usuario(String DNI, String usuario, String password,
			String nombre, String apellido, String direccion, String poblacion,
			String provincia, int CP, String pais, int telefono,
			String email) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.CP = CP;
		this.pais = pais;
		this.telefono = telefono;
		this.email = email;
		this.setUsuario(usuario);
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

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
