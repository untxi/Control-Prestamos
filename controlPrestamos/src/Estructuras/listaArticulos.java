package Estructuras;
import java.util.ArrayList;


public class listaArticulos {

	private ArrayList<Articulo> Articulos;

	public listaArticulos() {
		Articulos = new ArrayList<Articulo>();
	}

	// en este momento agrega repetidos porque aun no agrega por orden
	// alfabetico
	// una vez que agregue con orden alfabetico solo buscamos en la letra
	// especifica!
	public void agregar(Articulo nuevoArticulo) {
		Articulos.add(nuevoArticulo);
	}

	// Eliminar un Articulo segun la posicion indicada
	// se puede hacer por nombre este es temporal (funcion busqueda se pordria
	// usar)

	public void EliminarArticulo(int pos) {
		Articulos.remove(pos);
	}

	// Busca un Articulo y si lo encuentra retorna su posicion en la lista.
	// mas adelante podria retornar el articulo, ya veremos....
	public int BuscarArticulo(String nombre) {
		int buscado = -1;
		int largo = Articulos.size();
		for (int indice = 0; indice < largo; indice++) {
			if (Articulos.get(indice).equals(nombre)) {
				buscado = indice;// para saber donde est?@#!
				indice = largo;// para salir
			}
		}
		return buscado;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		Articulos = articulos;
	}

	public ArrayList<Articulo> getArticulos() {
		return Articulos;
	}

	public void imprimir() {
		
		for (int i = 0; i < Articulos.size(); i++) {
			int x = i + 1;
			System.out.println(("  "+x+" - ")+Articulos.get(i).getNombre());
		}
		System.out.println();
	}

	
}
