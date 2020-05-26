package com.br.trackDonation.helper;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailHelper {
	public void sendMail(String donatorMail, String donatorName, String receiverName, String receiverFamily, String receiverPhoto) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kaiquejuvenciocosta@gmail.com", "senha");
			}
		});
		/** Ativa Debug para sessão */
		session.setDebug(true);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kaiquejuvenciocosta@gmail.com"));

			// Remetente

			Address[] toUser = InternetAddress
					.parse(donatorMail);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Rastreio de doação IRES");// Assunto
			
			String msgBody = "Olá " + donatorName + " gostariamos de dar um feedback sobre a sua doação. Ela foi doada para o(a) " + receiverName + " da família " + receiverFamily;
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText(msgBody);
			
			Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        
	        messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\Users\\kaiqu\\Desktop\\trackDonation\\" + receiverPhoto);
			messageBodyPart.setDataHandler(new DataHandler(source));
			multipart.addBodyPart(messageBodyPart);
	        
	        message.setContent(multipart);
	        
	        /** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
