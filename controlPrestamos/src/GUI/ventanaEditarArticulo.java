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
	private JComboBox comboBoxSeleccCategoria;
	/**
	 * nombre del articulo
	 */
	private JTextField fieldNombre;
	/**
	 * autor del articulo
	 */
	private JTextField fieldAutor;
	/**
	 * edicion del articulo
	 */
	private JTextField fieldEdicion;
	/**
	 * descripcion del articulo
	 */
	JEditorPane fieldDescripcion;
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
	private JLabel lblAutor;
	/**
	 * etiqueta
	 */
	private JLabel lblImagen;
	/**
	 * editorial del articulo
	 */
	private JTextField fieldEditorial;
	/**
	 * categoria del articulo
	 */
	private JComboBox comboBoxCategoria;
	/**
	 * calificación del articulo
	 */
	private JComboBox comboBoxCalificacion;
	
	
	private JComboBox comboBoxSeleccArticulo;
	
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
		setTitle("Mea Providere - Actualizar Art\u00EDculo");
		setFrameIcon(new ImageIcon(ventanaEditarArticulo.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 450, 482);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categor\u00EDa");
		lblSeleccioneLaCategoria.setBounds(10, 11, 119, 14);
		
		comboBoxSeleccCategoria = new JComboBox();
		comboBoxSeleccCategoria.setBounds(218, 11, 205, 20);
		comboBoxSeleccCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxSeleccCategoria.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
					if(!administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxSeleccCategoria.getSelectedIndex()).get(i).isPrestado())
					{
						categorias[i] = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxSeleccCategoria.getSelectedIndex()).get(i).getNombre();
					}
				}
				comboBoxSeleccArticulo.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(349, 419, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cambiarVentana(comboBoxSeleccCategoria.getSelectedIndex());
				fieldNombre.setText("");
				fieldAutor.setText("");
				fieldEdicion.setText("");
				fieldEditorial.setText("");
				fieldDescripcion.setText("");
				setVisible(false);
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 100, 46, 14);
		
		fieldNombre = new JTextField();
		fieldNombre.setBounds(60, 97, 143, 20);
		fieldNombre.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(218, 100, 46, 14);
		
		fieldAutor = new JTextField();
		fieldAutor.setBounds(271, 97, 152, 20);
		fieldAutor.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edici\u00F3n");
		lblEdicion.setBounds(10, 186, 46, 14);
		
		fieldEdicion = new JTextField();
		fieldEdicion.setBounds(60, 183, 143, 20);
		fieldEdicion.setColumns(10);
		
		JLabel lblCalificacion = new JLabel("Calificaci\u00F3n");
		lblCalificacion.setBounds(218, 137, 70, 14);
		
		comboBoxCalificacion = new JComboBox();
		comboBoxCalificacion.setBounds(298, 134, 121, 20);
		comboBoxCalificacion.setModel(new DefaultComboBoxModel(new String[] {"\"Seleccione\"", "1 Estrella", "2 Estrellas", "3 Estrellas", "4 Estrellas", "5 Estrellas", "6 Estrellas", "7 Estrellas", "8 Estrellas", "9 Estrellas", "10 Estrellas"}));
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 223, 104, 165);
		
		JButton btnBuscarImagen = new JButton("Buscar Imagen");
		btnBuscarImagen.setBounds(10, 419, 104, 23);
		btnBuscarImagen.addActionListener(new ActionListener() {
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
						lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		        		
		        		
		        		
						} catch (IOException e) 
        			{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
			        }		
			}
		});
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(272, 265, 54, 14);
		
		fieldDescripcion = new JEditorPane();
		fieldDescripcion.setBounds(161, 290, 262, 112);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (comboBoxSeleccCategoria.getSelectedIndex() == categoriaLibro)
				{
					miArticulo.setNombre(fieldNombre.getText());
					miArticulo.setCalificacion(comboBoxCalificacion.getSelectedIndex()+1);
					((Libro)miArticulo).setAutor(fieldAutor.getText());
					((Libro)miArticulo).setEdicion(fieldEdicion.getText());
					((Libro)miArticulo).seteditorial(fieldEditorial.getText());
				}
				else if(comboBoxSeleccCategoria.getSelectedIndex() == categoriaRevista)
				{	
					miArticulo.setNombre(fieldNombre.getText());
					miArticulo.setCalificacion(comboBoxCalificacion.getSelectedIndex()+1);
					((Libro)miArticulo).setAutor(fieldAutor.getText());
					((Libro)miArticulo).setEdicion(fieldEdicion.getText());
					((Libro)miArticulo).seteditorial(fieldEditorial.getText());
				}
				else if (comboBoxSeleccCategoria.getSelectedIndex() == categoriaPelicula)
				{			
					miArticulo.setNombre(fieldNombre.getText());
					miArticulo.setCalificacion(comboBoxCalificacion.getSelectedIndex()+1);
					((Pelicula)miArticulo).setDirector(fieldAutor.getText());
					((Pelicula)miArticulo).setCategoria(comboBoxCategoria.getSelectedItem().toString());
				}
				else
				{
					miArticulo.setNombre(fieldNombre.getText());
					miArticulo.setCalificacion(comboBoxCalificacion.getSelectedIndex()+1);
					((Otro)miArticulo).setDescripcion(fieldDescripcion.getText());
				}
				cambiarVentana(comboBoxSeleccCategoria.getSelectedIndex());
				fieldNombre.setText("");
				fieldAutor.setText("");
				fieldEdicion.setText("");
				fieldEditorial.setText("");
				fieldDescripcion.setText("");
				administradorAplicacion.getInstance().imprimirListaCategorias();
			}
		});
		btnEditar.setBounds(196, 419, 71, 23);
		getContentPane().setLayout(null);
		getContentPane().add(lblSeleccioneLaCategoria);
		getContentPane().add(comboBoxSeleccCategoria);
		getContentPane().add(lblNombre);
		getContentPane().add(fieldNombre);
		getContentPane().add(lblAutor);
		getContentPane().add(fieldAutor);
		getContentPane().add(lblEdicion);
		getContentPane().add(fieldEdicion);
		getContentPane().add(lblDescripcion);
		getContentPane().add(lblCalificacion);
		getContentPane().add(comboBoxCalificacion);
		getContentPane().add(lblImagen);
		getContentPane().add(fieldDescripcion);
		getContentPane().add(btnBuscarImagen);
		getContentPane().add(btnEditar);
		getContentPane().add(btnCancelar);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(218, 186, 54, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(10, 137, 46, 14);
		getContentPane().add(lblEditorial);
		
		fieldEditorial = new JTextField();
		fieldEditorial.setBounds(60, 134, 134, 20);
		getContentPane().add(fieldEditorial);
		fieldEditorial.setColumns(10);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"\"Seleccione\"", "Acci\u00F3n ", "Suspenso", "Terror", "Comedia", "Ciencia Ficci\u00F3n", "Animada"}));
		comboBoxCategoria.setBounds(301, 183, 121, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblSeleccioneElArticulo = new JLabel("Seleccione el art\u00EDculo");
		lblSeleccioneElArticulo.setBounds(10, 61, 119, 14);
		getContentPane().add(lblSeleccioneElArticulo);
		
		comboBoxSeleccArticulo = new JComboBox();
		comboBoxSeleccArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				escogerArticulo();
			}
		});
		comboBoxSeleccArticulo.setBounds(218, 58, 205, 20);
		getContentPane().add(comboBoxSeleccArticulo);
		
		ventaBuscador = new JFileChooser();
		
		
		
	}
	
	
	private void cambiarVentana(int pCategoria)
	{
		if(pCategoria == categoriaLibro)
		{
			lblAutor.setText("Autor");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);
			fieldEdicion.setEnabled(true);
			fieldEditorial.setEnabled(true);
			
			
			fieldNombre.setText(miArticulo.getNombre());
			fieldAutor.setText(((Libro)miArticulo).getAutor());
			fieldEdicion.setText(((Libro)miArticulo).getEdicion());
			fieldEditorial.setText(((Libro)miArticulo).geteditorial());
			comboBoxCalificacion.setSelectedIndex(miArticulo.getCalificacion()-1);

			
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			
		}
		else if(pCategoria == categoriaRevista)
		{
			lblAutor.setText("Creador");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);
			fieldEdicion.setEnabled(true);
			fieldEditorial.setEnabled(true);
			
			fieldNombre.setText(miArticulo.getNombre());
			fieldAutor.setText(((Libro)miArticulo).getAutor());
			fieldEdicion.setText(((Libro)miArticulo).getEdicion());
			fieldEditorial.setText(((Libro)miArticulo).geteditorial());
			comboBoxCalificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else if(pCategoria == categoriaPelicula)
		{
			lblAutor.setText("Director");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);

			fieldNombre.setText(miArticulo.getNombre());
			fieldAutor.setText(((Pelicula)miArticulo).getDirector());
			comboBoxCalificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			comboBoxCategoria.setSelectedItem(((Pelicula)miArticulo).getCategoria());
			
			fieldEdicion.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(true);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else
		{
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(false);
			fieldEdicion.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldDescripcion.setEnabled(true);
			
			fieldNombre.setText(miArticulo.getNombre());
			fieldDescripcion.setText(((Otro)miArticulo).getDescripcion());
			comboBoxCalificacion.setSelectedIndex(miArticulo.getCalificacion()-1);
			
			comboBoxCategoria.setEnabled(false);
			ImageIcon portada = new ImageIcon(pathImagenes + miArticulo.getImagen());
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		
	}

	
	private void escogerArticulo()
	{
		miArticulo = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxSeleccCategoria.getSelectedIndex()).get(comboBoxSeleccArticulo.getSelectedIndex());
		cambiarVentana(comboBoxSeleccCategoria.getSelectedIndex());
	}
	
	
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBoxSeleccCategoria.setModel(new DefaultComboBoxModel(categorias));
	}
}

