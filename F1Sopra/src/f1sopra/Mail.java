/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package f1sopra;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author victor
 */
public class Mail {
    public static void main(String[] args)
    {
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "fuensa82@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fuensa82@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("victor@fuensalida.com"));
            message.setSubject("Hola");
            message.setText("Mensajito con Java Mail <b>prueba</b>",
                    "ISO-8859-1",
                    "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("f1sopra@gmail.com", "HijoLuna");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
