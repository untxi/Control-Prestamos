package GUI;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Estructuras.Prestamo;
import Interfaces.IConstantes;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
/**
 * Clase panel articulo
 * 
 * contiene información del articulo
 * 
 * @author Adrián
 *
 */
public class panelArticulo extends JPanel implements IConstantes
{
	//Atributo
	/**
	 * Imagen de la portada
	 */
	private ImageIcon portada; 
	private JTextField textitulo;
	private JTextField textAutor;
	private JTextField texEditorial;
	private JTextField textedicion;
	private JTextField textPersona;
	private JLabel lblNewLabel;
	private JLabel titulo;
	private JLabel autor;
	private JLabel editorial;
	private JLabel edicion;
	private JLabel persona;
	private JLabel Descripcion;
	private JEditorPane textDescripcion;
	private JLabel label;

	//Médoto
	/**
	 * constructor con tres parametros
	 * @param y
	 * @param pArticulo
	 * @param pCategoria
	 * @wbp.parser.constructor
	 */
	public panelArticulo(int y, Articulo pArticulo, int pCategoria) 
	{
		portada = new ImageIcon(pathImagenes+pArticulo.getImagen());
		setBounds(new Rectangle(0, y, 534, 267));
		setBackground(new Color(112, 128, 144));
		setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 165, 265);
		lblNewLabel.setIcon(new ImageIcon(portada.getImage().getScaledInstance(164, 265, Image.SCALE_SMOOTH)));
		add(lblNewLabel);
		
		titulo = new JLabel("New label");
		titulo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		titulo.setBounds(198, 11, 87, 14);
		add(titulo);
		
		autor = new JLabel("New label");
		autor.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		autor.setBounds(198, 36, 87, 14);
		add(autor);
		
		editorial = new JLabel("New label");
		editorial.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		editorial.setBounds(198, 61, 87, 14);
		add(editorial);
		
		edicion = new JLabel("New label");
		edicion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		edicion.setBounds(198, 86, 87, 14);
		add(edicion);
		
		persona = new JLabel("Prestado a: ");
		persona.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		persona.setBounds(198, 110, 87, 14);
		add(persona);
		
		Descripcion = new JLabel("Descripci\u00F3n");
		Descripcion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		Descripcion.setBounds(198, 135, 87, 14);
		add(Descripcion);
		
		textitulo = new JTextField();
		textitulo.setFont(new Font("Calibri", Font.ITALIC, 11));
		textitulo.setEditable(false);
		textitulo.setBounds(298, 8, 226, 20);
		add(textitulo);
		textitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setFont(new Font("Calibri", Font.ITALIC, 11));
		textAutor.setEditable(false);
		textAutor.setColumns(10);
		textAutor.setBounds(298, 33, 226, 20);
		add(textAutor);
		
		texEditorial = new JTextField();
		texEditorial.setFont(new Font("Calibri", Font.ITALIC, 11));
		texEditorial.setEditable(false);
		texEditorial.setColumns(10);
		texEditorial.setBounds(298, 58, 226, 20);
		add(texEditorial);
		
		textedicion = new JTextField();
		textedicion.setFont(new Font("Calibri", Font.ITALIC, 11));
		textedicion.setEditable(false);
		textedicion.setColumns(10);
		textedicion.setBounds(298, 83, 226, 20);
		add(textedicion);
		
		textPersona = new JTextField();
		textPersona.setFont(new Font("Calibri", Font.ITALIC, 11));
		textPersona.setEditable(false);
		textPersona.setColumns(10);
		textPersona.setBounds(298, 107, 226, 20);
		add(textPersona);
		
		textDescripcion = new JEditorPane();
		textDescripcion.setEditable(false);
		textDescripcion.setFont(new Font("Calibri", Font.ITALIC, 11));
		textDescripcion.setBounds(198, 160, 326, 67);
		add(textDescripcion);
		
