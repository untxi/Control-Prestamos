package GUI;



import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import Administradores.administradorAplicacion;
import Estructuras.Articulo;
import Estructuras.Libro;
import Estructuras.Otro;
import Estructuras.Pelicula;
import Interfaces.IConstantes;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
/**
 * Clase ventanaAgregarArticulo
 * 
 * Contiene información de la ventana agregar articulo 
 * 
 * @author Marco
 *
 */
public class ventanaEditarArticulo extends JInternalFrame implements IConstantes 
{
	//Atributos
	/**
	 * Ventana agregar persona
	 */
	private static ventanaEditarArticulo miVentanaEditarArticulo;
	/**
	 * 
	 */
	private JComboBox comboBox;
	/**
	 * nombre del articulo
	 */
	private JTextField nombre;
	/**
	 * autor del articulo
	 */
	private JTextField autor;
	/**
	 * edicion del articulo
	 */
	private JTextField edicion;
	/**
	 * descripcion del articulo
	 */
	JEditorPane descripcion;
	/**
	 * nombre de la imagen
	 */
	private Articulo miArticulo;
	/**
	 *ventana buscador 
	 */
	private JFileChooser ventaBuscador;
	/**
	 * nueva etiqueta
	 */
	private JLabel lblNewLabel_1;
	/**
	 * etiqueta
	 */
	private JLabel label;
	/**
	 * editorial del articulo
	 */
	private JTextField editorial;
	/**
	 * categoria del articulo
	 */
	private JComboBox categoria;
	/**
	 * calificación del articulo
	 */
	private JComboBox calificacion;
	/**
	 * barra
	 */
	private JProgressBar progressBar;
	
	
	private JComboBox comboBox_1;
	
	//metodo publico
	/**
	 * Abre la ventana agregar articulo
	 * @return miVentanaAgregarArticulo
	 */
	public static ventanaEditarArticulo getInstance()
	{
		if(miVentanaEditarArticulo == null)
		{
			miVentanaEditarArticulo =  new ventanaEditarArticulo();
		}
		return miVentanaEditarArticulo;
	}


