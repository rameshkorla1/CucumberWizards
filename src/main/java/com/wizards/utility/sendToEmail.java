package com.wizards.utility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

public class sendToEmail {
	
	public void emailSending() {

	 final String username = "ramesh.korla@outlook.com";
	    final String password = "Munitha@3556";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp-mail.outlook.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("ramesh.korla@outlook.com"));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("ramesh.korla1@gmail.com"));
	        message.setSubject("Testing Subject");
	        message.setText("PFA");

	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();
	        
	        String file = "./PdfReport/ExtentPdf.pdf";
	        String fileName = "ExtentPdf.pdf";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }
}
