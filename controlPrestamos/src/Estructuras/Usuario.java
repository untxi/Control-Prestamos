package Estructuras;

public class Usuario extends Persona
{
	private String contrase�a;
	private String nikname;

	public Usuario(String nombre, String pNickName ,String pContrase�a) 
	{
		super(nombre);
		this.setContrase�a(pContrase�a);
		this.setNikname(pNickName);
	}

	public String getContrase�a() 
	{
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) 
	{
		this.contrase�a = contrase�a;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

}
