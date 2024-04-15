import java.util.ArrayList;

public class ChatHistory {
    private ArrayList<Message> messagesReceived;
    private ArrayList<Message> messagesSent;

    public ChatHistory() {
        messagesReceived = new ArrayList<>();
        messagesSent = new ArrayList<>();
    }

    public void addToSentMessages(Message message) {
        messagesSent.add(message);
    }

    public void addToReceivedMessages(Message message) {
        messagesReceived.add(message);
    }

    public void removeLastSentMessage() {
        messagesSent.remove(messagesSent.size() - 1);
    }

    public void removeLastFromReceived(User user) {
        //todo
    }

    public void removeLastFromSent(User user) {
        messagesSent.remove(user);
    }

    public void removeReceivedMessage() {
        messagesReceived.remove(messagesReceived.size() - 1);
    }

    public Message getLastMessageSent() {
        return messagesSent.get(messagesSent.size() - 1);
    }

    public Message getLastMessageReceived() {
        return messagesReceived.get(messagesReceived.size() - 1);
    }
}
