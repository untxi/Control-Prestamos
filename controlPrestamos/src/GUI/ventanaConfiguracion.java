package GUI;

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

public class ventanaConfiguracion extends JInternalFrame
{
	
	private JSpinner spinner;
	private JSpinner spinner_1;
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
		setFrameIcon(new ImageIcon(ventanaConfiguracion.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setIconifiable(true);
		setBounds(100, 100, 339, 142);
		getContentPane().setLayout(null);
		
		JLabel lblDiasDePrestamo = new JLabel("Dias de Prestamo");
		lblDiasDePrestamo.setBounds(10, 24, 102, 14);
		getContentPane().add(lblDiasDePrestamo);
		
		JLabel lblDiasDeTolerancia = new JLabel("Dias de Tolerancia");
		lblDiasDeTolerancia.setBounds(10, 74, 102, 14);
		getContentPane().add(lblDiasDeTolerancia);
		
		spinner = new JSpinner();
		spinner.setBounds(146, 21, 29, 20);
		getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(146, 71, 29, 20);
		getContentPane().add(spinner_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				administradorAplicacion.getInstance().setDiasPrestamo((Integer)spinner.getValue());
				administradorAplicacion.getInstance().setDiasTolerancia((Integer)spinner_1.getValue());
				spinner.setValue(new Integer(0));
				spinner_1.setValue(new Integer(0));
				setVisible(false);
			}
		});
		btnAceptar.setBounds(224, 20, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				spinner.setValue(new Integer(0));
				spinner_1.setValue(new Integer(0));
				setVisible(false);
			}
		});
		btnCancelar.setBounds(224, 70, 89, 23);
		getContentPane().add(btnCancelar);
		setVisible(false);
	}
}
