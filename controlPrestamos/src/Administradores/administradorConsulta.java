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
	
	
	 // Para retornar la lista del Top de pr�stamos
	public ArrayList topPrestamo(ArrayList listaArticulos)
	{
		/* Paso 1. Ordena de mayor a menos todos los art�culos de acuerdo a la cantidad de veces prestado
		 * Paso 2. Toma los primeros art�culos de acuerdo al rango definido en miTop por el usuario 
		 */
		ArrayList listaPrestados; // Para guardar los primeros miTop art�culos
		
		//for(int i=0; i < listaArticulos. ; i++)
		//{
			// Revisar que se esta manipulando
			//Estructuras.Articulo actual = listaArticulos[i];
			//System.out.println("Art�culo :  " + actual + "\n");
			
		//}
		
		return listaPrestados;
			
	}//fin TopPrestamo
	// M�todo: Consulta de art�culos Prestamos 
	public ArrayList Prestamos(ArrayList listaPrestamos)
	{
		ArrayList listaPrestados;
		// Ordenar alfab�ticamente la lista de art�culos prestados
		ArrayList.sort(listaPrestamos);
		return listaPrestados;
	}
	// M�todo: Consulta de no prestados
	public ArrayList NoPrestamos(ArrayList listaArticulos)
	{
		ArrayList listaArticulosNoP;
		// Ciclo para recoger la lista, si esta en lista de prestados salta, sino agrega a lista del return
		return listaArticulosNoP;
	}
	// M�todo: Consulda de cantidad prestamos 
	public ArrayList Todos(ArrayList listaArticulos)
	{
		ArrayList listaTodos;
		// Ordena Todos los art�culos en orden abc
		return listaTodos;
	}
	// M�todo: Consulta de cantidadd de prestamos en periodo
	public ArrayList VecesMeses(ArrayList listaArticulos)
	{
		ArrayList listaPrestados;
		// Comparar si la cantidad prestamos y el perido cumplen dentro del rango para agregarlos. 
		return listaPrestados;
	}
	
	///// las funciones tienen que devolverme ArrayList<Ariculo> � ArrayList<Prestamo>

}// Fin clase
