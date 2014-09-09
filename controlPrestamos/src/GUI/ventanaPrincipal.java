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

public class ventanaPrincipal extends JFrame implements IConstantes 
{
	private JDesktopPane escritorio;
	private JMenu menuRegistro;
	private JMenu menuConfiguracion;
	private JMenu menuAgregar;
	private JMenu menuConsultar;
	private JMenu menuSalir;
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel;
	private JFileChooser ventaBuscador;
	private static ventanaPrincipal miVentanaPrincipal;
	

	
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
	private ventanaPrincipal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 593);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(135, 206, 250));
		getContentPane().add(escritorio);
		
		panel.setSize(534, 5000);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GroupLayout gl_escritorio = new GroupLayout(escritorio);
		gl_escritorio.setHorizontalGroup(
			gl_escritorio.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_escritorio.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE))
		);
		gl_escritorio.setVerticalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(455))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Configurar preferencias del sistema");
		mntmNewMenuItem_4.setIcon(new ImageIcon(imagenConfig));
		mntmNewMenuItem_4.setBackground(new Color(100, 149, 237));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ventanaConfiguracion n = new ventanaConfiguracion();
				escritorio.add(n);
				n.show();
				mostrarConsultaArticulos(administradorAplicacion.getInstance().getMiListaCategorias().get(0),0);
				
			}
		});
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
		});
		menuConfiguracion.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Prestar Articulo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventanaPrestamo.getInstance().setVisible(true);
			}
		});
		menuConfiguracion.add(mntmNewMenuItem_7);
		
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
		menuConsultar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Recursos/ImagenesGUI/table_tab_search.png")));
		menuBar.add(menuConsultar);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Top 10 de articulos");
		mntmNewMenuItem_2.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmConsultaDeLibros = new JMenuItem("Listado de articulos");
		mntmConsultaDeLibros.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmConsultaDeLibros);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado personalizado");
		mntmNewMenuItem_3.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listado de articulos prestados");
		mntmNewMenuItem.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de articulos no prestados");
		mntmNewMenuItem_1.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem_1);
		
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
	
	public void activarAplicacion()
	{
		menuConfiguracion.setEnabled(true);
		menuAgregar.setEnabled(true);
		menuConsultar.setEnabled(true);
		lblNewLabel.setText("Bienvenido " + administradorAplicacion.getInstance().getUsuario().getNombre());
	}
	
	public void desactivarAplicacion()
	{
		//menuConfiguracion.setEnabled(false);
		menuAgregar.setEnabled(false);
		menuConsultar.setEnabled(false);
		lblNewLabel.setText("");
	}
	
	
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
