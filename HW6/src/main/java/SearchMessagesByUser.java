import java.util.Iterator;

public class SearchMessagesByUser implements Iterator {
    private User user;
    private int index;
    private ChatHistory chatHistory;

    public SearchMessagesByUser(User user) {
        this.user = user;
        chatHistory = ChatServer.getInstance().getChatHistory();
        index = 0;
    }

    @Override
    public boolean hasNext() {
        while(index < chatHistory.getMessagesSent().size()) {
            Message message = chatHistory.getMessagesSent().get(index);
            if(message.getSender().getName() == user.getName()  || message.getRecipients().contains(user.getName())) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            Message message = chatHistory.getMessagesSent().get(index);
            index++;
            return message;
        }
        return null;
    }
}
