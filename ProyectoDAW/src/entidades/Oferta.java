package entidades;

public class Oferta {

	private int IDOferta;
	private int IDEvento;
	private int Puntos;
	private String FechaInicio;
	private String FechaFin;
	private double descuento;

	public Oferta(int IDOferta, int IDEvento, int Puntos, String FechaInicio,
			String FechaFin, double descuento) {

		this.IDOferta = IDOferta;
		this.IDEvento = IDEvento;
		this.Puntos = Puntos;
		this.FechaInicio = FechaInicio;
		this.FechaFin = FechaFin;
		this.descuento = descuento;

	}
	
	public static void getOfertas() {
	}

	public int getIDOferta() {
		return IDOferta;
	}

	public void setIDOferta(int iDOferta) {
		IDOferta = iDOferta;
	}

	public int getIDEvento() {
		return IDEvento;
	}

	public void setIDEvento(int iDEvento) {
		IDEvento = iDEvento;
	}

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

}
