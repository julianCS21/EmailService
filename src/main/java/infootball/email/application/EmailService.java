package infootball.email.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendWelcomeEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Welcome to inFootball!");
        message.setText(
                "Hi there,\n\n" +
                        "Thank you for joining inFootball! We are excited to have you with us.\n" +
                        "Here are a few resources to help you get started:\n\n" +
                        "- Explore all the features we offer\n" +
                        "- Check out our new user guide\n" +
                        "- Feel free to reach out if you have any questions\n\n" +
                        "We hope you enjoy the experience.\n\n" +
                        "Best regards,\n" +
                        "The inFootball Support Team"
        );
        message.setFrom(username);

        mailSender.send(message);
    }
}
