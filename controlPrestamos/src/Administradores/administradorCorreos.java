package Administradores;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Clase Administrador de Correos
 * 	Enviar un correo electr�nico con un mensaje de recordatorio 
 * 	para la devoluci�n del art�culo
 * 
 * @author Adrian Soto
 */
public class administradorCorreos
{
	
	// M�todos
	// Constructor
	public administradorCorreos(){}
	
	/**
	 * simpleMail
	 * 	Funci�n con la que se env�a el correo electr�nico a los pr�stamos vencidos
	 * @param to 		  a quien se env�a el correo 
	 */
	public void simpleMail(String to) throws Exception {
		  
		    String host = "smtp.gmail.com";
		    Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable",true);
		    /* mail.smtp.ssl.trust is needed in script to avoid error "Could not convert socket to TLS"  */ 
		    props.setProperty("mail.smtp.ssl.trust", host);
		    props.put("mail.smtp.auth", true);      
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", "controlprestamos896@gmail.com");
		    props.put("mail.smtp.password", "ControlAdrian");
		    props.put("mail.smtp.port", "587");
		  
		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress("controlprestamos896@gmail.com"));
		 
		    InternetAddress toAddress = new InternetAddress(to);
		    // Correo Electr�nico del Destinatario
		    message.addRecipient(Message.RecipientType.TO, toAddress);
		    // Subject del correo
		    message.setSubject("Recordatorio Prestamo");
		    // Mensaje de Recordatorio
		    message.setText("�Hola!"+
		    		"Se le recuerda que se le ha prestado un art�culo."+
		    		"Su plazo est� por vencer, comun�quese conmigo"+
		    		"                                             "+
		    		"                                             "+
		    		"by MeaProvidere�");
		 
		    Transport transport = session.getTransport("smtp");
		  
		    transport.connect(host, "controlprestamos896@gmail.com", "ControlAdrian");
		 
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();
		}
		 
	
	
}
