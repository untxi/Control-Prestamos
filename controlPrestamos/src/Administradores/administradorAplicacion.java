package Administradores;
import java.util.ArrayList;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Persona;
import Estructuras.Usuario;
import Interfaces.IConstantes;


public class administradorAplicacion implements IConstantes
{
	// Parametros Privados 
	private static administradorAplicacion miAdministrador;
	private ArrayList<Persona> Personas = new ArrayList<Persona>();
	private administradorArchivos miAdministradorArchivos = new administradorArchivos();
	private ArrayList<String> tiposCategorias = new ArrayList<String>();
	private ArrayList<ArrayList<Articulo>> miListaCategorias = new ArrayList<ArrayList<Articulo>>();
	private Usuario usuario;
	
	
	//CREACION DE LISTAS PARA LA MANIPULACIÓN DE CONSULTAS
	public static ArrayList listaPrestados;
	public static ArrayList listaArticulos;
	
	// Parámetros Generales: Dinámicos en razón al usuario, Estáticos en razón al  
	public int miTop          = 10;
	public int alarmaVerde    = 15;
	public int alarmaAmarilla = 20;
	public int alarmaRoja     = 25;
	public int vecesConsulta  = 3;
	public int mesesConsulta  = 6;
	
	public int getMiTop() {	return miTop;}
	public void setMiTop(int miTop) {this.miTop = miTop;}
	
	public static ArrayList getListaPrestados() {return listaPrestados;	}
	public static void setListaPrestados(ArrayList listaPrestados) {administradorAplicacion.listaPrestados = listaPrestados;}
	
	public static ArrayList getListaArticulos() {return listaArticulos;	}
	public static void setListaArticulos(ArrayList listaArticulos) {administradorAplicacion.listaArticulos = listaArticulos;}

	public int getAlarmaVerde() {return alarmaVerde;}
	public void setAlarmaVerde(int alarmaVerde) {this.alarmaVerde = alarmaVerde;}

	public int getAlarmaAmarilla() {return alarmaAmarilla;}
	public void setAlarmaAmarilla(int alarmaAmarilla) {	this.alarmaAmarilla = alarmaAmarilla;}

	public int getAlarmaRoja() {return alarmaRoja;}
	public void setAlarmaRoja(int alarmaRoja) {	this.alarmaRoja = alarmaRoja;}

	public int getVecesConsulta() {	return vecesConsulta;}
	public void setVecesConsulta(int vecesConsulta) {this.vecesConsulta = vecesConsulta;}

	public int getMesesConsulta() {	return mesesConsulta;}
	public void setMesesConsulta(int mesesConsulta) {this.mesesConsulta = mesesConsulta;}

	private administradorAplicacion()
	{
		tiposCategorias.add("Libro");
		tiposCategorias.add("Revista");
		tiposCategorias.add("Pelicula");
		for(int i = 0;i < tiposCategorias.size(); i++)
		{
			miListaCategorias.add(new ArrayList<Articulo>());
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
	
	public void imprimirListaPersonas()
	{
		int i;
		System.out.println("Lista Personas");
		for(i=0;i<Personas.size();i++)
		{
			System.out.println("Nombre: "+ Personas.get(i).getNombre());
		}
	}
	
	public void cargarPersonas(String pPath)
	{
		miAdministradorArchivos.leerArchivoPersona(pPath, Personas);
		imprimirListaPersonas();
	}
	
	public void agregarPersona(String pNombre, String pApellido1, String pApellido2,
			String pCedula, String pTelefono, String pCorreoE, int pCategoria)
	{
		Personas.add(new Persona(pNombre, pApellido1, pApellido2, pCedula, pTelefono, pCorreoE, pCategoria));
		
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
	public ArrayList<Persona> getPersonas()
	{
		return Personas;
	}

	public void setPersonas(ArrayList<Persona> personas) 
	{
		Personas = personas;
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

}
