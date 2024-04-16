import java.util.ArrayList;

public class ChatServer {
    private ArrayList<User> users;
    private ChatHistory chatHistory;
    private MessageMemento memento;
    private ArrayList<BlockedList> blockedList;

    private static ChatServer instance;

    private ChatServer() {
        users = new ArrayList<>();
        chatHistory = new ChatHistory();
        memento = new MessageMemento(chatHistory);
        blockedList = new ArrayList<>();
    }

    public static ChatServer getInstance() {
        if(instance == null) {
            instance = new ChatServer();
        }
        return instance;
    }


    public void registerUser(User user) { users.add(user); }
    public void unregisterUser(User user) {
        users.remove(user);
    }

    public void sendMessage(User sender, ArrayList<User> recipients, Message message) {
        memento = new MessageMemento(chatHistory);

        for(User recipient: recipients) {
            if( !isBlocked(recipient,sender) ) {
                recipient.receiveMessage(message, sender);
            }
        }
        chatHistory.addToSentMessages(message);
    }

    private boolean isBlocked(User recipient, User sender) {
        for(BlockedList userList: blockedList) {
            if(userList.getUser().getName() == recipient.getName()) {
                for(User user: userList.getBlocked()) {
                    if(user.getName() == sender.getName()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void undo() {
        setChatHistory(memento.getMessageState());
    }

    public void setChatHistory(ChatHistory chatHistory) {
        this.chatHistory = chatHistory;
    }
    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public ArrayList<Message> viewChatHistory(User user) {
        return chatHistory.getAllMessagesOf(user);
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public MessageMemento getMemento() {
        return memento;
    }

    public void setMemento(MessageMemento memento) {
        this.memento = memento;
    }

    public ArrayList<BlockedList> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(ArrayList<BlockedList> blockedList) {
        this.blockedList = blockedList;
    }
}
