package Estructuras;

import java.util.Date;

public class Prestamo
{
	private Articulo miArticulo;
	private Persona miPersona;
	private Date miFecha;
	private int estadoPrestamo;
	private int Categoria;
	
	
	public Prestamo(Articulo pMiArticulo, Persona pMiPersona, Date pMiFecha)
	{
		setMiArticulo(pMiArticulo);
		setMiPersona(pMiPersona);
		setMiFecha(pMiFecha);
	}


	public Articulo getMiArticulo() {
		return miArticulo;
	}


	public void setMiArticulo(Articulo miArticulo) {
		this.miArticulo = miArticulo;
	}


	public Persona getMiPersona() {
		return miPersona;
	}


	public void setMiPersona(Persona miPersona)
	{
		this.miPersona = miPersona;
	}


	public Date getMiFecha() {
		return miFecha;
	}


	public void setMiFecha(Date miFecha) {
		this.miFecha = miFecha;
	}


	public int getEstadoPrestamo() {
		return estadoPrestamo;
	}


	public void setEstadoPrestamo(int estadoPrestamo) 
	{
		this.estadoPrestamo = estadoPrestamo;
	}


	public int getCategoria() {
		return Categoria;
	}


	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	
}
