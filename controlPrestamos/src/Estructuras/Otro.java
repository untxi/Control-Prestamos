package Estructuras;

public class Otro extends Articulo {
	private String descripcion;

	public Otro(String nombre, int calificacion, String imagen,
			String descripcion) {
		super(nombre, calificacion, imagen);
		this.descripcion = descripcion;
	}
	
	public Otro(String nombre, int calificacion, String imagen) {
		super(nombre, calificacion, imagen);
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
