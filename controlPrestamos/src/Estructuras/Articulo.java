package Estructuras;
/**
 * clase Articulo
 * 
 * contiene informacion acerca del articulo
 * 
 * @author Adrián
 *
 */
public class Articulo {
	//Atributos
	/**
	 * nombre del articulo
	 */
	private String nombre;
	/**
	 * calificación del articulo
	 */
	private int calificacion;
	/**
	 * imagen del articulo
	 */
	private String imagen;
	/**
	 * veces prestado del articulo
	 */
	private int cantPrestamos = 0;
	/**
	 * articulo prestado (true or false)
	 */
	private boolean prestado = false;
	/**
	 * Cantidad de veces prestado
	 */
	private int[] cantPrestamosXMes = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	/**
	 * contrucctor con tres parametros
	 * @param nombre
	 * @param calificacion
	 * @param imagen
	 */
	public Articulo(String nombre, int calificacion, String imagen) 
	{
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.imagen = imagen;
	}
	/**
	 * nombre del articulo
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * constructor con un parametro
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * calificacion del articulo
	 * @return calificacion
	 */
	public int getCalificacion() {
		return calificacion;
	}
	/**
	 * constructor con un parametro
	 * @param calificacion
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	/**
	 * imagen del articulo
	 * @return imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * constructor con un parametro
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * cantidad de veces prestado
	 * @return cantPrestamos
	 */
	public int getCantPrestamos() {
		return cantPrestamos;
	}
	/**
	 * constructor con un parametro
	 * @param cantPrestamos
	 */
	public void setCantPrestamos(int cantPrestamos) 
	{
		this.cantPrestamos = cantPrestamos;		
	}
	/**
	 * ¿está prestado?
	 * @return prestado
	 */
	public boolean isPrestado() {
		return prestado;
	}
	/**
	 * constructor con un parametro
	 * @param prestado
	 */
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	/**
	 * cantidad de veces prestado por mes
	 * @param pMes
	 * @return cantPrestamosXMes
	 */
	public int getCantPrestamosXMes(int pMes) 
	{
		return cantPrestamosXMes[pMes];
	}
	/**
	 * constructor con un parametro
	 * @param pMes
	 */
	public void setCantPrestamosXMes(int pMes) 
	{
		this.cantPrestamosXMes[pMes] = this.cantPrestamosXMes[pMes]+1;
	}
	
	public int getCantPresAcumuladosEnRangoMeses(int pDesde,int pHasta)
	{
		int Acumulado = 0;
		for(int i = pDesde;i <= pHasta;i++)
		{
			Acumulado += cantPrestamosXMes[i];
		}
		return Acumulado;
	}
	
}
