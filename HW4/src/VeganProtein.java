import java.util.Random;

public class VeganProtein {
    private String[] proteins = {"Beef", "Tofu"};

    public String generateProtein() {
        int rand = new Random().nextInt(proteins.length);
        return proteins[rand];
    }

    public String[] getProteins() {
        return proteins;
    }

    public void setProteins(String[] proteins) {
        this.proteins = proteins;
    }
}
