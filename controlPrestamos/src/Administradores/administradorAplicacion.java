package Administradores;
import java.util.ArrayList;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Persona;
import Estructuras.Prestamo;
import Estructuras.Usuario;
import Interfaces.IConstantes;


public class administradorAplicacion implements IConstantes
{
	private static administradorAplicacion miAdministrador;
	private administradorConsulta miAdministradorConsultas = new administradorConsulta();
	private ArrayList<ArrayList<Persona>> miListaPersonas = new ArrayList<ArrayList<Persona>>();
	private administradorArchivos miAdministradorArchivos = new administradorArchivos();
	private ArrayList<String> tiposCategorias = new ArrayList<String>();
	private ArrayList<ArrayList<Articulo>> miListaCategorias = new ArrayList<ArrayList<Articulo>>();
	private ArrayList<ArrayList<Prestamo>> miListaPrestamos = new ArrayList<ArrayList<Prestamo>>();
	private Usuario usuario;
	private int diasPrestamo = 20;
	private int diasTolerancia = 5;
	
	
	
	public ArrayList<ArrayList<Prestamo>> getMiListaPrestamos() {
		return miListaPrestamos;
	}

	public void setMiListaPrestamos(ArrayList<ArrayList<Prestamo>> miListaPrestamos) {
		this.miListaPrestamos = miListaPrestamos;
	}


	
	private administradorAplicacion()
	{
		tiposCategorias.add("Libro");
		tiposCategorias.add("Revista");
		tiposCategorias.add("Pelicula");
		for(int i = 0;i < tiposCategorias.size(); i++)
		{
			miListaCategorias.add(new ArrayList<Articulo>());
			miListaPrestamos.add(new ArrayList<Prestamo>());
		}
		for(int j = 0;j < cantCategoriasPersona; j++)
		{
			miListaPersonas.add(new ArrayList<Persona>());
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
	
	public void imprimirListaCategorias()
	{
		int i,j;
		for(i=0;i<miListaCategorias.size();i++)
		{
			System.out.println("Categoria: "+tiposCategorias.get(i));
			for(j=0;j<miListaCategorias.get(i).size();j++)
			{
				System.out.println(miListaCategorias.get(i).get(j).getNombre());
			}
		}
	}
	
	public void imprimirListaPersona()
	{
		int i,j;
		for(i=0;i<miListaPersonas.size();i++)
		{
			System.out.println("Indice: "+ i);
			for(j=0;j<miListaPersonas.get(i).size();j++)
			{
				System.out.println(miListaPersonas.get(i).get(j).getNombre());
			}
		}
		System.out.println("///////////////////////////////////////////////////");
	}
	
	public void imprimirListaPrestamos()
	{
		int i,j;
		for(i=0;i<miListaPrestamos.size();i++)
		{
			System.out.println("Categoria: "+tiposCategorias.get(i));
			for(j=0;j<miListaPrestamos.get(i).size();j++)
			{
				System.out.println("Fecha: "   +miListaPrestamos.get(i).get(j).getMiFecha().toString());
				System.out.println("Persona: " +miListaPrestamos.get(i).get(j).getMiPersona().getNombre());
				System.out.println("Articulo: "+miListaPrestamos.get(i).get(j).getMiArticulo().getNombre());
			}
		}
		//System.out.println("///////////////////////////////////////////////////");
	}
	
	
	
	public void cargarPersonas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPersona(pPath);
	}
	
	public void agregarPersona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		miListaPersonas.get(pCategoria).add(new Persona(pNombre, pApellido1, pApellido2, pCedula, pTelefono, pCorreoE, pCategoria));
		imprimirListaPersona();
		
	}
	
	public void agregarPrestamo(int pCategoria,Prestamo pPrestamo)
	{
		miListaPrestamos.get(pCategoria).add(pPrestamo);
		imprimirListaPrestamos();
	}
	
