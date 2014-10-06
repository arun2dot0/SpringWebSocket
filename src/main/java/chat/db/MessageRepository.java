package chat.db;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import chat.ChatMessage;

@Repository
public interface MessageRepository extends MongoRepository<ChatMessage, String> {

		public ChatMessage findByName(String name);

}
