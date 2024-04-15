import java.sql.Timestamp;

public class MessageMemento {
    private String messageState;
    private Timestamp timestamp;

    public MessageMemento(String message) {
        timestamp = new Timestamp(System.currentTimeMillis());
        messageState = message;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
