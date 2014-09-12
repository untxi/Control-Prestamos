package Administradores;

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

public class administradorConsulta implements IConstantes
{
	
	private ArrayList<Articulo> ListaArticulosTemp = new ArrayList<Articulo>();
	private ArrayList<Prestamo> ListaPrestamosTemp = new ArrayList<Prestamo>();

	public administradorConsulta()
	{
		
	}
	
	
//////////////////////////////Ordenamientos///////////////////////////////////////////////	
	
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
	
///////////////////////////////////////////Filtros///////////////////////////////////////////////////////////
	public void aplicarFiltroLibros(String pTitulo, String pAutor, String pEditorial, int pCategoria )
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Libro temp = (Libro)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pTitulo.isEmpty())
			{
				if(!like(temp.getNombre(),pTitulo+"%"))
				{
					temp = null;
				}
			}
			if(!pAutor.isEmpty() && temp!=null)
			{
				if(!like(temp.getAutor(),pAutor+"%"))
				{
					temp = null;
				}
			}
			if(!pEditorial.isEmpty() && temp!=null)
			{
				if(!like(temp.geteditorial(),pEditorial+"%"))
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
	public void aplicarFiltroPeliculas(String pNombre, String pDirector,int pCategoria)
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Pelicula temp = (Pelicula)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pNombre.isEmpty())
			{
				if(!like(temp.getNombre(),pNombre+"%"))
				{
					temp = null;
				}
			}
			if(!pDirector.isEmpty() && temp!=null)
			{
				if(!like(temp.getDirector(),pDirector+"%"))
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
	public void aplicarFiltroOtros(String pNombre,int pCategoria)
	{
		for(int i = 0;i < administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).size(); i++)
		{
			Otro temp = (Otro)administradorAplicacion.getInstance().getMiListaCategorias().get(pCategoria).get(i);
			if(!pNombre.isEmpty())
			{
				if(!like(temp.getNombre(),pNombre+"%"))
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
	public void aplicaFiltroPrestamos(String pNombrePersona,int pCategoria)
	{
		for (int i = 0;i < administradorAplicacion.getInstance().getMiListaPrestamos().get(pCategoria).size();i++)
		{
			Prestamo Temp = administradorAplicacion.getInstance().getMiListaPrestamos().get(pCategoria).get(i);
			if(!pNombrePersona.isEmpty())
			{
				if(!like(Temp.getMiPersona().getNombre(),pNombrePersona+"%"))
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
	
	
	
	////////////////////////////////////7Consultas//////////////////////////////////////////////
	
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
	

 public void consultaArticulosConPrestamoVencido()
 {
	 
 }	
	
	
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
