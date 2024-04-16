import java.util.ArrayList;

public class BlockedList {
    private User user;
    private ArrayList<User> blocked;

    public BlockedList(User user) {
        this.user = user;
        blocked = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<User> blocked) {
        this.blocked = blocked;
    }
}
