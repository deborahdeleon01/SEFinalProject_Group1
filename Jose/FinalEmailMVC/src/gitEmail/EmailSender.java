/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitEmail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author Alex
 */
public class EmailSender {
    // Constructors
    EmailSender() {
        
    }
    
    EmailSender(String fromEmail, String username, String password, String toEmail, String subject, String textMessage, String attachment) {
        
    }
    
    public static void EmailSender(String fromEmail, String username, String password, String toEmail, String subject, String textMessage, String attachment) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.office365.com");
            props.put("mail.smtp.port","587");
//            props.put("mail.smtp.auth", "true");  //If this is enabled, the program would send email as soon as it's run (no need for authentication)
            props.put("mail.smtp.starttls.enable", "true");

//            props.put("mail.smtp.socketFactory.class", "java.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.socketFactory.port", "587");
//            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getInstance(props, null);
            mailSession.setDebug(true);

            Message emailMessage = new MimeMessage(mailSession);

            emailMessage.setFrom(new InternetAddress(fromEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // Mail multiple recipients using a comma ( , ) as parse
            emailMessage.setSubject(subject);

            // Create body part for the text message 
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(textMessage);

            // Create bodypart for attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment); 
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachment);

            // Add bodyparts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(messageBodyPart);

            emailMessage.setContent(multipart);

            // Helps Sends Message through smtp protocol
            Transport transport =  mailSession.getTransport("smtp");
            transport.connect("smtp.office365.com", username, password);

            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());

            transport.send(emailMessage);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
