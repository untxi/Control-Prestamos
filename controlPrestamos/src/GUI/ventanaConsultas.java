package GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import Administradores.administradorAplicacion;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ventanaConsultas extends JInternalFrame {
	
	
	private static ventanaConsultas miVentanaConsultas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JSpinner spinner_1;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JSpinner spinner;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	
	
	public static ventanaConsultas getInstance()
	{
		if(miVentanaConsultas == null)
		{
			miVentanaConsultas = new ventanaConsultas();
		}
		return miVentanaConsultas;
	}
	
	
	/**
	 * Create the frame.
	 */
	private ventanaConsultas() {
		setTitle("Mea Providere - Consultas");
		setFrameIcon(new ImageIcon(ventanaConsultas.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setIconifiable(true);
		setBounds(100, 100, 701, 319);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeConsulta = new JLabel("Tipo de Consulta");
		lblTipoDeConsulta.setBounds(10, 11, 85, 14);
		getContentPane().add(lblTipoDeConsulta);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentana();
			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Top por categoria", "Todos los articulos por categoria", "Consulta Personalizada por categoria", "Todos los articulos prestados por categoria", "Todos los articulos no prestados por categoria"}));
		comboBox.setBounds(10, 36, 240, 20);
		getContentPane().add(comboBox);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setBounds(10, 117, 46, 14);
		getContentPane().add(lblFrom);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentanaPorFrom();
			}
		});
		comboBox_1.setBounds(10, 142, 240, 20);
		getContentPane().add(comboBox_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(260, 0, 8, 290);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(482, 0, 8, 290);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(260, 159, 220, 8);
		getContentPane().add(separator_2);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				administradorAplicacion.getInstance().getMiAdministradorConsultas().consulta(comboBox.getSelectedIndex(), comboBox_1.getSelectedIndex(),
						(Integer)spinner.getValue(),(Integer)spinner_1.getValue(), dateChooser.getJCalendar().getDate(), dateChooser_1.getJCalendar().getDate(), textField.getText(), textField_1.getText(),
						textField_2.getText(), textField_3.getText());
				limpiarVentana();
				setVisible(false);
					
			}
		});
		btnConsultar.setBounds(545, 11, 89, 23);
		getContentPane().add(btnConsultar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				limpiarVentana();
			}
		});
		btnLimpiar.setBounds(545, 141, 89, 23);
		getContentPane().add(btnLimpiar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				limpiarVentana();
				miVentanaConsultas.setVisible(false);
			}
		});
		btnCancelar.setBounds(545, 256, 89, 23);
		getContentPane().add(btnCancelar);
		
		
		panel = new JPanel();
		panel.setBounds(260, 0, 212, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWhere = new JLabel("WHERE");
		lblWhere.setBounds(77, 11, 46, 14);
		panel.add(lblWhere);
		
		textField = new JTextField();
		textField.setBounds(116, 36, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 74, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 105, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 136, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(25, 39, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setBounds(25, 77, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Editorial");
		lblNewLabel_2.setBounds(25, 108, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(25, 139, 46, 14);
		panel.add(lblPersona);
		panel.setVisible(false);
		
		panel_1 = new JPanel();
		panel_1.setBounds(270, 159, 202, 131);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCantidadDePrestamos = new JLabel("Cantidad de Prestamos");
		lblCantidadDePrestamos.setBounds(10, 27, 111, 14);
		panel_1.add(lblCantidadDePrestamos);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(145, 24, 47, 20);
		panel_1.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(10, 75, 46, 14);
		panel_1.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(10, 106, 46, 14);
		panel_1.add(lblHasta);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 69, 87, 20);
		panel_1.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(105, 100, 87, 20);
		panel_1.add(dateChooser_1);
		
	
		panel_2 = new JPanel();
		panel_2.setBounds(57, 218, 120, 49);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		spinner = new JSpinner();
		spinner.setBounds(74, 18, 46, 20);
		panel_2.add(spinner);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblLimit = new JLabel("LIMIT");
		lblLimit.setBounds(10, 21, 46, 14);
		panel_2.add(lblLimit);
		
		setVisible(false);
		cambiarComboBox();
		comboBox_1.setSelectedIndex(0);
		comboBox.setSelectedIndex(0);
		
		
		cambiarVentanaPorFrom();
	}
	
	public void cambiarComboBox()
	{
		int cantCategorias = administradorAplicacion.getInstance().getTiposCategorias().size();
		String [] categorias = new String[cantCategorias];
		for(int i = 0; i < cantCategorias; i++)
		{
			categorias[i] = administradorAplicacion.getInstance().getTiposCategorias().get(i);
		}
		comboBox_1.setModel(new DefaultComboBoxModel(categorias));
	}
	
	private void cambiarVentana()
	{
		if(comboBox.getSelectedIndex() == 0)
		{
			panel.setVisible(false);
			panel_2.setVisible(true);
			panel_1.setVisible(false);
		}
		if(comboBox.getSelectedIndex() == 1)
		{
			panel.setVisible(true);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
		}
		if(comboBox.getSelectedIndex() == 2)
		{
			panel.setVisible(false);
			panel_2.setVisible(false);
			panel_1.setVisible(true);
		}
		if(comboBox.getSelectedIndex() == 3)
		{
			panel.setVisible(true);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
			textField_3.setEnabled(true);
			textField_2.setEnabled(false);
			textField_1.setEnabled(false);
			textField.setEnabled(false);
		}
		if(comboBox.getSelectedIndex() == 4)
		{
			panel.setVisible(false);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
		}
	}
	
	private void cambiarVentanaPorFrom()
	{
		if(comboBox_1.getSelectedIndex() == 0)
		{
			lblNewLabel.setText("Titulo");
			lblNewLabel_1.setText("Autor");
			lblNewLabel_2.setText("Editorial");
			textField_3.setEnabled(false);
			textField_2.setEnabled(true);
			textField_1.setEnabled(true);
			textField.setEnabled(true);
			cambiarVentana();
		}
		if(comboBox_1.getSelectedIndex() == 1)
		{
			lblNewLabel.setText("Nombre");
			lblNewLabel_1.setText("Credor");
			lblNewLabel_2.setText("Editorial");
			textField_3.setEnabled(false);
			textField_2.setEnabled(true);
			textField_1.setEnabled(true);
			textField.setEnabled(true);
			cambiarVentana();
		}
		if(comboBox_1.getSelectedIndex() == 2)
		{
			lblNewLabel.setText("Nombre");
			lblNewLabel_1.setText("Director");
			lblNewLabel_2.setText("Editorial");
			textField_3.setEnabled(false);
			textField_2.setEnabled(false);
			textField_1.setEnabled(true);
			textField.setEnabled(true);
			cambiarVentana();
		}
		if(comboBox_1.getSelectedIndex() > 2)
		{
			lblNewLabel.setText("Nombre");
			lblNewLabel_1.setText("Director");
			lblNewLabel_2.setText("Editorial");
			textField_3.setEnabled(false);
			textField_2.setEnabled(false);
			textField_1.setEnabled(false);
			textField.setEnabled(true);
			cambiarVentana();
		}
	}
	
	private void limpiarVentana()
	{
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		textField_3.setText("");
		textField_2.setText("");
		textField_1.setText("");
		textField.setText("");
		((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
		((JTextField)dateChooser_1.getDateEditor().getUiComponent()).setText("");
		spinner.setValue(new Integer(0));
		spinner_1.setValue(new Integer(0));
		cambiarVentanaPorFrom();
	}
}
