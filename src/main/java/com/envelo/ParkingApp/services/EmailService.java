package com.envelo.ParkingApp.services;

import com.envelo.ParkingApp.model.entity.Qrcode;
import com.envelo.ParkingApp.repository.UserRepository;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    public EmailService( JavaMailSender mailSender, UserRepository userRepository) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
    }

    public void sendEmailWithAttachment() throws MessagingException, IOException, WriterException {
        MimeMessage msg = mailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("r.paliwoda992@gmail.com");
        helper.setSubject("Your Ticket");
        // default = text/plain
        //helper.setText("Check attachment for image!");
        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);
        Qrcode.createQR("aa","android.png",200,200);
        FileSystemResource file
                = new FileSystemResource(new File("android.png"));
        helper.addAttachment("Invoice", file);
        mailSender.send(msg);

    }

    public void prepareAndSend(String recipients, String content, String subject) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(this.fromEmail);
            messageHelper.setTo(recipients);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            messageHelper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File("qrcode.png"));
            messageHelper.addAttachment("Ticket.png", file);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            //
        }
    }
}