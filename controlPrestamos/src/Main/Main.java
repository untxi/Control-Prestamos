package Main;

import java.util.Date;
import java.util.GregorianCalendar;

import Administradores.administradorAplicacion;
import GUI.ventanaPrincipal;
import Estructuras.Otro;
import Estructuras.Prestamo;

public class Main {

	public static void main(String[] args)
	{
		ventanaPrincipal miVentana = ventanaPrincipal.getInstance();
		administradorAplicacion.getInstance().cargarPersonas("src\\Recursos\\Archivos\\Personas.txt");
		administradorAplicacion.getInstance().cargarLibros("src\\Recursos\\Archivos\\Libros.txt");
		administradorAplicacion.getInstance().cargarRevistas("src\\Recursos\\Archivos\\Revistas.txt");
		administradorAplicacion.getInstance().cargarPeliculas("src\\Recursos\\Archivos\\Peliculas.txt");		
	}
	

}
