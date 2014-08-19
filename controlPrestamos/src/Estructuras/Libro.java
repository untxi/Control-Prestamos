package Estructuras;

public class Libro extends Articulo {

	private String autor;
	private String editorial;
	private String edicion;
	
	
	public Libro(String titulo,String autor, String editorial, 
			String edicion,int calificacion, String imagen ) {
		
		super(titulo, calificacion, imagen);
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
	}
	
	public Libro(String titulo,int calificacion, String imagen ) {
		super(titulo, calificacion, imagen);
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String geteditorial() {
		return editorial;
	}


	public void seteditorial(String editorial) {
		this.editorial = editorial;
	}


	public String getEdicion() {
		return edicion;
	}


	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	

}
