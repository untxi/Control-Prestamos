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
import javax.swing.JButton;

import Administradores.administradorAplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase ventanaRegistroUsuario
 * 
 * Permite ingresar toda la informaci�n de usuario
 * 
 * @author Samantha
 */
public class ventanaAgregarCategoria extends JInternalFrame {

	// Atributos
	/**
	 * Crea la ventana
	 */
	private static ventanaAgregarCategoria miVentanaAgregarCategoria;
	/**
	 * Ingresar la categor�a nueva
	 */
	private JTextField fieldNuevaCategoria;
	
	
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
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Ingresar Categor\u00EDa");
		setFrameIcon(new ImageIcon(ventanaAgregarCategoria.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 149);
		getContentPane().setLayout(null);
		
		JLabel lblNuevaCategoria = new JLabel("Nueva Categor\u00EDa");
		lblNuevaCategoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblNuevaCategoria.setBounds(22, 20, 104, 14);
		getContentPane().add(lblNuevaCategoria);
		
		fieldNuevaCategoria = new JTextField();
		fieldNuevaCategoria.setBounds(136, 20, 147, 30);
		getContentPane().add(fieldNuevaCategoria);
		fieldNuevaCategoria.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 153, 0));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!fieldNuevaCategoria.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarCategoria(fieldNuevaCategoria.getText());
					fieldNuevaCategoria.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "La categoría se ha agregado correctamente");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No ha escrito ninguna categoría");
				}
			}
		});
		btnAceptar.setBounds(22, 79, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fieldNuevaCategoria.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(185, 82, 98, 23);
		getContentPane().add(btnCancelar);

	}

}
