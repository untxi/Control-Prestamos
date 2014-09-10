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
	private JTextField fieldCedula;
	/**
	 * categoria
	 */
	private JComboBox comboBoxCategoriaPerson;
	/**
	 * persona prestada
	 */
	private JComboBox comboBoxPersona;
	/**
	 * campo para ingresar categoria
	 */
	private JComboBox comboBoxCategoriaArt;
	/**
	 * campo para ingresar el articulo
	 */
	private JComboBox comboBoxNombreArticulo;
	/**
	 * Etiqueta
	 */
	private JLabel label_1;
	/**
	 * fecha
	 */
	private JDateChooser calendarioPrestamo;
	
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 321, 567);
		getContentPane().setLayout(null);
		
		JLabel lblTitlePersona = new JLabel("Persona");
		lblTitlePersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitlePersona.setBounds(102, 11, 79, 25);
		getContentPane().add(lblTitlePersona);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 203, 414, 14);
		getContentPane().add(separator);
		
		JLabel lblCategoriaPerson = new JLabel("Categoria");
		lblCategoriaPerson.setBounds(10, 66, 68, 14);
		getContentPane().add(lblCategoriaPerson);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(10, 115, 46, 14);
		getContentPane().add(lblPersona);
		
		comboBoxCategoriaPerson = new JComboBox();
		comboBoxCategoriaPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int cantPersonas = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPerson.getSelectedIndex()).size();
				String [] categorias = new String[cantPersonas];
				for(int i = 0; i < cantPersonas; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPerson.getSelectedIndex()).get(i).getNombre();
				}
				comboBoxPersona.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoriaPerson.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		comboBoxCategoriaPerson.setBounds(145, 63, 150, 20);
		getContentPane().add(comboBoxCategoriaPerson);
		
		comboBoxPersona = new JComboBox();
		comboBoxPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fieldCedula.setText(administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPerson.getSelectedIndex()).get(comboBoxPersona.getSelectedIndex()).getCedula());
			}
		});
		comboBoxPersona.setBounds(145, 112, 150, 20);
		getContentPane().add(comboBoxPersona);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 161, 46, 14);
		getContentPane().add(lblCedula);
		
		fieldCedula = new JTextField();
		fieldCedula.setEnabled(false);
		fieldCedula.setBounds(145, 158, 150, 20);
		getContentPane().add(fieldCedula);
		fieldCedula.setColumns(10);
		
		JLabel lblTitleArticulo = new JLabel("Articulo");
		lblTitleArticulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitleArticulo.setBounds(108, 215, 73, 25);
		getContentPane().add(lblTitleArticulo);
		
		JLabel lblCategoriaArt = new JLabel("Categoria");
		lblCategoriaArt.setBounds(10, 260, 68, 14);
		getContentPane().add(lblCategoriaArt);
		
		comboBoxCategoriaArt = new JComboBox();
		comboBoxCategoriaArt.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) 
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArt.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArt.getSelectedIndex()).get(i).getNombre();
				}
				comboBoxNombreArticulo.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoriaArt.setBounds(145, 257, 150, 20);
		getContentPane().add(comboBoxCategoriaArt);
		
		JLabel lblNombreArticulo = new JLabel("Nombre articulo");
		lblNombreArticulo.setBounds(10, 314, 87, 14);
		getContentPane().add(lblNombreArticulo);
		
		comboBoxNombreArticulo = new JComboBox();
		comboBoxNombreArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String nombreImagen;
				nombreImagen = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArt.getSelectedIndex()).get(comboBoxNombreArticulo.getSelectedIndex()).getImagen();
				ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
				label_1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			}
		});
		comboBoxNombreArticulo.setBounds(145, 311, 150, 20);
		getContentPane().add(comboBoxNombreArticulo);
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 362, 104, 165);
		getContentPane().add(label_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(comboBoxPersona.getSelectedIndex() != -1 && comboBoxNombreArticulo.getSelectedIndex() != -1)
				{
					Persona miPersona = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoriaPerson.getSelectedIndex()).get(comboBoxPersona.getSelectedIndex());
					Articulo miArticulo = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBoxCategoriaArt.getSelectedIndex()).get(comboBoxNombreArticulo.getSelectedIndex());
					miArticulo.setPrestado(true);
					miArticulo.setCantPrestamos(miArticulo.getCantPrestamos() + 1);
					Date miFecha = calendarioPrestamo.getJCalendar().getDate();
					System.out.println("Mes: "+ miFecha.getMonth());
					administradorAplicacion.getInstance().agregarPrestamo(comboBoxCategoriaArt.getSelectedIndex(),new Prestamo(miArticulo,miPersona,miFecha));
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
			public void actionPerformed(ActionEvent e) 
			{
				//persona.setSelectedIndex(-1);
				//comboBox_1.setSelectedIndex(-1);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(210, 504, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblFechaDePrestamo = new JLabel("Fecha de prestamo");
		lblFechaDePrestamo.setBounds(158, 362, 104, 14);
		getContentPane().add(lblFechaDePrestamo);
		
		calendarioPrestamo = new JDateChooser();
		calendarioPrestamo.setBounds(145, 387, 133, 20);
		getContentPane().add(calendarioPrestamo);
		cambiarComboBox();
	}
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBoxCategoriaArt.setModel(new DefaultComboBoxModel(categorias));
	}
}
