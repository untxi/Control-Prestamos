package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ventanaAgregarPersona extends JInternalFrame 
{
	private static ventanaAgregarPersona miVentanaAgregarPersona;
	
	
	
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
		setBounds(100, 100, 363, 207);
	}

}
