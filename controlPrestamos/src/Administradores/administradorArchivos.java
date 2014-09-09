package Administradores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Pelicula;
import Estructuras.Persona;

public class administradorArchivos 
{


	FileReader fr = null;
	BufferedReader br = null;
	public void leerArchivoLibro(String ruta, ArrayList<Articulo> pListaArticulos) {
		try {
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);

			String linea;
			// Obtenemos el contenido del archivo linea por linea
			while ((linea = br.readLine()) != null)
			{
				String[] tokens = linea.split("-");
				pListaArticulos.add(crearLibro(tokens));
			}

		} catch (Exception e) {
		}
		// finally se utiliza para que si todo ocurre correctamente o si ocurre
		// algun error se cierre el archivo que anteriormente abrimos
		finally {
			try {
				br.close();
			} catch (Exception ex) {
			}
		}
	}

	public void leerArchivoPelicula(String ruta, ArrayList<Articulo> pListaArticulos) {
		try {
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);

			String linea;
			// Obtenemos el contenido del archivo linea por linea
			while ((linea = br.readLine()) != null)
			{
				String[] tokens = linea.split("-");
				pListaArticulos.add(crearPelicula(tokens));
			}

		} catch (Exception e) {
		}
		// finally se utiliza para que si todo ocurre correctamente o si ocurre
		// algun error se cierre el archivo que anteriormente abrimos
		finally {
			try {
				br.close();
			} catch (Exception ex) {
			}
		}
	}

	public void leerArchivoPersona(String ruta) {
		try {
			fr = new FileReader(ruta);
			br = new BufferedReader(fr);

			String linea;

			// Obtenemos el contenido del archivo linea por linea
			while ((linea = br.readLine()) != null)
			{
				String[] tokens = linea.split("-");
				administradorAplicacion.getInstance().agregarPersona(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
																	 tokens[5], Integer.parseInt(tokens[6]));
			}

		} catch (Exception e) {
		}
		// finally se utiliza para que si todo ocurre correctamente o si ocurre
		// algun error se cierre el archivo que anteriormente abrimos
		finally {
			try {
				br.close();
			} catch (Exception ex) {
			}
		}
	}

	
	//crea y agrega una persona a la lista "Libros" con la informacion del arreglo "libro"
	private Libro crearLibro(String[] pLibro) 
	{
		Libro nLibro = new Libro(pLibro[0], pLibro[1], pLibro[2],
				pLibro[3], Integer.parseInt(pLibro[4]), pLibro[5]);
		return nLibro;
	}

	private Pelicula crearPelicula(String[] pPelicula) 
	{
		Pelicula nPelicula = new Pelicula(pPelicula[0] ,Integer.parseInt(pPelicula[1]), pPelicula[2],pPelicula[3],pPelicula[4]);
		return nPelicula;
	}
	
	
}
