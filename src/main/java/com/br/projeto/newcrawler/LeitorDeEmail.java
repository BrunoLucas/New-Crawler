package com.br.projeto.newcrawler;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class LeitorDeEmail {

	private Properties properties;
	public LeitorDeEmail(){
		//create properties field

	}
	
	public  void ler(UsuarioEmail usuario) 
		   {
		      try {
		    	  
			      properties = new Properties();

			      
			      properties.put("mail.imaps.starttls.enable", "true");
			      properties.put("mail.store.protocol", "imaps");
			      properties.setProperty("mail.imaps.host", "imap.gmail.com");
			      properties.setProperty("mail.imaps.port", "993");
			      properties.setProperty("mail.imaps.auth", "true");
//			      properties.setProperty("mail.debug", "true");
			      Session emailSession = Session.getDefaultInstance(properties);
			      Store store = emailSession.getStore("imaps");
			      store.connect("imap.gmail.com", usuario.getEmail(), usuario.getSenha());
			      Folder emailFolder = store.getFolder("INBOX");
			      emailFolder.open(Folder.READ_ONLY);
			      Message[] messages = emailFolder.getMessages();

			      for (int i = 0, n = messages.length; i < n; i++) {
			         Message message = messages[i];
			         System.out.println("---------------------------------");
			         System.out.println("Titulo: " + message.getSubject());
			         
			         if(message.getContentType().contains("multipart/ALTERNATIVE")){
			        	 Multipart multipart = (Multipart) messages[i].getContent();
	
			        	    StringBuilder conteudo = new StringBuilder();
			        	    for (int j = 0; j < multipart.getCount(); j++) {
	
			        	        BodyPart bodyPart = multipart.getBodyPart(j);
			        	        conteudo.append(bodyPart.getContent().toString());
			        	    }
			        	    System.out.println("Corpo: " + conteudo.toString());
			         }
			         System.out.println("Corpo: " + message.getContent().toString());
	
			      }
	
			      emailFolder.close(false);
			      store.close();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}
