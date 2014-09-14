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
	
	private JComboBox comboBoxPersona;
	
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
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Actualizar Persona");
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
		lblApellido1.setBounds(176, 14, 96, 14);
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
		lblTelefono.setBounds(194, 69, 62, 14);
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
		
		comboBoxPersona = new JComboBox();
		comboBoxPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				mostrarDatos();
			}
		});
		comboBoxPersona.setBounds(86, 139, 156, 17);
		getContentPane().add(comboBoxPersona);
		
		
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
				comboBoxPersona.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Familia", "Colega", "Estudiante"}));
		comboBoxCategoria.setSelectedIndex(0);
		comboBoxCategoria.setMaximumRowCount(3);
		comboBoxCategoria.setBounds(86, 98, 156, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCategoria.setBounds(10, 98, 71, 14);
		getContentPane().add(lblCategoria);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(204, 0, 102));
		btnEditar.setBackground(new Color(255, 153, 0));
		btnEditar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				miPersona.setNombre(fieldNombre.getText());
				miPersona.setApellido1(fieldApellido1.getText());
				miPersona.setApellido2(fieldApellido2.getText());
				miPersona.setCorreoE(fieldCorreo.getText());
				miPersona.setCedula(fieldCedula.getText());
				miPersona.setTelefono(fieldTelefono.getText());
				fieldNombre.setText("");
				fieldApellido1.setText("");
				fieldApellido2.setText("");
				fieldCedula.setText("");
				fieldTelefono.setText("");
				fieldCorreo.setText("");
				setVisible(false);
			}
		});
		btnEditar.setBounds(282, 122, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(204, 0, 102));
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 11));
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
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblPersona.setBounds(10, 142, 46, 14);
		getContentPane().add(lblPersona);
		
	}
	
	
	private void mostrarDatos()
	{
		miPersona = administradorAplicacion.getInstance().getPersonas().get(comboBoxCategoria.getSelectedIndex()).get(comboBoxPersona.getSelectedIndex());
		fieldNombre.setText(miPersona.getNombre());
		fieldApellido1.setText(miPersona.getApellido1());
		fieldApellido2.setText(miPersona.getApellido2());
		fieldCedula.setText(miPersona.getCedula());
		fieldTelefono.setText(miPersona.getTelefono());
		fieldCorreo.setText(miPersona.getCorreoE());
	}
	
	
}




