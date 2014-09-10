package Estructuras;
/**
 * Clase Persona
 * Crea una persona 
 * 
 * @author Adrian Soto
 *
 */
public class Persona 
{
	// Atributos
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	/**
	 * Primer apellido de la persona
	 */
	private String apellido1;
	/**
	 * Segundo Apellido de la persona
	 */
	private String apellido2;
	/**
	 * Número de cédula de la persona
	 */
	private String cedula;
	/**
	 * Número de teléfono móvil/fijo de la persona
	 */
	private String telefono;
	/**
	 * Dirección de correo electrónico
	 */
	private String correoE;
	/**
	 * Categoría de la persona
	 */
	private int categoria;
	
	// Métodos
	/**
	 * Contructor de la persona
	 * @param pNombre    : nobmre
	 * @param pApellido1 : 1er apellido
	 * @param pApellido2 : 2do apellido
	 * @param pCedula    :  número de cédula
	 * @param pTelefono  :  número de teléfono
	 * @param pCorreoE   : dirección de correo electrónico
	 * @param pCategoria : categoría de la persona
	 */
	public Persona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		super();
		this.setNombre(pNombre);;
		this.setApellido1(pApellido1);
		this.setApellido2(pApellido2);
		this.setCedula(pCedula);
		this.setTelefono(pTelefono);
		this.setCorreoE(pCorreoE);
		this.setCategoria(pCategoria);
	}

	/**
	 * 
	 * @param nombre
	 */
	public Persona(String nombre) 
	{
		super();
		this.nombre = nombre;
	}
	/**
	 * Get nombre
	 * @return retorna el nombre
	 */
	public String getNombre() 
	{
		return nombre;	
	}
	/**
	 * Set Nombre
	 * @param nombre recibe el nombre
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	/**
	 * Get Apellido 1
	 * @return retorna el primer el apellido
	 */
	public String getApellido1() 
	{
		return apellido1;
	}
	/**
	 * Get Apellido 1
	 * @param apellido1 recibe el primer apellido
	 */
	public void setApellido1(String apellido1) 
	{
		this.apellido1 = apellido1;
	}
	/**
	 * Get Apellido 2
	 * @return retorna el segundo apellido
	 */
	public String getApellido2() 
	{
		return apellido2;
	}
	/**
	 * Set Apellido 2
	 * @param apellido2 recibe el segundo apellido
	 */
	public void setApellido2(String apellido2) 
	{
		this.apellido2 = apellido2;	
	}
	/**
	 * Get del número de teléfono
	 * @return
	 */
	public String getTelefono() 
	{
		return telefono;
	}
	/**
	 * Set del número de teléfono 
	 * @param telefono
	 */
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	/**
	 * Get del correo electrónico
	 * @return retorna el correo electrónico
	 */
	public String getCorreoE() 
	{
		return correoE;
	}
	/**
	 * Set del correo electrónico 
	 * @param correoE recibe el del correo electrónico
	 */
	public void setCorreoE(String correoE) 
	{
		this.correoE = correoE;
	}
	/**
	 * Get del número de cedula 
	 * @return retorna el número de cédula
	 */
	public String getCedula() 
	{
		return cedula;
	}
	/**
	 * Set del número de cédula
	 * @param cedula recibe el número de cédula
	 */
	public void setCedula(String cedula) 
	{
		this.cedula = cedula;
	}
	/**
	 * Get de la categoría de la persona
	 * @return retorna la categoría de la persona
	 */
	public int getCategoria() 
	{
		return categoria;
	}
	/**
	 * Set de la categoría de la persona
	 * @param categoria recibe la categoría de la persona
	 */
	public void setCategoria(int categoria) 
	{
		this.categoria = categoria;
	}	
}
