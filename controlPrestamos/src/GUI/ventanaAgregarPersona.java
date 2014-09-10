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
	private JTextField fieldNombre;
	/**
	 * campo para digitar el primer apellido 
	 */
	private JTextField fieldApellido1;
	/**
	 * campo para digitar el segundo apellido
	 */
	private JTextField fieldApellido2;
	/**
	 * campo para digitar la cedular
	 */
	private JTextField fieldCedula;
	/**
	 * campo para digitar el telefono
	 */
	private JTextField fieldTelefono;
	/**
	 * campo para digitar el correo
	 */
	private JTextField fieldCorreo;
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 14, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("Primer Apellido");
		lblApellido1.setBounds(176, 14, 80, 14);
		getContentPane().add(lblApellido1);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setBounds(381, 14, 96, 14);
		getContentPane().add(lblApellido2);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(10, 69, 46, 14);
		getContentPane().add(lblCedula);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(176, 69, 46, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(381, 69, 46, 14);
		getContentPane().add(lblCorreo);
		
		fieldNombre = new JTextField();
		fieldNombre.setBounds(66, 11, 100, 20);
		getContentPane().add(fieldNombre);
		fieldNombre.setColumns(10);
		
		fieldApellido1 = new JTextField();
		fieldApellido1.setBounds(266, 11, 105, 20);
		getContentPane().add(fieldApellido1);
		fieldApellido1.setColumns(10);
		
		fieldApellido2 = new JTextField();
		fieldApellido2.setBounds(487, 11, 111, 20);
		getContentPane().add(fieldApellido2);
		fieldApellido2.setColumns(10);
		
		fieldCedula = new JTextField();
		fieldCedula.setBounds(66, 66, 100, 20);
		getContentPane().add(fieldCedula);
		fieldCedula.setColumns(10);
		
		fieldTelefono = new JTextField();
		fieldTelefono.setBounds(266, 66, 105, 20);
		getContentPane().add(fieldTelefono);
		fieldTelefono.setColumns(10);
		
		fieldCorreo = new JTextField();
		fieldCorreo.setBounds(487, 66, 111, 20);
		getContentPane().add(fieldCorreo);
		fieldCorreo.setColumns(10);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCategoria.setMaximumRowCount(3);
		comboBoxCategoria.setBounds(66, 123, 156, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 126, 71, 14);
		getContentPane().add(lblCategoria);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!fieldNombre.getText().isEmpty() && !fieldApellido1.getText().isEmpty() &&
				   !fieldApellido2.getText().isEmpty() && !fieldCedula.getText().isEmpty() &&
				   !fieldTelefono.getText().isEmpty() && !fieldCorreo.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarPersona(fieldNombre.getText(), 
							fieldApellido1.getText(),fieldApellido2.getText(), fieldCedula.getText(),
							fieldTelefono.getText(), fieldCorreo.getText(), comboBoxCategoria.getSelectedIndex());
					fieldNombre.setText("");
					fieldApellido1.setText("");
					fieldApellido2.setText("");
					fieldCedula.setText("");
					fieldTelefono.setText("");
					fieldCorreo.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Se agrego la persona con exito");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del formulario");
				}
			}
		});
		btnAceptar.setBounds(283, 122, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fieldNombre.setText("");
				fieldApellido1.setText("");
				fieldApellido2.setText("");
				fieldCedula.setText("");
				fieldTelefono.setText("");
				fieldCorreo.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(487, 122, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
