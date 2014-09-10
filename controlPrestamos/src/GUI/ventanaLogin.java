package GUI;
// Librerias
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
// Clases
import Administradores.administradorAplicacion;

/**
 * Clase ventanaLogin
 * Muestra la ventana para ingresar al programa 
 * 
 * @author Samantha
 */
public class ventanaLogin extends JInternalFrame {
	// Atributos
	/**
	 * Campo para nickname
	 */
	private JTextField fieldNombreUsuario;
	/**
	 * Campo para contraseña
	 */
	private JPasswordField fieldConstraseña;
	/**
	 * Ventana para logear
	 */
	private static ventanaLogin miVentanaLogin;
	
	// Métodos
	/**
	 * Get para la ventana
	 * @return ventana para logear
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 186);
		getContentPane().setLayout(null);
		/**
		 * Label para ingresar el nombre
		 */
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(10, 36, 99, 14);
		getContentPane().add(lblNombreUsuario);
		/**
		 * Label para ingresar la contraseña
		 */
		JLabel lblContaseña = new JLabel("Contrase\u00F1a");
		lblContaseña.setBounds(10, 80, 86, 14);
		getContentPane().add(lblContaseña);
		/**
		 * Campo para ingresar el usuario
		 */
		fieldNombreUsuario = new JTextField();
		fieldNombreUsuario.setBounds(137, 33, 145, 20);
		getContentPane().add(fieldNombreUsuario);
		fieldNombreUsuario.setColumns(10);
		/**
		 * Campo para ingresar la contraseña
		 */
		fieldConstraseña = new JPasswordField();
		fieldConstraseña.setBounds(137, 77, 145, 20);
		getContentPane().add(fieldConstraseña);
		/**
		 * Botón para aceptar lo digitado y enviar la información
		 */
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!fieldNombreUsuario.getText().isEmpty() && !fieldConstraseña.getText().isEmpty())
				{
					if(administradorAplicacion.getInstance().validarUsuario(fieldNombreUsuario.getText(), fieldConstraseña.getText()))
					{
						fieldNombreUsuario.setText("");
						fieldConstraseña.setText("");
						ventanaPrincipal.getInstance().activarAplicacion();
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Bienvenido "+ administradorAplicacion.getInstance().getUsuario().getNombre() );
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
		/**
		 * Botón para cancelar la información ingresada
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fieldNombreUsuario.setText("");
				fieldConstraseña.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(159, 123, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
}
