import java.sql.Timestamp;
import java.util.ArrayList;

public class Message {
    private String messageContent;
    private User sender;
    private ArrayList<User> recipients;
    private Timestamp timestamp;

    public Message(User sender, String messageContent, ArrayList<User> recipients) {
        this.sender = sender;
        this.messageContent = messageContent;
        this.recipients = recipients;
        timestamp = new Timestamp(System.currentTimeMillis());
    }


    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public User getSender() { return sender; }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public ArrayList<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<User> recipients) {
        this.recipients = recipients;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
