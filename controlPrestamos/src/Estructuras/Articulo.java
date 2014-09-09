package Estructuras;

public class Articulo {
	private String nombre;
	private int calificacion;
	private String imagen;
	private int cantPrestamos = 0;
	private boolean prestado = false;
	private int[] cantPrestamosXMes = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	public Articulo(String nombre, int calificacion, String imagen) 
	{
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

	public int getCantPrestamos() {
		return cantPrestamos;
	}

	public void setCantPrestamos(int cantPrestamos) 
	{
		this.cantPrestamos = cantPrestamos;
		
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public int getCantPrestamosXMes(int pMes) 
	{
		return cantPrestamosXMes[pMes];
	}

	public void setCantPrestamosXMes(int pMes) {
		this.cantPrestamosXMes[pMes] = this.cantPrestamosXMes[pMes]+1;
	}
	
}
