
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JToolBar;

import Administradores.administradorAplicacion;
import Estructuras.Articulo;
import Interfaces.IConstantes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.SystemColor;
import java.awt.ScrollPane;
import java.awt.Point;

import net.miginfocom.swing.MigLayout;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.util.ArrayList;

/**
 * Clase ventanaPrincipal
 * 
 * Contiene información de lo que hay en la ventana principal
 * 
 * @author Adrián
 *
 */
public class ventanaPrincipal extends JFrame implements IConstantes 
{
	//Atributos
	/**
	 * ventana de escritorio
	 */
	private JDesktopPane escritorio;
	/**
	 * Menu del Registro
	 */
	private JMenu menuRegistro;
	/**
	 * Menu de Configuracion
	 */
	private JMenu menuConfiguracion;
	/**
	 * Menu de Agregar
	 */
	private JMenu menuAgregar;
	/**
	 * Menu de Consulta
	 */
	private JMenu menuConsultar;
	/**
	 * Menu Salir
	 */
	private JMenu menuSalir;
	/**
	 * Nuevo panel
	 */
	private JPanel panel = new JPanel();
	/**
	 * Nueva etiqueta
	 */
	private JLabel lblNewLabel;
	/**
	 * ventana buscador
	 */
	private JFileChooser ventaBuscador;
	/**
	 * ventana principal
	 */
	private static ventanaPrincipal miVentanaPrincipal;
	

	//Método Público
	/**
	 * Crea la ventana principal
	 * @return miVentanaPrincipal
	 */
	
