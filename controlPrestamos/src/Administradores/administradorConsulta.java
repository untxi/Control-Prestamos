package Administradores;
// Importar Librer�as y Clases
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Prestamo;
import GUI.ventanaPrincipal;
import Interfaces.IConstantes;
/**
 * Clase administradorConsulta
 * 	Administra las consultas que puede realizar 
 * 	el usuario en sus pr�stamos
 *
 * @author Samantha Arburola
 *
 */
public class administradorConsulta implements IConstantes
{
	/**
	 * Crea una lista de todos los art�culos
	 */
	private ArrayList<Articulo> ListaArticulosTemp = new ArrayList<Articulo>();
	/**
	 * Crea uns lista de art�culos Prestados
	 */
	private ArrayList<Prestamo> ListaPrestamosTemp = new ArrayList<Prestamo>();

	// Constructor
	public administradorConsulta()
	{
		
	}
	
	
	// Ordenamientos //
	/**
	 * Ordena los art�culos por orden alfab�tico del nombre
	 * @param pListaCategorias lista de todos los art�culos
	 */
	public void ordenarArticulosPorNombre(ArrayList<Articulo> pListaCategorias)
	{
		
			Collections.sort(pListaCategorias, new Comparator<Articulo>() 
					{
				        public int compare(Articulo  pArticulo1, Articulo  pArticulo2)
				        {

				            return  pArticulo1.getNombre().compareTo(pArticulo2.getNombre());
				        }
				    });
	}
	

	/**
	 * Ordena los art�culos por orden ascendente de la cantidad de pr�stamos
	 * @param pListaCategorias Lista de categor�as
	 */
	public void ordenarArticulosPorCantPrestamos(ArrayList<Articulo> pListaCategorias)
	{
		
			Collections.sort(pListaCategorias, new Comparator<Articulo>() 
					{
				        public int compare(Articulo  pArticulo1, Articulo  pArticulo2)
				        {
				            return new Integer(pArticulo2.getCantPrestamos()).compareTo(new Integer(pArticulo1.getCantPrestamos()));
				        }
				    });
	}
	
	
	/**
	 * Ordenar los art�culos prestados por orden alfab�tico de los nombres
	 * @param pListaPrestamos Lista de art�culos prestados
	 */
	public void ordenarPrestamosPorNombre(ArrayList<Prestamo> pListaPrestamos)
	{
		
		Collections.sort(pListaPrestamos, new Comparator<Prestamo>() 
				{
			        public int compare(Prestamo  pPrestamo1, Prestamo  pPrestamo2)
			        {

			            return  pPrestamo1.getMiPersona().getNombre().compareTo(pPrestamo2.getMiPersona().getNombre());
			        }
			    });
	}
	
