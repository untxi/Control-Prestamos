package Estructuras;
import java.util.ArrayList;


public class listaPersonas {
	private ArrayList<Persona> Personas;

	public listaPersonas(){
		Personas = new ArrayList<Persona>();
	}

	// en este momento agrega repetidos porque aun no agrega por orden
	// alfabetico
	// una vez que agregue con orden alfabetico solo buscamos en la letra
	// especifica!
	public void agregar(Persona nuevaPersona) {
		Personas.add(nuevaPersona);
	}

	// Eliminar un Persona segun la posicion indicada
	// se puede hacer por nombre este es temporal (funcion busqueda se pordria
	// usar)

	public void EliminarPersona(int pos) {
		Personas.remove(pos);
	}

	// Busca un Persona y si lo encuentra retorna su posicion en la lista.
	// mas adelante podria retornar el Persona, ya veremos....
	public int BuscarPersona(String nombre) {
		int buscado = -1;
		int largo = Personas.size();
		for (int indice = 0; indice < largo; indice++) {
			if (Personas.get(indice).equals(nombre)) {
				buscado = indice;// para saber donde est?@#!
				indice = largo;// para salir
			}
		}
		return buscado;
	}
	
	

	public void setPersonas(ArrayList<Persona> Personas) {
		this.Personas = Personas;
	}

	public ArrayList<Persona> getPersonas() {
		return Personas;
	}

	public void imprimir() 
	{
		for (int i = 0; i < Personas.size(); i++) 
		{
			int num = i + 1;
			System.out.println(("  "+num+" - ")+Personas.get(i).getNombre() + Personas.get(i).getCedula());
		}
		System.out.println();
	}
}
