package chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.ChatMessage;
import chat.db.MessageRepository;

@Controller
public class GreetingController {
	
	@Autowired
	private MessageRepository repository;

	@MessageMapping("/chat")
	@SendTo("/topic/cignex-main")
    public Greeting greeting(ChatMessage message) throws Exception {
    	 repository.save(message);
    	 return new Greeting( message.getName() + ":"+message.getMessage());
    }
    
	@RequestMapping("/allmessages")
	@ResponseBody
	public List<ChatMessage> getAllMessages() throws Exception {
    	 return repository.findAll();
    }
    
}
