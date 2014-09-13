package GUI;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import Administradores.administradorAplicacion;
import Estructuras.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale.Category;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
/**
 * Clase ventanaagregarpersona
 * 
 * Contiene la informacion de la ventana agregar persona
 * 
 * @author Marco
 *
 */
public class ventanaEditarPersona extends JInternalFrame 
{
	//Atributos
	/**
	 * ventana agregar persona
	 */
	private static ventanaEditarPersona miVentanaEditarPersona;
	/**
	 * campo para digitar el nombre
	 */
	private JTextField textFieldNombre;
	/**
	 * campo para digitar el primer apellido 
	 */
	private JTextField textFieldApellido1;
	/**
	 * campo para digitar el segundo apellido
	 */
	private JTextField textFieldApellido2;
	/**
	 * campo para digitar la cedular
	 */
	private JTextField textFieldCedula;
	/**
	 * campo para digitar el telefono
	 */
	private JTextField textFieldTelefono;
	/**
	 * campo para digitar el correo
	 */
	private JTextField textFieldCorreo;
	/**
	 * seleccionar categoria
	 */
	private JComboBox comboBoxCategoria;
	
	private JComboBox comboBox;
	
	private Persona miPersona;
	
	//Método Público
	/**
	 * Abre la ventana de agregar persona
	 * @return miVentanaAgregarPersona
	 */
	public static ventanaEditarPersona getInstance()
	{
		if(miVentanaEditarPersona == null)
		{
			miVentanaEditarPersona = new ventanaEditarPersona();
		}
		return miVentanaEditarPersona;
	}
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private ventanaEditarPersona() 
	{
		setTitle("Mea Providere - Actualizar Persona");
		setFrameIcon(new ImageIcon(ventanaAgregarPersona.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 624, 196);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Primer Apellido");
		lblNewLabel_1.setBounds(176, 14, 80, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido");
		lblNewLabel_2.setBounds(381, 14, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00E9dula");
		lblNewLabel_3.setBounds(10, 69, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(176, 69, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setBounds(381, 69, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(66, 11, 100, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(266, 11, 105, 20);
		getContentPane().add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(487, 11, 111, 20);
		getContentPane().add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(66, 66, 100, 20);
		getContentPane().add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(266, 66, 105, 20);
		getContentPane().add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(487, 66, 111, 20);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				mostrarDatos();
			}
		});
		comboBox.setBounds(86, 139, 156, 17);
		getContentPane().add(comboBox);
		
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int cantPersonas = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoria.getSelectedIndex()).size();
				String [] categorias = new String[cantPersonas];
				for(int i = 0; i < cantPersonas; i++)
				{
					categorias[i] = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoria.getSelectedIndex()).get(i).getNombre();
				}
				comboBox.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCategoria.setMaximumRowCount(3);
		comboBoxCategoria.setBounds(86, 98, 156, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setBounds(10, 98, 71, 14);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				miPersona.setNombre(textFieldNombre.getText());
				miPersona.setApellido1(textFieldApellido1.getText());
				miPersona.setApellido2(textFieldApellido2.getText());
				miPersona.setCorreoE(textFieldCorreo.getText());
				miPersona.setCedula(textFieldCedula.getText());
				miPersona.setTelefono(textFieldTelefono.getText());
				textFieldNombre.setText("");
				textFieldApellido1.setText("");
				textFieldApellido2.setText("");
				textFieldCedula.setText("");
				textFieldTelefono.setText("");
				textFieldCorreo.setText("");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(282, 122, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textFieldNombre.setText("");
				textFieldApellido1.setText("");
				textFieldApellido2.setText("");
				textFieldCedula.setText("");
				textFieldTelefono.setText("");
				textFieldCorreo.setText("");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(487, 122, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(10, 142, 46, 14);
		getContentPane().add(lblPersona);
		
	}
	
	
	private void mostrarDatos()
	{
		miPersona = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoria.getSelectedIndex()).get(comboBox.getSelectedIndex());
		textFieldNombre.setText(miPersona.getNombre());
		textFieldApellido1.setText(miPersona.getApellido1());
		textFieldApellido2.setText(miPersona.getApellido2());
		textFieldCedula.setText(miPersona.getCedula());
		textFieldTelefono.setText(miPersona.getTelefono());
		textFieldCorreo.setText(miPersona.getCorreoE());
	}
	
	
}




