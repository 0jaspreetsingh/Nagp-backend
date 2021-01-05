package com.nagarro.nagpmanagement.email;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

@Component
public class SendSMTP {

	public static String sendMail(String toEmailId, String text, String subject, File[] files) throws IOException {

		try {

			// --[ Set up the default parameters
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");

			p.put("mail.transport.protocol", "smtp");

			p.put("mail.smtp.host", "smtp.gmail.com");

			p.put("mail.smtp.port", "587");

			p.put("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator("demo@gmail.com", "password");

			Session mailSession = Session.getInstance(p, auth);

			Message msg = new MimeMessage(mailSession);

			msg.setFrom(new InternetAddress("demo@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailId));
			msg.setSentDate(new Date());
			msg.setSubject(subject);

			MimeBodyPart messageBodyPart;
			messageBodyPart = new MimeBodyPart();
			MimeMultipart multipart = new MimeMultipart();
			messageBodyPart.setText(text);
			multipart.addBodyPart(messageBodyPart);
			if (files != null) {

				for (File file : files) {

					messageBodyPart = new MimeBodyPart();
					// File filename = file.getName()//new
					// File("C:\\Users\\jaspreetsingh03\\Documents\\ExitTest.docx");
					messageBodyPart.setFileName(file.getName());
					messageBodyPart.attachFile(file);
					multipart.addBodyPart(messageBodyPart);
				}
			}
			msg.setContent(multipart);
			Transport.send(msg);

			return "sent";

		} catch (MessagingException E) {
			System.out.println("Something gone wrong while sending mail!" + E);
			return "failed";
		}
	}
}
