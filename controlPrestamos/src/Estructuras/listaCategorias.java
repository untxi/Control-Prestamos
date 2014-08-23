package Estructuras;
import java.util.ArrayList;


public class listaCategorias {

	private ArrayList<Categoria> Categorias;

	public listaCategorias() {
		Categorias = new ArrayList<Categoria>();
	}

	// en este momento agrega repetidos porque aun no agrega por orden
	// alfabetico
	// una vez que agregue con orden alfabetico solo buscamos en la letra
	// especifica!
	public void agregarCategoria(Categoria nuevoCategoria) {
		Categorias.add(nuevoCategoria);
	}

	// Eliminar un Categoria segun la posicion indicada
	// se puede hacer por nombre este es temporal (funcion busqueda se pordria
	// usar)

	public void EliminarCaegoria(int pos) {
		Categorias.remove(pos);
	}

	// Busca un Categoria y si lo encuentra retorna su posicion en la lista.
	// mas adelante podria retornar el Categoria, ya veremos....
	public int BuscarCategoria(String nombre) {
		int buscado = -1;
		int largo = Categorias.size();
		for (int indice = 0; indice < largo; indice++) {
			if (Categorias.get(indice).equals(nombre)) {
				buscado = indice;// para saber donde est?@#!
				indice = largo;// para salir
			}
		}
		return buscado;
	}

	public void imprimir() {
		for (int i = 0; i < Categorias.size(); i++) {
			System.out.println(Categorias.get(i).getnombreCategoria() + ": ");
			Categorias.get(i).getArticulos().imprimir();
		}
		System.out.println();
	}

	/*
	 * Iterator<String> nombreIterator = nombreArrayList.iterator();
	 * while(nombreIterator.hasNext()){ String elemento = nombreIterator.next();
	 * System.out.print(elemento+" / "); }
	 */

	public void setCategorias(ArrayList<Categoria> Categorias) {
		this.Categorias = Categorias;
	}

	public ArrayList<Categoria> getCategorias() {
		return Categorias;
	}
}
