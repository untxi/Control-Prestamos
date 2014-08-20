package Administradores;
import java.util.ArrayList;

import Estructuras.Categoria;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Persona;
import Estructuras.Usuario;
import Estructuras.listaCategorias;
import Estructuras.listaPersonas;
import Interfaces.IConstantes;


public class administradorAplicacion implements IConstantes
{
	private static administradorAplicacion miAdministrador;
	private listaPersonas Personas = new listaPersonas();
	private administradorArchivos miAdministradorArchivos = new administradorArchivos();
	private listaCategorias miListaCategorias = new listaCategorias();
	private ArrayList<String> tiposCategorias = new ArrayList<String>();
	private listaPersonas Usuarios = new listaPersonas();
	private Usuario usuario;

	
	private administradorAplicacion()
	{
		tiposCategorias.add("Libro");
		tiposCategorias.add("Revista");
		tiposCategorias.add("Pelicula");
		for(int i = 0;i < tiposCategorias.size(); i++)
		{
			miListaCategorias.agregarCategoria(new Categoria(tiposCategorias.get(i)));
		}
	}
	
	public static administradorAplicacion getInstance()
	{
		if(miAdministrador == null)
		{
			miAdministrador = new administradorAplicacion();
		}
		return miAdministrador;
	}
	
	public void cargarPersonas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPersona(pPath, Personas);
		Personas.imprimir();
	}
	
	public void agregarPersona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		Personas.agregar(new Persona(pNombre, pApellido1, pApellido2, pCedula, pTelefono, pCorreoE, pCategoria));
		
	}
	
	public void cargarLibros(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.getCategorias().get(categoriaLibro).getArticulos());
		//System.out.println(miListaCategorias.getCategorias().get(categoriaLibro).getnombreCategoria());
		miListaCategorias.getCategorias().get(categoriaLibro).getArticulos().imprimir();
	}

	public void cargarRevistas(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.getCategorias().get(categoriaRevista).getArticulos());
		//System.out.println(miListaCategorias.getCategorias().get(categoriaRevista).getnombreCategoria());
		miListaCategorias.getCategorias().get(categoriaRevista).getArticulos().imprimir();
	}
	
	public void cargarPeliculas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPelicula(pPath,miListaCategorias.getCategorias().get(categoriaPelicula).getArticulos());
		//System.out.println(miListaCategorias.getCategorias().get(categoriaPelicula).getnombreCategoria());
		miListaCategorias.getCategorias().get(categoriaPelicula).getArticulos().imprimir();
	}
	
	public void agregarCategoria(String pCategoria)
	{
		tiposCategorias.add(pCategoria);
		miListaCategorias.agregarCategoria(new Categoria(pCategoria));
	} 
	
	public void agregarLibro(String pTitulo ,String pAutor, String pEditorial, 
							 String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevoLibro = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.getCategorias().get(categoriaLibro).getArticulos().agregar(nuevoLibro);
	}
	public void agregarRevista(String pTitulo ,String pAutor, String pEditorial, 
			 				   String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevaRevista = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.getCategorias().get(categoriaRevista).getArticulos().agregar(nuevaRevista);
	}
	public void agregarPelicula(String pNombre, int pCalificacion, String pImagen,
			String pDirector, String pCategoria)
	{
		Pelicula nuevaPelicula = new Pelicula(pNombre, pCalificacion, pImagen, pDirector, pCategoria);
		miListaCategorias.getCategorias().get(categoriaPelicula).getArticulos().agregar(nuevaPelicula);
	}
	public void agregarOtro(String pNombre, int pCalificacion, String pIimagen,
							String pDescripcion, int pIndiceCategoria)
	{
		Otro nuevoArticulo = new Otro(pNombre, pCalificacion, pIimagen, pDescripcion);
		miListaCategorias.getCategorias().get(pIndiceCategoria).getArticulos().agregar(nuevoArticulo);
	}
	
	public void agregarUsuario(String pNombre, String pNickName ,String pContraseña)
	{
		Usuarios.agregar(new Usuario(pNombre, pNickName ,pContraseña));
	}
	
	public boolean validarUsuario(String pNickName ,String pContraseña)
	{
		int indice;
		boolean existe = false;
		for(indice = 0; indice < Usuarios.getPersonas().size(); indice++)
		{
			//System.out.println(((Usuario)Usuarios.getPersonas().get(indice)).getNikname());
			if(((Usuario)Usuarios.getPersonas().get(indice)).getNikname().compareTo(pNickName) == 0 &&
					((Usuario)Usuarios.getPersonas().get(indice)).getContraseña().compareTo(pContraseña) == 0)
			{
				//System.out.println(((Usuario)Usuarios.getPersonas().get(indice)).getNikname());
				usuario = ((Usuario)Usuarios.getPersonas().get(indice));
				existe = true;
			}
		}
		return existe;
	}
	public listaPersonas getPersonas() {
		return Personas;
	}

	public void setPersonas(listaPersonas personas) {
		Personas = personas;
	}

	public administradorArchivos getMiAdministradorArchivos() {
		return miAdministradorArchivos;
	}

	public void setMiAdministradorArchivos(administradorArchivos miAdministradorArchivos) {
		this.miAdministradorArchivos = miAdministradorArchivos;
	}

	public listaCategorias getMiListaCategorias() {
		return miListaCategorias;
	}

	public void setMiListaCategorias(listaCategorias miListaCategorias) {
		this.miListaCategorias = miListaCategorias;
	}

	public listaPersonas getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(listaPersonas usuarios) {
		Usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