	/**
	 * Create the frame.
	 */
	private ventanaEditarArticulo()
	{
		setTitle("Mea Providere - Actualizar Articulo");
		setFrameIcon(new ImageIcon(ventanaEditarArticulo.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 450, 482);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categoria");
		lblSeleccioneLaCategoria.setBounds(10, 11, 119, 14);
		
		comboBox = new JComboBox();
		comboBox.setBounds(218, 11, 205, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
					if(!administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(i).isPrestado())
					{
						categorias[i] = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(i).getNombre();
					}
				}
				comboBox_1.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(349, 419, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cambiarVentana(comboBox.getSelectedIndex());
				nombre.setText("");
				autor.setText("");
				edicion.setText("");
				editorial.setText("");
				descripcion.setText("");
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 100, 46, 14);
		
		nombre = new JTextField();
		nombre.setBounds(60, 97, 143, 20);
		nombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(218, 100, 46, 14);
		
		autor = new JTextField();
		autor.setBounds(271, 97, 152, 20);
		autor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edicion");
		lblNewLabel_2.setBounds(10, 186, 46, 14);
		
		edicion = new JTextField();
		edicion.setBounds(60, 183, 143, 20);
		edicion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Calificacion");
		lblNewLabel_3.setBounds(218, 137, 70, 14);
		
		calificacion = new JComboBox();
		calificacion.setBounds(298, 134, 121, 20);
		calificacion.setModel(new DefaultComboBoxModel(new String[] {"1 Estrella", "2 Estrellas", "3 Estrellas", "4 Estrellas", "5 Estrellas", "6 Estrellas", "7 Estrellas", "8 Estrellas", "9 Estrellas", "10 Estrellas"}));
		
		label = new JLabel("");
		label.setBounds(10, 223, 104, 165);
		
		JButton btnNewButton = new JButton("Buscar Imagen");
		btnNewButton.setBounds(10, 419, 104, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				int respuesta = ventaBuscador.showOpenDialog(miVentanaEditarArticulo);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        	//progressBar.setVisible(true);
		        	//progressBar.setBorderPainted(true);
		        	//repaint();
		        	///////////////////////////////////////////////
        			try {
        				
        				//progressBar.
		        		File nuevoArchivo = ventaBuscador.getSelectedFile();
		        		FileInputStream fregis = new FileInputStream(nuevoArchivo.getAbsolutePath());
		        		FileOutputStream fsalida = new FileOutputStream(pathImagenes + nuevoArchivo.getName(), true);
		        	
		        		int b = fregis.read();
		        		while (b != -1) 
		        		{
		        			fsalida.write(b);
							b = fregis.read();
		        		}

		        		fsalida.flush();
		        		fsalida.close();
		        		fregis.close();
						miArticulo.setImagen(nuevoArchivo.getName());
						ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
						label.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		        		
		        		
		        		
						} catch (IOException e) 
        			{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
			        }		
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n");
		lblNewLabel_4.setBounds(272, 265, 54, 14);
		
		descripcion = new JEditorPane();
		descripcion.setBounds(161, 290, 262, 112);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (comboBox.getSelectedIndex() == categoriaLibro)
				{
					miArticulo.setNombre(nombre.getText());
					miArticulo.setCalificacion(calificacion.getSelectedIndex()+1);
					((Libro)miArticulo).setAutor(autor.getText());
					((Libro)miArticulo).setEdicion(edicion.getText());
					((Libro)miArticulo).seteditorial(editorial.getText());
				}
				else if(comboBox.getSelectedIndex() == categoriaRevista)
				{	
					miArticulo.setNombre(nombre.getText());
					miArticulo.setCalificacion(calificacion.getSelectedIndex()+1);
					((Libro)miArticulo).setAutor(autor.getText());
					((Libro)miArticulo).setEdicion(edicion.getText());
					((Libro)miArticulo).seteditorial(editorial.getText());
				}
				else if (comboBox.getSelectedIndex() == categoriaPelicula)
				{			
					miArticulo.setNombre(nombre.getText());
					miArticulo.setCalificacion(calificacion.getSelectedIndex()+1);
					((Pelicula)miArticulo).setDirector(autor.getText());
					((Pelicula)miArticulo).setCategoria(categoria.getSelectedItem().toString());
				}
				else
				{
					miArticulo.setNombre(nombre.getText());
					miArticulo.setCalificacion(calificacion.getSelectedIndex()+1);
					((Otro)miArticulo).setDescripcion(descripcion.getText());
				}
				cambiarVentana(comboBox.getSelectedIndex());
				nombre.setText("");
				autor.setText("");
				edicion.setText("");
				editorial.setText("");
				descripcion.setText("");
				administradorAplicacion.getInstance().imprimirListaCategorias();
			}
		});
		btnNewButton_1.setBounds(196, 419, 71, 23);
		getContentPane().setLayout(null);
		getContentPane().add(lblSeleccioneLaCategoria);
		getContentPane().add(comboBox);
		getContentPane().add(lblNewLabel);
		getContentPane().add(nombre);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(autor);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(edicion);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(calificacion);
		getContentPane().add(label);
		getContentPane().add(descripcion);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);
		getContentPane().add(btnCancelar);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(218, 186, 54, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(10, 137, 46, 14);
		getContentPane().add(lblEditorial);
		
		editorial = new JTextField();
		editorial.setBounds(60, 134, 134, 20);
		getContentPane().add(editorial);
		editorial.setColumns(10);
		
		categoria = new JComboBox();
		categoria.setModel(new DefaultComboBoxModel(new String[] {"Accion ", "Suspenso", "Terror", "Comedia", "Infantil"}));
		categoria.setBounds(301, 183, 121, 20);
		getContentPane().add(categoria);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 394, 104, 14);
		//progressBar.setVisible(false);
		getContentPane().add(progressBar);
		
		JLabel lblSeleccioneElArticulo = new JLabel("Seleccione el articulo");
		lblSeleccioneElArticulo.setBounds(10, 61, 119, 14);
		getContentPane().add(lblSeleccioneElArticulo);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				escogerArticulo();
			}
		});
		comboBox_1.setBounds(218, 58, 205, 20);
		getContentPane().add(comboBox_1);
		
		ventaBuscador = new JFileChooser();
		
		
		
	}
	
	
	private void cambiarVentana(int pCategoria)
	{
		if(pCategoria == categoriaLibro)
		{
			lblNewLabel_1.setText("Autor");
			nombre.setEnabled(true);
			autor.setEnabled(true);
			edicion.setEnabled(true);
			editorial.setEnabled(true);
			
			
			nombre.setText(miArticulo.getNombre());
			autor.setText(((Libro)miArticulo).getAutor());
			edicion.setText(((Libro)miArticulo).getEdicion());
			editorial.setText(((Libro)miArticulo).geteditorial());
			calificacion.setSelectedIndex(miArticulo.getCalificacion()-1);

			
			descripcion.setEnabled(false);
			categoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			label.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			
		}
		else if(pCategoria == categoriaRevista)
		{
			lblNewLabel_1.setText("Creador");
			nombre.setEnabled(true);
			autor.setEnabled(true);
			edicion.setEnabled(true);
			editorial.setEnabled(true);
			
			nombre.setText(miArticulo.getNombre());
			autor.setText(((Libro)miArticulo).getAutor());
			edicion.setText(((Libro)miArticulo).getEdicion());
			editorial.setText(((Libro)miArticulo).geteditorial());
			calificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			
			descripcion.setEnabled(false);
			categoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			label.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else if(pCategoria == categoriaPelicula)
		{
			lblNewLabel_1.setText("Director");
			nombre.setEnabled(true);
			autor.setEnabled(true);

			nombre.setText(miArticulo.getNombre());
			autor.setText(((Pelicula)miArticulo).getDirector());
			calificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			categoria.setSelectedItem(((Pelicula)miArticulo).getCategoria());
			
			edicion.setEnabled(false);
			editorial.setEnabled(false);
			descripcion.setEnabled(false);
			categoria.setEnabled(true);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			label.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else
		{
			nombre.setEnabled(true);
			autor.setEnabled(false);
			edicion.setEnabled(false);
			editorial.setEnabled(false);
			descripcion.setEnabled(true);
			
			nombre.setText(miArticulo.getNombre());
			descripcion.setText(((Otro)miArticulo).getDescripcion());
			calificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			
			categoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			label.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		
	}

	
	private void escogerArticulo()
	{
		miArticulo = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(comboBox_1.getSelectedIndex());
		cambiarVentana(comboBox.getSelectedIndex());
	}
	
	
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBox.setModel(new DefaultComboBoxModel(categorias));
	}
}

