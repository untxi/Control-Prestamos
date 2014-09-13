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

public class ventanaDevolverPrestamos extends JInternalFrame implements IConstantes
{
	
	private static ventanaDevolverPrestamos miVentanaDevolverPrestamos;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel label_1;
	
	
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
		setTitle("Mea Providere - Devoluci\u00F3n");
		setIconifiable(true);
		setFrameIcon(new ImageIcon(ventanaDevolverPrestamos.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setBounds(100, 100, 299, 300);
		getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int cantCategorias = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).size();
				String [] categorias = new String[cantCategorias];
				for(int i = 0; i < cantCategorias; i++)
				{
						categorias[i] = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).get(i).getMiArticulo().getNombre();
				}
				comboBox_1.setModel(new DefaultComboBoxModel(categorias));
			}
		});
		comboBox.setBounds(103, 19, 150, 20);
		getContentPane().add(comboBox);
		
		JLabel label = new JLabel("Categoria");
		label.setBounds(10, 22, 68, 14);
		getContentPane().add(label);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setBounds(10, 61, 46, 14);
		getContentPane().add(lblArticulo);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String nombreImagen;
				nombreImagen = administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).get(comboBox_1.getSelectedIndex()).getMiArticulo().getImagen();
				ImageIcon portada = new ImageIcon(pathImagenes + nombreImagen);
				label_1.setIcon(new ImageIcon(portada.getImage().getScaledInstance(104, 165, Image.SCALE_SMOOTH)));
			}
		});
		comboBox_1.setBounds(103, 58, 150, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).get(comboBox_1.getSelectedIndex()).getMiArticulo().setPrestado(false);
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).set(comboBox_1.getSelectedIndex(), null);
				administradorAplicacion.getInstance().getMiListaPrestamos().get(comboBox.getSelectedIndex()).remove(comboBox_1.getSelectedIndex());
				comboBox.setSelectedIndex(0);
				if(comboBox_1.getItemCount() != 0)
				{
					comboBox_1.setSelectedIndex(0);
				}
				setVisible(false);
			}
		});
		btnDevolver.setBounds(164, 184, 89, 23);
		getContentPane().add(btnDevolver);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBox.setSelectedIndex(0);
				if(comboBox_1.getItemCount() != 0)
				{
					comboBox_1.setSelectedIndex(0);
				}
				setVisible(false);
			}
		});
		btnCancelar.setBounds(164, 237, 89, 23);
		getContentPane().add(btnCancelar);
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 100, 104, 165);
		getContentPane().add(label_1);
	}
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBox.setModel(new DefaultComboBoxModel(categorias));
	}
	

	
}
