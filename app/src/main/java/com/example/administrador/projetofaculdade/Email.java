package com.example.administrador.projetofaculdade;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;

public class Email {
    public static void sendAttachEmail(List<String> to, String subject, String body, String attach)
    {
        Properties p = getProps();
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        MimeBodyPart mbp = new MimeBodyPart();
        try {
            // "de" e "para"!!
            msg.setFrom(new InternetAddress("mdapp@mobilescience.mobi"));
            InternetAddress [] emails = new InternetAddress[to.size()];
            int i = 0;
            for (Iterator iterator = to.iterator(); iterator.hasNext();) {
                String toAddr = (String) iterator.next();
                emails[i] = new InternetAddress(toAddr);
                i++;
            }
            msg.setRecipients(Message.RecipientType.TO, emails);
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText(body);
            //enviando anexo
            DataSource fds = new FileDataSource(attach);
            mbp.setDisposition(Part.ATTACHMENT);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            msg.setContent(mp);
            // enviando mensagem
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Enviado com sucesso!");
    }
    private static Properties getProps() {
        Properties p = new Properties();
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.auth", "true");
        return p;
    }
}
class SMTPAuthenticator extends javax.mail.Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication ("mdapp@mobilescience.mobi", "marketd");
    }
}