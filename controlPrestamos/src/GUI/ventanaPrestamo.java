package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import Administradores.administradorAplicacion;
import Estructuras.Articulo;
import Estructuras.Persona;
import Estructuras.Prestamo;
import Interfaces.IConstantes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;
/**
 * Clase ventana prestamo
 * 
 * Contiene la información de la ventana prestamo
 * 
 * @author Marco
 *
 */
public class ventanaPrestamo extends JInternalFrame implements IConstantes {
	//Atributos
	/**
	 * ventana de prestamo
	 */
	private static ventanaPrestamo miVentanaPrestamo;
	/**
	 * campo para ingresar numero de cedula
	 */
	private JTextField txtCedula;
	/**
	 * categoria
	 */
	private JComboBox comboBoxCategoriaPersona;
	/**
	 * persona prestada
	 */
	private JComboBox comboBoxPersona;
	/**
	 * campo para ingresar categoria
	 */
	private JComboBox comboBoxCategoriaArticulo;
	/**
	 * campo para ingresar el articulo
	 */
	private JComboBox comboBoxNombreArticulo;
	/**
	 * Etiqueta
	 */
	private JLabel lblImagen;
	/**
	 * fecha
	 */
	private JDateChooser dateChooserPrestamo;
	
	//Método Público
	/**
	 * abre la ventana prestamo
	 * @return miVentanaPrestamo
	 */
	public static ventanaPrestamo getInstance()
	{
		if(miVentanaPrestamo == null)
		{
			miVentanaPrestamo = new ventanaPrestamo();
		}
		return miVentanaPrestamo;
	}
	/**
	 * Create the frame.
	 */
	private ventanaPrestamo() {
		setTitle("Mea Providere - Pr\u00E9stamo Art\u00EDculo");
		setFrameIcon(new ImageIcon(ventanaPrestamo.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 321, 567);
		getContentPane().setLayout(null);
		
		JLabel lblTituloPersona = new JLabel("Persona");
		lblTituloPersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloPersona.setBounds(102, 11, 79, 25);
		getContentPane().add(lblTituloPersona);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 203, 414, 14);
		getContentPane().add(separator);
		
		JLabel lblCategoriaPersona = new JLabel("Categor\u00EDa");
		lblCategoriaPersona.setBounds(10, 66, 68, 14);
		getContentPane().add(lblCategoriaPersona);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(10, 115, 46, 14);
		getContentPane().add(lblPersona);
		
		comboBoxCategoriaPersona = new JComboBox();
		comboBoxCategoriaPersona.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e)
			{
				int cantPersonas = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPersona.getSelectedIndex()).size();
				String [] categorias = new String[cantPersonas];
				for(int i = 0; i < cantPersonas; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPersona.getSelectedIndex()).get(i).getNombre();
				}
				comboBoxPersona.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoriaPersona.setModel(new DefaultComboBoxModel(new String[] {"\"Seleccione\"", "Familia", "Colega", "Estudiante"}));
		comboBoxCategoriaPersona.setBounds(145, 63, 150, 20);
		getContentPane().add(comboBoxCategoriaPersona);
		
		comboBoxPersona = new JComboBox();
		comboBoxPersona.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e) 
			{
				txtCedula.setText(administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPersona.getSelectedIndex()).get(comboBoxPersona.getSelectedIndex()).getCedula());
			}
		});
		comboBoxPersona.setBounds(145, 112, 150, 20);
		getContentPane().add(comboBoxPersona);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(10, 161, 46, 14);
		getContentPane().add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setEnabled(false);
		txtCedula.setBounds(145, 158, 150, 20);
		getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblTituloArticulo = new JLabel("Art\u00EDculo");
		lblTituloArticulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloArticulo.setBounds(108, 215, 73, 25);
		getContentPane().add(lblTituloArticulo);
		
		JLabel lblCategoriaArticulo = new JLabel("Categor\u00EDa");
		lblCategoriaArticulo.setBounds(10, 260, 68, 14);
		getContentPane().add(lblCategoriaArticulo);
		
		comboBoxCategoriaArticulo = new JComboBox();
		comboBoxCategoriaArticulo.addActionListener(new ActionListener() {
			 /**
			  *  
			  */
			  public void actionPerformed(ActionEvent arg0) 
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArticulo.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
					if(!administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArticulo.getSelectedIndex()).get(i).isPrestado())
					{
						categorias[i] = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArticulo.getSelectedIndex()).get(i).getNombre();
					}
				}
				comboBoxNombreArticulo.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoriaArticulo.setBounds(145, 257, 150, 20);
		getContentPane().add(comboBoxCategoriaArticulo);
		
		JLabel lblNombreArticulo = new JLabel("Nombre art\u00EDculo");
		lblNombreArticulo.setBounds(10, 314, 87, 14);
		getContentPane().add(lblNombreArticulo);
		
		comboBoxNombreArticulo = new JComboBox();
		comboBoxNombreArticulo.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) 
			{
				if(comboBoxNombreArticulo.getSelectedIndex() != -1)
				{
					String nombreImagen;
					nombreImagen = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArticulo.getSelectedIndex()).get(comboBoxNombreArticulo.getSelectedIndex()).getImagen();
					ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
					lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
				}
			}
		});
		comboBoxNombreArticulo.setBounds(145, 311, 150, 20);
		getContentPane().add(comboBoxNombreArticulo);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(10, 362, 104, 165);
		getContentPane().add(lblImagen);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(comboBoxPersona.getSelectedIndex() != -1 && comboBoxNombreArticulo.getSelectedIndex() != -1)
				{
					Persona miPersona = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPersona.getSelectedIndex()).get(comboBoxPersona.getSelectedIndex());
					Articulo miArticulo = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArticulo.getSelectedIndex()).get(comboBoxNombreArticulo.getSelectedIndex());
					miArticulo.setPrestado(true);
					miArticulo.setCantPrestamos(miArticulo.getCantPrestamos() + 1);
					Date miFecha = dateChooserPrestamo.getJCalendar().getDate();
					miArticulo.setCantPrestamosXMes(miFecha.getMonth());
					//System.out.println("Mes: "+ miFecha.getMonth());
					administradorAplicacion.getInstance().agregarPrestamo(comboBoxCategoriaArticulo.getSelectedIndex(),new Prestamo(miArticulo,miPersona,miFecha));
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe agregar los datos correctamente");
				}
			}
		});
		btnAceptar.setBounds(121, 504, 79, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e) 
			{
				//persona.setSelectedIndex(-1);
				//comboBox_1.setSelectedIndex(-1);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(210, 504, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblFechaDePrestamo = new JLabel("Fecha de pr\u00E9stamo");
		lblFechaDePrestamo.setBounds(158, 362, 104, 14);
		getContentPane().add(lblFechaDePrestamo);
		
		dateChooserPrestamo = new JDateChooser();
		dateChooserPrestamo.setBounds(145, 387, 133, 20);
		getContentPane().add(dateChooserPrestamo);
		cambiarComboBox();

	}
	/**
	 * 
	 */
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBoxCategoriaArticulo.setModel(new DefaultComboBoxModel(categorias));
	}
	
	
	
}
