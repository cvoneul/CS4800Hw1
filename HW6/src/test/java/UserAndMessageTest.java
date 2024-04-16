import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAndMessageTest {
    private User userA = new User("Trump");
    private User userB = new User("Biden");
    private User userC = new User("Hilary");
    private User userD = new User("Vivek");
    private ArrayList<User> recipientsForA;
    private ArrayList<User> recipientsForB;
    private BlockedList b = new BlockedList(userB);


    @Test
    public void sendMessageTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA,"Do you have the launch codes?", recipientsForA);

        userA.sendMessage(message);

        String expected = "Do you have the launch codes?";

        String actual = ChatServer.getInstance().getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual);
    }

    @Test
    public void recieveMessageTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA,"Do you have the launch codes?", recipientsForA);

        userA.sendMessage(message);

        String expected = "Do you have the launch codes?";
        String actual = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();

        assertEquals(expected, actual);
    }

    @Test
    public void mulitpleRecipientsTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        recipientsForA.add(userC);
        recipientsForA.add(userD);

        Message message = new Message(userA,"Do you have the launch codes?", recipientsForA);

        userA.sendMessage(message);

        String expected = "Do you have the launch codes?";

        ArrayList<Message> messages = ChatServer.getInstance().viewChatHistory(userA);
        String actual = messages.get(messages.size()-1).getMessageContent();

        assertEquals(expected, actual, actual);
    }

    @Test
    public void respondTest() {
        recipientsForA = new ArrayList<>();
        recipientsForB = new ArrayList<>();
        recipientsForA.add(userB);
        recipientsForB.add(userA);

        Message message = new Message(userA, "Do you have the launch codes?", recipientsForA);
        userA.sendMessage(message);

        Message messageBack = new Message(userB, "I dont remember", recipientsForB);
        userB.sendMessage(messageBack);

        String expected = "I dont remember";
        String actual1 = ChatServer.getInstance().getChatHistory().getLastMessageSent().getMessageContent();
        String actual2 = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();
        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void blockedTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);

        Message message = new Message(userA,"Im spamming you with messages", recipientsForA);
        userA.sendMessage(message);

        ArrayList<User> usersBHasBlocked = new ArrayList<>();
        usersBHasBlocked.add(userA);
        b.setBlocked(usersBHasBlocked);
        ChatServer.getInstance().getBlockedList().add(b);

        Message message2 = new Message(userA,"Im spamming you with messages #2", recipientsForA);

        userA.sendMessage(message2);

        String expected = "Im spamming you with messages";

        String actual = ChatServer.getInstance().getChatHistory().getLastMessageReceived().getMessageContent();

        assertEquals(expected, actual);
    }


    @Test
    public void undoMessageTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message1 = new Message(userA,"Do you have the launch codes?", recipientsForA);
        Message message2 = new Message(userA, "This new message should get undo-ed", recipientsForA);

        userA.sendMessage(message1);
        userA.sendMessage(message2);

        String expected = "Do you have the launch codes?";
        userA.undoLastMessageSent();
        String actual = ChatServer.getInstance().getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual);
    }

}
