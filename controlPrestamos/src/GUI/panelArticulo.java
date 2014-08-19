package GUI;

import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Interfaces.IConstantes;
import java.awt.Color;
import java.awt.Rectangle;

public class panelArticulo extends JPanel implements IConstantes
{
	private ImageIcon portada = new ImageIcon(imagenPortada); 

	/**
	 * Create the panel.
	 */
	public panelArticulo(int y) 
	{
		setBounds(new Rectangle(0, y, 342, 165));
		setBackground(new Color(95, 158, 160));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 104, 165);
		lblNewLabel.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
		add(lblNewLabel);

	}
}
