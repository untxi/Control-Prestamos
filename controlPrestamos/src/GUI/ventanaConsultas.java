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
import java.awt.Font;
import java.awt.Color;

public class ventanaConsultas extends JInternalFrame {
	
	
	private static ventanaConsultas miVentanaConsultas;
	private JTextField fieldTitulo;
	private JTextField fieldAutor;
	private JTextField fieldEditorial;
	private JComboBox comboBoxDesde;
	private JComboBox comboBoxTipoConsulta;
	private JSpinner spinnerCantidadPrestamos;
	private JDateChooser dateChooserDesde;
	private JDateChooser dateChooserHasta;
	private JSpinner spinnerLimite;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JTextField fieldPersona;
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
		setBackground(new Color(153, 102, 153));
		getContentPane().setBackground(new Color(51, 153, 204));
		setTitle("Mea Providere - Consultas");
		setFrameIcon(new ImageIcon(ventanaConsultas.class.getResource("/Recursos/ImagenesGUI/Logo Adrian.png")));
		setIconifiable(true);
		setBounds(100, 100, 758, 319);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeConsulta = new JLabel("Tipo de Consulta");
		lblTipoDeConsulta.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblTipoDeConsulta.setBounds(10, 11, 113, 14);
		getContentPane().add(lblTipoDeConsulta);
		
