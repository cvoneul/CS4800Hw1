import java.util.ArrayList;

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


        ArrayList<User> usersBHasBlocked = new ArrayList<>();
        usersBHasBlocked.add(a);

        BlockedList blockListOfB = new BlockedList(b);
        blockListOfB.setBlocked(usersBHasBlocked);
        ChatServer.getInstance().getBlockedList().add(blockListOfB);


        Message message = new Message(a, "meet me there at 5:30pm", recipientsForA);
        a.sendMessage(message);

    }
}
