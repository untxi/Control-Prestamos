package Estructuras;

import java.util.ArrayList;

public class Articulo {
	private String nombre;
	private int calificacion;
	private String imagen;
	private int cantidadPrestamos;
	private ArrayList<Integer> fechaPrestamo = new ArrayList<Integer>();
	int meses = 12;
	
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

	public ArrayList<Integer> getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(ArrayList<Integer> fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getCantidadPrestamos() {
		return cantidadPrestamos;
	}

	public void setCantidadPrestamos(int cantidadPrestamos) {
		this.cantidadPrestamos = cantidadPrestamos;
	}
}
