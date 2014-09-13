package GUI;

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

public class ventanaLogin extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private static ventanaLogin miVentanaLogin;


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
		setTitle("Mea Providere - Iniciar Seci\u00F3n");
		setFrameIcon(new ImageIcon(ventanaLogin.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 186);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setBounds(10, 36, 99, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(10, 80, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(137, 33, 145, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 77, 145, 20);
		getContentPane().add(passwordField);
		
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
		btnNewButton.setBounds(22, 123, 89, 23);
		getContentPane().add(btnNewButton);
		
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
