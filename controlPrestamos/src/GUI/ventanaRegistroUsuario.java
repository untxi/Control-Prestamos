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
	private JTextField fieldNombre;
	/**
	 * Nickname para usuario
	 */
	private JTextField fieldNombreUsuario;
	/**
	 * Contraseña 
	 */
	private JPasswordField fieldContrasena;
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
		fieldNombre = new JTextField();
		fieldNombre.setBounds(171, 11, 150, 20);
		getContentPane().add(fieldNombre);
		fieldNombre.setColumns(10);
		/**
		 * Label para ingresar el nombre
		 */
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 14, 122, 14);
		getContentPane().add(lblNombre);
		/**
		 * Label para ingresar el nickname
		 */
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(10, 68, 94, 14);
		getContentPane().add(lblNombreUsuario);
		/**
		 * Label para ingresar la contraseña
		 */
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(10, 116, 86, 14);
		getContentPane().add(lblContrasena);
		/**
		 * Campo para ingresar el usuario
		 */
		fieldNombreUsuario = new JTextField();
		fieldNombreUsuario.setBounds(171, 65, 150, 20);
		getContentPane().add(fieldNombreUsuario);
		fieldNombreUsuario.setColumns(10);
		/**
		 * Campo para ingresar la contraseña
		 */
		fieldContrasena = new JPasswordField();
		fieldContrasena.setBounds(171, 113, 150, 20);
		getContentPane().add(fieldContrasena);
		/**
		 * Botón para aceptar lo digitado y enviar la información
		 */
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(!fieldNombre.getText().isEmpty() && !fieldNombreUsuario.getText().isEmpty() && !fieldContrasena.getText().isEmpty())
				{
					administradorAplicacion.getInstance().setUsuario(new Usuario(fieldNombre.getText(), fieldNombreUsuario.getText(), fieldContrasena.getText()));
					fieldNombre.setText("");
					fieldNombreUsuario.setText("");
					fieldContrasena.setText("");
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
		btnAceptar.setBounds(43, 169, 89, 23);
		getContentPane().add(btnAceptar);
		/**
		 * Botón para cancelar la información ingresada
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				fieldNombre.setText("");
				fieldNombreUsuario.setText("");
				fieldContrasena.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(183, 169, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
