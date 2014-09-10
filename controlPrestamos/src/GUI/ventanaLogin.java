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
	private JTextField textField;
	/**
	 * Campo para contraseña
	 */
	private JPasswordField passwordField;
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
		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setBounds(10, 36, 99, 14);
		getContentPane().add(lblNewLabel);
		/**
		 * Label para ingresar la contraseña
		 */
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(10, 80, 86, 14);
		getContentPane().add(lblNewLabel_1);
		/**
		 * Campo para ingresar el usuario
		 */
		textField = new JTextField();
		textField.setBounds(137, 33, 145, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		/**
		 * Campo para ingresar la contraseña
		 */
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 77, 145, 20);
		getContentPane().add(passwordField);
		/**
		 * Botón para aceptar lo digitado y enviar la información
		 */
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textField.getText().isEmpty() && !passwordField.getText().isEmpty())
				{
					if(administradorAplicacion.getInstance().validarUsuario(textField.getText(), passwordField.getText()))
					{
						textField.setText("");
						passwordField.setText("");
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
		btnNewButton.setBounds(22, 123, 89, 23);
		getContentPane().add(btnNewButton);
		/**
		 * Botón para cancelar la información ingresada
		 */
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				passwordField.setText("");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(159, 123, 89, 23);
		getContentPane().add(btnNewButton_1);
		
	}
}
