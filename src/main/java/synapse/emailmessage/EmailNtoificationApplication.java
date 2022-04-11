package synapse.emailmessage;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailNtoificationApplication {
    
	@Autowired
	private EmailSenderService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmailNtoificationApplication.class, args);}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggermail() throws MessagingException
	{
	//	service.sendsimpleemial("venusmaart48@gmail.com", "this is subject","this is body");
		 service.sendmailwithattachment("venusmaart48@gmail.com","this is subject","this is body","C:\\Users\\venu kumar\\OneDrive\\Pictures\\New folder\\download.gif");
		
		
		
	}
	
	
	
	
	

}
