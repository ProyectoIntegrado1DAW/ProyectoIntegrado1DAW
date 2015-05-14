package entidades;

public class Evento {
	private String IDEvento;
	private String DNIGestor;
	private String nombre;
	private String tipoEvento;

	private int numEntradas;
	private int entrReservadas;

	private String descripcion;
	private String locales;
	private String ciudad;
	private String Fecha;
	private int precio;
	// private String Fecha;
	private String DiaSemana;
	private String hora;

	public Evento(String IDEvento, String DNIGestor, String nombre,
			String tipoEvento, int numEntradas, int entrReservadas,
			String descripcion, String locales, String ciudad, int precio,
			String fecha, String DiaSemana, String hora) {

		this.IDEvento = IDEvento;
		this.DNIGestor = DNIGestor;
		this.nombre = nombre;
		this.tipoEvento = tipoEvento;
		this.Fecha = fecha;
		this.numEntradas = numEntradas;
		this.entrReservadas = entrReservadas;

		this.descripcion = descripcion;
		this.locales = locales;
		this.ciudad = ciudad;

		this.precio = precio;
		this.DiaSemana = DiaSemana;
		this.hora = hora;
	}

	public String getIDEvento() {
		return IDEvento;
	}

	public void setIDEvento(String iDEvento) {
		IDEvento = iDEvento;
	}

	public String getDNIGestor() {
		return DNIGestor;
	}

	public void setDNIGestor(String dNIGestor) {
		DNIGestor = dNIGestor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public int getEntrReservadas() {
		return entrReservadas;
	}

	public void setEntrReservadas(int entrReservadas) {
		this.entrReservadas = entrReservadas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocales() {
		return locales;
	}

	public void setLocales(String locales) {
		this.locales = locales;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDiaSemana() {
		return DiaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		DiaSemana = diaSemana;
	}

	public String getOra() {
		return hora;
	}

	public void setOra(String ora) {
		this.hora = ora;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

}
