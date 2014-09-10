package Estructuras;
/**
 * Clase Otro
 * Crea un artículo de cualquier categoría
 * 
 * @author Samantha Arburola
 */

public class Otro extends Articulo {
	// Atributos
	/**
	 * Descripción del estado ó características del artículo
	 */
	private String descripcion;
	// Métodos
	/**
	 * Constructor
	 * @param nombre       : nombre el artículo
	 * @param calificacion : calificación para el artículo
	 * @param imagen       : imagen para identificar el artículo
	 * @param descripcion  : Descripción del estado ó características del artículo
	 */
	public Otro(String nombre, int calificacion, String imagen,
			String descripcion) {
		super(nombre, calificacion, imagen);
		this.descripcion = descripcion;
	}
	/**
	 * Artículo otro
	 * @param nombre       : nombre el artículo
	 * @param calificacion : alificación para el artículo
	 * @param imagen       : imagen para identificar el artículo
	 */
	public Otro(String nombre, int calificacion, String imagen) {
		super(nombre, calificacion, imagen);
	}
	/**
	 * Get la descripción del artículo
	 * @return string con la descripción
	 */
	public String getDescripcion() {return descripcion;}
	/**
	 * Set de la descripcción
	 * @param descripcion recibe una descripción para el artículo
	 */
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;	}
	
}
