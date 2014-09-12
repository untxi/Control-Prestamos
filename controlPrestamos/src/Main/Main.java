package Main;

import Administradores.administradorAplicacion;
import GUI.ventanaPrincipal;
import Estructuras.Otro;

public class Main {

	public static void main(String[] args) 
	{
		//System.out.println("Hola Mundo");
		ventanaPrincipal miVentana = ventanaPrincipal.getInstance();
		//int[] prueba = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		//System.out.println(prueba[4]);
		administradorAplicacion.getInstance().cargarPersonas("src\\Recursos\\Archivos\\Personas.txt");
		administradorAplicacion.getInstance().cargarLibros("src\\Recursos\\Archivos\\Libros.txt");
		administradorAplicacion.getInstance().cargarRevistas("src\\Recursos\\Archivos\\Revistas.txt");
		administradorAplicacion.getInstance().cargarPeliculas("src\\Recursos\\Archivos\\Peliculas.txt");
		
		//String prueba = "Hola Mundo";
		//System.out.println(like("hola","HO%"));
		
	}
	
	public static boolean like(String str, String expr) {
	    expr = expr.toLowerCase(); // ignoring locale for now
	    expr = expr.replace(".", "\\."); // "\\" is escaped to "\" (thanks, Alan M)
	    // ... escape any other potentially problematic characters here
	    expr = expr.replace("?", ".");
	    expr = expr.replace("%", ".*");
	    str = str.toLowerCase();
	    return str.matches(expr);
	}	

}
