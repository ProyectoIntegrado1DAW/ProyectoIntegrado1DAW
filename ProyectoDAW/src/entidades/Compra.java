package entidades;

public class Compra {

	int IDcompra;
	String DNI;
	String numTarjeta;
	String formaPago;
	int numEntradas;

	public Compra(int IDcompra, String DNI, String numTarjeta,
			String formaPago, int numEntradas) {
		
		this.IDcompra = IDcompra;
		this.DNI = DNI;
		this.numTarjeta = numTarjeta;
		this.formaPago = formaPago;
		this.numEntradas = numEntradas;

	}

	public int getIDcompra() {
		return IDcompra;
	}

	public void setIDcompra(int iDcompra) {
		IDcompra = iDcompra;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

}
