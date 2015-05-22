package entidades;

public class Oferta {

	private int puntos;
	private String descripcion;
	private float descuento;

	public Oferta(int puntos, String descripcion, float descuento) {

		this.puntos = puntos;
		this.descripcion = descripcion;
		this.descuento = descuento;

	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

}
