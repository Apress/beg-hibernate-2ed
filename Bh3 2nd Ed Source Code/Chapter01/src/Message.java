import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
   private Message() {
       
   }

   public Message(String messageText) {
      this.messageText = messageText;
   }

   public String getMessageText() {
      return messageText;
   }

   public void setMessageText(String messageText) {
      this.messageText = messageText;
   }

   @Id
   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
    private String messageText;
    private Integer id;


}