package Estructuras;

public class Articulo {
	private String nombre;
	private int calificacion;
	private String imagen;
	
	public Articulo(String nombre, int calificacion, String imagen) {
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
