package br.com.javaparaweb.capitulo14.javamail;

import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import br.com.javaparaweb.capitulo14.javamail.Autenticacao;

public class TesteJavaMailAnexo {

	private static final String CONTA = "adm@localhost";

	public static void main(String[] args) throws AddressException,	MessagingException {

		Properties config = new Properties();
		config.setProperty("mail.smtp.host", "localhost");
		config.setProperty("mail.smtp.port", "25");
		config.setProperty("mail.smtp.auth", "true");

		Session sessao = Session.getInstance(config, new Autenticacao(CONTA, "123"));

		MimeMessage email = new MimeMessage(sessao);
		email.setFrom(new InternetAddress(CONTA));
		email.setRecipient(Message.RecipientType.TO, new InternetAddress("livrojava@localhost"));
		email.setSubject("Teste de e-mail com anexo usando JavaMail");
		email.setSentDate(new Date());

		MimeMultipart partesEmail = new MimeMultipart();
		
		MimeBodyPart corpo = new MimeBodyPart(); 
		corpo.setContent("E-mail com anexo", "text/html");
		partesEmail.addBodyPart(corpo);

		MimeBodyPart anexo = new MimeBodyPart(); 
		anexo.setDataHandler(new DataHandler(new FileDataSource("/tmp/texto.txt"))); 
		anexo.setFileName("texto.txt");
		partesEmail.addBodyPart(anexo);

		email.setContent(partesEmail); 
		Transport.send(email);
		System.out.println("E-mail enviado com sucesso");
	}
}