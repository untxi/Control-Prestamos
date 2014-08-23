package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Administradores.administradorAplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaRegistroUsuario extends JInternalFrame 
{
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private static ventanaRegistroUsuario miVentanaRegistroUsuario;


	public static ventanaRegistroUsuario getInstance()
	{
		if(miVentanaRegistroUsuario == null)
		{
			miVentanaRegistroUsuario = new ventanaRegistroUsuario();
		}
		return miVentanaRegistroUsuario;
	}
	
	/**
	 * Create the frame.
	 */
	private ventanaRegistroUsuario() 
	{
		setIconifiable(true);
		setBounds(100, 100, 351, 232);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(171, 11, 150, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 122, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Usuario");
		lblNewLabel_1.setBounds(10, 68, 94, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(10, 116, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 65, 150, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 113, 150, 20);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && !passwordField.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarUsuario(textField.getText(), textField_1.getText(), passwordField.getText());
					textField.setText("");
					textField_1.setText("");
					passwordField.setText("");
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
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(183, 169, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
