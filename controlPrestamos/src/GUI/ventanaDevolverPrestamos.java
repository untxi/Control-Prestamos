package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Administradores.administradorAplicacion;
import Interfaces.IConstantes;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ventanaDevolverPrestamos extends JInternalFrame implements IConstantes
{
	
	private static ventanaDevolverPrestamos miVentanaDevolverPrestamos;
	private JComboBox comboBoxCategoria;
	private JComboBox comboBoxArticulo;
	private JLabel lblImagen;
	
	
	public static ventanaDevolverPrestamos getInstance()
	{
		if(miVentanaDevolverPrestamos == null)
		{
			miVentanaDevolverPrestamos = new ventanaDevolverPrestamos();
		}
		return miVentanaDevolverPrestamos; 
	} 


	/**
	 * Create the frame.
	 */
	private ventanaDevolverPrestamos() 
	{
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Devoluci\u00F3n");
		setIconifiable(true);
		setFrameIcon(new ImageIcon(ventanaDevolverPrestamos.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setBounds(100, 100, 299, 300);
		getContentPane().setLayout(null);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
						categorias[i] = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).get(i).getMiArticulo().getNombre();
				}
				comboBoxArticulo.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBoxCategoria.setBounds(103, 19, 150, 20);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCategoria.setBounds(10, 22, 68, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblArticulo = new JLabel("Art\u00EDculo");
		lblArticulo.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblArticulo.setBounds(10, 61, 46, 14);
		getContentPane().add(lblArticulo);
		
		comboBoxArticulo = new JComboBox();
		comboBoxArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String nombreImagen;
				nombreImagen = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).get(comboBoxArticulo.getSelectedIndex()).getMiArticulo().getImagen();
				ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
				lblImagen.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			}
		});
		comboBoxArticulo.setBounds(103, 58, 150, 20);
		getContentPane().add(comboBoxArticulo);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setForeground(new Color(204, 0, 102));
		btnDevolver.setBackground(new Color(255, 153, 0));
		btnDevolver.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).get(comboBoxArticulo.getSelectedIndex()).getMiArticulo().setPrestado(false);
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).set(comboBoxArticulo.getSelectedIndex(), null);
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBoxCategoria.getSelectedIndex()).remove(comboBoxArticulo.getSelectedIndex());
				comboBoxCategoria.setSelectedIndex(0);
				if(comboBoxArticulo.getItemCount() != 0)
				{
					comboBoxArticulo.setSelectedIndex(0);
				}
				setVisible(false);
			}
		});
		btnDevolver.setBounds(164, 184, 89, 23);
		getContentPane().add(btnDevolver);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(204, 0, 102));
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setFont(new Font("Gisha", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxCategoria.setSelectedIndex(0);
				if(comboBoxArticulo.getItemCount() != 0)
				{
					comboBoxArticulo.setSelectedIndex(0);
				}
				setVisible(false);
			}
		});
		btnCancelar.setBounds(164, 237, 89, 23);
		getContentPane().add(btnCancelar);
		
		lblImagen = new JLabel("");
		lblImagen.setBackground(new Color(255, 153, 0));
		lblImagen.setBounds(10, 100, 104, 165);
		getContentPane().add(lblImagen);
	}
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBoxCategoria.setModel(new DefaultComboBoxModel(categorias));
	}
	

	
}
