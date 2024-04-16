import java.sql.Timestamp;

public class MessageMemento {
    private ChatHistory messageState;
    private Timestamp timestamp;

    public MessageMemento(ChatHistory messageState) {
        this.messageState = new ChatHistory(messageState);
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ChatHistory getMessageState() {
        return messageState;
    }

    public void setMessageState(ChatHistory messageState) {
        this.messageState = messageState;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
