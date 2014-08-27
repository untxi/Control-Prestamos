package Administradores;

//  Funcionalidad
import java.util.ArrayList;


// Clases
import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Persona;
import Estructuras.Usuario;
import Interfaces.IConstantes;
import Administradores.administradorAplicacion;


 
public class administradorConsulta
{
	//ArrayList<listaArticulos>// esta va a ser la lista de articulos total
	
	
	 // Para retornar la lista del Top de préstamos
	public ArrayList topPrestamo(ArrayList listaArticulos)
	{
		/* Paso 1. Ordena de mayor a menos todos los artículos de acuerdo a la cantidad de veces prestado
		 * Paso 2. Toma los primeros artículos de acuerdo al rango definido en miTop por el usuario 
		 */
		ArrayList listaPrestados; // Para guardar los primeros miTop artículos
		
		//for(int i=0; i < listaArticulos. ; i++)
		//{
			// Revisar que se esta manipulando
			//Estructuras.Articulo actual = listaArticulos[i];
			//System.out.println("Artículo :  " + actual + "\n");
			
		//}
		
		return listaPrestados;
			
	}//fin TopPrestamo
	// Método: Consulta de artículos Prestamos 
	public ArrayList Prestamos(ArrayList listaPrestamos)
	{
		ArrayList listaPrestados;
		// Ordenar alfabéticamente la lista de artículos prestados
		ArrayList.sort(listaPrestamos);
		return listaPrestados;
	}
	// Método: Consulta de no prestados
	public ArrayList NoPrestamos(ArrayList listaArticulos)
	{
		ArrayList listaArticulosNoP;
		// Ciclo para recoger la lista, si esta en lista de prestados salta, sino agrega a lista del return
		return listaArticulosNoP;
	}
	// Método: Consulda de cantidad prestamos 
	public ArrayList Todos(ArrayList listaArticulos)
	{
		ArrayList listaTodos;
		// Ordena Todos los artículos en orden abc
		return listaTodos;
	}
	// Método: Consulta de cantidadd de prestamos en periodo
	public ArrayList VecesMeses(ArrayList listaArticulos)
	{
		ArrayList listaPrestados;
		// Comparar si la cantidad prestamos y el perido cumplen dentro del rango para agregarlos. 
		return listaPrestados;
	}
	
	///// las funciones tienen que devolverme ArrayList<Ariculo> ó ArrayList<Prestamo>

}// Fin clase
