package part2;

import java.util.Random;

public class PaleoProtein {
    private String[] proteins = {"Fish", "Chicken", "Beef"};

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
