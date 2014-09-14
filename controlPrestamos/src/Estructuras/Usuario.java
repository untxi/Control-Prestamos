package Estructuras;
/**
 * Clase Usuario
 * Crea una persona con características para manejar una cuenta
 * @author Samantha Arburola
 *
 */
public class Usuario extends Persona
{
	// Atributos
	/**
	* Contraseña del usuario
	*/
	private String contraseña;
	/**
	 * nickname del usuario
	 */
	private String nikname;

	/**
	 * Construcción de usuario
	 * @param nombre      : nombre
	 * @param pNickName   : nickname o seudónimo
	 * @param pContraseña : contraseña del usuario
	 */
	public Usuario(String nombre, String pNickName ,String pContraseña) 
	{
		super(nombre);
		this.setContraseña(pContraseña);
		this.setNikname(pNickName);
	}

	/**
	 * Get & Set
	 */
	public String getContraseña() 
	{
		return contraseña;
	}

	public void setContraseña(String contraseña) 
	{
		this.contraseña = contraseña;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

}
