package tasks.homelibrary.resource;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class MailClass {
    private String mailFrom;
    private String password;
    private String mailTo;
    private String text;
    private String title;

    public MailClass(String mailFrom, String password, String mailTo, String text, String title) {
        this.mailFrom = mailFrom;
        this.password = password;
        this.mailTo = mailTo;
        this.text = text;
        this.title = title;
        sendEmail();
    }

    public MailClass(String mailFrom, String password, String mailTo, String text, String title, String directory) {
        this.mailFrom = mailFrom;
        this.password = password;
        this.mailTo = mailTo;
        this.text = text;
        this.title = title;
        sendEmail(directory);
    }

    private void sendEmail() {
        try {
            java.util.Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.ru");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.connectiontimeout", "6000");
            props.put("mail.smtp.timeout", "6000");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(mailFrom, password));
                }
            });
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(mailFrom);
            msg.setFrom(addressFrom);
            InternetAddress addressTo = new InternetAddress(mailTo);
            msg.setRecipient(Message.RecipientType.TO, addressTo);
            msg.setSubject(title);
            msg.setText(text);
            Transport.send(msg);

        } catch (Throwable e) {
            System.err.println("Неправильный пароль от почты!" + e);
        }
    }

    private void sendEmail(String directory) {
        try {
            java.util.Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.ru");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.connectiontimeout", "6000");
            props.put("mail.smtp.timeout", "6000");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(mailFrom, password));
                }
            });
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(mailFrom);
            msg.setFrom(addressFrom);
            InternetAddress addressTo = new InternetAddress(mailTo);
            msg.setRecipient(Message.RecipientType.TO, addressTo);
            msg.setSubject(title);

            File file = new File(directory);
            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart part1 = new MimeBodyPart();
            part1.addHeader("Content-Type", "text/plain; charset=UTF-8");
            part1.setDataHandler(new DataHandler(text, "text/plain; charset=\"utf-8\""));
            multipart.addBodyPart(part1);

            MimeBodyPart part2 = new MimeBodyPart();
            part2.setFileName(MimeUtility.encodeWord(file.getName()));
            part2.setDataHandler(new DataHandler(new FileDataSource(file)));
            multipart.addBodyPart(part2);

            msg.setContent(multipart);
            Transport.send(msg);

        } catch (Throwable e) {
            System.err.println("Неправильный пароль от почты!" + e);
        }
    }
}