	public void cargarLibros(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.get(categoriaLibro));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaLibro).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaLibro).getArticulos().imprimir();
	}

	public void cargarRevistas(String pPath)
	{
		miAdministradorArchivos.leerArchivoLibro(pPath,miListaCategorias.get(categoriaRevista));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaRevista).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaRevista).getArticulos().imprimir();
	}
	
	public void cargarPeliculas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPelicula(pPath,miListaCategorias.get(categoriaPelicula));
		imprimirListaCategorias();
		//System.out.println(miListaCategorias.getCategorias().get(categoriaPelicula).getnombreCategoria());
		//miListaCategorias.getCategorias().get(categoriaPelicula).getArticulos().imprimir();
	}
	
	public void agregarCategoria(String pCategoria)
	{
		tiposCategorias.add(pCategoria);
		miListaCategorias.add(new ArrayList<Articulo>());
		miListaPrestamos.add(new ArrayList<Prestamo>());
		//miListaCategorias.agregarCategoria(new Categoria(pCategoria));
	} 
	
	public void agregarLibro(String pTitulo ,String pAutor, String pEditorial, 
							 String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevoLibro = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.get(categoriaLibro).add(nuevoLibro);
	}
	public void agregarRevista(String pTitulo ,String pAutor, String pEditorial, 
			 				   String pEdicion,int pCalificacion, String pImagen)
	{
		Libro nuevaRevista = new Libro(pTitulo ,pAutor, pEditorial, pEdicion, pCalificacion, pImagen);
		miListaCategorias.get(categoriaRevista).add(nuevaRevista);
	}
	public void agregarPelicula(String pNombre, int pCalificacion, String pImagen,
			String pDirector, String pCategoria)
	{
		Pelicula nuevaPelicula = new Pelicula(pNombre, pCalificacion, pImagen, pDirector, pCategoria);
		miListaCategorias.get(categoriaPelicula).add(nuevaPelicula);
	}
	public void agregarOtro(String pNombre, int pCalificacion, String pIimagen,
							String pDescripcion, int pIndiceCategoria)
	{
		Otro nuevoArticulo = new Otro(pNombre, pCalificacion, pIimagen, pDescripcion);
		miListaCategorias.get(pIndiceCategoria).add(nuevoArticulo);
	}
	
	
	public boolean validarUsuario(String pNickName ,String pContraseña)
	{
		boolean esUsuario = false;
		if(usuario.getNikname().compareTo(pNickName) == 0 && usuario.getContraseña().compareTo(pContraseña) == 0)
		{
			esUsuario = true;
		}
		return esUsuario;
	}
	public ArrayList<ArrayList<Persona>> getPersonas()
	{
		return miListaPersonas;
	}

	public void setPersonas(ArrayList<ArrayList<Persona>> pMiListaPersonas) 
	{
		miListaPersonas = pMiListaPersonas;
	}

	public administradorArchivos getMiAdministradorArchivos() {
		return miAdministradorArchivos;
	}

	public void setMiAdministradorArchivos(administradorArchivos miAdministradorArchivos) {
		this.miAdministradorArchivos = miAdministradorArchivos;
	}

	public ArrayList<ArrayList<Articulo>> getMiListaCategorias() {
		return miListaCategorias;
	}

	public void setMiListaCategorias(ArrayList<ArrayList<Articulo>> miListaCategorias) {
		this.miListaCategorias = miListaCategorias;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<String> getTiposCategorias() {
		return tiposCategorias;
	}

	public void setTiposCategorias(ArrayList<String> tiposCategorias) {
		this.tiposCategorias = tiposCategorias;
	}

	public administradorConsulta getMiAdministradorConsultas() {
		return miAdministradorConsultas;
	}

	public void setMiAdministradorConsultas(administradorConsulta miAdministradorConsultas) {
		this.miAdministradorConsultas = miAdministradorConsultas;
	}

	public int getDiasPrestamo() {
		return diasPrestamo;
	}

	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}

	public int getDiasTolerancia() {
		return diasTolerancia;
	}

	public void setDiasTolerancia(int diasTolerancia) {
		this.diasTolerancia = diasTolerancia;
	}

}
