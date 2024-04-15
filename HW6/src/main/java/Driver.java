import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        User a = new User("adam");
        User b = new User("bob");
        User c = new User("carlos");

        ArrayList<User> recipientsForA = new ArrayList<>();
        recipientsForA.add(b);
        recipientsForA.add(c);

        Message message = new Message(a, "meet me there at 5:30pm", recipientsForA);
        a.sendMessage(message);

    }
}