	public static ventanaPrincipal getInstance()
	{
		if(miVentanaPrincipal == null)
		{
			miVentanaPrincipal = new ventanaPrincipal();
		}
		return miVentanaPrincipal;
	}
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	//Método Privado
	/**
	 * Todo lo contenido en la ventana principal
	 */
	private ventanaPrincipal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 593);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(135, 206, 250));
		getContentPane().add(escritorio);
		
		panel.setSize(534, 5000);
		JScrollPane scrollBar = new JScrollPane(panel);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setAutoscrolls(true);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GroupLayout gl_escritorio = new GroupLayout(escritorio);
		gl_escritorio.setHorizontalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE))
		);
		gl_escritorio.setVerticalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(455))
				.addGroup(Alignment.TRAILING, gl_escritorio.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
		);
		escritorio.setLayout(gl_escritorio);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		menuBar.setAlignmentX(10.0f);
		menuBar.setAlignmentY(1.0f);
		menuBar.setBackground(new Color(100, 149, 237));
		setJMenuBar(menuBar);
		
		menuRegistro = new JMenu("");
		menuRegistro.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/lock.png")));
		menuBar.add(menuRegistro);
		
		JMenuItem mntmCrearCuenta = new JMenuItem("Crear cuenta");
		mntmCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ventanaRegistroUsuario.getInstance().setVisible(true);
			}
		});
		mntmCrearCuenta.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/user_add.png")));
		mntmCrearCuenta.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmCrearCuenta);
		
		JMenuItem mntmIniciarSecion = new JMenuItem("Iniciar Secion");
		mntmIniciarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ventanaLogin.getInstance().setVisible(true);
			}
		});
		mntmIniciarSecion.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/lock_open.png")));
		mntmIniciarSecion.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmIniciarSecion);
		
		JMenuItem mntmCerrarSecion = new JMenuItem("Cerrar Secion");
		mntmCerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//administradorAplicacion.getInstance().setUsuario(null);
				desactivarAplicacion();
			}
		});
		mntmCerrarSecion.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/lock_break.png")));
		mntmCerrarSecion.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmCerrarSecion);
		
		menuConfiguracion = new JMenu("");
		menuConfiguracion.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/gear_in.png")));
		menuBar.add(menuConfiguracion);
		
		JMenuItem mntmconfigSistema = new JMenuItem("Configurar preferencias del sistema");
		mntmconfigSistema.setIcon(new ImageIcon(imagenConfig));
		mntmconfigSistema.setBackground(new Color(100, 149, 237));
		mntmconfigSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ventanaConfiguracion n = new ventanaConfiguracion();
				escritorio.add(n);
				n.show();
				mostrarConsultaArticulos(administradorAplicacion.getInstance().getMiListaCategorias().get(0),0);
				
			}
		});
		mntmconfigSistema.addMouseListener(new MouseAdapter() {
		});
		menuConfiguracion.add(mntmconfigSistema);
		
		JMenuItem mntmConfigPrestaArticulo = new JMenuItem("Prestar Articulo");
		mntmConfigPrestaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaPrestamo.getInstance().setVisible(true);
			}
		});
		menuConfiguracion.add(mntmConfigPrestaArticulo);
		
		menuAgregar = new JMenu("");
		menuAgregar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/world_add.png")));
		menuBar.add(menuAgregar);
		
		JMenuItem mntmAgregarArticulo = new JMenuItem("Agregar articulo");
		mntmAgregarArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/installer_box.png")));
		mntmAgregarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ventanaAgregarArticulo.getInstance().cambiarComboBox();
				ventanaAgregarArticulo.getInstance().setVisible(true);
			}
		});
		mntmAgregarArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarArticulo);
		
		JMenuItem mntmAgregarPersona = new JMenuItem("Agregar persona");
		mntmAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ventanaAgregarPersona.getInstance().setVisible(true);
			}
		});
		mntmAgregarPersona.setBackground(new Color(100, 149, 237));
		mntmAgregarPersona.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/user_add.png")));
		menuAgregar.add(mntmAgregarPersona);
		
		JMenuItem mntmAgregarCategoriaArticulo = new JMenuItem("Agregar categoria articulo");
		mntmAgregarCategoriaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaAgregarCategoria.getInstance().setVisible(true);
			}
		});
		mntmAgregarCategoriaArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/package_add.png")));
		mntmAgregarCategoriaArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarCategoriaArticulo);
		
		JMenuItem mntmAgregarLibroDesde = new JMenuItem("Agregar Libros desde archivo txt");
		mntmAgregarLibroDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarLibros(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
	        }
			});
		mntmAgregarLibroDesde.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/book_add.png")));
		mntmAgregarLibroDesde.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarLibroDesde);
		
		JMenuItem mntmAgregarRevistas = new JMenuItem("Agregar revistas desde archivo txt");
		mntmAgregarRevistas.setBackground(new Color(100, 149, 237));
		mntmAgregarRevistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarRevistas(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
				// agregar revistas desde archivo txt
			}
		});
		mntmAgregarRevistas.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/book_add.png")));
		menuAgregar.add(mntmAgregarRevistas);
		
		JMenuItem mntmAgregarPeliculas = new JMenuItem("Agregar peliculas desde archivo txt");
		mntmAgregarPeliculas.setBackground(new Color(100, 149, 237));
		mntmAgregarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarPeliculas(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
			}
		});
		mntmAgregarPeliculas.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/dvd_add.png")));
		menuAgregar.add(mntmAgregarPeliculas);
		
		JMenuItem mntmAgregarPersonasDesde = new JMenuItem("Agregar personas desde archivo txt");
		mntmAgregarPersonasDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarPersonas(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
			}
		});
		mntmAgregarPersonasDesde.setBackground(new Color(100, 149, 237));
		mntmAgregarPersonasDesde.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/group_add.png")));
		menuAgregar.add(mntmAgregarPersonasDesde);
		
		menuConsultar = new JMenu("");
		menuConsultar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/table_tab_search.png")));
		menuBar.add(menuConsultar);
		
		JMenuItem mntmTopArticulo = new JMenuItem("Top 10 de articulos");
		mntmTopArticulo.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmTopArticulo);
		
		JMenuItem mntmListadoArticulos = new JMenuItem("Listado de articulos");
		mntmListadoArticulos.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmListadoArticulos);
		
		JMenuItem mntmListadoPersonalizado = new JMenuItem("Listado personalizado");
		mntmListadoPersonalizado.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmListadoPersonalizado);
		
		JMenuItem mntmListadoArticulosPrestados = new JMenuItem("Listado de articulos prestados");
		mntmListadoArticulosPrestados.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmListadoArticulosPrestados);
		
		JMenuItem mntmListadoArticuosNoPrestados = new JMenuItem("Listado de articulos no prestados");
		mntmListadoArticuosNoPrestados.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmListadoArticuosNoPrestados);
		
		menuSalir = new JMenu("");
		menuSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				System.exit(0);
			}
		});
		menuSalir.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/cross.png")));
		menuBar.add(menuSalir);
		try {
			setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventaBuscador = new JFileChooser();
		
		desactivarAplicacion();
		escritorio.add(ventanaRegistroUsuario.getInstance());
		escritorio.add(ventanaLogin.getInstance());
		escritorio.add(ventanaAgregarPersona.getInstance());
		escritorio.add(ventanaAgregarCategoria.getInstance());
		escritorio.add(ventanaAgregarArticulo.getInstance());
		escritorio.add(ventanaPrestamo.getInstance());
		
		//mostrarConsultaArticulos(10);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	//Médtodos Públicos
	/**
	 * Se activa la aplicación cuando el usuario ingresa
	 */
	public void activarAplicacion()
	{
		menuConfiguracion.setEnabled(true);
		menuAgregar.setEnabled(true);
		menuConsultar.setEnabled(true);
		lblNewLabel.setText("Bienvenido " + administradorAplicacion.getInstance().getUsuario().getNombre());
	}
	/**
	 * Se desactiva la aplicación cuando el usuario se retira
	 */
	public void desactivarAplicacion()
	{
		//menuConfiguracion.setEnabled(false);
		menuAgregar.setEnabled(false);
		menuConsultar.setEnabled(false);
		lblNewLabel.setText("");
	}
	
	//Método Privado
	/**
	 * Muestra la consulta de los articulos
	 * @param pConsulta
	 * @param pCategoria
	 */
	private void mostrarConsultaArticulos(ArrayList<Articulo> pConsulta,int pCategoria)
	{
		int y = 0;
		for(int i = 0;i<pConsulta.size();i++)
		{
			panel.add(new panelArticulo(y,pConsulta.get(i),pCategoria));
			y+=270;
		}//recordar poner el panel en absolute layout
		panel.setPreferredSize(new Dimension(534,y));
		panel.setLayout(null);
	}
}
