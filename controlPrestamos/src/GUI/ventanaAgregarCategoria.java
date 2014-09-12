package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Administradores.administradorAplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class ventanaAgregarCategoria extends JInternalFrame {

	
	private static ventanaAgregarCategoria miVentanaAgregarCategoria;
	private JTextField textField;
	
	
	public static ventanaAgregarCategoria getInstance()
	{
		if(miVentanaAgregarCategoria == null)
		{
			miVentanaAgregarCategoria = new ventanaAgregarCategoria();
		}
		return miVentanaAgregarCategoria;
	}
	

	/**
	 * Create the frame.
	 */
	public ventanaAgregarCategoria() 
	{
		setFrameIcon(new ImageIcon(ventanaAgregarCategoria.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 149);
		getContentPane().setLayout(null);
		
		JLabel lblNuevaCategoria = new JLabel("Nueva Categoria");
		lblNuevaCategoria.setBounds(10, 23, 104, 14);
		getContentPane().add(lblNuevaCategoria);
		
		textField = new JTextField();
		textField.setBounds(136, 20, 147, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textField.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarCategoria(textField.getText());
					textField.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "La categoria se ha agregado correctamente");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No ha escrito ninguna categoria");
				}
			}
		});
		btnAceptar.setBounds(10, 82, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(194, 82, 89, 23);
		getContentPane().add(btnCancelar);

	}

}