		portada = null;
		ponerEstrellas(pArticulo.getCalificacion());
		mostrarInformacion(pArticulo, pCategoria);
	}

	public panelArticulo(int y, Prestamo pPrestamo, int pCategoria) 
	{
		portada = new ImageIcon(pathImagenes+pPrestamo.getMiArticulo().getImagen());
		setBounds(new Rectangle(0, y, 534, 267));
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		titulo = new JLabel("New label");
		titulo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		titulo.setBounds(198, 11, 87, 14);
		add(titulo);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 165, 265);
		lblNewLabel.setIcon(new ImageIcon(portada.getImage().getScaledInstance(164, 265, Image.SCALE_SMOOTH)));
		add(lblNewLabel);
		
		autor = new JLabel("New label");
		autor.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		autor.setBounds(198, 36, 87, 14);
		add(autor);
		
		editorial = new JLabel("New label");
		editorial.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		editorial.setBounds(198, 61, 87, 14);
		add(editorial);
		
		edicion = new JLabel("New label");
		edicion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		edicion.setBounds(198, 86, 87, 14);
		add(edicion);
		
		persona = new JLabel("Prestado a: ");
		persona.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		persona.setBounds(198, 110, 87, 14);
		add(persona);
		
		Descripcion = new JLabel("New label");
		Descripcion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		Descripcion.setBounds(198, 135, 87, 14);
		add(Descripcion);
		
		textitulo = new JTextField();
		textitulo.setBounds(298, 8, 226, 20);
		add(textitulo);
		textitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(298, 33, 226, 20);
		add(textAutor);
		
		texEditorial = new JTextField();
		texEditorial.setColumns(10);
		texEditorial.setBounds(298, 58, 226, 20);
		add(texEditorial);
		
		textedicion = new JTextField();
		textedicion.setColumns(10);
		textedicion.setBounds(298, 83, 226, 20);
		add(textedicion);
		
		textPersona = new JTextField();
		textPersona.setColumns(10);
		textPersona.setBounds(298, 107, 226, 20);
		add(textPersona);
		
		textDescripcion = new JEditorPane();
		textDescripcion.setBounds(198, 160, 326, 67);
		add(textDescripcion);
		mostrarInformacion(pPrestamo.getMiArticulo(), pCategoria);
		persona.setVisible(true);
		textPersona.setText(pPrestamo.getMiPersona().getNombre() + " " +pPrestamo.getMiPersona().getApellido1());
		textPersona.setVisible(true);
		ponerEstrellas(pPrestamo.getMiArticulo().getCalificacion());
		portada = null;
	}
	
	private void ponerEstrellas(int pCalificacion)
	{
		int x=196;
		for(int i = 0;i< pCalificacion;i++)
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(panelArticulo.class.getResource("/Recursos/ImagenesGUI/star.png")));
			label.setBounds(x, 238, 16, 14);
			add(label);
			x+=25;
		}
	}
	
	private void mostrarInformacion(Articulo pArticulo, int pCategoria)
	{
		if(pCategoria == 0)
		{
			titulo.setText("Titulo: ");
			autor.setText("Autor: ");
			editorial.setText("Editorial: ");
			edicion.setText("Edición: ");
			textitulo.setText(pArticulo.getNombre());
			textAutor.setText(((Libro)pArticulo).getAutor());
			texEditorial.setText(((Libro)pArticulo).geteditorial());
			textedicion.setText(((Libro)pArticulo).getEdicion());
			persona.setVisible(false);
			textPersona.setVisible(false);
			Descripcion.setVisible(false);
			textDescripcion.setVisible(false);
		}
		else if(pCategoria == 1)
		{
			titulo.setText("Nombre: ");
			autor.setText("Creador: ");
			editorial.setText("Editorial: ");
			edicion.setText("Edición: ");
			textitulo.setText(pArticulo.getNombre());
			textAutor.setText(((Libro)pArticulo).getAutor());
			texEditorial.setText(((Libro)pArticulo).geteditorial());
			textedicion.setText(((Libro)pArticulo).getEdicion());
			persona.setVisible(false);
			textPersona.setVisible(false);
			Descripcion.setVisible(false);
			textDescripcion.setVisible(false);
		}
		else if(pCategoria == 2)
		{
			titulo.setText("Nombre: ");
			autor.setText("Director: ");
			editorial.setText("Categoria: ");
			edicion.setVisible(false);
			textitulo.setText(pArticulo.getNombre());
			textAutor.setText(((Pelicula)pArticulo).getDirector());
			texEditorial.setText(((Pelicula)pArticulo).getCategoria());
			textedicion.setVisible(false);
			persona.setVisible(false);
			textPersona.setVisible(false);
			Descripcion.setVisible(false);
			textDescripcion.setVisible(false);
		}
		else
		{
			titulo.setText("Nombre: ");
			autor.setVisible(false);
			editorial.setVisible(false);
			edicion.setVisible(false);
			textitulo.setText(pArticulo.getNombre());
			textAutor.setVisible(false);
			texEditorial.setVisible(false);
			textedicion.setVisible(false);
			persona.setVisible(false);
			textPersona.setVisible(false);
			textDescripcion.setText(((Otro)pArticulo).getDescripcion());
		}
	}
	
}
