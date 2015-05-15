package entidades;

public class Entrada {

	private int IDentrada;
	private int IDevento;
	private String DNI;
	private String nombreEvento;
	private String informacion; // evento.toString();
	private String tipoEntrada;
	private double Precio;
	private String datosCliente; // cliente.tostring
	
	
	public int getIDentrada() {
		return IDentrada;
	}
	public void setIDentrada(int iDentrada) {
		IDentrada = iDentrada;
	}
	public int getIDevento() {
		return IDevento;
	}
	public void setIDevento(int iDevento) {
		IDevento = iDevento;
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
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

}
