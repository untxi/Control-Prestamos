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
public class ventanaAgregarArticulo extends JInternalFrame implements IConstantes 
{
	//Atributos
	/**
	 * Ventana agregar persona
	 */
	private static ventanaAgregarArticulo miVentanaAgregarArticulo;
	/**
	 * 
	 */
	private JComboBox comboBoxSelecCategoria;
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
	private JTextField filedEdicion;
	/**
	 * descripcion del articulo
	 */
	JEditorPane fieldDescripcion;
	/**
	 * nombre de la imagen
	 */
	private String nombreImagen;
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
	
	//metodo publico
	/**
	 * Abre la ventana agregar articulo
	 * @return miVentanaAgregarArticulo
	 */
	public static ventanaAgregarArticulo getInstance()
	{
		if(miVentanaAgregarArticulo == null)
		{
			miVentanaAgregarArticulo = new ventanaAgregarArticulo();
		}
		return miVentanaAgregarArticulo;
	}

	/**
	 * Create the frame.
	 */
	public ventanaAgregarArticulo()
	{
		setTitle("Mea Providere - Ingresar Art\u00EDculo");
		setFrameIcon(new ImageIcon(ventanaAgregarArticulo.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 450, 482);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categor\u00EDa");
		lblSeleccioneLaCategoria.setBounds(10, 11, 119, 14);
		
		comboBoxSelecCategoria = new JComboBox();
		comboBoxSelecCategoria.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxSelecCategoria.setBounds(218, 11, 205, 20);
		comboBoxSelecCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentana(comboBoxSelecCategoria.getSelectedIndex());	
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(349, 419, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cambiarVentana(0);
				comboBoxSelecCategoria.setSelectedIndex(0);
				fieldNombre.setText("");
				fieldAutor.setText("");
				filedEdicion.setText("");
				fieldEditorial.setText("");
				fieldDescripcion.setText("");
				setVisible(false);
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 71, 46, 14);
		
		fieldNombre = new JTextField();
		fieldNombre.setBounds(60, 68, 143, 20);
		fieldNombre.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(221, 71, 46, 14);
		
		fieldAutor = new JTextField();
		fieldAutor.setBounds(277, 68, 152, 20);
		fieldAutor.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edici\u00F3n");
		lblEdicion.setBounds(10, 186, 46, 14);
		
		filedEdicion = new JTextField();
		filedEdicion.setBounds(60, 183, 143, 20);
		filedEdicion.setColumns(10);
		
		JLabel lblCalificacion = new JLabel("Calificaci\u00F3n");
		lblCalificacion.setBounds(221, 130, 70, 14);
		
		comboBoxCalificacion = new JComboBox();
		comboBoxCalificacion.setBounds(301, 127, 121, 20);
		comboBoxCalificacion.setModel(new DefaultComboBoxModel(new String[] {"\"Seleccione\"", "1 Estrella", "2 Estrellas", "3 Estrellas", "4 Estrellas", "5 Estrellas", "6 Estrellas", "7 Estrellas", "8 Estrellas", "9 Estrellas", "10 Estrellas"}));
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 223, 104, 165);
		
		JButton btnBuscarImagen = new JButton("Buscar Imagen");
		btnBuscarImagen.setBounds(10, 419, 104, 23);
		btnBuscarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				int respuesta = ventaBuscador.showOpenDialog(miVentanaAgregarArticulo);
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
						nombreImagen = nuevoArchivo.getName();
						ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (comboBoxSelecCategoria.getSelectedIndex() == categoriaLibro)
				{
					if(!fieldNombre.getText().isEmpty() && !fieldAutor.getText().isEmpty() && !filedEdicion.getText().isEmpty() &&
							!fieldEditorial.getText().isEmpty() )
					{
						administradorAplicacion.getInstance().agregarLibro(fieldNombre.getText(), fieldAutor.getText(), fieldEditorial.getText(),
																		   filedEdicion.getText(), comboBoxCalificacion.getSelectedIndex(),
																		   nombreImagen);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debe llenar todo el formulario");
					}
				}
				else if(comboBoxSelecCategoria.getSelectedIndex() == categoriaRevista)
				{	
					if(!fieldNombre.getText().isEmpty() && !fieldAutor.getText().isEmpty() && !filedEdicion.getText().isEmpty() &&
						!fieldEditorial.getText().isEmpty() )
					{
						administradorAplicacion.getInstance().agregarRevista(fieldNombre.getText(), fieldAutor.getText(), fieldEditorial.getText(),
								   filedEdicion.getText(), comboBoxCalificacion.getSelectedIndex(),
								   nombreImagen);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debe llenar todo el formulario");
					}
				}
				else if (comboBoxSelecCategoria.getSelectedIndex() == categoriaPelicula)
				{			
					if(!fieldNombre.getText().isEmpty() && !fieldAutor.getText().isEmpty() )
					{
						administradorAplicacion.getInstance().agregarPelicula(fieldNombre.getText(), comboBoxCalificacion.getSelectedIndex(),
																			  nombreImagen, fieldAutor.getText(), 
																			  comboBoxCategoria.getSelectedItem().toString());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debe llenar todo el formulario");
					}
				}
				else
				{
					if(!fieldNombre.getText().isEmpty() && !fieldDescripcion.getText().isEmpty() )
					{
						administradorAplicacion.getInstance().agregarOtro(fieldNombre.getText(), comboBoxCalificacion.getSelectedIndex(), nombreImagen,
																		  fieldDescripcion.getText(), comboBoxSelecCategoria.getSelectedIndex());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debe llenar todo el formulario");
					}
				}
				cambiarVentana(0);
				comboBoxSelecCategoria.setSelectedIndex(0);
				fieldNombre.setText("");
				fieldAutor.setText("");
				filedEdicion.setText("");
				fieldEditorial.setText("");
				fieldDescripcion.setText("");
				administradorAplicacion.getInstance().imprimirListaCategorias();
			}
		});
		btnAceptar.setBounds(196, 419, 71, 23);
		getContentPane().setLayout(null);
		getContentPane().add(lblSeleccioneLaCategoria);
		getContentPane().add(comboBoxSelecCategoria);
		getContentPane().add(lblNombre);
		getContentPane().add(fieldNombre);
		getContentPane().add(lblAutor);
		getContentPane().add(fieldAutor);
		getContentPane().add(lblEdicion);
		getContentPane().add(filedEdicion);
		getContentPane().add(lblDescripcion);
		getContentPane().add(lblCalificacion);
		getContentPane().add(comboBoxCalificacion);
		getContentPane().add(lblImagen);
		getContentPane().add(fieldDescripcion);
		getContentPane().add(btnBuscarImagen);
		getContentPane().add(btnAceptar);
		getContentPane().add(btnCancelar);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(218, 186, 54, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(10, 130, 46, 14);
		getContentPane().add(lblEditorial);
		
		fieldEditorial = new JTextField();
		fieldEditorial.setBounds(66, 127, 134, 20);
		getContentPane().add(fieldEditorial);
		fieldEditorial.setColumns(10);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"\"Seleccione\"", "Acci\u00F3n ", "Suspenso", "Terror", "Comedia", "Ciencia Ficci\u00F3n", "Animada"}));
		comboBoxCategoria.setBounds(301, 183, 121, 20);
		getContentPane().add(comboBoxCategoria);
		
		ventaBuscador = new JFileChooser();
		
		
		
	}
	
	
	private void cambiarVentana(int pCategoria)
	{
		if(pCategoria == categoriaLibro)
		{
			lblAutor.setText("Autor");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);
			filedEdicion.setEnabled(true);
			fieldEditorial.setEnabled(true);
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(false);
			nombreImagen = imagenLibro;
			ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			
		}
		else if(pCategoria == categoriaRevista)
		{
			lblAutor.setText("Creador");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);
			filedEdicion.setEnabled(true);
			fieldEditorial.setEnabled(true);
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(false);
			nombreImagen = imagenRevista;
			ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else if(pCategoria == categoriaPelicula)
		{
			lblAutor.setText("Director");
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(true);
			filedEdicion.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldDescripcion.setEnabled(false);
			comboBoxCategoria.setEnabled(true);
			nombreImagen = imagenPelicula;
			ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		else
		{
			fieldNombre.setEnabled(true);
			fieldAutor.setEnabled(false);
			filedEdicion.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldDescripcion.setEnabled(true);
			comboBoxCategoria.setEnabled(false);
			nombreImagen = imagenArticulo;
			ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
			lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		}
		
	}
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBoxSelecCategoria.setModel(new DefaultComboBoxModel(categorias));
	}
}
