package br.com.javaparaweb.capitulo14.gmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import br.com.javaparaweb.capitulo14.javamail.Autenticacao;

public class TesteGmail {

	private static final String SERVIDOR_SMTP = "smtp.gmail.com";
	private static final String PORTA_SERVIDOR_SMTP = "465";
	private static final String EMAIL = "testelivrojava@gmail.com";
	private static final String SENHA = "livrojava";

	public static void main(String[] args) throws AddressException, MessagingException {

		Autenticacao autenticacao = new Autenticacao(EMAIL, SENHA); 
		Session session = Session.getDefaultInstance(getPropriedades(), autenticacao);
		session.setDebug(true); 

		MimeMessage email = new MimeMessage(session);
		email.setRecipient(Message.RecipientType.TO, new InternetAddress("testelivrojava@gmail.com"));
		email.setFrom(new InternetAddress(EMAIL));
		email.setSubject("Teste de e-mail usando Gmail");
		email.setContent("Corpo da mensagem", "text/plain");
		email.setSentDate(new Date());
		Transport envio = session.getTransport("smtp");
		envio.connect(SERVIDOR_SMTP, EMAIL, SENHA);
		email.saveChanges(); 
		envio.sendMessage(email, email.getAllRecipients());
		envio.close();

		System.out.println("E-mail enviado com sucesso");
	}

	public static Properties getPropriedades() {
		Properties config = new Properties();
		config.setProperty("mail.transport.protocol", "smtp");
		config.setProperty("mail.smtp.starttls.enable", "true");
		config.setProperty("mail.smtp.host", SERVIDOR_SMTP); 
		config.setProperty("mail.smtp.auth", "true"); 
		config.setProperty("mail.smtp.user", EMAIL); 
		config.setProperty("mail.debug", "true");
		config.setProperty("mail.smtp.port", PORTA_SERVIDOR_SMTP); 
		config.setProperty("mail.smtp.socketFactory.port", PORTA_SERVIDOR_SMTP); 
		config.setProperty("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
		config.setProperty("mail.smtp.socketFactory.fallback", "false");
		return config;
	}
}