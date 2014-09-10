package GUI;
// Importar Librerías
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
// Importar Clases
import Administradores.administradorAplicacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
/**
 * Clase ventanaAgregarCategoria
 * Permite agregar categorías para artículos nuevos diferentes a los existentes
 * 
 * @author Samantha Arburola
 */
public class ventanaAgregarCategoria extends JInternalFrame {
	// Atributos
	/**
	 * Ventana para ingresar datos
	 */
	private static ventanaAgregarCategoria miVentanaAgregarCategoria;
	/**
	 * Ingresar Categoría
	 */
	private JTextField textFieldCategoria;
	// Métodos
	/**
	 * Método Público: ventanaAgregarCategoria
	 * Permite crear la nueva categoría
	 * 
	 * @return ventana para ingresar categoría
	 */
	public static ventanaAgregarCategoria getInstance()
	{
		if(miVentanaAgregarCategoria == null)
		{
			miVentanaAgregarCategoria = new ventanaAgregarCategoria();
		}
		return miVentanaAgregarCategoria;
	}
	

	/**
	 * Crea la ventana
	 */
	public ventanaAgregarCategoria() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setBounds(100, 100, 315, 149);
		getContentPane().setLayout(null);
		/**
		 * Label para ingresar la categoría
		 */
		JLabel lblNuevaCategoria = new JLabel("Nueva Categoria");
		lblNuevaCategoria.setBounds(10, 23, 104, 14);
		getContentPane().add(lblNuevaCategoria);
		/**
		 * Campo para ingresar la nueva categoría
		 */
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(136, 20, 147, 20);
		getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		/**
		 * Botón para aceptar lo digitado y enviar la información
		 */
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(!textFieldCategoria.getText().isEmpty())
				{
					administradorAplicacion.getInstance().agregarCategoria(textFieldCategoria.getText());
					textFieldCategoria.setText("");
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
		/**
		 * Botón para cancelar la información ingresada
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textFieldCategoria.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(194, 82, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
