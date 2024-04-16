import java.util.ArrayList;
import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        User a = new User("adam");
        User b = new User("bob");
        User c = new User("carlos");

        ChatServer.getInstance().registerUser(a);
        ChatServer.getInstance().registerUser(b);
        ChatServer.getInstance().registerUser(c);

        ArrayList<User> recipientsForA = new ArrayList<>();
        recipientsForA.add(b);
        recipientsForA.add(c);

        ArrayList<User> recipientsForC = new ArrayList<>();
        recipientsForC.add(a);


        ArrayList<User> usersBHasBlocked = new ArrayList<>();
        usersBHasBlocked.add(a);

        BlockedList blockListOfB = new BlockedList(b);
        blockListOfB.setBlocked(usersBHasBlocked);
        ChatServer.getInstance().getBlockedList().add(blockListOfB);


        Message message1 = new Message(a, "meet me there at 5:30pm", recipientsForA);
        a.sendMessage(message1);

        a.undoLastMessageSent();

        Message message2 = new Message(a, "actually meet me there at 6pm", recipientsForA);
        a.sendMessage(message2);

        Message message3 = new Message(c, "6pm. got it", recipientsForC);
        c.sendMessage(message3);


        Iterator iterator = c.iterator(a);
        while(iterator.hasNext()) {
            Message m = (Message) iterator.next();
            System.out.println( m.getTimestamp().toString() + ":: "
                    + m.getRecipients().get(0).getName() + ": received message from:"
                    + m.getSender().getName() + " : " + m.getMessageContent());
        }

    }
}
