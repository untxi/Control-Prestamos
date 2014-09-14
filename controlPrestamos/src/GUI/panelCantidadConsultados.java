package GUI;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import Interfaces.IConstantes;

import java.awt.Font;

public class panelCantidadConsultados extends JPanel implements IConstantes 
{
	
	private JLabel text;
	private JLabel num;

	/**
	 * Create the panel.
	 */
	public panelCantidadConsultados(int y,int pCantidad, int pConsulta) 
	{
		setBounds(new Rectangle(0, y, 534, 267));
		setBackground(new Color(204, 153, 204));
		setLayout(null);
		
		if(pConsulta == consultaTodos)
		{
			text = new JLabel("Cantidad de articulos consultados");
		}
		if(pConsulta == consultaPrestados)
		{
			text = new JLabel("Cantidad de articulos prestados");
		}
		if(pConsulta == consultaNoPrestados)
		{
			text = new JLabel("cantidad de articulos no prestados");
		}

		text.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		text.setBounds(21, 62, 451, 43);
		add(text);
		
		num = new JLabel(((Integer)pCantidad).toString());
		num.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		num.setBounds(373, 189, 151, 43);
		add(num);
	}

}
