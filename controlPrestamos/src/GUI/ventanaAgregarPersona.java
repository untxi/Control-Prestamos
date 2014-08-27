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

public class ventanaAgregarPersona extends JInternalFrame 
{
	private static ventanaAgregarPersona miVentanaAgregarPersona;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	
	
	
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
		setIconifiable(true);
		setBounds(100, 100, 624, 196);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Primer Apellido");
		lblNewLabel_1.setBounds(176, 14, 80, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido");
		lblNewLabel_2.setBounds(381, 14, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00E9dula");
		lblNewLabel_3.setBounds(10, 69, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(176, 69, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setBounds(381, 69, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(66, 11, 100, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 11, 105, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(487, 11, 111, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 66, 100, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(266, 66, 105, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(487, 66, 111, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Colega", "Familiar", "Estudiante"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(66, 123, 156, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setBounds(10, 126, 71, 14);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() &&
				   !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty() &&
				   !textField_4.getText().isEmpty() && !textField_5.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarPersona(textField.getText(), 
							textField_1.getText(),textField_2.getText(), textField_3.getText(),
							textField_4.getText(), textField_5.getText(), comboBox.getSelectedIndex());
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Se agrego la persona con exito");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del formulario");
				}
			}
		});
		btnNewButton.setBounds(282, 122, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(487, 122, 89, 23);
		getContentPane().add(btnNewButton_1);
	}
}
