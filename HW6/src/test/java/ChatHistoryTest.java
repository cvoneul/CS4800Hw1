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

        userB.getChatHistory().addToReceivedMessages(message);
        userA.getChatHistory().addToSentMessages(message);

        String expected = "message 1";
        String actual1 = userB.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = userA.getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void multipleMessagesTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA, "message 1", recipientsForA);
        Message message2 = new Message(userA, "message 2", recipientsForA);
        Message message3 = new Message(userA, "message 3", recipientsForA);

        userB.getChatHistory().addToReceivedMessages(message);
        userB.getChatHistory().addToReceivedMessages(message2);
        userB.getChatHistory().addToReceivedMessages(message3);
        userA.getChatHistory().addToSentMessages(message);
        userA.getChatHistory().addToSentMessages(message2);
        userA.getChatHistory().addToSentMessages(message3);

        String expected = "message 3";
        String actual1 = userB.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = userA.getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void MultipleRecipients() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        recipientsForA.add(userC);
        recipientsForA.add(userD);

        Message message = new Message(userA, "To everyone", recipientsForA);

        userB.getChatHistory().addToReceivedMessages(message);
        userC.getChatHistory().addToReceivedMessages(message);
        userD.getChatHistory().addToReceivedMessages(message);
        userA.getChatHistory().addToSentMessages(message);

        String expected = "To everyone";
        String actual1 = userB.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = userC.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual3 = userD.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual4 = userA.getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
        assertEquals(expected, actual3, actual4);
    }

    @Test
    public void viewUserChatHistory() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA, "message 1", recipientsForA);

        userB.getChatHistory().addToReceivedMessages(message);

        String expected = "message 1";
        ChatHistory chatHistory = userA.viewChatHistory(userB);
        String actual = chatHistory.getLastMessageReceived().getMessageContent();

        assertEquals(expected, actual);
    }
}
