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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
/**
 * Clase ventanaagregarpersona
 * 
 * Contiene la informacion de la ventana agregar persona
 * 
 * @author Marco
 *
 */
public class ventanaAgregarPersona extends JInternalFrame 
{
	//Atributos
	/**
	 * ventana agregar persona
	 */
	private static ventanaAgregarPersona miVentanaAgregarPersona;
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
	
	
	//Método Público
	/**
	 * Abre la ventana de agregar persona
	 * @return miVentanaAgregarPersona
	 */
	public static ventanaAgregarPersona getInstance()
	{
		if(miVentanaAgregarPersona == null)
		{
			miVentanaAgregarPersona = new ventanaAgregarPersona();
		}
		return miVentanaAgregarPersona;
	}
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private ventanaAgregarPersona() 
	{
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
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCategoria.setMaximumRowCount(3);
		comboBoxCategoria.setBounds(66, 123, 156, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setBounds(10, 126, 71, 14);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textFieldNombre.getText().isEmpty() && !textFieldApellido1.getText().isEmpty() &&
				   !textFieldApellido2.getText().isEmpty() && !textFieldCedula.getText().isEmpty() &&
				   !textFieldTelefono.getText().isEmpty() && !textFieldCorreo.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarPersona(textFieldNombre.getText(), 
							textFieldApellido1.getText(),textFieldApellido2.getText(), textFieldCedula.getText(),
							textFieldTelefono.getText(), textFieldCorreo.getText(), comboBoxCategoria.getSelectedIndex());
					textFieldNombre.setText("");
					textFieldApellido1.setText("");
					textFieldApellido2.setText("");
					textFieldCedula.setText("");
					textFieldTelefono.setText("");
					textFieldCorreo.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Se agrego la persona con exito");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del formulario");
				}
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
	}
}
