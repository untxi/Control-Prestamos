package GUI;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Estructuras.Articulo;
import Interfaces.IConstantes;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
/**
 * Clase panel articulo
 * 
 * contiene información del articulo
 * 
 * @author Adrián
 *
 */
public class panelArticulo extends JPanel implements IConstantes
{
	//Atributo
	/**
	 * Imagen de la portada
	 */
	private ImageIcon portada; 

	//Médoto
	/**
	 * constructor con tres parametros
	 * @param y
	 * @param pArticulo
	 * @param pCategoria
	 */
	public panelArticulo(int y, Articulo pArticulo, int pCategoria) 
	{
		portada = new ImageIcon(pathImagenes+pArticulo.getImagen());
		setBounds(new Rectangle(0, y, 534, 267));
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 165, 265);
		lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(164, 265, Image.SCALE_SMOOTH)));
		add(lblImagen);

	}
}
