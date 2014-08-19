package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
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

public class ventanaPrincipal extends JFrame implements IConstantes 
{
	private JDesktopPane escritorio;
	private JMenu menuRegistro;
	private JMenu menuConfiguracion;
	private JMenu menuAgregar;
	private JMenu menuConsultar;
	private JMenu menuSalir;
	private JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaPrincipal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 593);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(135, 206, 250));
		getContentPane().add(escritorio);
		
		panel.setSize(342, 5000);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		GroupLayout gl_escritorio = new GroupLayout(escritorio);
		gl_escritorio.setHorizontalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_escritorio.createSequentialGroup()
					.addContainerGap(981, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
		);
		gl_escritorio.setVerticalGroup(
			gl_escritorio.createParallelGroup(Alignment.LEADING)
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
		menuRegistro.setIcon(new ImageIcon(imagenLogin));
		menuBar.add(menuRegistro);
		
		JMenuItem mntmCrearCuenta = new JMenuItem("Crear cuenta");
		mntmCrearCuenta.setIcon(new ImageIcon(imagenUser));
		mntmCrearCuenta.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmCrearCuenta);
		
		JMenuItem mntmIniciarSecion = new JMenuItem("Iniciar Secion");
		mntmIniciarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				menuConfiguracion.setEnabled(true);
				menuAgregar.setEnabled(true);
				menuConsultar.setEnabled(true);
			}
		});
		mntmIniciarSecion.setIcon(new ImageIcon(imagenUser));
		mntmIniciarSecion.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmIniciarSecion);
		
		JMenuItem mntmCerrarSecion = new JMenuItem("Cerrar Secion");
		mntmCerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				menuConfiguracion.setEnabled(false);
				menuAgregar.setEnabled(false);
				menuConsultar.setEnabled(false);
			}
		});
		mntmCerrarSecion.setIcon(new ImageIcon(imagenUser));
		mntmCerrarSecion.setBackground(new Color(100, 149, 237));
		menuRegistro.add(mntmCerrarSecion);
		
		menuConfiguracion = new JMenu("");
		menuConfiguracion.setIcon(new ImageIcon(imagenConfiguracion));
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
				mostrarConsultaArticulos(5);
				
			}
		});
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
		});
		menuConfiguracion.add(mntmNewMenuItem_4);
		
		menuAgregar = new JMenu("");
		menuAgregar.setIcon(new ImageIcon(imagenCargar));
		menuBar.add(menuAgregar);
		
		JMenuItem mntmAgregarArticulo = new JMenuItem("Agregar articulo");
		mntmAgregarArticulo.setIcon(new ImageIcon(imagenArticulos));
		mntmAgregarArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarArticulo);
		
		JMenuItem mntmAgregarPersona = new JMenuItem("Agregar persona");
		mntmAgregarPersona.setBackground(new Color(100, 149, 237));
		mntmAgregarPersona.setIcon(new ImageIcon(imagenPersona));
		menuAgregar.add(mntmAgregarPersona);
		
		JMenuItem mntmAgregarCategoriaArticulo = new JMenuItem("Agregar categoria articulo");
		mntmAgregarCategoriaArticulo.setIcon(new ImageIcon(imagenArticulos));
		mntmAgregarCategoriaArticulo.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarCategoriaArticulo);
		
		JMenuItem mntmAgregarCategoria = new JMenuItem("Agregar categoria persona");
		mntmAgregarCategoria.setBackground(new Color(100, 149, 237));
		mntmAgregarCategoria.setIcon(new ImageIcon(imagenPersona));
		menuAgregar.add(mntmAgregarCategoria);
		
		JMenuItem mntmAgregarArticulosDesde = new JMenuItem("Agregar articulos desde archivo txt");
		mntmAgregarArticulosDesde.setIcon(new ImageIcon(imagenArticulos));
		mntmAgregarArticulosDesde.setBackground(new Color(100, 149, 237));
		menuAgregar.add(mntmAgregarArticulosDesde);
		
		JMenuItem mntmAgregarPersonasDesde = new JMenuItem("Agregar personas desde archivo txt");
		mntmAgregarPersonasDesde.setBackground(new Color(100, 149, 237));
		mntmAgregarPersonasDesde.setIcon(new ImageIcon(imagenPersona));
		menuAgregar.add(mntmAgregarPersonasDesde);
		
		menuConsultar = new JMenu("");
		menuConsultar.setIcon(new ImageIcon(imagenConsulta));
		menuBar.add(menuConsultar);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Top 10 de articulos");
		mntmNewMenuItem_2.setIcon(new ImageIcon(imagenArticulos));
		mntmNewMenuItem_2.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmConsultaDeLibros = new JMenuItem("Listado de articulos");
		mntmConsultaDeLibros.setIcon(new ImageIcon(imagenArticulos));
		mntmConsultaDeLibros.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmConsultaDeLibros);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado personalizado");
		mntmNewMenuItem_3.setIcon(new ImageIcon(imagenArticulos));
		mntmNewMenuItem_3.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listado de articulos prestados");
		mntmNewMenuItem.setIcon(new ImageIcon(imagenArticulos));
		mntmNewMenuItem.setBackground(new Color(100, 149, 237));
		menuConsultar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de articulos no prestados");
		mntmNewMenuItem_1.setIcon(new ImageIcon(imagenArticulos));
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
		menuSalir.setIcon(new ImageIcon(imagenSalir));
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
		
		
		menuConfiguracion.setEnabled(false);
		menuAgregar.setEnabled(false);
		menuConsultar.setEnabled(false);
		mostrarConsultaArticulos(10);
		setVisible(true);
	}
	
	private void mostrarConsultaArticulos(int x)
	{
		int y = 0;
		for(int i = 0;i<x;i++)
		{
			panel.add(new panelArticulo(y));
			y+=165;
		}//recordar poner el panel en absolute layout
		panel.setPreferredSize(new Dimension(342,y));
		panel.setLayout(null);
	}
}
