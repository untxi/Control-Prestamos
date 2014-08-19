package Estructuras;

public class Persona 
{

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String cedula;	
	private String telefono;
	private String correoE;
	private int categoria;
	
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

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}	
}
