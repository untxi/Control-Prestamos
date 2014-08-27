package Estructuras;

public class Usuario extends Persona
{
	private String contraseña;
	private String nikname;

	public Usuario(String nombre, String pNickName ,String pContraseña) 
	{
		super(nombre);
		this.setContraseña(pContraseña);
		this.setNikname(pNickName);
	}

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
