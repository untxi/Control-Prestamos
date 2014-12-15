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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
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
	
	
	//M�todo P�blico
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
		getContentPane().setForeground(new Color(153, 0, 204));
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Agregar Persona");
		setFrameIcon(new ImageIcon(ventanaAgregarPersona.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 624, 196);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNombre.setBounds(10, 14, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("Primer Apellido");
		lblApellido1.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblApellido1.setBounds(176, 14, 89, 14);
		getContentPane().add(lblApellido1);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido");
		lblApellido2.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblApellido2.setBounds(381, 14, 105, 14);
		getContentPane().add(lblApellido2);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCedula.setBounds(10, 69, 46, 14);
		getContentPane().add(lblCedula);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblTelefono.setBounds(184, 69, 81, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCorreo.setBounds(431, 69, 46, 14);
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
		
		JLabel lblCaegoria = new JLabel("Categor\u00EDa");
		lblCaegoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCaegoria.setBounds(10, 126, 71, 14);
		getContentPane().add(lblCaegoria);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 153, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 11));
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
					JOptionPane.showMessageDialog(null, "Se agreg� la persona con �xito");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del formulario");
				}
			}
		});
		btnAceptar.setBounds(282, 122, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
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
		btnCancelar.setBounds(487, 122, 100, 23);
		getContentPane().add(btnCancelar);
	}
}
