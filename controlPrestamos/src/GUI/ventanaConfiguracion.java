package GUI;
/**
 * Ventana para el ingreso de los datos del usuario al registro
 * 
 * @author Samantha Arburola
 */

// Librerias y clases
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;

import Administradores.administradorAplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

/**
 * Clase ventanaRegistroUsuario
 * 
 * Permite ingresar toda la información de usuario
 * 
 * @author Samantha Arburola
 */
public class ventanaConfiguracion extends JInternalFrame
{
	
	private JSpinner spinnerPrestamo;
	private JSpinner spinnerTolerancia;
	private static ventanaConfiguracion miVentanaConfiguracion;
	
	
	public static ventanaConfiguracion getInstance()
	{
		if(miVentanaConfiguracion == null)
		{
			miVentanaConfiguracion = new ventanaConfiguracion();
		}
		return miVentanaConfiguracion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaConfiguracion frame = new ventanaConfiguracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private ventanaConfiguracion() {
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Preferencias");
		setFrameIcon(new ImageIcon(ventanaConfiguracion.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setIconifiable(true);
		setBounds(100, 100, 339, 142);
		getContentPane().setLayout(null);
		// Días de prestamo
		JLabel lblDiasDePrestamo = new JLabel("D\u00EDas de Pr\u00E9stamo");
		lblDiasDePrestamo.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblDiasDePrestamo.setBounds(10, 24, 102, 14);
		getContentPane().add(lblDiasDePrestamo);
		// Días de tolerancia
		JLabel lblDiasDeTolerancia = new JLabel("D\u00EDas de Tolerancia");
		lblDiasDeTolerancia.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblDiasDeTolerancia.setBounds(10, 74, 102, 14);
		getContentPane().add(lblDiasDeTolerancia);
		
		spinnerPrestamo = new JSpinner();
		spinnerPrestamo.setBounds(146, 21, 29, 20);
		getContentPane().add(spinnerPrestamo);
		
		spinnerTolerancia = new JSpinner();
		spinnerTolerancia.setBounds(146, 71, 29, 20);
		getContentPane().add(spinnerTolerancia);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 153, 0));
		btnAceptar.setForeground(new Color(204, 0, 102));
		btnAceptar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				administradorAplicacion.getInstance().setDiasPrestamo((Integer)spinnerPrestamo.getValue());
				administradorAplicacion.getInstance().setDiasTolerancia((Integer)spinnerTolerancia.getValue());
				spinnerPrestamo.setValue(new Integer(0));
				spinnerTolerancia.setValue(new Integer(0));
				setVisible(false);
			}
		});
		btnAceptar.setBounds(224, 20, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setForeground(new Color(204, 0, 102));
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				spinnerPrestamo.setValue(new Integer(0));
				spinnerTolerancia.setValue(new Integer(0));
				setVisible(false);
			}
		});
		btnCancelar.setBounds(224, 70, 89, 23);
		getContentPane().add(btnCancelar);
		setVisible(false);
	}
}
