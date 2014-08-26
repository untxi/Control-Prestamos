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



public class administradorConsulta
{
	
	// Para retornar la lista del Top de préstamos
	public ArrayList TopPrestamo (int miTop, ArrayList listaArticulos)
	{
		/* Paso 1. Ordena de mayor a menos todos los artículos de acuerdo a la cantidad de veces prestado
		 * Paso 2. Toma los primeros artículos de acuerdo al rango definido en miTop por el usuario 
		 */
		ArrayList listaPrestados;
		//ArrayList listaArticulos.sort();
		for(int i=0; i < listaArticulos ; i++)
		{
			// Revisar que se esta manipulando
			//Estructuras.Articulo actual = listaArticulos[i];
			//System.out.println("Artículo :  " + actual + "\n");
			
		}
		
		return listaPrestados;
			
	}//fin TopPrestamo
		
	
	
	///// las funciones tienen que devolverme ArrayList<Ariculo> ó ArrayList<Prestamo>

}// Fin clase
