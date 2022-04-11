package synapse.emailmessage;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendsimpleemial(String emailto,String body,String Subject)
			 {
		
	SimpleMailMessage message = new SimpleMailMessage();
	
	message.setFrom("sabitha824@gmail.com");
	message.setTo(emailto);
	message.setSubject(Subject);
	message.setText(body);
	mailsender.send(message);
	System.out.println("Mail Sent.........");
	
	}
	public void sendmailwithattachment(String emailto,String body,String Subject,String attachment) throws MessagingException
			{
		MimeMessage mimeMessage = mailsender.createMimeMessage();
		MimeMessageHelper mimemessagehelper = new MimeMessageHelper(mimeMessage,true);
		
		mimemessagehelper.setFrom("sabitha824@gmail.com");
		mimemessagehelper.setTo(emailto);
		mimemessagehelper.setSubject(Subject);
		mimemessagehelper.setText(body);
		
		
		FileSystemResource filesystem = new FileSystemResource( new File(attachment));
		
		mimemessagehelper.addAttachment(filesystem.getFilename(),filesystem);
		mailsender.send(mimeMessage);
		System.out.println("Email sent with attachment");
			
	}
		
	
}
