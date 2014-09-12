
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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JToolBar;

import Administradores.administradorAplicacion;
import Estructuras.Articulo;
import Estructuras.Prestamo;
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
import java.awt.Toolkit;

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
	
	private JScrollPane scrollPane;
	
	private JLabel lblNewLabel_1;
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 593);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(135, 206, 250));
		getContentPane().add(escritorio);
		
		panel.setSize(534, 5000);
		scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setSize(new Dimension(500, 400));
		GroupLayout gl_escritorio = new GroupLayout(escritorio);
		gl_escritorio.setHorizontalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_escritorio.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE))
		);
		gl_escritorio.setVerticalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
					.addGap(794))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
		);
		
		ImageIcon portada = new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png"));
		lblNewLabel_1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));
		
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Preferencias del sistema");
		mntmNewMenuItem_4.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/gear_in_peque.png")));
		mntmNewMenuItem_4.setBackground(new Color(100, 149, 237));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ventanaConfiguracion.getInstance().setVisible(true);
			}
		});
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Prestar Articulo");
		mntmNewMenuItem_7.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/package_delete.png")));
		mntmNewMenuItem_7.setBackground(new Color(100, 149, 237));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaPrestamo.getInstance().setVisible(true);
			}
		});
		
		JMenuItem mntmMandarEmail = new JMenuItem("Mandar Email");
		mntmMandarEmail.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/email_go.png")));
		mntmMandarEmail.setBackground(new Color(100, 149, 237));
		menuConfiguracion.add(mntmMandarEmail);
		menuConfiguracion.add(mntmNewMenuItem_7);
		
		JMenuItem mntmDevolverArticulo = new JMenuItem("Devolver Articulo");
		mntmDevolverArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/package_add.png")));
		mntmDevolverArticulo.setBackground(new Color(100, 149, 237));
		menuConfiguracion.add(mntmDevolverArticulo);
		menuConfiguracion.add(mntmNewMenuItem_4);
		
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
		
		JMenuItem mntmEditarPersona = new JMenuItem("Editar Persona");
		mntmEditarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaEditarPersona.getInstance().setVisible(true);
			}
		});
		mntmEditarPersona.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/user.png")));
		mntmEditarPersona.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmEditarPersona);
		mntmAgregarCategoriaArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/package_add.png")));
		mntmAgregarCategoriaArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarCategoriaArticulo);
		
		JMenuItem mntmAgregarArticulosDesde = new JMenuItem("Agregar Libros desde archivo txt");
		mntmAgregarArticulosDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarLibros(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
	        }
			});
		
		JMenuItem mntmEditarArticulo = new JMenuItem("Editar Articulo");
		mntmEditarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ventanaEditarArticulo.getInstance().cambiarComboBox();
				ventanaEditarArticulo.getInstance().setVisible(true);
			}
		});
		mntmEditarArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/installer_box.png")));
		mntmEditarArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmEditarArticulo);
		mntmAgregarArticulosDesde.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/book_add.png")));
		mntmAgregarArticulosDesde.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarArticulosDesde);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Agregar revistas desde archivo txt");
		mntmNewMenuItem_5.setBackground(new Color(100, 149, 237));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_5.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/book_add.png")));
		menuAgregar.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar peliculas desde archivo txt");
		mntmNewMenuItem_6.setBackground(new Color(100, 149, 237));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int respuesta = ventaBuscador.showOpenDialog(miVentanaPrincipal);
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        	{
		        		administradorAplicacion.getInstance().cargarPeliculas(ventaBuscador.getSelectedFile().getAbsolutePath());
			        }		
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/dvd_add.png")));
		menuAgregar.add(mntmNewMenuItem_6);
		
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
		menuConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				ventanaConsultas.getInstance().cambiarComboBox();
				ventanaConsultas.getInstance().setVisible(true);
			}
		});
		menuConsultar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/table_tab_search.png")));
		menuBar.add(menuConsultar);
		
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
		
		//desactivarAplicacion();
		escritorio.add(ventanaRegistroUsuario.getInstance());
		escritorio.add(ventanaLogin.getInstance());
		escritorio.add(ventanaAgregarPersona.getInstance());
		escritorio.add(ventanaAgregarCategoria.getInstance());
		escritorio.add(ventanaAgregarArticulo.getInstance());
		escritorio.add(ventanaPrestamo.getInstance());
		escritorio.add(ventanaConsultas.getInstance());
		escritorio.add(ventanaConfiguracion.getInstance());
		escritorio.add(ventanaEditarArticulo.getInstance());
		escritorio.add(ventanaEditarPersona.getInstance());
		
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
	public void mostrarConsultaArticulos(ArrayList<Articulo> pConsulta,int pCategoria, int y)
	{
		//limpiarPanelConsulta();
		for(int i = 0;i<pConsulta.size();i++)
		{
			panel.add(new panelArticulo(y,pConsulta.get(i),pCategoria));
			y+=270;
		}//recordar poner el panel en absolute layout
		panel.setPreferredSize(new Dimension(534,y));
		panel.setLayout(null);
	}
	
	public void mostrarConsultaPrestamos(ArrayList<Prestamo> pConsulta,int pCategoria, int y)
	{
		//limpiarPanelConsulta();
		for(int i = 0;i<pConsulta.size();i++)
		{
			panel.add(new panelArticulo(y,pConsulta.get(i),pCategoria));
			y+=270;
		}//recordar poner el panel en absolute layout
		panel.setPreferredSize(new Dimension(534,y));
		panel.setLayout(null);
	}
	
	public void mostrarCantArticulos(int y,int pCantidad, int pConsulta)
	{
		//limpiarPanelConsulta();
		panel.add(new panelCantidadConsultados(y,pCantidad,pConsulta));
		panel.setPreferredSize(new Dimension(534,y));
		panel.setLayout(null);
	}
	
	
	public void limpiarPanelConsulta()
	{
		panel.removeAll();
		panel.repaint();
	} 
}
