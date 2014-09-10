package GUI;
/**
 * Ventana para el ingreso de los datos del usuario al registro
 * 
 * @author Samantha Arburola
 */

// Librerias
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
// Clases
import Administradores.administradorAplicacion;
import Estructuras.Usuario;

/**
 * Clase ventanaRegistroUsuario
 * 
 * Permite ingresar toda la información de usuario
 * 
 * @author Samantha
 */
public class ventanaRegistroUsuario extends JInternalFrame 
{
	// Atributos
	/**
	 * Nombre del Usuario
	 */
	private JTextField textFieldNombre;
	/**
	 * Nickname para usuario
	 */
	private JTextField textFieldUsuario;
	/**
	 * Contraseña 
	 */
	private JPasswordField passwordFieldContrasena;
	/**
	 * Ventana para ingresar datos
	 */
	private static ventanaRegistroUsuario miVentanaRegistroUsuario;
	
	// Métodos
	/**
	 * Método Público: ventanaRegistroUsuario
	 * 	Permite que el usuario se registre
	 * @return ventana de registro
	 */
	public static ventanaRegistroUsuario getInstance()
	{
		if(miVentanaRegistroUsuario == null)
		{
			miVentanaRegistroUsuario = new ventanaRegistroUsuario();
		}
		return miVentanaRegistroUsuario;
	}
	
	/**
	 * Crea la interfaz
	 */
	private ventanaRegistroUsuario() 
	{
		/**
		 * Propiedades de la ventana
		 */
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 351, 232);
		getContentPane().setLayout(null);
		/**
		 * Campo para ingresar el nombre
		 */
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(171, 11, 150, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		/**
		 * Label para ingresar el nombre
		 */
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 122, 14);
		getContentPane().add(lblNewLabel);
		/**
		 * Label para ingresar el nickname
		 */
		JLabel lblNewLabel_1 = new JLabel("Nombre Usuario");
		lblNewLabel_1.setBounds(10, 68, 94, 14);
		getContentPane().add(lblNewLabel_1);
		/**
		 * Label para ingresar la contraseña
		 */
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(10, 116, 86, 14);
		getContentPane().add(lblNewLabel_2);
		/**
		 * Campo para ingresar el usuario
		 */
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(171, 65, 150, 20);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		/**
		 * Campo para ingresar la contraseña
		 */
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(171, 113, 150, 20);
		getContentPane().add(passwordFieldContrasena);
		/**
		 * Botón para aceptar lo digitado y enviar la información
		 */
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(!textFieldNombre.getText().isEmpty() && !textFieldUsuario.getText().isEmpty() && !passwordFieldContrasena.getText().isEmpty())
				{
					administradorAplicacion.getInstance().setUsuario(new Usuario(textFieldNombre.getText(), textFieldUsuario.getText(), passwordFieldContrasena.getText()));
					textFieldNombre.setText("");
					textFieldUsuario.setText("");
					passwordFieldContrasena.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Usuario agreado con exito");
					//System.out.println("Usuario agregado");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del formulario");
				}
			}
			
		});
		btnNewButton.setBounds(43, 169, 89, 23);
		getContentPane().add(btnNewButton);
		/**
		 * Botón para cancelar la información ingresada
		 */
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				textFieldNombre.setText("");
				textFieldUsuario.setText("");
				passwordFieldContrasena.setText("");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(183, 169, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
