package Estructuras;


public class Categoria {
	
	private String categoria;
	private listaArticulos Articulos;
	
	
	public Categoria(String nombreCategoria) {
		super();
		this.categoria = nombreCategoria;
		Articulos = new listaArticulos();
	}


	public String getnombreCategoria() {
		return categoria;
	}


	public void setnombreCategoria(String pCategoria) {
		this.categoria = pCategoria;
	}


	public listaArticulos getArticulos() {
		return Articulos;
	}


	public void setArticulos(listaArticulos articulos) {
		Articulos = articulos;
	}
	
	
}
