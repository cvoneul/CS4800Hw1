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


    @Test
    public void sendMessageTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA,"Do you have the launch codes?", recipientsForA);

        userA.sendMessage(message);

        String expected = "Do you have the launch codes?";

        String actual = userA.getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual);
    }

    @Test
    public void recieveMessageTest() {
        recipientsForA = new ArrayList<>();
        recipientsForA.add(userB);
        Message message = new Message(userA,"Do you have the launch codes?", recipientsForA);

        userA.sendMessage(message);

        String expected = "Do you have the launch codes?";
        String actual = userB.getChatHistory().getLastMessageReceived().getMessageContent();

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
        String actual1 = userB.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual2 = userC.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual3 = userD.getChatHistory().getLastMessageReceived().getMessageContent();
        String actual4 = userA.getChatHistory().getLastMessageSent().getMessageContent();

        assertEquals(expected, actual1, actual2);
        assertEquals(expected, actual3, actual4);
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
        String actual1 = userB.getChatHistory().getLastMessageSent().getMessageContent();
        String actual2 = userA.getChatHistory().getLastMessageReceived().getMessageContent();
        assertEquals(expected, actual1, actual2);
    }

    @Test
    public void undoMessageTest() {
        ;
    }

}
