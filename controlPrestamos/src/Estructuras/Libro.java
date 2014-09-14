package Estructuras;
/**
 * clase libro
 * 
 * contiene informacion acerca del libro
 * 
 * @author Marco
 *
 */
public class Libro extends Articulo {
	//Atributos
	/**
	 * nombre del autor
	 */
	private String autor;
	/**
	 * nombre de la editorial
	 */
	private String editorial;
	/**
	 * nombre de la edicion
	 */
	private String edicion;
	
	/**
	 * constructor con seis parametros
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param edicion
	 * @param calificacion
	 * @param imagen
	 */
	public Libro(String titulo,String autor, String editorial, 
			String edicion,int calificacion, String imagen ) {
		
		super(titulo, calificacion, imagen);
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
	}
	/**
	 * constructor con tres parametros
	 * @param titulo
	 * @param calificacion
	 * @param imagen
	 */
	public Libro(String titulo,int calificacion, String imagen ) {
		super(titulo, calificacion, imagen);
	}

	/**
	 *Nombre del autor 
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * constructor con un parametro
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * nombre de la editorial 
	 * @return editorial
	 */
	public String geteditorial() {
		return editorial;
	}

	/**
	 * constructor con un parametro
	 * @param editorial
	 */
	public void seteditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * edicion
	 * @return edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * constructor con un parametro
	 * @param edicion
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	

}
