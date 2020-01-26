package com.fastsloth.general;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import com.fastsloth.beans.Dog;

public class SendEmail {
	
	public SendEmail(Dog dog) {
		
	}
	public void mailing(String name, String ownerName, String breed, String group, String gender, String dogClass, String day1, String day2, String day3, String email, String membership) 
			throws AddressException, MessagingException {
		
		String body = "";
		String date = "";
		String subject = "Welcome to Fast Sloth Club";
		String from = "fastsloth.cs@gmail.com";
		String senderPassword = "d33pLearning!";
		
		if (day1.equals("on") && day2.equals("on") && day3.equals("on")) {
			date = "March 1-3, 2019";
		} else if (day1.equals("on") && day2.equals("on") && day3.equals("off")) {
			date = "March 1 and March 2, 2019";
		} else if (day1.equals("on") && day2.equals("off") && day3.equals("on")) {
			date = "March 1 and March 3, 2019";
		} else if (day1.equals("off") && day2.equals("on") && day3.equals("on")) {
			date = "March 2 and March 3, 2019";
		} else if (day1.equals("on") && day2.equals("off") && day3.equals("off")) {
			date = "March 1, 2019";
		} else if (day1.equals("off") && day2.equals("on") && day3.equals("off")) {
			date = "March 2, 2019";
		} else {
			date = "March 3, 2019";
		}
		
		body = "\nHello, " + ownerName + "!" +
	    	   "\n\nEntry for " + name + " was successful!" + 
				"\nHere is some details: " +
	    	   "\nBreed: " + breed + 
	    	   "\nGroup: " + group +
	    	   "\nGender: " + gender +
	    	   "\nClass: " + dogClass +
	    	   "\nSee you on " + date + "." +
				"\n\nYou can check details any time on our website." +
	    	   " http://localhost:8080/DogShow/search.jsp" +
	    	   "\nThank you!" +
				"\nRegards," +
	    	   "\nFast Sloth Club";
		
		//The code that sends the email
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.gmail.com");
		props.put("mail.smtps.port", "465");
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "false");
		Session session = Session.getDefaultInstance(props);
		
		//Create the message
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		message.setText(body);
		
		//Address the message
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(email);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);
		
		//Send the message
		Transport transport = session.getTransport();
		transport.connect(from, senderPassword);
		transport.sendMessage(message, message.getAllRecipients());
		System.out.println("Email has been sent out successfully");
	}
}
