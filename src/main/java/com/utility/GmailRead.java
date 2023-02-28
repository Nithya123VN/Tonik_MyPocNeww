package com.utility;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.jsoup.Jsoup;

public class GmailRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String plainText = null;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.port", "465");
        try {
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("nithyahv74@gmail.com", "vzskhapnxrlafalk");
                        }
                    });
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "nithyahv74@gmail.com", "vzskhapnxrlafalk");// need to enter the required Mail ID and password
            System.out.println("connection is established with the Mail ID");
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);
            int messageCount = inbox.getMessageCount();
            System.out.println(messageCount);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message[] message = inbox.search(ft);
            boolean emailFound = false;
            for (int i = 1; i < message.length; i++) {
//               System.out.println("Mail Subject:- " + message[i].getSubject());
                if(emailFound == false){
                    if(message[i].getSubject().contains("Verify your email address")){
                        MimeMessage msg = (MimeMessage) message[i];
//                        System.out.println(msg.getContentType());
                        Multipart mp = (Multipart) msg.getContent();
                        int mp_count = mp.getCount();
                        System.out.println(mp_count);
//                        for (int j = 0; j < mp_count; j++) {
//                            System.out.println(mp.getBodyPart(j).getContent());
//                        }
//                       System.out.println(mp.getBodyPart(0).getContent());

						
						  String s = (String)mp.getBodyPart(0).getContent(); 
						  plainText = Jsoup.parse(s).text(); 
//						  System.out.println(plainText); 
						  String [] array =  plainText.split("\\*"); 
						  System.out.println(array[1]);
//						  String [] array1 = array[1].split("\\."); System.out.println(array1[0]);
//						 
//                        FlagTerm ft1 = new FlagTerm(new Flags(Flags.Flag.SEEN), true);
//                        Message[] message1 = inbox.search(ft1);
//                        emailFound = true;
                        break;
                    }
                }
            }
            if(emailFound == false){
                System.out.println("User is not received the mail or the mail content is read");
            }
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    public String fetchPassword(String Message){
        Pattern p = Pattern.compile("\\b((?:https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
        Matcher m = p.matcher(Message);
        m.find();
        return m.group(0);
    }

}
