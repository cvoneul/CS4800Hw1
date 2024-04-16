import java.util.ArrayList;

public class ChatHistory {
    private ArrayList<Message> messagesReceived;
    private ArrayList<Message> messagesSent;

    public ChatHistory() {
        messagesReceived = new ArrayList<>();
        messagesSent = new ArrayList<>();
    }

    public ChatHistory(ChatHistory chatHistory) {
        messagesSent = chatHistory.getMessagesSent();
        messagesReceived = chatHistory.getMessagesReceived();
    }

    public void addToSentMessages(Message message) {
        messagesSent.add(message);
    }

    public void addToReceivedMessages(Message message) {
        messagesReceived.add(message);
    }

    public void removeLastSentAndReceivedMessage() {
        removeLastReceivedMessage();
        removeLastSentMessage();
    }

    public ArrayList<Message> getAllMessagesOf(User user) {
        ArrayList<Message> userHistory = new ArrayList<>();

        for(Message m: messagesSent) {
            if(m.getSender() == user) {
                userHistory.add(m);
            }
        }
        return userHistory;
    }

    public void removeLastSentMessage() {
        messagesSent.remove(messagesSent.size() - 1);
    }

    public void removeLastReceivedMessage() {
        messagesReceived.remove(messagesReceived.size() - 1);
    }

    public Message getLastMessageSent() {
        return messagesSent.get(messagesSent.size() - 1);
    }

    public Message getLastMessageReceived() {
        return messagesReceived.get(messagesReceived.size() - 1);
    }

    public ArrayList<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(ArrayList<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public ArrayList<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(ArrayList<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }
}
