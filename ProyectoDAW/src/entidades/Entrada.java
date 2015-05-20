package entidades;

public class Entrada {

	private int IDentrada;
	//private int IDevento;
	private String DNI;
	private String nombreEvento;
	private String informacion; // evento.toString();
	private String tipoEntrada;
	private float Precio;
	private String datosCliente; // cliente.tostring

	public Entrada(int IDentrada, String DNI,
			String nombreEvento, String informacion, String tipoEntrada,
			float Precio, String datosCliente) {

		this.IDentrada = IDentrada;
		//this.IDevento = IDevento;
		this.DNI = DNI;
		this.nombreEvento = nombreEvento;
		this.informacion = informacion;
		this.tipoEntrada = tipoEntrada;
		this.Precio = Precio;
		this.datosCliente = datosCliente;
	}

	public int getIDentrada() {
		return IDentrada;
	}

	public void setIDentrada(int iDentrada) {
		IDentrada = iDentrada;
	}



	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		Precio = precio;
	}

	public String getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

}