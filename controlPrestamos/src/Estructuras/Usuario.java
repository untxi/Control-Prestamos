package Estructuras;
/**
 * Clase Usuario
 * Crea una persona con caracter�sticas para manejar una cuenta
 * @author Samantha Arburola
 *
 */
public class Usuario extends Persona
{
	// Atributos
	/**
	* Contrase�a del usuario
	*/
	private String contrasena;
	/**
	 * nickname del usuario
	 */
	private String nikname;

	/**
	 * Construcci�n de usuario
	 * @param nombre      : nombre
	 * @param pNickName   : nickname o seud�nimo
	 * @param pContrase�a : contrase�a del usuario
	 */
	public Usuario(String nombre, String pNickName ,String pContrasena) 
	{
		super(nombre);
		this.setContrasena(pContrasena);
		this.setNikname(pNickName);
	}

	/**
	 * Get & Set
	 */
	public String getContrasena() 
	{
		return contrasena;
	}

	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

}
