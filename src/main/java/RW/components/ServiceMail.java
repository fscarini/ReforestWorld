package RW.components;

import RW.components.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceMail {

    public ModelMessage sendMail(String email, String code) {
                ModelMessage ms = new ModelMessage(false, "");
        String from = "no-reply@reforestworld.com.br";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtppro.zoho.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        String username = "no-reply@reforestworld.com.br";
        String password = "ReforestWorld2024@";
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Código de verificação");
            message.setText("Olá! Tudo bem? Somos da Reforest World!\n"
                    + " Seu código de verificação é" + code
                            + "\n Ao realizar o seu primeiro login, será solicitado que você digite o código."
                            + "\n Após isso, sua conta será ativada e você poderá começar a contribuir com o nosso planeta."
                            + "\n Seja bem vindo ao futuro!");
            Transport.send(message);
            ms.setSuccess(true);
        } catch (MessagingException e) {
            if (e.getMessage().equals("Invalid Addresses")) {
                ms.setMessage("Invalid email");
            } else {
                ms.setMessage("Error");
            }
        }
        return ms;
    }
}
