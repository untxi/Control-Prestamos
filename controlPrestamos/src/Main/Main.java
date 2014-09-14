package Main;
/**
 * Importar Recursos 
 */
import java.util.Date;
import java.util.GregorianCalendar;

import Administradores.administradorAplicacion;
import GUI.ventanaPrincipal;
import Estructuras.Otro;
import Estructuras.Prestamo;
/**
 * Clase Main
 * 
 * Genera la ventana principal del programa
 * 
 * @author Adrian Soto
 */
public class Main {
	// Métodos Públicos
	public static void main(String[] args)
	{
		/**
		 * Genera la ventana principal del interfaz para el usuario
		 * @param lista de string
		 */
		ventanaPrincipal miVentana = ventanaPrincipal.getInstance();
		administradorAplicacion.getInstance().cargarPersonas("src\\Recursos\\Archivos\\Personas.txt");
		administradorAplicacion.getInstance().cargarLibros("src\\Recursos\\Archivos\\Libros.txt");
		administradorAplicacion.getInstance().cargarRevistas("src\\Recursos\\Archivos\\Revistas.txt");
		administradorAplicacion.getInstance().cargarPeliculas("src\\Recursos\\Archivos\\Peliculas.txt");		
	}
	

}
