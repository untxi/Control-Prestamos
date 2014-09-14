package Estructuras;

import java.util.Date;
/**
 * Clase prestamo
 * 
 * Contiene informacion de lo que se presta
 * 
 * @author Adrián
 *
 */
public class Prestamo
{
	//Atributos
	/**
	 * Nombre de Articulo
	 */
	private Articulo miArticulo;
	/**
	 * Nombre de Persona
	 */
	private Persona miPersona;
	/**
	 * fecha de prestamo
	 */
	private Date miFecha;
	/**
	 * el estado de prestamo
	 */
	private int estadoPrestamo;
	/**
	 * el estado de la categoria
	 */
	private int Categoria;
	
	/**
	 * constructor con tres parametros
	 * @param pMiArticulo
	 * @param pMiPersona
	 * @param pMiFecha
	 */
	public Prestamo(Articulo pMiArticulo, Persona pMiPersona, Date pMiFecha)
	{
		setMiArticulo(pMiArticulo);
		setMiPersona(pMiPersona);
		setMiFecha(pMiFecha);
	}

	/**
	 * el articulo prestado
	 * @return miArticulo
	 */
	public Articulo getMiArticulo() {
		return miArticulo;
	}

	/**
	 * constructor con un parametro
	 * @param miArticulo
	 */
	public void setMiArticulo(Articulo miArticulo) {
		this.miArticulo = miArticulo;
	}

	/**
	 * la persona prestada
	 * @return miPersona
	 */
	public Persona getMiPersona() {
		return miPersona;
	}

	/**
	 * constructor con un parametro
	 * @param miPersona
	 */
	public void setMiPersona(Persona miPersona)
	{
		this.miPersona = miPersona;
	}

	/**
	 * la fecha de préstamo
	 * @return miFecha
	 */
	public Date getMiFecha() {
		return miFecha;
	}

	/**
	 * constructor con un parametro
	 * @param miFecha
	 */
	public void setMiFecha(Date miFecha) {
		this.miFecha = miFecha;
	}

	/**
	 * el estado de préstamo
	 * @return estadoPrestamo
	 */
	public int getEstadoPrestamo() {
		return estadoPrestamo;
	}

	/**
	 * constructor con un parametro
	 * @param estadoPrestamo
	 */
	public void setEstadoPrestamo(int estadoPrestamo) 
	{
		this.estadoPrestamo = estadoPrestamo;
	}

	/**
	 * la categoria prestada
	 * @return Categoria
	 */
	public int getCategoria() {
		return Categoria;
	}

	/**
	 * constructor con una categoria
	 * @param categoria
	 */
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	
}
