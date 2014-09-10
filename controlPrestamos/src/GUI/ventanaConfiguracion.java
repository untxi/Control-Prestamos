package GUI;

//Librerias
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase ventanaConfiguración
 * Crea la ventana para manipular los parametros generales
 * 
 * @author Samantha
 */
public class ventanaConfiguracion extends JInternalFrame {
	// Métodos
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
	public ventanaConfiguracion() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 292);
		getContentPane().setLayout(null);
		/**
		 * Label de explicación: Alertas
		 */
		JLabel lblAlertas = new JLabel("Alertas");
		lblAlertas.setBounds(10, 23, 46, 14);
		getContentPane().add(lblAlertas);
		/**
		 * Label de explicación
		 */
		JLabel lblLasAlertasSe = new JLabel("Las alertas se dan en 3 rangos para  recordar las fechas vencidas de los prestamos");
		lblLasAlertasSe.setBounds(10, 48, 414, 14);
		getContentPane().add(lblLasAlertasSe);
		/**
		 * Label Primera Alerta
		 */
		JLabel lblPrimeraAlerta = new JLabel("Primera Alerta");
		lblPrimeraAlerta.setBounds(10, 73, 76, 14);
		getContentPane().add(lblPrimeraAlerta);
		/**
		 * Label Segunda Alerta
		 */
		JLabel lblSegundaAlerta = new JLabel("Segunda Alerta");
		lblSegundaAlerta.setBounds(140, 73, 76, 14);
		getContentPane().add(lblSegundaAlerta);
		/**
		 * Label Alerta Final
		 */
		JLabel lblAlertaFinal = new JLabel("Alerta Final");
		lblAlertaFinal.setBounds(282, 73, 76, 14);
		getContentPane().add(lblAlertaFinal);
		/**
		 * Label de explicación
		 */
		JLabel lblTopPrestamos = new JLabel("Top Prestamos");
		lblTopPrestamos.setBounds(10, 110, 76, 14);
		getContentPane().add(lblTopPrestamos);
		/** 
		 * Label Título
		 */
		JLabel lblParmatrosGeneralesDe = new JLabel("Par\u00E1matros Generales de Configuraci\u00F3n");
		lblParmatrosGeneralesDe.setBounds(121, 11, 199, 14);
		getContentPane().add(lblParmatrosGeneralesDe);
		
		TextField fieldVerde = new TextField();
		fieldVerde.setText("15");
		fieldVerde.setBounds(92, 68, 28, 22);
		getContentPane().add(fieldVerde);
		
		TextField fieldAmarillo = new TextField();
		fieldAmarillo.setText("30");
		fieldAmarillo.setBounds(222, 68, 28, 22);
		getContentPane().add(fieldAmarillo);
		
		TextField fieldRojo = new TextField();
		fieldRojo.setText("45");
		fieldRojo.setBounds(343, 68, 28, 22);
		getContentPane().add(fieldRojo);
		
		TextField textFieldTop = new TextField();
		textFieldTop.setText("10");
		textFieldTop.setBounds(92, 110, 28, 22);
		getContentPane().add(textFieldTop);
		
		JButton btnAceptar = new JButton("Guardar Cambios");
		btnAceptar.setBounds(54, 212, 115, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(243, 212, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblVecesConsultados = new JLabel("Veces Consultados");
		lblVecesConsultados.setBounds(10, 168, 102, 14);
		getContentPane().add(lblVecesConsultados);
		
		JLabel lblTopDePrestamos = new JLabel("Top de Prestamos una cantidad de veces en ciertos meses");
		lblTopDePrestamos.setBounds(10, 143, 288, 14);
		getContentPane().add(lblTopDePrestamos);
		
		TextField fieldVeces = new TextField();
		fieldVeces.setText("3");
		fieldVeces.setBounds(109, 163, 28, 22);
		getContentPane().add(fieldVeces);
		
		JLabel lblMesesConsultados = new JLabel("Meses Consultados");
		lblMesesConsultados.setBounds(170, 168, 102, 14);
		getContentPane().add(lblMesesConsultados);
		
		TextField fieldMeses = new TextField();
		fieldMeses.setText("6");
		fieldMeses.setBounds(270, 163, 28, 22);
		getContentPane().add(fieldMeses);

	}
}
