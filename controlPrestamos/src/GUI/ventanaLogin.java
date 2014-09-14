package GUI;
/**
 * Ventana para el ingreso de los datos del usuario al registro
 * 
 * @author Samantha Arburola
 */

// Librerias y Clases
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Administradores.administradorAplicacion;
import Estructuras.Prestamo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

/**
 * Clase ventanaRegistroUsuario
 * 
 * Permite ingresar toda la información de usuario
 * 
 * @author Samantha
 */
public class ventanaLogin extends JInternalFrame {
	// Atributos
	/**
	* Nombre del Usuario
	*/
	private JTextField fieldNombreUsuario;
	/**
	 * Contraseña 
	 */
	private JPasswordField fieldContrasena;
	/**
	 * Ventana para ingresar datos
	 */
	private static ventanaLogin miVentanaLogin;

	// Métodos
	/**
	* Método Público: ventanaRegistroUsuario
	* 	Permite que el usuario se registre
	* @return ventana de registro
	*/
	public static ventanaLogin getInstance()
	{
		if(miVentanaLogin == null)
		{
			miVentanaLogin = new ventanaLogin();
		}
		return miVentanaLogin;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ventanaLogin() {
		setTitle("Mea Providere - Iniciar Sesi\u00F3n");
		setFrameIcon(new ImageIcon(ventanaLogin.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 186);
		getContentPane().setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario");
		lblNombreUsuario.setBounds(10, 36, 99, 14);
		getContentPane().add(lblNombreUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(10, 80, 86, 14);
		getContentPane().add(lblContrasena);
		
		fieldNombreUsuario = new JTextField();
		fieldNombreUsuario.setBounds(137, 33, 145, 20);
		getContentPane().add(fieldNombreUsuario);
		fieldNombreUsuario.setColumns(10);
		
		fieldContrasena = new JPasswordField();
		fieldContrasena.setBounds(137, 77, 145, 20);
		getContentPane().add(fieldContrasena);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!fieldNombreUsuario.getText().isEmpty() && !fieldContrasena.getText().isEmpty())
				{
					if(administradorAplicacion.getInstance().validarUsuario(fieldNombreUsuario.getText(), fieldContrasena.getText()))
					{
						fieldNombreUsuario.setText("");
						fieldContrasena.setText("");
						ventanaPrincipal.getInstance().activarAplicacion();
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Bienvenido "+ administradorAplicacion.getInstance().getUsuario().getNombre() );
						administradorAplicacion.getInstance().agregarPrestamo(0, new Prestamo(administradorAplicacion.getInstance().getMiListaCategorias().get(0).get(0),
								  administradorAplicacion.getInstance().getPersonas().get(0).get(0), new Date()));
						administradorAplicacion.getInstance().getMiListaCategorias().get(0).get(0).setPrestado(true);
						try {
							administradorAplicacion.getInstance().getMiAdministradorConsultas().consultaArticulosConPrestamoVencido();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");			
					}
				}
				/// iniciar 
			}
		});
		btnAceptar.setBounds(22, 123, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fieldNombreUsuario.setText("");
				fieldContrasena.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(159, 123, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
}
