package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void main(String[] args) {
		System.out.println("prepareing to send email");
		String to = "myself.jbk@gmail.com";
		String from = "jbkismyname@gmail.com";
		
//		Properties
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.port", "465");
		
//		Session to authentication
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("jbkismyname@gmail.com", "wagtsnkuvuvixykq");
			}
		});

		session.setDebug(true);
		
// 		MimeMessage instance..!
		
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// to address
			message.setSubject("Email from Balakrishna");// subject
			message.setText("done");// text content
			Transport.send(message);// send
			System.out.println("Email sent");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
