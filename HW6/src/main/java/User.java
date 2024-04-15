
public class User {
    private String name;
    private MessageMemento memento;
    private ChatHistory chatHistory;

    public User(String name) {
        this.name = name;
        memento = new MessageMemento("");
        chatHistory = new ChatHistory();
    }

    public void sendMessage(Message message) {
        try {
            memento.setMessageState(chatHistory.getLastMessageSent().getMessageContent());
        }catch (IndexOutOfBoundsException e) {}

        ChatServer.sendMessage(this, message.getRecipients(), message);

        chatHistory.addToSentMessages(message);
    }

    public void receiveMessage(Message message, User user) {
        System.out.println(getName() + ": received message from:" + user.getName() + " : " + message.getMessageContent());
        chatHistory.addToReceivedMessages(message);
    }

    public ChatHistory viewChatHistory(User user) {
        return ChatServer.viewChatHistory(user);
    }


    public String undoLastMessageSent() {
        ChatServer.deleteLastMessageReceived(chatHistory.getLastMessageSent());
        chatHistory.removeLastSentMessage();
        return memento.getMessageState();
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ChatHistory chatHistory) {
        this.chatHistory = chatHistory;
    }

}
