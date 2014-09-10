package Estructuras;
/**
 * 
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
	public Usuario(String nombre, String pNickName ,String pContraseña) {
		super(nombre);
		this.setContraseña(pContraseña);
		this.setNikname(pNickName);
	}
	/**
	 * Get contraseña
	 * @return contraseña
	 */
	public String getContraseña() {return contraseña;}
	/**
	 * Set contraseña
	 * @param contraseña recibe la contraseña del usuario
	 */
	public void setContraseña(String contraseña){this.contraseña = contraseña;}
	/**
	 * Get nickname
	 * @return nickname del usuario
	 */
	public String getNikname() {return nikname;}
	/**
	 * Set nickname
	 * @param nikname recibe el seudónimo del usuario
	 */
	public void setNikname(String nikname) {this.nikname = nikname;}
}