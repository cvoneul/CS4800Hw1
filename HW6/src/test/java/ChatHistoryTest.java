import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatHistoryTest {
    private User userA = new User("Trump");
    private User userB = new User("Biden");
    private User userC = new User("Hilary");
    private User userD = new User("Vivek");

    private ArrayList<User> recipientsForA;

    @Test
    public void basicAddCheckTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA, "message 1", recipientsForA);

        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message);
        ChatServer.getInstance().getChatHistory().addToSentMessages(message);

        String expected = "message 1";
        String actual1 = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = ChatServer.getInstance().getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void multipleMessagesTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA, "message 1", recipientsForA);
        Message message2 = new Message(userA, "message 2", recipientsForA);
        Message message3 = new Message(userA, "message 3", recipientsForA);

        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message);
        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message2);
        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message3);
        ChatServer.getInstance().getChatHistory().addToSentMessages(message);
        ChatServer.getInstance().getChatHistory().addToSentMessages(message2);
        ChatServer.getInstance().getChatHistory().addToSentMessages(message3);

        String expected = "message 3";
        String actual1 = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = ChatServer.getInstance().getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void MultipleRecipients() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        recipientsForA.add(userC);
        recipientsForA.add(userD);

        Message message = new Message(userA, "To everyone", recipientsForA);

        ChatServer.getInstance().getChatHistory().addToReceivedMessages(message);

        String expected = "To everyone";
        String actual = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();

        String expected1 = "BidenHilaryVivek";
        ArrayList<User> recipients = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getRecipients();
        String actual1 = "";
        for(User x: recipients) {
            actual1 += x.getName();
        }

        assertEquals(expected1, actual1);
        assertEquals(expected, actual);
    }

    @Test
    public void viewUserChatHistory() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA, "message 1", recipientsForA);

        userA.sendMessage(message);

        String expected = "message 1";
        ArrayList<Message> messagesSent = userB.getUserChatHistory(userA);
        String actual = "";
        for(Message m: messagesSent) {
            actual += m.getMessageContent();
        }

        assertEquals(expected, actual);
    }
}
