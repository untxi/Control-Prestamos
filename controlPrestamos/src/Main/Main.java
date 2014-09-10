package Main;
/**
 * Importar Recursos 
 */
import Administradores.administradorAplicacion;
import GUI.ventanaPrincipal;
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
		//System.out.println("Hola Mundo");
		ventanaPrincipal miVentana = ventanaPrincipal.getInstance();
		//int[] prueba = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		//System.out.println(prueba[4]);
		administradorAplicacion.getInstance().cargarPersonas("src\\Recursos\\Archivos\\Personas.txt");
		administradorAplicacion.getInstance().cargarLibros("src\\Recursos\\Archivos\\Libros.txt");
		administradorAplicacion.getInstance().cargarRevistas("src\\Recursos\\Archivos\\Revistas.txt");
		administradorAplicacion.getInstance().cargarPeliculas("src\\Recursos\\Archivos\\Peliculas.txt");
	}
}