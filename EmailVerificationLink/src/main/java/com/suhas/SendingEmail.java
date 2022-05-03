package com.suhas;

import java.util.Properties;
import com.suhas.DbConnection;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
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
import com.suhas.RegisterUser;
import com.suhas.RegisterDao;
import com.suhas.ActivateAccount;

public class SendingEmail {

	String email;
	String myHash;

	public SendingEmail(String email, String myHash) {
		this.email = email;
		this.myHash = myHash;
	}

	public void sendMail() {

		String from = "suhass2402@gmail.com";
		String password = "jaisriram9";

		Properties theProperties = new Properties();

		theProperties.put("mail.smtp.auth", "true");
		theProperties.put("mail.smtp.host", "smtp.gmail.com");
		theProperties.put("mail.smtp.port", "587");
		theProperties.put("mail.smtp.starttls.required", "true");
		theProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(theProperties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Email Verification Link");
			message.setText("Click this link to confirm your email address and complete setup for your account."
					+ "\n\nVerification Link: " + "http://localhost:8091/BankingEmail/ActivateAccount?key1=" + email + "&key2="
					+ myHash);

			Transport.send(message);

			System.out.println("Successfully sent Verification Link");

		} catch (MessagingException e) {
			System.out.println("Error at SendingEmail.java: " + e);
		}

	}

}