	// Filtros //
	/**
	 * Filtrar la consulta de art�culos por la categor�a libros
	 * @param pTitulo		t�tulo del libro
	 * @param pAutor		autor del libro
	 * @param pEditorial	editoria del libro
	 * @param pCategoria	categor�a del libro
	 */
	public void aplicarFiltroLibros(String pTitulo, String pAutor, String pEditorial, int pCategoria )
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Libro temp = (Libro)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pTitulo.isEmpty())
			{
				if(!like(temp.getNombre(),"%"+pTitulo+"%"))
				{
					temp = null;
				}
			}
			if(!pAutor.isEmpty() && temp!=null)
			{
				if(!like(temp.getAutor(),"%"+pAutor+"%"))
				{
					temp = null;
				}
			}
			if(!pEditorial.isEmpty() && temp!=null)
			{
				if(!like(temp.geteditorial(),"%"+pEditorial+"%"))
				{
					temp = null;
				}
			}
			if(temp != null)
			{
				ListaArticulosTemp.add(temp);
			}
		}
	}
	
	/**
	 * Filtrar la consulta de art�culos por la categor�a pel�culas
	 * @param pNombre		nombre de la pel�cula
	 * @param pDirector		director de la pel�cula
	 * @param pCategoria	categor�a de la pel�cula
	 */
	public void aplicarFiltroPeliculas(String pNombre, String pDirector,int pCategoria)
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Pelicula temp = (Pelicula)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pNombre.isEmpty())
			{
				if(!like(temp.getNombre(),"%"+pNombre+"%"))
				{
					temp = null;
				}
			}
			if(!pDirector.isEmpty() && temp!=null)
			{
				if(!like(temp.getDirector(),"%"+pDirector+"%"))
				{
					temp = null;
				}
			}
			if(temp != null)
			{
				ListaArticulosTemp.add(temp);
			}
		}
	}
	
	/**
	 * Filtrar la consulta de art�culos por la categor�a agregada
	 * @param pNombre		nombre del art�culo
	 * @param pCategoria	categor�a del art�culo
	 */
	public void aplicarFiltroOtros(String pNombre,int pCategoria)
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Otro temp = (Otro)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pNombre.isEmpty())
			{
				if(!like(temp.getNombre(),"%"+pNombre+"%"))
				{
					temp = null;
				}
			}
			if(temp != null)
			{
				ListaArticulosTemp.add(temp);
			}
		}
	}
	
	/**
	 * Filtrar la consulta de art�culos por los que se encuentran prestados
	 * @param pNombrePersona  nombre de la persona que tiene el art�culo como prestamo
	 * @param pCategoria	  categor�a del art�culo
	 */
	public void aplicaFiltroPrestamos(String pNombrePersona,int pCategoria)
	{
		for (int i = 0;i < administradorAplicacion.getInstance().getMiListaPrestamos().get(pCategoria).size();i++)
		{
			Prestamo Temp = administradorAplicacion.getInstance().getMiListaPrestamos().get(pCategoria).get(i);
			if(!pNombrePersona.isEmpty())
			{
				if(!like(Temp.getMiPersona().getNombre(),"%"+pNombrePersona+"%"))
				{
					Temp = null;
				}
			}
			if(Temp != null)
			{
				ListaPrestamosTemp.add(Temp);
			}
		}
		
	}
	
	
	
	// Consultas //
	/**
	 * Consultar los prestamos respecto a un n�mero de prestamos
	 * @param pCategoria	categor�a de los art�culos por consultar
	 * @param pLimit		cantidad top de art�culos
	 */
	private void consultaTop(int pCategoria, int pLimit)
	{
		ordenarArticulosPorCantPrestamos(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria));
		for (int i = 0;i < pLimit ;i++)
		{
			if(i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size())
			{
				ListaArticulosTemp.add(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i));
			}
		}
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().mostrarConsultaArticulos(ListaArticulosTemp, pCategoria,0);
		ListaArticulosTemp = null;
		ListaArticulosTemp = new ArrayList<Articulo>();
	}
	
	/**
	 * Consulta todos los art�culos existentes y los presenta en ordn alfab�tico
	 * @param pCategoria	categor�a de los art�culos
	 * @param pTitulo		t�tulo del art�culo
	 * @param pAutor		autor de la obra
	 * @param pEditorial	editorial en caso de literatura
	 * @param pConsulta		consulta cantidad de art�culos a consultar
	 */
	private void consultaTodosLosArticulos(int pCategoria,String pTitulo,String pAutor,String pEditorial, int pConsulta)
	{
		if(pCategoria == 0 || pCategoria == 1)
		{
			aplicarFiltroLibros(pTitulo, pAutor, pEditorial, pCategoria);
			ordenarArticulosPorNombre(ListaArticulosTemp);
		}
		if(pCategoria == 2)
		{
			aplicarFiltroPeliculas(pTitulo, pAutor, pCategoria);
			ordenarArticulosPorNombre(ListaArticulosTemp);
		}
		if(pCategoria > 2)
		{
			aplicarFiltroOtros(pTitulo, pCategoria);
			ordenarArticulosPorNombre(ListaArticulosTemp);
		}
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().mostrarCantArticulos(0, administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(), pConsulta);
		ventanaPrincipal.getInstance().mostrarConsultaArticulos(ListaArticulosTemp, pCategoria,270);
		ListaArticulosTemp = null;
		ListaArticulosTemp = new ArrayList<Articulo>();
	}
	
	/**
	 * Consulta flexible para que el usuario consulte seg�n su gusto
	 * @param pCategoria	 categor�a a consultar
	 * @param pCantPrestamos cantidad de art�culos 
	 * @param pDesde		 inicio del lapso de tiempo
	 * @param pHasta		 final del lapso de tiempo
	 */
	private void consultaPersonalizada(int pCategoria,int pCantPrestamos, Date pDesde, Date pHasta)
	{
		ordenarArticulosPorNombre(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria));
		for (int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size() ;i++)
		{
			if(pCantPrestamos <= administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i).getCantPresAcumuladosEnRangoMeses(pDesde.getMonth(), pHasta.getMonth()))
			{
				ListaArticulosTemp.add(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i));
			}
		}
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().mostrarConsultaArticulos(ListaArticulosTemp, pCategoria,0);
		ListaArticulosTemp = null;
		ListaArticulosTemp = new ArrayList<Articulo>();
	}
	
	/**
	 * Consulta los art�culos prestados actualmente
	 * @param pCategoria	 categor�a por consultar
	 * @param pNombrePersona nombre de a quien se lo prestaron
	 * @param pConsulta		 cantidad de consultas
	 */
	private void consultaPrestados(int pCategoria,String pNombrePersona, int pConsulta)
	{
		aplicaFiltroPrestamos(pNombrePersona, pCategoria);
		ordenarPrestamosPorNombre(ListaPrestamosTemp);
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().mostrarCantArticulos(0, ListaPrestamosTemp.size(), pConsulta);
		ventanaPrincipal.getInstance().mostrarConsultaPrestamos(ListaPrestamosTemp,pCategoria,270);
		ListaPrestamosTemp = null;
		ListaPrestamosTemp = new ArrayList<Prestamo>();
	}
	
	/**
	 * Consulta de los no prestados
	 * @param pCategoria categor�a por consultar
	 * @param pConsulta  cantidad de consultas
	 */
	private void consultaNoPrestados(int pCategoria, int pConsulta)
	{
		ordenarArticulosPorNombre(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria));
		for (int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size() ;i++)
		{
			if(!administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i).isPrestado())
			{
				ListaArticulosTemp.add(administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i));
			}
		}
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().mostrarCantArticulos(0, ListaArticulosTemp.size(), pConsulta);
		ventanaPrincipal.getInstance().mostrarConsultaArticulos(ListaArticulosTemp, pCategoria,270);
		ListaArticulosTemp = null;
		ListaArticulosTemp = new ArrayList<Articulo>();
	}
	
	/**
	 * Consulta los ar�tculos vencidos
	 */
	public void consultaArticulosConPrestamoVencido() throws Exception
	{
		ventanaPrincipal.getInstance().limpiarPanelConsulta();
		ventanaPrincipal.getInstance().setcoordenadaY(0);
		for (int i = 0;i < administradorAplicacion.getInstance().getMiListaPrestamos().size();i++)
		{
			for(int j = 0;j < administradorAplicacion.getInstance().getMiListaPrestamos().get(i).size();j++)
			{
				Prestamo Temp = administradorAplicacion.getInstance().getMiListaPrestamos().get(i).get(j);
				ListaPrestamosTemp.add(Temp);
			}
			ventanaPrincipal.getInstance().mostrarPrestamosParaCorreo(ListaPrestamosTemp,i);
			ListaPrestamosTemp = null;
			ListaPrestamosTemp = new ArrayList<Prestamo>();
		}
	}	
	
	/**
	 * Men� para consultas
	 */
	public void consulta(int pConsulta,int pCategoria, int pLimit, int pCantPrestamos, Date pDesde, Date pHasta,
						 String pTitulo,String pAutor,String pEditorial,String pNombrePersona)
	{
		if(pConsulta == consultaTop )
		{
			consultaTop(pCategoria, pLimit);
		}
		if(pConsulta == consultaTodos )
		{
			consultaTodosLosArticulos(pCategoria,pTitulo,pAutor,pEditorial,consultaTodos);
		}
		if(pConsulta == consultaPersonalizada )
		{
			consultaPersonalizada(pCategoria,pCantPrestamos, pDesde, pHasta);
		}
		if(pConsulta == consultaPrestados )
		{
			consultaPrestados(pCategoria, pNombrePersona,consultaPrestados);
		}
		if(pConsulta == consultaNoPrestados )
		{
			consultaNoPrestados(pCategoria,consultaNoPrestados);
		}
		
	}
	
	/**
	 * Validaci�n
	 */
	public boolean like(String str, String expr) 
	{
	    expr = expr.toLowerCase(); // ignoring locale for now
	    expr = expr.replace(".", "\\."); // "\\" is escaped to "\" (thanks, Alan M)
	    // ... escape any other potentially problematic characters here
	    expr = expr.replace("?", ".");
	    expr = expr.replace("%", ".*");
	    str = str.toLowerCase();
	    return str.matches(expr);
	}	
	


}
