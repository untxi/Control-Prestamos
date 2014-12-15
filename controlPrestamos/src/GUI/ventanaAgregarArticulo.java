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
import java.awt.Color;
import java.awt.Font;
/**
 * Clase ventanaAgregarArticulo
 * 
 * Contiene informaci�n de la ventana agregar articulo 
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
	 * edici�n del articulo
	 */
	private JTextField filedEdicion;
	/**
	 * descripci�n del articulo
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
	 * editorial del art�culo
	 */
	private JTextField fieldEditorial;
	/**
	 * categor�a del art�culo
	 */
	private JComboBox comboBoxCategoria;
	/**
	 * calificaci�n del art�culo
	 */
	private JComboBox comboBoxCalificacion;
	
	//m�todo publico
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
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Ingresar Art\u00EDculo");
		setFrameIcon(new ImageIcon(ventanaAgregarArticulo.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 450, 482);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categor\u00EDa");
		lblSeleccioneLaCategoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblSeleccioneLaCategoria.setBounds(10, 11, 143, 14);
		
		comboBoxSelecCategoria = new JComboBox();
		comboBoxSelecCategoria.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxSelecCategoria.setBounds(218, 11, 205, 29);
		comboBoxSelecCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentana(comboBoxSelecCategoria.getSelectedIndex());	
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.setBounds(332, 419, 92, 23);
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
		lblNombre.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNombre.setBounds(10, 71, 46, 14);
		
		fieldNombre = new JTextField();
		fieldNombre.setBounds(60, 68, 143, 29);
		fieldNombre.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblAutor.setBounds(221, 71, 46, 14);
		
		fieldAutor = new JTextField();
		fieldAutor.setBounds(277, 68, 152, 29);
		fieldAutor.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edici\u00F3n");
		lblEdicion.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblEdicion.setBounds(10, 186, 46, 14);
		
		filedEdicion = new JTextField();
		filedEdicion.setBounds(60, 183, 143, 28);
		filedEdicion.setColumns(10);
		
		JLabel lblCalificacion = new JLabel("Estrellas");
		lblCalificacion.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCalificacion.setBounds(221, 130, 70, 14);
		
		comboBoxCalificacion = new JComboBox();
		comboBoxCalificacion.setBounds(301, 127, 58, 29);
		comboBoxCalificacion.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 223, 104, 165);
		
		JButton btnBuscarImagen = new JButton("Buscar Imagen");
		btnBuscarImagen.setBackground(new Color(255, 153, 0));
		btnBuscarImagen.setForeground(Color.WHITE);
		btnBuscarImagen.setFont(new Font("Dialog", Font.BOLD, 11));
		btnBuscarImagen.setBounds(10, 419, 143, 23);
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
		lblDescripcion.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblDescripcion.setBounds(256, 265, 70, 14);
		
		fieldDescripcion = new JEditorPane();
		fieldDescripcion.setBounds(161, 290, 262, 112);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 153, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 11));
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
				JOptionPane.showMessageDialog(null, "Artículo Agregado con éxito");
				
			}
		});
		btnAceptar.setBounds(187, 419, 92, 23);
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
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCategoria.setBounds(218, 186, 73, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblEditorial.setBounds(10, 130, 46, 14);
		getContentPane().add(lblEditorial);
		
		fieldEditorial = new JTextField();
		fieldEditorial.setBounds(66, 127, 134, 29);
		getContentPane().add(fieldEditorial);
		fieldEditorial.setColumns(10);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Acci\u00F3n ", "Suspenso", "Terror", "Comedia", "Ciencia Ficci\u00F3n", "Animada"}));
		comboBoxCategoria.setBounds(301, 183, 121, 29);
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
