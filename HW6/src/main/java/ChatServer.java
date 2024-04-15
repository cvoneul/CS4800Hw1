import java.util.ArrayList;

public class ChatServer {
    private static ArrayList<User> users = new ArrayList<>();


    public static void registerUser(User user) {
        users.add(user);
    }

    public static void unregisterUser(User user) {
        users.remove(user);
    }

    public static void sendMessage(User sender, ArrayList<User> recipients, Message m) {
        recipients.forEach(recipient -> recipient.receiveMessage(m, sender));
    }

    public static void deleteLastMessageReceived(Message message) {
        User sender = message.getSender();
        for(User user: message.getRecipients()) {
            user.getChatHistory().removeLastFromReceived(sender);
        }
    }

    public static void blockMessage() {

    }

    public static ChatHistory viewChatHistory(User user) {
        return user.getChatHistory();
    }
}
