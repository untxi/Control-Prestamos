package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import Administradores.administradorAplicacion;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ventanaAgregarArticulo extends JInternalFrame {

	private static ventanaAgregarArticulo miVentanaAgregarArticulo;
	private JComboBox comboBox;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	public static ventanaAgregarArticulo getInstance()
	{
		if(miVentanaAgregarArticulo == null)
		{
			miVentanaAgregarArticulo = new ventanaAgregarArticulo();
		}
		return miVentanaAgregarArticulo;
	}

	/**
	 * Create the frame.
	 */
	public ventanaAgregarArticulo()
	{
		setIconifiable(true);
		setBounds(100, 100, 457, 459);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categoria");
		
		comboBox = new JComboBox();
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//setear todos los cosos antes de cerrar
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSeleccioneLaCategoria, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCancelar)
					.addContainerGap(325, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeleccioneLaCategoria)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCancelar)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
		);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Agregar Libro", null, panel_1, null);
		getContentPane().setLayout(groupLayout);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(232, 31, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edicion");
		lblNewLabel_2.setBounds(10, 87, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Calificacion");
		lblNewLabel_3.setBounds(232, 87, 70, 14);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(66, 28, 143, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 28, 152, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 84, 143, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1 Estrella", "3 Estrelas", "4 Estrelas", "5 Estrelas", "6 Estrelas", "7 Estrelas", "8 Estrelas", "9 Estrelas", "10 Estrelas"}));
		comboBox_1.setBounds(305, 84, 121, 20);
		panel_1.add(comboBox_1);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 114, 104, 165);
		panel_1.add(label);
		
		JButton btnCargarImagen = new JButton("Cargar Imagen");
		btnCargarImagen.setBounds(20, 290, 104, 23);
		panel_1.add(btnCargarImagen);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(305, 290, 89, 23);
		panel_1.add(btnAceptar);
		
		panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Agregar Revista", null, panel, null);
		
		JLabel label_1 = new JLabel("Titulo");
		label_1.setBounds(10, 31, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor");
		label_2.setBounds(232, 31, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Edicion");
		label_3.setBounds(10, 87, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Calificacion");
		label_4.setBounds(232, 87, 70, 14);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 28, 143, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(274, 28, 152, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(69, 84, 143, 20);
		panel.add(textField_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(305, 84, 121, 20);
		panel.add(comboBox_2);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(20, 114, 104, 165);
		panel.add(label_5);
		
		JButton button = new JButton("Cargar Imagen");
		button.setBounds(20, 290, 104, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Aceptar");
		button_1.setBounds(305, 290, 89, 23);
		panel.add(button_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Agregar Pelicula", null, panel_2, null);
		
		JLabel label_6 = new JLabel("Titulo");
		label_6.setBounds(10, 31, 46, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Autor");
		label_7.setBounds(232, 31, 46, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Edicion");
		label_8.setBounds(10, 87, 46, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Calificacion");
		label_9.setBounds(232, 87, 70, 14);
		panel_2.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(66, 28, 143, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(274, 28, 152, 20);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(69, 84, 143, 20);
		panel_2.add(textField_8);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(305, 84, 121, 20);
		panel_2.add(comboBox_3);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(20, 114, 104, 165);
		panel_2.add(label_10);
		
		JButton button_2 = new JButton("Cargar Imagen");
		button_2.setBounds(20, 290, 104, 23);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("Aceptar");
		button_3.setBounds(305, 290, 89, 23);
		panel_2.add(button_3);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Agregar Articulo", null, panel_3, null);
		
		JLabel label_11 = new JLabel("Titulo");
		label_11.setBounds(10, 31, 46, 14);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Autor");
		label_12.setBounds(232, 31, 46, 14);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("Edicion");
		label_13.setBounds(10, 87, 46, 14);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Calificacion");
		label_14.setBounds(232, 87, 70, 14);
		panel_3.add(label_14);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(66, 28, 143, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(274, 28, 152, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(69, 84, 143, 20);
		panel_3.add(textField_11);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(305, 84, 121, 20);
		panel_3.add(comboBox_4);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(20, 114, 104, 165);
		panel_3.add(label_15);
		
		JButton button_4 = new JButton("Cargar Imagen");
		button_4.setBounds(20, 290, 104, 23);
		panel_3.add(button_4);
		
		JButton button_5 = new JButton("Aceptar");
		button_5.setBounds(305, 290, 89, 23);
		panel_3.add(button_5);
		
		panel.setVisible(false);
		panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
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