		comboBoxTipoConsulta = new JComboBox();
		comboBoxTipoConsulta.setBackground(new Color(255, 102, 0));
		comboBoxTipoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentana();
			}
		});

		comboBoxTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Top por categoria", "Todos los articulos por categoria", "Consulta Personalizada por categoria", "Todos los articulos prestados por categoria", "Todos los articulos no prestados por categoria"}));
		comboBoxTipoConsulta.setBounds(10, 36, 313, 20);
		getContentPane().add(comboBoxTipoConsulta);
		
		JLabel lblDesdeTipo = new JLabel("Desde");
		lblDesdeTipo.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblDesdeTipo.setBounds(10, 117, 46, 14);
		getContentPane().add(lblDesdeTipo);
		
		comboBoxDesde = new JComboBox();
		comboBoxDesde.setBackground(new Color(255, 102, 0));
		comboBoxDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cambiarVentanaPorFrom();
			}
		});
		comboBoxDesde.setBounds(10, 142, 240, 20);
		getContentPane().add(comboBoxDesde);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(359, 0, 8, 290);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(611, 0, 8, 290);
		getContentPane().add(separator_1);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnConsultar.setBackground(new Color(255, 153, 0));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				administradorAplicacion.getInstance().getMiAdministradorConsultas().consulta(comboBoxTipoConsulta.getSelectedIndex(), comboBoxDesde.getSelectedIndex(),
						(Integer)spinnerLimite.getValue(),(Integer)spinnerCantidadPrestamos.getValue(), dateChooserDesde.getJCalendar().getDate(), dateChooserHasta.getJCalendar().getDate(), fieldTitulo.getText(), fieldAutor.getText(),
						fieldEditorial.getText(), fieldPersona.getText());
				limpiarVentana();
				setVisible(false);
					
			}
		});
		btnConsultar.setBounds(631, 47, 105, 23);
		getContentPane().add(btnConsultar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnLimpiar.setBackground(new Color(255, 153, 0));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				limpiarVentana();
			}
		});
		btnLimpiar.setBounds(631, 142, 105, 23);
		getContentPane().add(btnLimpiar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				limpiarVentana();
				miVentanaConsultas.setVisible(false);
			}
		});
		btnCancelar.setBounds(631, 218, 105, 23);
		getContentPane().add(btnCancelar);
		
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 153, 204));
		panel.setBounds(379, 0, 212, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFiltro = new JLabel("FILTRO");
		lblFiltro.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblFiltro.setBounds(78, 11, 46, 14);
		panel.add(lblFiltro);
		
		fieldTitulo = new JTextField();
		fieldTitulo.setBounds(116, 36, 86, 26);
		panel.add(fieldTitulo);
		fieldTitulo.setColumns(10);
		
		fieldAutor = new JTextField();
		fieldAutor.setBounds(116, 74, 86, 26);
		panel.add(fieldAutor);
		fieldAutor.setColumns(10);
		
		fieldEditorial = new JTextField();
		fieldEditorial.setBounds(116, 105, 86, 26);
		panel.add(fieldEditorial);
		fieldEditorial.setColumns(10);
		
		fieldPersona = new JTextField();
		fieldPersona.setBounds(116, 136, 86, 26);
		panel.add(fieldPersona);
		fieldPersona.setColumns(10);
		
		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblTitulo.setBounds(25, 39, 46, 14);
		panel.add(lblTitulo);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblAutor.setBounds(25, 77, 46, 14);
		panel.add(lblAutor);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblEditorial.setBounds(25, 108, 46, 14);
		panel.add(lblEditorial);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblPersona.setBounds(25, 139, 73, 14);
		panel.add(lblPersona);
		panel.setVisible(false);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 204));
		panel_1.setBounds(379, 159, 212, 131);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCantidadDePrestamos = new JLabel("Cantidad de Prestamos");
		lblCantidadDePrestamos.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblCantidadDePrestamos.setBounds(10, 27, 134, 14);
		panel_1.add(lblCantidadDePrestamos);
		
		spinnerCantidadPrestamos = new JSpinner();
		spinnerCantidadPrestamos.setBounds(145, 24, 47, 20);
		panel_1.add(spinnerCantidadPrestamos);
		spinnerCantidadPrestamos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblDesde.setBounds(10, 75, 46, 14);
		panel_1.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Gisha", Font.PLAIN, 11));
		lblHasta.setBounds(10, 106, 46, 14);
		panel_1.add(lblHasta);
		
		dateChooserDesde = new JDateChooser();
		dateChooserDesde.getCalendarButton().setBackground(new Color(255, 153, 0));
		dateChooserDesde.setBounds(105, 69, 87, 20);
		panel_1.add(dateChooserDesde);
		
		dateChooserHasta = new JDateChooser();
		dateChooserHasta.getCalendarButton().setBackground(new Color(255, 153, 0));
		dateChooserHasta.setBounds(105, 100, 87, 20);
		panel_1.add(dateChooserHasta);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 7, 220, 8);
		panel_1.add(separator_2);
		
	
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 204));
		panel_2.setBounds(57, 218, 120, 49);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		spinnerLimite = new JSpinner();
		spinnerLimite.setBounds(74, 18, 46, 20);
		panel_2.add(spinnerLimite);
		spinnerLimite.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JLabel lblLimite = new JLabel("L\u00EDmite");
		lblLimite.setFont(new Font("Gisha", Font.PLAIN, 12));
		lblLimite.setBounds(18, 21, 46, 14);
		panel_2.add(lblLimite);
		
		setVisible(false);
		cambiarComboBox();
		comboBoxDesde.setSelectedIndex(0);
		comboBoxTipoConsulta.setSelectedIndex(0);
		
		
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
		comboBoxDesde.setModel(new DefaultComboBoxModel(categorias));
	}
	
	private void cambiarVentana()
	{
		if(comboBoxTipoConsulta.getSelectedIndex() == 0)
		{
			panel.setVisible(false);
			panel_2.setVisible(true);
			panel_1.setVisible(false);
		}
		if(comboBoxTipoConsulta.getSelectedIndex() == 1)
		{
			panel.setVisible(true);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
		}
		if(comboBoxTipoConsulta.getSelectedIndex() == 2)
		{
			panel.setVisible(false);
			panel_2.setVisible(false);
			panel_1.setVisible(true);
		}
		if(comboBoxTipoConsulta.getSelectedIndex() == 3)
		{
			panel.setVisible(true);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
			fieldPersona.setEnabled(true);
			fieldEditorial.setEnabled(false);
			fieldAutor.setEnabled(false);
			fieldTitulo.setEnabled(false);
		}
		if(comboBoxTipoConsulta.getSelectedIndex() == 4)
		{
			panel.setVisible(false);
			panel_2.setVisible(false);
			panel_1.setVisible(false);
		}
	}
	
	private void cambiarVentanaPorFrom()
	{
		if(comboBoxDesde.getSelectedIndex() == 0)
		{
			lblTitulo.setText("Titulo");
			lblAutor.setText("Autor");
			lblEditorial.setText("Editorial");
			fieldPersona.setEnabled(false);
			fieldEditorial.setEnabled(true);
			fieldAutor.setEnabled(true);
			fieldTitulo.setEnabled(true);
			cambiarVentana();
		}
		if(comboBoxDesde.getSelectedIndex() == 1)
		{
			lblTitulo.setText("Nombre");
			lblAutor.setText("Credor");
			lblEditorial.setText("Editorial");
			fieldPersona.setEnabled(false);
			fieldEditorial.setEnabled(true);
			fieldAutor.setEnabled(true);
			fieldTitulo.setEnabled(true);
			cambiarVentana();
		}
		if(comboBoxDesde.getSelectedIndex() == 2)
		{
			lblTitulo.setText("Nombre");
			lblAutor.setText("Director");
			lblEditorial.setText("Editorial");
			fieldPersona.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldAutor.setEnabled(true);
			fieldTitulo.setEnabled(true);
			cambiarVentana();
		}
		if(comboBoxDesde.getSelectedIndex() > 2)
		{
			lblTitulo.setText("Nombre");
			lblAutor.setText("Director");
			lblEditorial.setText("Editorial");
			fieldPersona.setEnabled(false);
			fieldEditorial.setEnabled(false);
			fieldAutor.setEnabled(false);
			fieldTitulo.setEnabled(true);
			cambiarVentana();
		}
	}
	
	private void limpiarVentana()
	{
		comboBoxTipoConsulta.setSelectedIndex(0);
		comboBoxDesde.setSelectedIndex(0);
		fieldPersona.setText("");
		fieldEditorial.setText("");
		fieldAutor.setText("");
		fieldTitulo.setText("");
		((JTextField)dateChooserDesde.getDateEditor().getUiComponent()).setText("");
		((JTextField)dateChooserHasta.getDateEditor().getUiComponent()).setText("");
		spinnerLimite.setValue(new Integer(0));
		spinnerCantidadPrestamos.setValue(new Integer(0));
		cambiarVentanaPorFrom();
	}
}
