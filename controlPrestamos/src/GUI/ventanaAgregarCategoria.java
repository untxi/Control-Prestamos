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
		setTitle("Mea Providere - Ingresar Categor\u00EDa");
		setFrameIcon(new ImageIcon(ventanaAgregarCategoria.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 149);
		getContentPane().setLayout(null);
		
		JLabel lblNuevaCategoria = new JLabel("Nueva Categor\u00EDa");
		lblNuevaCategoria.setBounds(10, 23, 104, 14);
		getContentPane().add(lblNuevaCategoria);
		
		fieldNuevaCategoria = new JTextField();
		fieldNuevaCategoria.setBounds(136, 20, 147, 20);
		getContentPane().add(fieldNuevaCategoria);
		fieldNuevaCategoria.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!fieldNuevaCategoria.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarCategoria(fieldNuevaCategoria.getText());
					fieldNuevaCategoria.setText("");
					setVisible(false);
					JOptionPane.showMessageDialog(null, "La categor�a se ha agregado correctamente");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No ha escrito ninguna categor�a");
				}
			}
		});
		btnAceptar.setBounds(10, 82, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fieldNuevaCategoria.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(194, 82, 89, 23);
		getContentPane().add(btnCancelar);

	}

}
