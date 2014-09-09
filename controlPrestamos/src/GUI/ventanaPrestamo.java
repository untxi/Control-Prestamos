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
	 * 
	 */
	private JTextField txtSdfasdfasd;
	/**
	 * categoria
	 */
	private JComboBox categoria;
	/**
	 * persona prestada
	 */
	private JComboBox persona;
	/**
	 * 
	 */
	private JComboBox comboBox;
	/**
	 * 
	 */
	private JComboBox comboBox_1;
	/**
	 * Etiqueta
	 */
	private JLabel label_1;
	/**
	 * fecha
	 */
	private JDateChooser dateChooser;
	
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
		
		JLabel lblNewLabel = new JLabel("Persona");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(102, 11, 79, 25);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 203, 414, 14);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(10, 66, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Persona");
		lblNewLabel_2.setBounds(10, 115, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		categoria = new JComboBox();
		categoria.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e)
			{
				int cantPersonas = administradorAplicacion.getInstance().getPersonas().get(categoria.getSelectedIndex()).size();
				String [] categorias = new String[cantPersonas];
				for(int i = 0; i < cantPersonas; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getPersonas().get(categoria.getSelectedIndex()).get(i).getNombre();
				}
				persona.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		categoria.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		categoria.setBounds(145, 63, 150, 20);
		getContentPane().add(categoria);
		
		persona = new JComboBox();
		persona.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e) 
			{
				txtSdfasdfasd.setText(administradorAplicacion.getInstance().getPersonas().get(categoria.getSelectedIndex()).get(persona.getSelectedIndex()).getCedula());
			}
		});
		persona.setBounds(145, 112, 150, 20);
		getContentPane().add(persona);
		
		JLabel lblNewLabel_3 = new JLabel("Cedula");
		lblNewLabel_3.setBounds(10, 161, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtSdfasdfasd = new JTextField();
		txtSdfasdfasd.setEnabled(false);
		txtSdfasdfasd.setBounds(145, 158, 150, 20);
		getContentPane().add(txtSdfasdfasd);
		txtSdfasdfasd.setColumns(10);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArticulo.setBounds(108, 215, 73, 25);
		getContentPane().add(lblArticulo);
		
		JLabel label = new JLabel("Categoria");
		label.setBounds(10, 260, 68, 14);
		getContentPane().add(label);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			 /**
			  *  
			  */
			  public void actionPerformed(ActionEvent arg0) 
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(i).getNombre();
				}
				comboBox_1.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBox.setBounds(145, 257, 150, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNombreArticulo = new JLabel("Nombre articulo");
		lblNombreArticulo.setBounds(10, 314, 87, 14);
		getContentPane().add(lblNombreArticulo);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) 
			{
				String nombreImagen;
				nombreImagen = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(comboBox_1.getSelectedIndex()).getImagen();
				ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
				label_1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			}
		});
		comboBox_1.setBounds(145, 311, 150, 20);
		getContentPane().add(comboBox_1);
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 362, 104, 165);
		getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(persona.getSelectedIndex() != -1 && comboBox_1.getSelectedIndex() != -1)
				{
					Persona miPersona = administradorAplicacion.getInstance().getPersonas().get(categoria.getSelectedIndex()).get(persona.getSelectedIndex());
					Articulo miArticulo = administradorAplicacion.getInstance().getMiListaCategorias().get(comboBox.getSelectedIndex()).get(comboBox_1.getSelectedIndex());
					miArticulo.setPrestado(true);
					miArticulo.setCantPrestamos(miArticulo.getCantPrestamos() + 1);
					Date miFecha = dateChooser.getJCalendar().getDate();
					System.out.println("Mes: "+ miFecha.getMonth());
					administradorAplicacion.getInstance().agregarPrestamo(comboBox.getSelectedIndex(),new Prestamo(miArticulo,miPersona,miFecha));
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe agregar los datos correctamente");
				}
			}
		});
		btnNewButton.setBounds(121, 504, 79, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(210, 504, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblFechaDePrestamo = new JLabel("Fecha de prestamo");
		lblFechaDePrestamo.setBounds(158, 362, 104, 14);
		getContentPane().add(lblFechaDePrestamo);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(145, 387, 133, 20);
		getContentPane().add(dateChooser);
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
		comboBox.setModel(new DefaultComboBoxModel(categorias));
	}
}
