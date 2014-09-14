package Estructuras;
/**
 * Clase pelicula
 * 
 * contiene informacion de pelicula
 * 
 * @author Marco
 *
 */
public class Pelicula extends Articulo{
	//Atributos
	/**
	 * nombre del director
	 */
	private String director;
	/**
	 * nombre de la categoria
	 */
	private String categoria;
	
	/**
	 * constructor con tres parametros
	 * @param nombre
	 * @param calificacion
	 * @param imagen
	 */
	public Pelicula(String nombre, int calificacion, String imagen) {
		super(nombre, calificacion, imagen);
	}
	/**
	 * constructor con cinco parametros
	 * @param nombre
	 * @param calificacion
	 * @param imagen
	 * @param director
	 * @param categoria
	 */
	public Pelicula(String nombre, int calificacion, String imagen,
			String director, String categoria) {
		super(nombre, calificacion, imagen);
		this.director = director;
		this.categoria = categoria;
	}
	/**
	 * nombre del director
	 * @return director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * constructor con un parametro
	 * @param director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * nombre de la categoria
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * constructor con un parametro
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
