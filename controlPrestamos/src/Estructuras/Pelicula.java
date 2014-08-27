package Estructuras;

public class Pelicula extends Articulo{
	
	private String director;
	private String categoria;
	
	
	public Pelicula(String nombre, int calificacion, String imagen) {
		super(nombre, calificacion, imagen);
	}
	
	public Pelicula(String nombre, int calificacion, String imagen,
			String director, String categoria) {
		super(nombre, calificacion, imagen);
		this.director = director;
		this.categoria = categoria;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
