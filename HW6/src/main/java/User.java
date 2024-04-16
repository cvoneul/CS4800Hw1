import java.util.ArrayList;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(Message message) {
        ChatServer.getInstance().sendMessage(this, message.getRecipients(), message);
    }

    public void receiveMessage(Message message, User user) {
        System.out.println(getName() + ": received message from:" + user.getName() + " : " + message.getMessageContent());
        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message);
    }

    public ArrayList<Message> getUserChatHistory(User user) {
        return ChatServer.getInstance().viewChatHistory(user);
    }

    public void undoLastMessageSent() {
        ChatServer.getInstance().undo();
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
